package com.senac.pizzademo.dto;

public class CardapioDTO {
    private PizzaDTO pizza;
    private Float preco;
    private String tamanho;

    public PizzaDTO getPizza() {
        return pizza;
    }
    public void setPizza(PizzaDTO pizza) {
        this.pizza = pizza;
    }
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public static class PizzaDTO {
        private Long id;
        private String nome;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
    }
}
