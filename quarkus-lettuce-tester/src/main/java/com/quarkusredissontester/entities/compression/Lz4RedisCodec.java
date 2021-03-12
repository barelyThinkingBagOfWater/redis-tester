package com.quarkusredissontester.entities.compression;


import io.lettuce.core.codec.RedisCodec;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

import java.nio.ByteBuffer;

public class Lz4RedisCodec<V> implements RedisCodec<String, V> {

    private static final int DECOMPRESSION_HEADER_SIZE = Integer.SIZE / 8;

    private final LZ4Factory factory = LZ4Factory.fastestInstance();

    private RedisCodec<String, V> innerCodec;    // an instance of JacksonRedisCodec

    public Lz4RedisCodec(RedisCodec<String, V> innerCodec) {
        this.innerCodec = innerCodec;
    }

    @Override
    public String decodeKey(ByteBuffer bytes) {
        return innerCodec.decodeKey(bytes);
    }

    @Override
    public V decodeValue(ByteBuffer src) {
        if (!src.hasRemaining()) {
            return null;
        }
        int decompressSize = src.getInt();
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        ByteBuffer dest = ByteBuffer.allocate(decompressSize);
        dest.mark();
        decompressor.decompress(src, dest);
        dest.reset();
        return innerCodec.decodeValue(dest);
    }

    @Override
    public ByteBuffer encodeKey(String key) {
        return innerCodec.encodeKey(key);
    }

    @Override
    public ByteBuffer encodeValue(V value) {
        ByteBuffer src = innerCodec.encodeValue(value);
        int length = src.remaining();
        LZ4Compressor compressor = factory.fastCompressor();
        ByteBuffer dest = ByteBuffer.allocate(compressor.maxCompressedLength(length) + DECOMPRESSION_HEADER_SIZE);
        dest.mark();
        dest.putInt(length);
        compressor.compress(src, dest);
        dest.limit(dest.position());
        dest.reset();
        return dest;
    }
}