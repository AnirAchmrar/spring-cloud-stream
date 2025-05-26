package com.example.tts.data;

public enum QueueConstants {

    TTS_ANALYTICS_BINDING_NAME("output-out-0");

    private final String value;

    public String getValue() {
        return value;
    }

    QueueConstants(String value) {
        this.value = value;
    }
}
