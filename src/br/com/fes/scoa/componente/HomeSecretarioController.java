package br.com.fes.scoa.componente;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeSecretarioController implements Initializable {

    @FXML
    public Button botaoListaAlunos;

    @FXML
    public Button botaoListaProfessores;

    @FXML
    public Button botaoListaDisciplinas;

    @FXML
    public Button botaoListaSalas;

    @FXML
    public Button botaoAlocarTurma;

    @FXML
    public void onListaAlunos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_alunos.fxml")));
            loader.setControllerFactory((t) -> new ListaAlunosController(false));
            Parent root = loader.load();
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
    public void onListaProfessores(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_professores.fxml")));
            loader.setControllerFactory((t) -> new ListaProfessoresController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Professores");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaDisciplinas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_disciplinas.fxml")));
            loader.setControllerFactory((t) -> new ListaDisciplinasController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Disciplinas");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaSalas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_salas.fxml")));
            loader.setControllerFactory((t) -> new ListaSalasController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Salas");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAlocaTurma(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_turma.fxml")));
            loader.setControllerFactory((t) -> new CadastroTurmaController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Alocar turma");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(botaoAlocarTurma.getScene().getWindow());
            stage.show();
            Platform.runLater(stage::requestFocus);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
