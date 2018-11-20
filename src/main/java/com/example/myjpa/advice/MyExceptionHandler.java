package com.example.myjpa.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public HashMap hanle(Exception e) {
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("file", stackTraceElement.getFileName());
        hashMap.put("line", stackTraceElement.getLineNumber());
        hashMap.put("message", e.getMessage());
        return hashMap;
    }
}
