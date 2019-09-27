package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Pessoa pessoa = em.find(Pessoa.class, 2);
		
		pessoa.setNome("Pedro Sá");
		
		System.out.println(pessoa.getNome());
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
