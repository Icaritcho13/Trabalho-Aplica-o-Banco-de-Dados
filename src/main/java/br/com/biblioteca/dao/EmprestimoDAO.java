package br.com.biblioteca.dao;

import br.com.biblioteca.model.Emprestimo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmprestimoDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("bibliotecaPU");

    public void salvar(Emprestimo emprestimo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void atualizar(Emprestimo emprestimo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(emprestimo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Emprestimo emprestimo = em.find(Emprestimo.class, id);
            if (emprestimo != null) {
                em.remove(emprestimo);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Emprestimo buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Emprestimo.class, id);
        } finally {
            em.close();
        }
    }

    public List<Emprestimo> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Emprestimo> query = em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Emprestimo> buscarPorNomeAluno(String nomeAluno) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Emprestimo> query = em.createQuery(
                "SELECT e FROM Emprestimo e WHERE e.aluno.nome LIKE :nome", Emprestimo.class);
            query.setParameter("nome", "%" + nomeAluno + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static void fechar() {
        emf.close();
    }
}
