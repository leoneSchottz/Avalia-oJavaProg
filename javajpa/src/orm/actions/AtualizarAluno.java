package orm.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;


public class AtualizarAluno {
    
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
        EntityManager manager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Qual o id que deseja atualizar");
		Long id = sc.nextLong();
        
        Aluno aluno1 = manager.find(Aluno.class, id);
		
		
		System.out.println("Nome do aluno");
		aluno1.setNome(sc.next());
		
		System.out.println("Email do aluno");
		aluno1.setEmail(sc.next());
		
		System.out.println("Cpf do aluno");
		aluno1.setCpf(sc.next());
		
		System.out.println("Endereço do aluno");
		aluno1.setEndereco(sc.next());
		
		System.out.println("Naturalidade do aluno");
		aluno1.setNaturalidade(sc.next());
		
		System.out.println("Data de nascimento do aluno (dd/MM/yyyy)");
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aluno1.setDataNascimento(formatador.parse(sc.next()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();		
        
        manager.getTransaction().begin();
        manager.merge(aluno1);
        manager.getTransaction().commit();

        System.out.println("Tarefa Atualizada");
    }
}
