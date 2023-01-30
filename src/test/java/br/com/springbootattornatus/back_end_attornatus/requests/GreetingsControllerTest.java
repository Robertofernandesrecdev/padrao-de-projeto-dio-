package br.com.springbootattornatus.back_end_attornatus.requests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.springbootattornatus.model.entity.Pessoa;


public class GreetingsControllerTest {
 
	@Test
	public void testCriar() {
		
	   Pessoa criarpessoa =  new Pessoa();
		
		assertNotNull(criarpessoa.getId());
		
	}
	
	
 }
