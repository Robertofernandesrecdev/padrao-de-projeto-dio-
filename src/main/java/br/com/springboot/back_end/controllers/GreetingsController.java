package br.com.springboot.back_end.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.springboot.back_end.repository.PessoaRepository;
import br.com.springboot.model.entity.Endereco;
import br.com.springboot.model.entity.Pessoa;

@RestController
public class GreetingsController {
	
	//private static final Object Pessoa = null;
	@Autowired /* injeção de dependencia */
	private PessoaRepository pessoaRepository;
    
    @GetMapping(value = "listarpessoas")
    @ResponseBody /* Retorna os dados ao corpo da resposta */
    public ResponseEntity<List<Pessoa>> listaPessoa(){
    
    List<Pessoa> pessoas = pessoaRepository.findAll(); /*executa a consulta no bda*/
	return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK ); /* retorna em JSON*/
	
    }
    
    @PostMapping(value = "criarpessoa") /*Mapeia a URL*/
    @ResponseBody /*descrição da resposta*/
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){ /* recebe os dados para salvar */
    	
    	 Pessoa user = pessoaRepository.save(pessoa);
    	 return new ResponseEntity<Pessoa>(user, HttpStatus.CREATED);
    	
    }
    
    @PostMapping(value = "criarendereco") /*Mapeia a URL*/
    @ResponseBody /*descrição da resposta*/
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco){ /* recebe os dados para salvar */
    	
    	 Endereco user = pessoaRepository.save(endereco);
    	 return new ResponseEntity<Endereco>(user, HttpStatus.CREATED);
    	
    }
    
    
    
    @PutMapping(value = "editar") /*Mapeia a URL*/
    @ResponseBody /*descrição da resposta*/
    public ResponseEntity<?> editar(@RequestBody Pessoa pessoa){ /* recebe os dados para salvar */
    	
    	if(pessoa.getId()== null) {
    		return new ResponseEntity<String>("Id não foi informado para editar! ", HttpStatus.OK);
    	}
    	
    	 Pessoa user = pessoaRepository.saveAndFlush(pessoa);
    	 return new ResponseEntity<Pessoa>(user, HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "consultarpessoaid") /*Mapeia a URL  intercepta dados de um formulário form-data   */
    @ResponseBody /*descrição da resposta*/
    public ResponseEntity<Pessoa> consultarpessoaid(@RequestParam(name = "Idpess") Long Idpess){ /* recebe os dados por Id*/
    	
    	 Pessoa pessoa = pessoaRepository.findById(Idpess).get();
    	 return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "delete") /*Mapeia a URL*/
    @ResponseBody /*descrição da resposta*/
    public ResponseEntity<String> delete(@RequestParam Long Idpess){ /* recebe os dados para salvar */
    	
    	 pessoaRepository.deleteById(Idpess);
    	 return new ResponseEntity<String>("Pessoa deletada com sucesso", HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "buscarPorNome") 
    @ResponseBody 
    public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestParam(name = "name") String name){ 
    	
    	List<Pessoa> pessoa = pessoaRepository.buscarPorNome(name.trim().toUpperCase());
    	 return new ResponseEntity<List<Pessoa>>(pessoa, HttpStatus.OK);
    }
    
    
    
}
