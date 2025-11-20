package com.AtividadeAPI.AtividadeAPI.controller;

import com.AtividadeAPI.AtividadeAPI.model.Produto;
import com.AtividadeAPI.AtividadeAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // POST - criar produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET - listar todos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto dados) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setNome(dados.getNome());
        produto.setPreco(dados.getPreco());
        return produtoRepository.save(produto);
    }

    // DELETE - remover
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

}

