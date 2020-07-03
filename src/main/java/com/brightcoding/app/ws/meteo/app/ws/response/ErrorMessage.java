/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.response;

import java.util.Date;


/**
 *
 * @author Yassine
 */
public class ErrorMessage {

   
     private Date timestamp;
    private String message;

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

   
}
//    private final String message;
//    private final Throwable throwable;
//    private final HttpStatus httpStatus;
//    private final ZonedDateTime timeStamp;
//    
//    public ErrorMessage(String message,
//                        Throwable throwable, 
//                        HttpStatus httpStatus, 
//                        ZonedDateTime timeStamp) {
//        this.message = message;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.timeStamp = timeStamp;
//    }
//    
//    public String getMessage() {
//        return message;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }
//
//    public ZonedDateTime getTimeStamp() {
//        return timeStamp;
//    }
//
//   
//    
//    
//    