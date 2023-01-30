package br.com.springbootattornatus.back_end_attornatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springbootattornatus.model.entity.Endereco;
import br.com.springbootattornatus.model.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "select u from Pessoa u where  upper(trim(u.nome)) like %?1%")
	List<Pessoa> buscarPorNome(String name);

	Endereco save(Endereco endereco);



}



