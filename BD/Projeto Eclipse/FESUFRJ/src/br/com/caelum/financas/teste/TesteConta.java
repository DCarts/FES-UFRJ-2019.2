package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.util.JPAUtil;

import java.time.LocalDate;

public class TesteConta {
	
	public static void main(String[] args) {
		
		
		
		Pessoa pessoa1 = new Pessoa("Pedro", LocalDate.parse("1987-12-04"), "14785214787", "UFRJ Fundao", "ufrjfudnaopedro@ufrj.br");

		EntityManager em = new JPAUtil().getEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(pessoa1);
		em.getTransaction().commit();
		
		
		em.close();
		
		
	}

}
