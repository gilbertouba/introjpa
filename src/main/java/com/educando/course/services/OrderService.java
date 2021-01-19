package com.educando.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.entities.Order;
import com.educando.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	public List<Order> FindAll(){
		return repository.findAll();
	}
	
	public Order FindById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
