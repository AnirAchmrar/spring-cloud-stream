package com.example.tts.mq;

import com.example.tts.data.PostTtsAnalyticsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class PostTtsAnalyticsPublisherService {

    private static final Logger log = LoggerFactory.getLogger(PostTtsAnalyticsPublisherService.class);
    public static final String POST_TTS_ANALYTICS_BINDING_NAME = "postTtsAnalytics-out-0";
    private final StreamBridge streamBridge;

    public PostTtsAnalyticsPublisherService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendAnalytics(PostTtsAnalyticsRequest request) {
        log.info("sendAnalytics: {}", request);
        streamBridge.send(POST_TTS_ANALYTICS_BINDING_NAME, request);
    }
}
