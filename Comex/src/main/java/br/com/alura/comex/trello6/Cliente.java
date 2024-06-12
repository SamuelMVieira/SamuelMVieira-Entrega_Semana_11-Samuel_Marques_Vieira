package br.com.alura.comex.trello6;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String profissao;
    private String telefone;
    private Endereco endereco;

    //Construtor obrigando preencher os atributos ao instanciar
    public Cliente(String nome, String cpf, String email, String profissao, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.profissao = profissao;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    //Alterando método toString para trazer o dados de forma estruturada
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", profissao='" + profissao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
