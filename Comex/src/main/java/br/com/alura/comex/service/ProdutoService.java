package br.com.alura.comex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alura.comex.modelos.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import br.com.alura.comex.modelos.Categoria;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto save(Produto produto) {
        // Validar se a categoria existe
        Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
                .orElseThrow(() -> new IllegalArgumentException("ID da categoria inválido"));
        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }
}
