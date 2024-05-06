package com.jts.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Order")
public class Order implements Serializable {

	@Id
	private int id;

	private String details;

	private int qty;

	private long price;
}
