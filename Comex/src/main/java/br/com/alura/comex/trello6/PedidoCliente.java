package br.com.alura.comex.trello6;

public class PedidoCliente {
    private Pedido pedido;
    private Cliente cliente;

    public PedidoCliente(Pedido pedido, Cliente cliente) {
        this.pedido = pedido;
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "PedidoCliente{" +
                "pedido=" + pedido +
                ", cliente=" + cliente +
                '}';
    }
}
