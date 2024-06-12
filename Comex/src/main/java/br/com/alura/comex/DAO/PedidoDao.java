package br.com.alura.comex.DAO;

import br.com.alura.comex.modelos.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PedidoDao {
    private final EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Pedido pedido) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(pedido);
            et.commit();
            System.out.println("Cadastrando Pedido: " + pedido);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
        }
    }

    public List<Pedido> listaTodos() {
        List<Pedido> pedidos = em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
        System.out.println("Listando todos os Pedidos: " + pedidos);
        return pedidos;
    }
}
