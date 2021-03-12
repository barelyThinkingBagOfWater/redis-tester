package com.springmvclettucetester.entities.compression;

import com.springmvclettucetester.entities.CompressionService;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

/**
 * To fix it you can copy : org.redisson.codec.LZ4Codec from a redisson implementation
 */
public class LZ4CompressionService implements CompressionService {

    private final LZ4Compressor compressor;
    private final LZ4SafeDecompressor decompressor;

    public LZ4CompressionService() {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        compressor = factory.highCompressor();
        decompressor = factory.safeDecompressor();
    }

    public byte[] compressPayload(byte[] payload) {
        int maxCompressedLength = compressor.maxCompressedLength(payload.length);
        byte[] compressed = new byte[maxCompressedLength];

        compressor.compress(payload,
                0, payload.length, compressed, 0, maxCompressedLength);

        return compressed;
    }

    public byte[] decompressTestEntity(byte[] compressedEntity) {
        byte[] decompressedEntity = new byte[10000000]; //Which value here? Do some real tests

        int decompressedLength2 = decompressor.decompress(compressedEntity, 0,
                compressedEntity.length, decompressedEntity, 0);

        return decompressedEntity;
    }
}
