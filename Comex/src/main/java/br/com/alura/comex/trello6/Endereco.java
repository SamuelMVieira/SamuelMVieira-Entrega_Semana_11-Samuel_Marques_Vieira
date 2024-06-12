package br.com.alura.comex.trello6;

public class Endereco {
    private String bairro;
    private String cidade;
    private String complemento;
    private String estado;
    private String rua;
    private int numero;

    //Construtor obrigando preencher os atributos ao instanciar
    public Endereco(String bairro, String cidade, String complemento, String estado, String rua, int numero) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.rua = rua;
        this.numero = numero;
    }

    //Alterando método toString para trazer o dados de forma estruturada
    @Override
    public String toString() {
        return "Endereco{" +
                "bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", estado='" + estado + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                '}';
    }
}
