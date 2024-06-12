package br.com.alura.comex.trello6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TestePedido {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Centro","Gotham","Mansão","NJ","Beco",1);
        Endereco endereco2 = new Endereco("Centro","Metropolis","Casa","WD","Estrada",2);
        Endereco endereco3 = new Endereco("Centro","Central City","Apartamento","DC","Lugar",3);
        Cliente cliente1 = new Cliente("Bruce Wayne","15975315975","batmam@morcegao.com","heroi","33123456789",endereco1);
        Cliente cliente2 = new Cliente("Clark Kent","15975315975","superman@todopoderoso.com","heroi","33123456789",endereco2);
        Cliente cliente3 = new Cliente("Barry Alen","15975315975","flash@superrapido.com","heroi","33123456789",endereco3);

        Produto produto1 = new Produto("Camisa A","Branca", 49.99, 1);
        Produto produto2 = new Produto("Camisa B","Preto", 49.99, 1);

        Pedido pedido1 = new Pedido(001,cliente1,produto1,100.00,1);
        Pedido pedido2 = new Pedido(002,cliente2,produto2,500.00,1);
        Pedido pedido3 = new Pedido(003,cliente2,produto2,300.00,1);
        Pedido pedido4 = new Pedido(004,cliente3,produto2,200.00,1);
        Pedido pedido5 = new Pedido(005,cliente1,produto1,400.00,1);

        PedidoCliente pedidoCliente1 = new PedidoCliente(pedido1,cliente1);
        PedidoCliente pedidoCliente2 = new PedidoCliente(pedido2,cliente3);
        PedidoCliente pedidoCliente3 = new PedidoCliente(pedido3,cliente1);
        PedidoCliente pedidoCliente4 = new PedidoCliente(pedido4,cliente2);
        PedidoCliente pedidoCliente5 = new PedidoCliente(pedido5,cliente3);

        ArrayList<PedidoCliente> pedidos = new ArrayList<>();
        pedidos.add(pedidoCliente1);
        pedidos.add(pedidoCliente2);
        pedidos.add(pedidoCliente3);
        pedidos.add(pedidoCliente4);
        pedidos.add(pedidoCliente5);

        for (PedidoCliente pedidoCliente : pedidos) {
            String nomeProduto = pedidoCliente.getPedido().getProduto().getNome();
            String nomeCliente = pedidoCliente.getCliente().getNome();
            Double precoPedido = pedidoCliente.getPedido().getPreco();
            Date dataPedido = pedidoCliente.getPedido().getData();
            System.out.println("Nome do Produto: " + nomeProduto);
            System.out.println("Nome do Cliente: " + nomeCliente);
            System.out.println("Preço Pedido: " + precoPedido);
            System.out.println("Data: " + dataPedido);
            System.out.println(); // Linha em branco para separar os resultados
        }

        System.out.println("Ordenando a lista de pedidos pelo valor total do menor para o maior");
        Collections.sort(pedidos, Comparator.comparingDouble(pedidoCliente -> pedidoCliente.getPedido().getValorTotal()));
        for (PedidoCliente pedidoCliente : pedidos) {
            System.out.println("Nome do Produto: " + pedidoCliente.getPedido().getProduto().getNome());
            System.out.println("Nome do Cliente: " + pedidoCliente.getCliente().getNome());
            System.out.println("Valor Total: " + pedidoCliente.getPedido().getValorTotal());
            System.out.println(); // Linha em branco para separar os resultados
        }

        System.out.println("Ordenando a lista de pedidos pelo valor total do maior para o menor");
        // Ordenando a lista de pedidos pelo valor total (do menor para o maior)
        pedidos.sort(Comparator.comparingDouble(pedidoCliente -> pedidoCliente.getPedido().getValorTotal()));
        // Invertendo a ordem da lista
        Collections.reverse(pedidos);

        for (PedidoCliente pedidoCliente : pedidos) {
            System.out.println("Nome do Produto: " + pedidoCliente.getPedido().getProduto().getNome());
            System.out.println("Nome do Cliente: " + pedidoCliente.getCliente().getNome());
            System.out.println("Valor Total: " + pedidoCliente.getPedido().getValorTotal());
            System.out.println(); // Linha em branco para separar os resultados
        }
    }


}
