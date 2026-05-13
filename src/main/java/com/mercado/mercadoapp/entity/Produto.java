package com.mercado.mercadoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;
    private Integer estoque;



    //Métodos ‘setters’ com validação
    public void setPreco(Double preco){
        if(preco < 0){
            throw new IllegalArgumentException("O valor não pode ser negativo");
        }
        this.preco = preco;
    }


    //Métodos ‘setters’ com validação
    public void setEstoque(int estoque){
        if(estoque < 0){
            throw new IllegalArgumentException("Estoque nãp pode ser negativo");
        }
        this.estoque = estoque;
    }

    //Métodos de ações
    public boolean temEstoque(int quantidade){
        return this.estoque >= quantidade;
    }

    public String resumo(){
        return "ID: " + id + "| " + nome + " | " + "R$" + preco + " | " + "Estoque: " + estoque;
    }

}
