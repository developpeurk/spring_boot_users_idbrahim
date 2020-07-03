/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.services;

import com.brightcoding.app.ws.meteo.app.ws.shared.dto.UserDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Yassine
 */
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    UserDto getUserByUserId(String id);

    UserDto updateUser(String id, UserDto userDto);
     void deleteUser(String userId);
     List<UserDto> getUsers(int page, int limit,String search, int status);
}
