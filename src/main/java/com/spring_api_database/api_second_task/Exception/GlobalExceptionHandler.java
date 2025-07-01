package com.spring_api_database.api_second_task.Exception;

import com.spring_api_database.api_second_task.Exception.ErrorResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.Instant;
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(BaseException.class)
//    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex, HttpServletRequest request) {
//        ErrorResponse error = new ErrorResponse(
//                ex.getErrorCode(),
//                ex.getMessage(),
//                ex.getStatus().value(),
//                request.getRequestURI(),
//                Instant.now()
//        );
//        return new ResponseEntity<>(error, ex.getStatus());
//    }
//    @ExceptionHandler(IllegalArgumentException.class)
//   public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request){
//        ErrorResponse error = new ErrorResponse(
//                "Wrong Input",
//                ex.getMessage(),
//                400,
//                request.getRequestURI(),
//                Instant.now()
//        );
//        return ResponseEntity.badRequest().body(error);
//   }
//}

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(SectionHandlingError.class)
//    public ResponseEntity<String> handleSectionNotFound(SectionHandlingError ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(EnrollmentHandlingError.class)
//    public ResponseEntity<String> handleEnrollmentNotFound(EnrollmentHandlingError ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex, HttpServletRequest req){
        log.warn("Handled BaseException: {} at {}", ex.getMessage(), req.getRequestURI());
        ErrorResponse error = new ErrorResponse(ex.getErrorCode(), ex.getMessage(), ex.getStatus().value(), req.getRequestURI(), Instant.now());
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedError(Exception ex, HttpServletRequest req){
        log.error("Unexpected error at {}: {}", req.getRequestURI(), ex.getMessage(), ex);
        ErrorResponse error = new ErrorResponse(
                "INTERNAL_ERROR",
                ex.getMessage(),
                500,
                req.getRequestURI(),
                Instant.now()

        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}