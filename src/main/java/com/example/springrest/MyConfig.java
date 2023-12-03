package com.example.springrest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyConfig {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
    @Bean
    public UserDetailsService usersDetailsService()
	{
		String sql = "SELECT * FROM Person.List";				
	    List<UserLogin> userLogin = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserLogin.class));
	    
	    
	    List<UserDetails> userDetails = new ArrayList<>();;
	    userLogin.forEach((value) ->{
	    	if(value != null)
	    	{
	    	UserDetails _userDetails = User.builder().username(value.getUsername()).
	    			password(passwordEncoder().encode(value.getPassword())).roles("Admin").build();
	    	
	    	
	    	if(userDetails!=null)
	    		userDetails.add(_userDetails);
	    	}
	    });
	    if(userLogin != null)
	    	System.out.println("----------------------------Filled");
	    UserDetails _userDetails = User.builder().username("Ok").
    			password(passwordEncoder().encode("Value")).roles("Admin").build();
	    return new InMemoryUserDetailsManager(userDetails);
	}

    @Bean
    PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception
    {
    	return builder.getAuthenticationManager();
    }
}
