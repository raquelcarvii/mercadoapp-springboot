package com.mercado.mercadoapp.controller;

import com.mercado.mercadoapp.entity.Cliente;
import com.mercado.mercadoapp.service.MercadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final MercadoService mercadoService;

    @GetMapping
    public List<Cliente>findAll(){
        return mercadoService.listarClientes();
    }
    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return mercadoService.salvarCliente(cliente);
    }
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        return  mercadoService.atualizarCliente(id, cliente);
    }
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Integer id){
        mercadoService.deletarCliente(id);
    }
}
