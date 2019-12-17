package com.medicaApp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicaApp.dao.IUsuarioDAO;
import com.medicaApp.model.Usuario;

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
		us.setUsername("santiago");
		us.setEnabled(true);
		us.setPassword(bcrypt.encode("123"));
		
		Usuario retorno =  dao.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()) );
	}
	
	

}
