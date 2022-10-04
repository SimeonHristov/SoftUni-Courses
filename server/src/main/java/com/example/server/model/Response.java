package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL) //if something us NULL, don't show to the user
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason; //will be NULL, won't send to front
    protected String message;
    protected String developerMessage; //will be NULL, won't send to front
    protected Map<?, ?> data;
}
