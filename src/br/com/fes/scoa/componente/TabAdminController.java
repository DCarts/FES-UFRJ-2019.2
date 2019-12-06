package br.com.fes.scoa.componente;

import javafx.application.Platform;
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

public class TabAdminController implements Initializable {

    @FXML
    public Button botaoListaAlunos;

    @FXML
    public Button botaoListaSecretarios;

    @FXML
    public Button botaoListaAdmins;

    @FXML
    public Button botaoListaProfessores;

    @FXML
    public Button botaoListaDisciplinas;

    @FXML
    public Button botaoListaCursos;

    @FXML
    public Button botaoListaAreas;

    @FXML
    public Button botaoListaSalas;

    @FXML
    public Button botaoListaSituacoes;

    @FXML
    public Button botaoAlocarTurma;

    @FXML
    public Button botaoInscreverAluno;

    @FXML
    public void onListaAlunos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_alunos.fxml")));
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
    public void onListaSecretarios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_secretarios.fxml")));
            loader.setControllerFactory((t) -> new ListaSecretariosController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Secretários");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaAdmins(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_sysadmins.fxml")));
            loader.setControllerFactory((t) -> new ListaSysadminsController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Administradores");
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_professores.fxml")));
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_disciplinas.fxml")));
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
    public void onListaCursos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_cursos.fxml")));
            loader.setControllerFactory((t) -> new ListaCursosController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cursos");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaAreas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_areas.fxml")));
            loader.setControllerFactory((t) -> new ListaAreasController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Áreas");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onListaSituacoes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_situacao.fxml")));
            loader.setControllerFactory((t) -> new ListaAreasController(false));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Situações");
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_salas.fxml")));
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_turma.fxml")));
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

    @FXML
    public void onInscrever(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_inscricao.fxml")));
            loader.setControllerFactory((t) -> new CadastroInscricaoController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Inscrever aluno");
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
