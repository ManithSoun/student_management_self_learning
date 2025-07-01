package com.spring_api_database.api_second_task.Exception;

import org.springframework.http.HttpStatus;

public class CourseHandlingError extends BaseException {
    public CourseHandlingError(String message) {
        super(message, "COURSE_NOT_FOUND", HttpStatus.NOT_FOUND);
    }


}
