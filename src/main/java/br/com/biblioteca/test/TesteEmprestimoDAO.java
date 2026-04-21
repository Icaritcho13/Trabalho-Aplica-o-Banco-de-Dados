package br.com.biblioteca.test;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Aluno;
import br.com.biblioteca.model.Emprestimo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class TesteEmprestimoDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("bibliotecaPU");

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setMatriculaAluno(12345);
        aluno.setNome("João Silva");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();

        EmprestimoDAO dao = new EmprestimoDAO();

        // 1. Incluir
        Emprestimo emp1 = new Emprestimo();
        emp1.setDataEmprestimo(new Date());
        emp1.setDataDevolucao(null);
        emp1.setAluno(aluno);
        dao.salvar(emp1);
        System.out.println("Empréstimo salvo com ID: " + emp1.getId());

        // 2. Alterar
        emp1.setDataDevolucao(new Date());
        dao.atualizar(emp1);
        System.out.println("Empréstimo atualizado");

        // 3. Buscar por ID
        Emprestimo encontrado = dao.buscarPorId(emp1.getId());
        System.out.println("Busca por ID: " + encontrado.getDataEmprestimo());

        // 4. Buscar todos
        List<Emprestimo> todos = dao.buscarTodos();
        System.out.println("Total de empréstimos: " + todos.size());

        // 5. Buscar por nome do aluno
        List<Emprestimo> porNome = dao.buscarPorNomeAluno("João");
        System.out.println("Empréstimos do João: " + porNome.size());

        // 6. Deletar
        dao.deletar(emp1.getId());
        System.out.println("Empréstimo deletado");

        emf.close();
        EmprestimoDAO.fechar();
    }
}
