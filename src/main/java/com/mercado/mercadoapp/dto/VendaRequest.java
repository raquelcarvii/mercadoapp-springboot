package com.mercado.mercadoapp.dto;

import lombok.Data;

@Data
public class VendaRequest {
    private Integer produtoId;
    private Integer clienteId;
    private int quantidade;
}
