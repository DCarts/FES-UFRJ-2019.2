package br.com.fes.scoa.componente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
		
	}
	 

}
