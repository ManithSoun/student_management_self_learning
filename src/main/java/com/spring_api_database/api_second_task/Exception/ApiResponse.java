package com.spring_api_database.api_second_task.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private Object metadata;

    public ApiResponse(String status, String message, T data, Object metadata) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    // Getters and setters omitted for brevity
}