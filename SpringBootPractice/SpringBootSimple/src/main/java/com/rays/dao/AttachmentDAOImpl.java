package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

@Repository
public class AttachmentDAOImpl implements AttachmentDAOInt{

	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public long add(AttachmentDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	@Override
	public void update(AttachmentDTO dto) {
		entityManager.merge(dto);
	}

	@Override
	public void delete(AttachmentDTO dto) {
		entityManager.remove(dto);
		
	}

	@Override
	public AttachmentDTO findByPk(Long pk) {
		AttachmentDTO dto = entityManager.find(AttachmentDTO.class, pk);
		return dto;
	}

}

