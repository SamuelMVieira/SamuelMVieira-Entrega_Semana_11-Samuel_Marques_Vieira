package br.com.alura.comex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.comex.modelos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
