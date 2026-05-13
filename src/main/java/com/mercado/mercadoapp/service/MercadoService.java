package com.mercado.mercadoapp.service;

import com.mercado.mercadoapp.entity.Cliente;
import com.mercado.mercadoapp.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mercado.mercadoapp.repository.ClienteRepository;
import com.mercado.mercadoapp.repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MercadoService {
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;


     //CRUD

    //Metodos que retornam os produtos e clientes
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    //Metodos que cadastram produtos e clientes
    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Metodos que atualizam produtos e clientes
    public Produto atualizarProduto(Integer idProduto, Produto produto){
        produto.setId(idProduto);
        return produtoRepository.save(produto);
    }
    public Cliente atualizarCliente(Integer idCliente, Cliente cliente){
        cliente.setId(idCliente);
        return clienteRepository.save(cliente);
    }

    //Metodos que deletam produtos e clientes
    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }
    public void deletarCliente(Integer id){
        clienteRepository.deleteById(id);
    }

    //Metodo que realiza vendas
    public boolean realizarVenda(int clienteId, int produtoId, int quantidade) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        Produto produto = produtoRepository.findById(produtoId).orElseThrow();
        if(cliente.temSaldo(produto.getPreco() * quantidade) && produto.temEstoque(quantidade)){
            cliente.sacar(produto.getPreco() * quantidade);
            produto.setEstoque(produto.getEstoque() - quantidade);
            clienteRepository.save(cliente);
            produtoRepository.save(produto);
            return true;
        }
        return false;
    }

}
