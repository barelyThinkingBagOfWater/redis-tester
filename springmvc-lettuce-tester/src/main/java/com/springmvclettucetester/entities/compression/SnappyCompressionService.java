package com.springmvclettucetester.entities.compression;

import com.springmvclettucetester.entities.CompressionService;
import org.xerial.snappy.Snappy;

import java.io.IOException;

public class SnappyCompressionService implements CompressionService {

    @Override
    public byte[] compressPayload(byte[] payload) {
        try {
            return Snappy.compress(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public byte[] decompressTestEntity(byte[] compressedEntity) {
        try {
            return Snappy.uncompress(compressedEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[1];
    }
}
