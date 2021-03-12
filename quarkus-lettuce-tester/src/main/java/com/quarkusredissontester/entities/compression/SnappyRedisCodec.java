package com.quarkusredissontester.entities.compression;

import io.lettuce.core.codec.RedisCodec;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import org.xerial.snappy.SnappyInputStream;
import org.xerial.snappy.SnappyOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SnappyRedisCodec<V> implements RedisCodec<String, V> {

    private RedisCodec<Object, Object> delegate;


    public SnappyRedisCodec(RedisCodec<Object, Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public String decodeKey(ByteBuffer bytes) {
        return (String) delegate.decodeKey(bytes);
    }

    @Override
    public V decodeValue(ByteBuffer bytes) {
        try {
            return (V) delegate.decodeValue(decompress(bytes));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public ByteBuffer encodeKey(String key) {
        return delegate.encodeKey(key);
    }


    @Override
    public ByteBuffer encodeValue(Object value) {
        try {
            return compress(delegate.encodeValue(value));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private ByteBuffer compress(ByteBuffer source) throws IOException {
        if (source.remaining() == 0) {
            return source;
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        SnappyOutputStream compressor = new SnappyOutputStream(buffer);
        try {
            getByteBufInputStream(source).transferTo(compressor);
        } finally {
            compressor.close();
        }
        return ByteBuffer.wrap(buffer.toByteArray());
    }

    private ByteBuffer decompress(ByteBuffer source) throws IOException {
        if (source.remaining() == 0) {
            return source;
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        SnappyInputStream decompressor = new SnappyInputStream(getByteBufInputStream(source));
        try {
            decompressor.transferTo(buffer);
        } finally {
            decompressor.close();
        }
        return ByteBuffer.wrap(buffer.toByteArray());
    }

    private ByteBufInputStream getByteBufInputStream(ByteBuffer source) {
        return new ByteBufInputStream(Unpooled.wrappedBuffer(source));
    }
}