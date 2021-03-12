package com.webfluxredistester.entities;

import com.webfluxredistester.entities.compression.LZ4CompressionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class LZ4CompressionServiceTest {

    private final com.webfluxredistester.entities.compression.LZ4CompressionService LZ4CompressionService = new LZ4CompressionService();

//    @Test
    public void testCompression() {
        // GIVEN
        String payload = "11111111111111111111111111111111111111111111111111111111111111111111";
        int payloadSize = payload.getBytes(StandardCharsets.UTF_8).length;

        // WHEN
        byte[] compressedPayload = LZ4CompressionService.compressPayload(payload.getBytes(StandardCharsets.UTF_8));
        int compressedPayloadSize = compressedPayload.length;

        // THEN
        log.info("Payload size:{}, compressed payload size:{}", payloadSize, compressedPayloadSize);
    }

//    @Test
    public void testDecompression() {
        // GIVEN
        String payload = "1234534523457212345345234572123453452345721234534523457212345345234572";
        int payloadSize = payload.length();
        byte[] compressedPayload = LZ4CompressionService.compressPayload(payload.getBytes(StandardCharsets.UTF_8));

        // WHEN
        byte[] decompressedPayload = LZ4CompressionService.decompressTestEntity(compressedPayload);
        int decompressedPayloadSize = decompressedPayload.length;

        // THEN
        assertThat(payload.equals(decompressedPayload));
        assertThat(decompressedPayloadSize == payloadSize);
    }
}