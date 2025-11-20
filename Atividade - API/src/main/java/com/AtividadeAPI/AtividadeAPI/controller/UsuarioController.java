package com.AtividadeAPI.AtividadeAPI.controller;

import com.AtividadeAPI.AtividadeAPI.model.Usuario;
import com.AtividadeAPI.AtividadeAPI.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // POST - criar usuário
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // GET - listar todos
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario dados) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        return usuarioRepository.save(usuario);
    }

    // DELETE - remover
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

}
