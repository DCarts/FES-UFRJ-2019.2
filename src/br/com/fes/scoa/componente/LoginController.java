package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Pessoa;
import br.com.fes.scoa.model.PessoaDAO;
import br.com.fes.scoa.model.SCOAPersistentManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.query.NativeQuery;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

	@FXML 
	public TextField campoLogin;
	
	@FXML 
	public PasswordField campoSenha;
	
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

			if ("1".equals(q.getSingleResult().toString())) {
				//loogou!

                Pessoa p = PessoaDAO.loadPessoaByQuery("cpf='"+campoLogin.getCharacters().toString()+ "'", null);

                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/home.fxml")));
                loader.setControllerFactory((t) -> new HomeController(p));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("SCOA");
                stage.setScene(new Scene(root));
                Platform.runLater(stage::requestFocus);
                stage.onCloseRequestProperty().setValue(evt -> {
                    try {
                        SCOAPersistentManager.instance().disposePersistentManager();
                    } catch (Exception err) {}
                    Platform.exit();
                });
                stage.show();
                campoLogin.getScene().getWindow().onCloseRequestProperty().setValue(Event::consume);
                campoLogin.getScene().getWindow().hide();
			}
			else {
				Alert errAlert = new Alert(Alert.AlertType.ERROR);
				errAlert.setTitle("Problema no login");
				errAlert.setHeaderText("Não foi possível logar");
				errAlert.setContentText("CPF ou senha inválidos.");
				errAlert.show();
				return;
			}
		} catch (Exception err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle("Erro");
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText("Erro durante o login");
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
			err.printStackTrace();
		}


	}
	 

}
