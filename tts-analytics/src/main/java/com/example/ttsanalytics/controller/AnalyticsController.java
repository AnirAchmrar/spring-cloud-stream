package com.example.ttsanalytics.controller;

import com.example.ttsanalytics.data.TtsAnalyticsRequest;
import com.example.ttsanalytics.data.TtsAnalyticsResponse;
import com.example.ttsanalytics.service.TtsAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ttsAnalytics")
public class AnalyticsController {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsController.class);
    private final TtsAnalyticsService service;

    public AnalyticsController(TtsAnalyticsService service) {
        this.service = service;
    }

    @PostMapping
    public TtsAnalyticsResponse doAnalytics(@RequestBody TtsAnalyticsRequest request){
        log.info("doAnalytics request: {}", request);
        return service.doAnalytics(request);
    }

}
