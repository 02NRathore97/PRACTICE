package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.UserServiceInt;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInt{
	
	@Autowired
	public UserDAOInt dao;
	
	@Autowired
	public AttachmentServiceInt attachmentServiceInt;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		UserDTO existDto = findById(dto.getId());
		dto.setImageId(existDto.getImageId());
		dao.update(dto);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		
		try {
			UserDTO dto = findById(id);
			dao.delete(dto);
			attachmentServiceInt.delete(dto.getImageId());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findById(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {
		Long id = dto.getId();
		if(id != null && id>0) {
			update(dto);
		}else {
			id = add(dto);
		}
		return id;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = dao.findByUniqueKey("loginId", loginId);
		if(dto != null) {
			if(dto.getPassword().equals(password)) {
				return dto;
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}

	

}
