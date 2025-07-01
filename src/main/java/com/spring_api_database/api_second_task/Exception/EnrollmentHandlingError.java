package com.spring_api_database.api_second_task.Exception;

import org.springframework.http.HttpStatus;

public class EnrollmentHandlingError extends BaseException{
    public EnrollmentHandlingError(String message){
        super (message, "EROLLMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }
}
