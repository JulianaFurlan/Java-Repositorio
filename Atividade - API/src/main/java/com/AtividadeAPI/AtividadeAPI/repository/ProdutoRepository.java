package com.AtividadeAPI.AtividadeAPI.repository;

import com.AtividadeAPI.AtividadeAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

