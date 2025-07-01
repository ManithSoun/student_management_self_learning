package com.spring_api_database.api_second_task.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
    private int status;
    private String path;
    private Instant timestamp;

    public ErrorResponse(String errorCode, String message, int status, String path, Instant timestamp) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    // Getters and setters (or use Lombok @Data)
}

