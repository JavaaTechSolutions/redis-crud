package com.jts.rediscache.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.jts.rediscache.OrderNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public Order save(Order order) {
		repository.save(order);
		return order;
	}

	@Cacheable(value = "order")
	public List<Order> findAll() {
		return repository.findAll();
	}

	@Cacheable(value = "order", key = "#id", condition="#id>=10")
	public Order findOrderById(int id) {
		return repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Not found"));
	}

	@Caching(
			  evict = {@CacheEvict(value = "order", allEntries = true), @CacheEvict(value="order", key="#id")
			}) 
	public String deleteOrder(int id) {
		repository.deleteById(id);
		return "Order deleted successfully!";
	}

}
