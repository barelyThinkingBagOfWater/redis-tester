package com.webfluxjedisredistester.entities;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.nio.charset.StandardCharsets;

public class LZ4CompressionService {

    private final LZ4Compressor compressor;
    private final LZ4SafeDecompressor decompressor;

    public LZ4CompressionService() {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        compressor = factory.highCompressor();
        decompressor = factory.safeDecompressor();
    }

    public byte[] compressPayload(String payload) {
        byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);

        int maxCompressedLength = compressor.maxCompressedLength(payloadBytes.length);
        byte[] compressed = new byte[maxCompressedLength];

        compressor.compress(payloadBytes,
                0, payloadBytes.length, compressed, 0, maxCompressedLength);

        return compressed;
    }

    public String decompressTestEntity(byte[] compressedEntity) {
        byte[] decompressedEntity = new byte[10000000]; //Which value here? Do some real tests

        int decompressedLength2 = decompressor.decompress(compressedEntity, 0,
                compressedEntity.length, decompressedEntity, 0);

        return new String(decompressedEntity);
    }
}
