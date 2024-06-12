package br.com.alura.comex.trello6;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Pedido implements Comparable<Pedido>{
    private int id;
    private Cliente cliente;
    private Produto produto;
    private double preco;
    private int quantidade;
    private double valorTotal;
    private Date data;

    //Construtor obrigando preencher os atributos ao instanciar


    public Pedido(int id, Cliente cliente, Produto produto, double preco, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.valorTotal = calcularValorTotalPedido();
        this.data = new Date();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Date getData() {
        return data;
    }

    private double calcularValorTotalPedido() {
        return this.preco * this.quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getPreco() {
        return preco;
    }

    public String isMaisBaratoQue(Pedido outroPedido) {
        BigDecimal meuPreco = BigDecimal.valueOf(this.preco);
        BigDecimal outroPreco = BigDecimal.valueOf(outroPedido.getPreco());

        if (meuPreco.compareTo(outroPreco) < 0) {
            return "Este pedido é mais barato do que o outro pedido.";
        } else {
            return "Este pedido não é mais barato do que o outro pedido.";
        }
    }

    public String isMaisCaroQue(Pedido outroPedido) {
        BigDecimal meuPreco = BigDecimal.valueOf(this.preco);
        BigDecimal outroPreco = BigDecimal.valueOf(outroPedido.getPreco());

        if (meuPreco.compareTo(outroPreco) > 0) {
            return "Este pedido é mais caro do que o outro pedido.";
        } else {
            return "Este pedido não é mais caro do que o outro pedido.";
        }
    }

    public static double calcularValorTotal(List<Pedido> pedidos) {
        double valorTotal = 0;
        for (Pedido pedido : pedidos) {
            valorTotal += pedido.getValorTotal();
        }
        return valorTotal;
    }

    //Alterando método toString para trazer o dados de forma estruturada
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", preco=" + preco +
                ", numero=" + quantidade +
                '}';
    }

    @Override
    public int compareTo(Pedido outroPedido) {
        return this.getProduto().getNome().compareTo(outroPedido.getProduto().getNome());
    }
}
