package br.com.springboot.back_end.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.entity.Endereco;
import br.com.springboot.model.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "select u from Pessoa u where  upper(trim(u.nome)) like %?1%")
	List<Pessoa> buscarPorNome(String name);

	Endereco save(Endereco endereco);



}



