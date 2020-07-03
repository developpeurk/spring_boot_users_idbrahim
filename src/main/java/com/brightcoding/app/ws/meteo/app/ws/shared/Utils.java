/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.shared;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yassine
 */
@Component
public class Utils {
   private final Random RANDOM = new SecureRandom();
   private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   
   public String generateStringId(int length){
       StringBuilder returnValue = new StringBuilder(length);
       for (int i = 0; i < length; i++) {
           returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
       }
       return new String(returnValue);
   }
   
}
