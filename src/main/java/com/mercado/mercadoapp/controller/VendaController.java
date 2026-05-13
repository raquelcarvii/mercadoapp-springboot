package com.mercado.mercadoapp.controller;

import com.mercado.mercadoapp.dto.VendaRequest;
import com.mercado.mercadoapp.service.MercadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {
    private final MercadoService mercadoService;

    @PostMapping
    public String realizarVenda(@RequestBody VendaRequest vendaRequest){
        boolean sucesso = mercadoService.realizarVenda(
                vendaRequest.getClienteId(),
                vendaRequest.getProdutoId(),
                vendaRequest.getQuantidade()
        );
        if (sucesso) {
            return "Venda realizada com sucesso!";
        } else {
            return "Venda falhou: saldo ou estoque insuficiente";
        }
    }
}

