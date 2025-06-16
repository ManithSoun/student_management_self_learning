package com.spring_api_database.api_second_task.Section;

public class SectionHandlingError extends RuntimeException{
    public SectionHandlingError(String message){
        super (message); //Calls Superclass constructor
    }
}
