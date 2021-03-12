package com.webfluxjedisredistester.entities;

import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SnappyCompressionService {

    public byte[] compressPayload(String payload) {
        try {
            return Snappy.compress(payload.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public String decompressTestEntity(byte[] compressedEntity) {
        try {
            return Snappy.uncompressString(compressedEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
