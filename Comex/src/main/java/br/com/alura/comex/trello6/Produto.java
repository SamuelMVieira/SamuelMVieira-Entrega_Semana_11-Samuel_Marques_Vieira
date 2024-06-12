package br.com.alura.comex.trello6;

import java.util.Objects;

public class Produto{
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String nome, String descricao, double preco, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    // Getters para acessar as propriedades
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setter para modificar o preço
    public void setPreco(double novoPreco) {
        if (novoPreco >= 0) {
            this.preco = novoPreco;
        } else {
            System.out.println("Preço inválido. O preço deve ser não negativo.");
        }
    }

    //Método toString para verificar resultados
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object outroProduto) {
        //Realizando comparação de Referência
        if (this == outroProduto) return true;
        //Garantir que o produto não é nulo e que estamos comparando produtos da mesma classe e ja realiza o casting
        if (!(outroProduto instanceof Produto produto)) return false;
        //Realizando a comparação com base no atributos que definem o produto
        return Objects.equals(this.nome, produto.nome) &&
                Objects.equals(this.descricao, produto.descricao) &&
                this.preco == produto.preco;
    }
}
