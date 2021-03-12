package com.webfluxredistester.entities;

import com.webfluxredistester.entities.compression.SnappyCompressionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SnappyCompressionServiceTest {

    private final SnappyCompressionService compressionService = new SnappyCompressionService();

    @Test
    public void testCompression() throws IOException {
        // GIVEN
        String payload = "1234534523457212345345234572123453452345721234534523457212345345234572";
        int payloadSize = payload.getBytes(StandardCharsets.UTF_8).length;

        // WHEN
        byte[] compressedPayload = compressionService.compressPayload(payload.getBytes(StandardCharsets.UTF_8));
        int compressedPayloadSize = compressedPayload.length;

        // THEN
        assertThat(payloadSize > compressedPayloadSize);
        log.info("Payload size:{}, compressed payload size:{}", payloadSize, compressedPayloadSize);
    }

    @Test
    public void testDecompression() throws IOException {
        // GIVEN
        String payload = "1234534523457212345345234572123453452345721234534523457212345345234572";
        int payloadSize = payload.length();
        byte[] compressedPayload = compressionService.compressPayload(payload.getBytes(StandardCharsets.UTF_8));

        // WHEN
        byte[] decompressedPayload = compressionService.decompressTestEntity(compressedPayload);
        int decompressedPayloadSize = decompressedPayload.length;

        // THEN
        assertThat(payload.equals(decompressedPayload));
        assertThat(decompressedPayloadSize == payloadSize);
    }
}