package com.codewithmonu.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithmonu.blog.exception.*;
import com.codewithmonu.blog.entities.User;
import com.codewithmonu.blog.payloads.UserDto;
import com.codewithmonu.blog.services.UserService;
import com.codewithmonu.blog.repositories.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		//get
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		
		//set
		user.setName(userDto.getName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(user.getAbout());
		
		
		//update
		User updateUser=this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updateUser);
		
		//data transfer of an object se convert kiya hai
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto =users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public UserDto deleteUser(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		return null;
	}
	
	public User dtoToUser(UserDto userDto) {
		User user=this.modelmapper.map(userDto, User.class);
		//user.setId(userDto.getId());
		//user.setName(userDto.getName());
		//user.setEmail(userDto.getEmail());
		//user.setAbout(userDto.getAbout());
		//user.setPassword(userDto.getPassword());
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelmapper.map(user, UserDto.class);
		//userDto.setId(user.getId());
		//userDto.setName(user.getName());
		//userDto.setEmail(user.getEmail());
		//userDto.setPassword(user.getPassword());
		//userDto.setAbout(user.getAbout());
		return userDto;
		
	}

}
