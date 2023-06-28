package orm.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.DateFormatter;

import orm.modelo.Aluno;


public class InserirAluno {
	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome do aluno");
		aluno1.setNome(sc.nextLine());
		
		System.out.println("Email do aluno");
		aluno1.setEmail(sc.nextLine());
		
		System.out.println("Cpf do aluno");
		aluno1.setCpf(sc.nextLine());
		
		System.out.println("Endere�o do aluno");
		aluno1.setEndereco(sc.nextLine());
		
		System.out.println("Naturalidade do aluno");
		aluno1.setNaturalidade(sc.nextLine());
		
		System.out.println("Data de nascimento do aluno");
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aluno1.setDataNascimento(formatador.parse(sc.nextLine()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno1);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa inserida, ID: "+aluno1.getId());
		
		manager.close();
		factory.close();
	}
}
