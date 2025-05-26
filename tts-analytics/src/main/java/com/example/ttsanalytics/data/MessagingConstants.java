package com.example.ttsanalytics.data;

public class MessagingConstants {

    public static final String TTS_ANALYTICS_CHANNEL_NAME = "ttsAnalyticsInput";
    public static final String TTS_ANALYTICS_EXCHANGE = "ttsAnalytics.exchange";
    public static final String TTS_ANALYTICS_QUEUE = "ttsAnalytics.queue";
    public static final String TTS_ANALYTICS_DLQ_EXCHANGE = "ttsAnalyticsDlx.exchange";
    public static final String TTS_ANALYTICS_DLQ_QUEUE = "ttsAnalyticsDlq.queue";
    public static final String TTS_ANALYTICS_ROUTING_KEY = "ttsAnalytics.routing.key";
    public static final String TTS_ANALYTICS_DLQ_ROUTING_KEY = "ttsAnalyticsDlq.routing.key";
    public static final int TTS_ANALYTICS_DLQ_TTL_MS = 5000;
}
