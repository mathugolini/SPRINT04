package br.com.sprint04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sprint04.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
