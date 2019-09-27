package br.com.fes.scoa.teste;

import javax.persistence.EntityManager;

import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Pessoa pessoa = em.find(Pessoa.class, 2);
		
		pessoa.setNome("Pedro S�");
		
		System.out.println(pessoa.getNome());
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
