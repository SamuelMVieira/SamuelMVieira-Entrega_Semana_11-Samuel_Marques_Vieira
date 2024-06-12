package br.com.alura.comex.DAO;

import br.com.alura.comex.modelos.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProdutoDao {
    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public Produto buscaPorId(Long id) {
        Produto produto = em.find(Produto.class, id);
        System.out.println("Busca por ID - Produto encontrado: " + produto);
        return produto;
    }

    public void cadastra(Produto produto) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(produto);
            et.commit();
            System.out.println("Cadastrando Produto: " + produto);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public List<Produto> listaTodos() {
        List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        System.out.println("Listando todos os Produtos: " + produtos);
        return produtos;
    }

    public List<Produto> listaIndisponiveis() {
        List<Produto> produtosIndisponiveis = em.createQuery("SELECT p FROM Produto p WHERE p.quantidade = 0", Produto.class).getResultList();
        System.out.println("Listando produtos indisponíveis: " + produtosIndisponiveis);
        return produtosIndisponiveis;
    }

    public void atualizarEstoque(Long produtoId, int novaQuantidade) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Produto produto = em.find(Produto.class, produtoId);
            if (produto != null) {
                produto.setQuantidade(novaQuantidade);
                em.merge(produto);
                System.out.println("Estoque atualizado - Produto: " + produto.getNome() + ", Quantidade: " + novaQuantidade);
            } else {
                System.out.println("Produto não encontrado para atualização de estoque.");
            }
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new RuntimeException("Erro ao atualizar o estoque do produto", e);
        }
    }

    public void salvar(Produto produto) {
    }

    public List<Produto> buscarTodos() {
        return List.of();
    }
}
