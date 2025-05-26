package com.example.ttsanalytics.data;

import java.io.Serializable;
import java.time.LocalDateTime;

public record PostTtsAnalyticsRequest(String id, LocalDateTime creationDate, long processTimeMs) implements Serializable {
}
