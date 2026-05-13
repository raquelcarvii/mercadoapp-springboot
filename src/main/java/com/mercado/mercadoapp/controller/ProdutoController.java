package com.mercado.mercadoapp.controller;

import com.mercado.mercadoapp.entity.Produto;
import com.mercado.mercadoapp.service.MercadoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor //necessario para injetar dependência
public class ProdutoController {

    //Injeção de dependência
    private final MercadoService mercadoService;

    @GetMapping
    public List<Produto>findAll(){
        return mercadoService.listarProdutos();
    }
    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return mercadoService.salvarProduto(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto){
        produto.setId(id);
        return mercadoService.atualizarProduto(id, produto);
    }
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Integer id){
        mercadoService.deletarProduto(id);
    }


}
