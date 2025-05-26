package com.example.ttsanalytics.service;

import com.example.ttsanalytics.data.TtsAnalyticsRequest;
import com.example.ttsanalytics.data.TtsAnalyticsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TtsAnalyticsService {

    private static final List<String> ISO_COUNTRIES = Arrays.asList(
            "US", "GB", "FR", "DE", "JP", "IN", "BR", "ZA", "AU", "CN"
    );

    private static final List<String> DEVICE_TYPES = Arrays.asList(
            "Desktop", "Mobile", "Tablet", "SmartTV", "Bot"
    );

    private static final Logger log = LoggerFactory.getLogger(TtsAnalyticsService.class);

    public TtsAnalyticsResponse doAnalytics(TtsAnalyticsRequest request) {
        if (request == null)
            log.warn("Empty request!!");
        return new TtsAnalyticsResponse(
                DEVICE_TYPES.get(ThreadLocalRandom.current().nextInt(0, DEVICE_TYPES.size())),
                ISO_COUNTRIES.get(ThreadLocalRandom.current().nextInt(0, ISO_COUNTRIES.size()))
        );
    }
}
