package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.SCOAPersistentManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.hibernate.query.NativeQuery;
import org.orm.PersistentException;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

	@FXML 
	public TextField campoLogin;
	
	@FXML 
	public TextField campoSenha;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void enter( ActionEvent event) {
		System.out.println("Cheguei!");

		try {
			NativeQuery q = SCOAPersistentManager.instance().getSession().createSQLQuery(
					"CALL loga_usuario(:pessoa_cpf, :pessoa_senha)")
					.setParameter("pessoa_cpf", campoLogin.getCharacters().toString())
					.setParameter("pessoa_senha", campoSenha.getCharacters().toString());

			System.out.println(q.getSingleResult());

			if (Integer.valueOf(1).equals(q.getSingleResult())) {
				//loogou!
				System.out.println("logado!");
			}
			else {
				System.out.println("nao logado!");
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}


	}
	 

}
