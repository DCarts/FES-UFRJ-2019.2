package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.TurmaDAOHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroTurmaController implements Initializable {

    @FXML
    public Button botaoSelecionarDisciplina;

    @FXML
    public Label labelDisciplinaSelecionada;
    private Disciplina disciplinaSelecionada = null;
    private final String labelDisciplinaEmptyText = "Nenhuma disciplina selecionada";

    @FXML
    public Button botaoSelecionarProfessor;

    @FXML
    public Label labelProfessorSelecionado;
    private Professor professorSelecionado = null;
    private final String labelProfessorEmptyText = "Nenhum professor selecionado";

    @FXML
    public Button botaoSelecionarSala;

    @FXML
    public Label labelSalaSelecionada;
    private Sala salaSelecionado = null;
    private final String labelSalaEmptyText = "Nenhuma sala selecionada";

    @FXML
    public Button botaoAdicionarHorario;

    @FXML
    public ListView<Horariodeaula> horariosSelecionadosView;
    private final ObservableList<Horariodeaula> horariosSelecionados = FXCollections.observableArrayList();

    @FXML
    public Button botaoEnviar;

    private final Turma original;
    private Turma nova = null;
    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroTurmaController(Turma original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar aluno";
            confirmDialogHeader = "Confirmar atualização da turma";
            confirmDialogContent = "Tem certeza que deseja atualizar a turma?";
            successDialogTitle = "Turma atualizada";
            successDialogHeader = "Turma atualizada:";
            successDialogContent = "O turma foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de turma";
            confirmDialogContent = "Tem certeza que deseja cadastrar a turma?";
            successDialogTitle = "Turma cadastrada";
            successDialogHeader = "Turma cadastrada:";
            successDialogContent = "A turma foi cadastrada com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        horariosSelecionadosView.setItems(horariosSelecionados);
        if (original != null) {
            // @TODO setar valores pros originais

            botaoEnviar.setText("Salvar");
        }

    }

    @FXML
    public void selecionaDisciplina(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_disciplinas.fxml")));
            loader.setControllerFactory((t) -> new ListaDisciplinasController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaDisciplinasController controller = loader.getController();
            Disciplina selected = controller.getSelectedItem();
            disciplinaSelecionada = selected;
            if (selected != null) {
                // @TODO fazer selecao
                labelDisciplinaSelecionada.setText(selected.getNome());
            }
            else {
                labelDisciplinaSelecionada.setText(labelDisciplinaEmptyText);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }

    }

    @FXML
    public void selecionaProfessor(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_professores.fxml")));
            loader.setControllerFactory((t) -> new ListaProfessoresController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaProfessoresController controller = loader.getController();
            Professor selected = controller.getSelectedItem();
            professorSelecionado = selected;
            if (selected != null) {
                // @TODO fazer selecao
                labelProfessorSelecionado.setText(selected.getPessoa().getNome());
            }
            else {
                labelProfessorSelecionado.setText(labelProfessorEmptyText);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }

    }

    @FXML
    public void adicionaHorario(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_salahorario.fxml")));
            loader.setControllerFactory((t) -> new CadastroSalaHorarioController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSalaHorarioController controller = loader.getController();
            Horariodeaula novo = controller.getNovo();
            if (novo != null) {
                if (horariosSelecionados.contains(novo)) {
                    // @TODO este horario ja esta selecionado
                    return;
                }
                horariosSelecionados.add(novo);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        if (professorSelecionado == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Professor não selecionado");
            errAlert.setContentText("Você precisa selecionar um professor!");
            errAlert.show();
            return;
        }
        if (disciplinaSelecionada == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Disciplina não selecionada");
            errAlert.setContentText("Você precisa selecionar uma disciplina!");
            errAlert.show();
            return;
        }
        if (horariosSelecionados.isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Horários não selecionados");
            errAlert.setContentText("Você precisa selecionar pelo menos um horário!");
            errAlert.show();
            return;
        }
        // @TODO testar selecao
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(confirmDialogTitle);
        alert.setHeaderText(confirmDialogHeader);
        alert.setContentText(confirmDialogContent);
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        setEditable(false);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                if (original != null) {
                    original.setProfessor(professorSelecionado);
                    original.setDisciplina(disciplinaSelecionada);
                    //@todo original.setSala(salaSelecionado);
                    //@todo original.setHorario(horariosSelecionados);
                    TurmaDAO.save(original);
                } else {
                    TurmaDAOHandler.cadastraTurma(
                            disciplinaSelecionada,
                            professorSelecionado
                    );
                }
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(successDialogTitle);
                successAlert.setHeaderText(successDialogHeader);
                successAlert.setContentText(successDialogContent);
                successAlert.show();
            } catch (Exception err) {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle(errorDialogTitle);
                errAlert.setHeaderText(err.toString());
                errAlert.setContentText(errorDialogContent);
                err.printStackTrace();
                errAlert.show();
            }
            finally {
                botaoEnviar.getScene().getWindow().hide();
            }

        }
        else {
            setEditable(true);
        }
    }

    private void setEditable(boolean edit) {
        horariosSelecionadosView.setEditable(edit);
        botaoAdicionarHorario.setDisable(!edit);
        botaoSelecionarDisciplina.setDisable(!edit);
        botaoSelecionarProfessor.setDisable(!edit);
        botaoSelecionarSala.setDisable(!edit);
        botaoEnviar.setDisable(!edit);
    }
}
