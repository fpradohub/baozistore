package com.baozistore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozistore.model.Cliente;
import com.baozistore.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
    	 return clienteRepository.save(cliente);        
    }
    
    @GetMapping
    public List<Cliente> listar() {
    	return clienteRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
    	return clienteRepository.findById(id).orElse(null);

    }
       

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
