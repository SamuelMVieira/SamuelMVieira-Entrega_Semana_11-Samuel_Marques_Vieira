package br.com.alura.comex.trello6;

public class ComparaProdutos {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Camisa A","Branca", 49.99, 1);
        Produto produto2 = new Produto("Camisa A","Branca", 49.99, 1);

        System.out.println(produto1);
        System.out.println(produto2);

        if (produto1.equals(produto2)){
            System.out.println("São iguais");
        } else {
            System.out.println("Não são iguais");
        }
    }
}
