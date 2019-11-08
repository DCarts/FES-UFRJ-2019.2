package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.*;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    private final String labelSalaEmpryText = "Nenhuma sala selecionada";

    @FXML
    public Button botaoAdicionarHorario;

    @FXML
    public ListView<HorarioDeAula> horariosSelecionadosView;
    private final ObservableList<HorarioDeAula> horariosSelecionados = FXCollections.observableArrayList();

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
        if (original != null) {
            // @TODO setar valores pros originais
            botaoEnviar.setText("Salvar");
        }

    }

    @FXML
    public void selecionaDisciplina(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/lista_disciplina.fxml")));
            loader.setControllerFactory((t) -> new ListaDisciplinasController());
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaDisciplinasController controller = loader.getController();
            /*TipoHoraDoDia novo = controller;
            if (novo != null) {
                // @TODO fazer selecao
                horariosSelecionados.add(novo);
            }*/

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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_horario.fxml")));
            loader.setControllerFactory((t) -> new CadastroHorarioController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroHorarioController controller = loader.getController();
            HorarioDeAula novo = controller.getNovo();
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
    public void selecionaSala(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_horario.fxml")));
            loader.setControllerFactory((t) -> new CadastroHorarioController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroHorarioController controller = loader.getController();
            HorarioDeAula novo = controller.getNovo();
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
    public void adicionaHorario(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_horario.fxml")));
            loader.setControllerFactory((t) -> new CadastroHorarioController(null));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroHorarioController controller = loader.getController();
            HorarioDeAula novo = controller.getNovo();
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
        throw new UnsupportedOperationException("falta implementar");
        /*String s = "\n" +
                campoNome.getCharacters() + '\n' +
                campoDataNasc.getValue().toString() + '\n' +
                campoCPF.getPlainText() + '\n' +
                campoEndereco.getCharacters() + '\n' +
                campoEmail.getCharacters() + '\n';
        System.out.println(s);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(confirmDialogTitle);
        alert.setHeaderText(confirmDialogHeader);
        alert.setContentText(confirmDialogContent);
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        setEditable(false);
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                if (modoEditar) {
                    Aluno aluno = AlunoDAO.editar(
                            editarPessoa.getId(),
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().toString(),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString());
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equals(aluno.getPessoa().getId())) {
                            lista.set(i,aluno.getPessoa());
                            break;
                        }
                    }
                } else {
                    Aluno aluno = AlunoDAO.cadastrar(
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().toString(),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString());
                    lista.add(aluno.getPessoa());
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
        }*/
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
