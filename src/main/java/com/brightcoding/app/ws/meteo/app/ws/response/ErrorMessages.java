/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.response;

/**
 *
 * @author Yassine
 */
public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal Bright coding server error"),
    NO_RECORD_FOUND("Record with provided id is not found");
    private String errorMessage;

    private ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
