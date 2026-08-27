package com.substring.assistant.payload;

public record AiRequest(
        Long sessionId,
        String query
) {
}
