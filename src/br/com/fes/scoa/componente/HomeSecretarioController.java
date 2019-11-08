package br.com.fes.scoa.componente;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeSecretarioController implements Initializable {

    @FXML
    public Button botaoNovoAluno;

    @FXML
    public Button botaoListaAlunos;

    @FXML
    public Button botaoNovoProfessor;

    @FXML
    public Button botaoNovaDisciplina;

    @FXML
    public Button botaoListaProfessores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void onNovoAluno(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_aluno.fxml")));
            loader.setControllerFactory((t) -> new CadastroAlunoController(FXCollections.observableArrayList(), null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar aluno");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaAlunos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_alunos.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Alunos");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNovoProfessor(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_professor.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Cadastrar professor");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNovaDisciplina(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_disciplina.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Cadastrar disciplina");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onListaProfessores(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_professores.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Professores");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
