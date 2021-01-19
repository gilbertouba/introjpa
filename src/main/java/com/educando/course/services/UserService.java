package com.educando.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educando.course.entities.User;
import com.educando.course.repositories.UserRepository;
import com.educando.course.services.exceptions.DatabaseException;
import com.educando.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> FindAll(){
		return repository.findAll();
	}
	
	public User FindById(Long id) {
		Optional<User> obj = repository.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {		
		return repository.save(obj);
	}
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		  catch (DataIntegrityViolationException e) {
			  throw new DatabaseException(e.getMessage());
		  }

	}
	
	public User update(Long id,User obj) {
		try {
		User entity_ = repository.getOne(id);
		updateData(entity_,obj);
		return repository.save(entity_);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
			
	}

	private void updateData(User entity_, User obj) {
		
		entity_.setName(obj.getName());
		entity_.setEmail(obj.getEmail());
		entity_.setPhone(obj.getPhone());
		
	}
}
