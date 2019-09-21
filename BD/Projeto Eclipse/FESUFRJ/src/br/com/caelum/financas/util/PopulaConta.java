package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Disciplina;
import br.com.caelum.financas.modelo.Pessoa;

public class PopulaConta {

  public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		//Conta conta1 = new Conta();
		
		Disciplina conta1 = new Disciplina();
		conta1.setDescricao("Conserta PC");
		conta1.setNome("Informatica");

		//conta1.setBanco("001 - BANCO DO BRASIL");
		//conta1.setNumero("16987-8");
		//conta1.setAgencia("6543");
		//conta1.setTitular("Maria dos Santos");



		// persistindo as contas
		manager.persist(conta1);

		manager.getTransaction().commit();

		manager.close();

	}
}