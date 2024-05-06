package com.jts.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jts.redis.dao.OrderDao;
import com.jts.redis.entity.Order;

@RestController
@RequestMapping("/api")
public class RedisController {

	@Autowired
	private OrderDao orderDao;

	@PostMapping("/save")
	public Order save(@RequestBody Order order) {
		return orderDao.save(order);
	}
	
	@GetMapping("/findAll")
	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Order findById(@PathVariable int id) {
		return orderDao.findOrderById(id);
	}

	@DeleteMapping("/remove/{id}")
	public String remove(@PathVariable int id) {
		return orderDao.deleteOrder(id);
	}
	
}
