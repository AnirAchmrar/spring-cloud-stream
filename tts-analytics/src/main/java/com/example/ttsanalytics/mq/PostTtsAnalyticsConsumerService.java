package com.example.ttsanalytics.mq;

import com.example.ttsanalytics.data.PostTtsAnalyticsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PostTtsAnalyticsConsumerService {

    private static final Logger log = LoggerFactory.getLogger(PostTtsAnalyticsConsumerService.class);

    @Bean
    public Consumer<PostTtsAnalyticsRequest> postTtsAnalytics() {
        return this::processAnalytics;
    }

    public void processAnalytics(PostTtsAnalyticsRequest request) {
        log.info("processAnalytics: {}", request);
        // Implementation
    }


}
