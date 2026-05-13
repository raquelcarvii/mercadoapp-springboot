package com.mercado.mercadoapp.repository;


import com.mercado.mercadoapp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
