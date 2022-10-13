package br.com.sprint04.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sprint04.model.Produto;
import br.com.sprint04.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository repository;
	
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	public void saveProduto(Produto produto) {
		repository.save(produto);
	}
	
	public Produto findProdutoById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Produto não encontrado")
				);
	}
	
	public List<Produto>findAll() {
		return repository.findAll();
	}

}
