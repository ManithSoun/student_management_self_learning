package com.spring_api_database.api_second_task.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SectionHandlingError extends BaseException{
    public SectionHandlingError(String message){
        super (message, "SECTION_NOT_FOUND", HttpStatus.NOT_FOUND); //Calls Superclass constructor
    }
}
