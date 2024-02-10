package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public void delete(Long id);
	
	public UserDTO findById(long pk);
	
	public long save(UserDTO dto);
	
	public UserDTO authenticate(String loginId, String password);
	
	public List search(UserDTO dto, int pageNo, int pageSize);
}

