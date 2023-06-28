package orm.actions;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Aluno;


public class BuscaAlunos {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
        EntityManager manager = factory.createEntityManager();

        // 
        String sql = "select a from Aluno a";

        Query query = manager.createQuery(sql);
//        query.setParameter("paramFinalizado", true);

        @SuppressWarnings("unchecked")
        List<Aluno> lista = query.getResultList();

        for (Aluno aluno : lista) {
            System.out.println(aluno.getNome());
        }
    }
}
