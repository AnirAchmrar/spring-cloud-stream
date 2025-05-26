package com.example.tts.mq;

import com.example.tts.data.PostTtsAnalyticsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.converter.CompositeMessageConverter;

import java.time.LocalDateTime;
import java.util.Objects;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class PostTtsAnalyticsPublisherServiceTest {

    @Autowired
    private OutputDestination outputDestination;

    @Autowired
    private CompositeMessageConverter converter;

    @Autowired
    private PostTtsAnalyticsPublisherService analyticsService;

    @Test
    void testSendMessage() {
        PostTtsAnalyticsRequest request = new PostTtsAnalyticsRequest(
                "123", LocalDateTime.now(), 1500
        );

        analyticsService.sendAnalytics(request);

        var message = outputDestination.receive(1000, "post-tts-analytics");
        assert message != null;

        PostTtsAnalyticsRequest received = (PostTtsAnalyticsRequest) converter.fromMessage(message, PostTtsAnalyticsRequest.class);

        assert Objects.requireNonNull(received).id().equals(request.id());
    }

}
