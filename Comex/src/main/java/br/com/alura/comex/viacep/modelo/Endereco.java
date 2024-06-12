package br.com.alura.comex.viacep.modelo;

public record Endereco(String cep, String logradouro,
                       String complemento, String bairro,
                       String localidade, String uf) {
}

