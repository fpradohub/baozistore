package com.baozistore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozistore.model.Produto;
import com.baozistore.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
	    this.produtoRepository = produtoRepository;
	}
	
	@PostMapping
	public Produto criar(@RequestBody Produto produto) {
	    return produtoRepository.save(produto);
	}
	
	@GetMapping
	public List<Produto> listar() {
	    return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
	    return produtoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
	    produtoRepository.deleteById(id);
	}
}
