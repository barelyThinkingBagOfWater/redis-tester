package com.springmvclettucetester.repositories;

import com.springmvclettucetester.entities.CompressionService;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;

public class CustomRedisSerializer<T> implements RedisSerializer<T> {

    private RedisSerializer<T> innerSerializer; //if you want to use your own à la Kryo, not sure if it's really worth it though
    private final CompressionService compressionService;


    public CustomRedisSerializer(CompressionService compressionService) {
        this.compressionService = compressionService;
    }

    public CustomRedisSerializer(RedisSerializer<T> innerSerializer, CompressionService compressionService) {
        this.innerSerializer = innerSerializer;
        this.compressionService = compressionService;
    }


    @Override
    public byte[] serialize(T object) throws SerializationException {
        try {
            byte[] bytes = innerSerializer != null ? innerSerializer.serialize(object)
                    : SerializationUtils.serialize((Serializable) object);
            return compressionService.compressPayload(bytes);
        } catch (Exception e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        try {
            byte[] bos = compressionService.decompressTestEntity(bytes);
            return (T) (innerSerializer != null ? innerSerializer.deserialize(bos) : SerializationUtils.deserialize(bos));
        } catch (Exception e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }
}
