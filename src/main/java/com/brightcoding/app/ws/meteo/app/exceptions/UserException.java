/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.exceptions;

/**
 *
 * @author Yassine
 */
public class UserException extends RuntimeException {

	
	private static final long serialVersionUID = 847500838613349753L;
	
	public UserException(String message)
	{
		super(message);
	}

}


