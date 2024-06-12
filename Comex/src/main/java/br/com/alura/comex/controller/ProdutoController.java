package br.com.alura.comex.controller;

import br.com.alura.comex.modelos.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alura.comex.modelos.Produto;
import br.com.alura.comex.service.ProdutoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setPrecoUnitario(produtoRequest.getPreco());
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setCategoria(new Categoria());
        produto.getCategoria().setId(produtoRequest.getCategoriaId());
        Produto savedProduto = produtoService.save(produto);
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }

    public static class ProdutoRequest {

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, message = "Nome deve ter pelo menos 2 caracteres")
        private String nome;

        @NotNull(message = "Preço é obrigatório")
        @Min(value = 0, message = "Preço deve ser positivo")
        private Double preco;

        private String descricao;

        @NotNull(message = "Quantidade em estoque é obrigatória")
        @Min(value = 0, message = "Quantidade em estoque deve ser positiva")
        private Integer quantidadeEmEstoque;

        @NotNull(message = "ID da categoria é obrigatório")
        private Long categoriaId;

        // Getters e Setters

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public BigDecimal getPreco() {

            return null;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Integer getQuantidadeEmEstoque() {
            return quantidadeEmEstoque;
        }

        public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }

        public Long getCategoriaId() {
            return categoriaId;
        }

        public void setCategoriaId(Long categoriaId) {
            this.categoriaId = categoriaId;
        }
    }
}
