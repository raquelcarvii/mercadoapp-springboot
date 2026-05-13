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
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Double saldo;


    //Métodos de ações

    public boolean temSaldo(double valor){
        return this.saldo >= valor;
    }
    public String resumo(){
        return "Nome: " + nome + " | Email: " + email + " | Saldo: " + saldo;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public void sacar(Double valor){
        if(saldo < valor){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }


}
