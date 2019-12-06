package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public Label labelNome;

    @FXML
    public Label labelCPF;

    @FXML
    public Label labelDataNasc;

    @FXML
    public Label labelEndereco;

    @FXML
    public Label labelEmail;

    @FXML
    public TabPane mainWindow;

    private final Pessoa pessoa;

    public HomeController(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelNome.setText(pessoa.getNome());
        labelCPF.setText(pessoa.getCpf());
        labelDataNasc.setText(pessoa.getData_nascimento().toString());
        labelEndereco.setText(pessoa.getEndereco());
        labelEmail.setText(pessoa.getEmail());
        try {
            if (pessoa.getSysadmins() != null) {
                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/tab_sysadmin.fxml")));
                loader.setControllerFactory((t) -> new TabAdminController());
                Parent root = loader.load();
                Tab tab = new Tab();
                tab.setText("Painel de controle");
                tab.setContent(root);
                mainWindow.getTabs().add(tab);
            }
            if (pessoa.getProfessor() != null) {
                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/tab_professor.fxml")));
                loader.setControllerFactory((t) -> new TabProfessorController(pessoa.getProfessor()));
                Parent root = loader.load();
                Tab tab = new Tab();
                tab.setText("Turmas");
                tab.setContent(root);
                mainWindow.getTabs().add(tab);
            }
            if (pessoa.getSecretario() != null) {
                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/tab_secretario.fxml")));
                loader.setControllerFactory((t) -> new TabSecretarioController(pessoa.getSecretario()));
                Parent root = loader.load();
                Tab tab = new Tab();
                tab.setText("Secretaria");
                tab.setContent(root);
                mainWindow.getTabs().add(tab);
            }
            if (pessoa.getAluno() != null) {
                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/tab_aluno.fxml")));
                loader.setControllerFactory((t) -> new TabAlunoController(pessoa.getAluno()));
                Parent root = loader.load();
                Tab tab = new Tab();
                tab.setText("Inscrições");
                tab.setContent(root);
                mainWindow.getTabs().add(tab);
            }
        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle("Erro");
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText("Erro ao listar turmas");
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
            err.printStackTrace();
        }
    }

}
