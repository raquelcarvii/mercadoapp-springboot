package com.mercado.mercadoapp.repository;

import com.mercado.mercadoapp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
