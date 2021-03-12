package com.springmvclettucetester.entities;

public interface CompressionService {
    byte[] compressPayload(byte[] payload);

    byte[] decompressTestEntity(byte[] compressedEntity);
}
