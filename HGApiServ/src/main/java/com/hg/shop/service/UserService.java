package com.hg.shop.service;

import java.util.List;

import com.hg.shop.entity.UserEntity;


public interface UserService {
	
	public UserEntity saveUser(UserEntity user);
	
	public UserEntity getUser(Long id);
	
	public List<UserEntity> getAllUsers();
	
	public UserEntity updateUser(UserEntity user);
	
	public void deleteUser(Long id);

}
