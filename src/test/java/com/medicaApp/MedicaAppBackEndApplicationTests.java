package com.medicaapp;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicaapp.dao.IUsuarioDAO;
import com.medicaapp.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicaAppBackEndApplicationTests {
	
	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(2);
		us.setUsername("carolina");
		us.setEnabled(true);
		us.setPassword(bcrypt.encode("123"));		
		Usuario retorno =  dao.save(us);		
		// db vs obj
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()) );
	}
	
//	@Test
//	public void testearPageable() throws JsonProcessingException {
//		
//		List<Integer> users = Arrays.asList(1,2,3,4,5,6,7,8,9);
//		Pageable pageable = PageRequest.of(4, 2);
//		
//		int start = (int) pageable.getOffset();
//		int end = (start + pageable.getPageSize()) > users.size() ? users.size() : (start + pageable.getPageSize());
//		Page<Integer> pages = new PageImpl<Integer>(users.subList(start, end), pageable, users.size());
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json = objectMapper.writeValueAsString(pages);
//	
//	}
	
	
	
	

}
