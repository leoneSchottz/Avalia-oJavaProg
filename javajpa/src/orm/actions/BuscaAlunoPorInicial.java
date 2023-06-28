package orm.actions;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Aluno;


public class BuscaAlunoPorInicial {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
        EntityManager manager = factory.createEntityManager();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Por qual letra deseja buscar?");
        String param = sc.nextLine()+"%";
        sc.close();
        // 
        String sql = "select a from Aluno a where a.nome like ?0";

        Query query = manager.createQuery(sql);
        query.setParameter(0, param);
//        query.setParameter("paramFinalizado", true);

        @SuppressWarnings("unchecked")
        List<Aluno> lista = query.getResultList();

        for (Aluno aluno : lista) {
            System.out.println(aluno.getNome());
        }
    }
}
