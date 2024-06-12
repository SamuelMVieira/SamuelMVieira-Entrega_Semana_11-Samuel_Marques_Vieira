package br.com.alura.comex.DAO;

import br.com.alura.comex.modelos.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public ClienteDao() {
    }

    public Cliente buscaPorId(Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println("Busca por ID - Cliente encontrado: " + cliente);
        return cliente;
    }

    public void cadastra(Cliente cliente) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(cliente);
            et.commit();
            System.out.println("Cadastrando Cliente: " + cliente);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void atualiza(Cliente cliente) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(cliente);
            et.commit();
            System.out.println("Atualizando Cliente: " + cliente);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void remove(Cliente cliente) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
            et.commit();
            System.out.println("Removendo Cliente: " + cliente);
        } catch (Exception e) {
            et.rollback();
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listaTodos() {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        System.out.println("Listando todos os Clientes: " + clientes);
        return clientes;
    }

    public List<Cliente> listaPorNome(String nome) {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
        System.out.println("Listando Clientes por nome (" + nome + "): " + clientes);
        return clientes;
    }

    public void salvar(Cliente cliente) {
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        return clientes != null ? clientes : Collections.emptyList(); // Garante que nunca retorne null
    }

    public void deletarCliente(Long clienteId) {
    }
}


