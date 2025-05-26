package com.example.ttsanalytics.mq;

import com.example.ttsanalytics.data.PostTtsAnalyticsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class PostTtsAnalyticsConsumerServiceTest {

    @Autowired
    private InputDestination inputDestination;

    @MockitoSpyBean
    private PostTtsAnalyticsConsumerService consumerService;

    @Test
    void testReceiveMessage() {
        PostTtsAnalyticsRequest request = new PostTtsAnalyticsRequest(
                "456", LocalDateTime.now(), 2000
        );

        inputDestination.send(new GenericMessage<>(request), "post-tts-analytics");

        // Verify the handler was called
        verify(consumerService, timeout(1000)).processAnalytics(request);
    }

    @Test
    void testRetryMechanism() throws Exception {
        PostTtsAnalyticsRequest request = new PostTtsAnalyticsRequest(
                "456", LocalDateTime.now(), 2000
        );

        // Mock failure scenario
        doThrow(new RuntimeException("Simulated processing failure"))
                .when(consumerService).processAnalytics(request);

        // Send test message
        inputDestination.send(new GenericMessage<>(request), "post-tts-analytics");

        // Verify retry attempts
        verify(consumerService, timeout(4000).times(3)).processAnalytics(request);
    }

}