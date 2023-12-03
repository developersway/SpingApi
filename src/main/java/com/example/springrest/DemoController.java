package com.example.springrest;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/home")
	public List<UserLogin> home()
	{
		String sql = "SELECT * FROM Person.List";
		List<UserLogin>list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserLogin.class));
		
		return list;
	}
}
