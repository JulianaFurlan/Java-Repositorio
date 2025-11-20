package com.AtividadeAPI.AtividadeAPI.repository;

import com.AtividadeAPI.AtividadeAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
