/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.controllers;

import com.brightcoding.app.ws.meteo.app.exceptions.UserException;
import com.brightcoding.app.ws.meteo.app.ws.requests.UserRequest;
import com.brightcoding.app.ws.meteo.app.ws.response.ErrorMessages;
import com.brightcoding.app.ws.meteo.app.ws.response.UserResponse;
import com.brightcoding.app.ws.meteo.app.ws.services.UserService;
import com.brightcoding.app.ws.meteo.app.ws.shared.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yassine
 */
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService; // injection de dépendence

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
		UserDto userDto = userService.getUserByUserId(id);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(userDto, userResponse);

		return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserResponse> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "4") int limit,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "status", defaultValue = "1") int status
			
			) {
		List<UserResponse> usersResponse = new ArrayList<>();
		List<UserDto> users = userService.getUsers(page, limit, search,status);
		for (UserDto userDto : users) {
			
			ModelMapper modelMapper = new ModelMapper();
			UserResponse userResponse =  modelMapper.map(userDto, UserResponse.class);
			usersResponse.add(userResponse);
		}
		return usersResponse;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) throws Exception {
		if (userRequest.getFirstName().isEmpty())
			throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

		// representation
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userRequest, UserDto.class);

		// service
		UserDto createUser = userService.createUser(userDto);
		UserResponse userResponse = modelMapper.map(createUser, UserResponse.class);
		// reponse

		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
		// representation
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);

		// service
		UserDto createUser = userService.updateUser(id, userDto);

		// reponse
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(createUser, userResponse);
		return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
