package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.AlocacaoDAOHandler;
import br.com.fes.scoa.util.InscricaoDAOHandler;
import br.com.fes.scoa.util.TurmaDAOHandler;
import javafx.application.Platform;
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
import org.orm.PersistentException;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CadastroInscricaoController implements Initializable {


    @FXML
    public TextField campoPeriodo;

    @FXML
    public Button botaoSelecionarTurma;

    @FXML
    public Label labelTurmaSelecionada;
    private Turma turmaSelecionada = null;
    private final String labelTurmaEmptyText = "Nenhuma turma selecionada";

    @FXML
    public Button botaoSelecionarAluno;

    @FXML
    public Label labelAlunoSelecionado;
    private Aluno alunoSelecionado = null;
    private final String labelAlunoEmptyText = "Nenhum aluno selecionado";

    @FXML
    public Button botaoEnviar;

    private final Inscricao_aluno original;
    private Inscricao_aluno nova = null;
    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroInscricaoController(Inscricao_aluno original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar inscrição";
            confirmDialogHeader = "Confirmar atualização da inscrição";
            confirmDialogContent = "Tem certeza que deseja atualizar a inscrição?";
            successDialogTitle = "Inscrição atualizada";
            successDialogHeader = "Inscrição atualizada:";
            successDialogContent = "A inscrição foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar inscrição";
            confirmDialogHeader = "Confirmar inscrição em turma";
            confirmDialogContent = "Tem certeza que deseja realizar a inscrição?";
            successDialogTitle = "Inscrição realizada";
            successDialogHeader = "Inscrição realizada:";
            successDialogContent = "A inscrição foi realizada com sucesso.";
            errorDialogTitle = "Erro na isncrição";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        campoPeriodo.textProperty().addListener((observable, oldValue, newValue) -> {
            testaPodeSelecionarTurma();
        });
        if (original != null) {
            alunoSelecionado = original.getAluno();
            labelAlunoSelecionado.setText(alunoSelecionado.getPessoa().getNome());
            turmaSelecionada = original.getTurma();
            labelTurmaSelecionada.setText(turmaSelecionada.getDisciplina()+" com "+turmaSelecionada.getProfessor().getPessoa().getNome());
            botaoEnviar.setText("Salvar");
        }

    }

    private void testaPodeSelecionarTurma() {
            botaoSelecionarTurma.setDisable(campoPeriodo.getCharacters().toString().trim().isEmpty());
    }

    @FXML
    public void selecionaTurma(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/turmas_professor.fxml")));
            ObservableList<Turma> turmas = TurmaDAOHandler.turmasPeriodo(campoPeriodo.getCharacters().toString());
            loader.setControllerFactory((t) -> new TurmasProfessorController(turmas, true, true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Selecionar turma");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            TurmasProfessorController controller = loader.getController();
            Turma selected = controller.getSelected();
            turmaSelecionada = selected;
            if (selected != null) {
                labelTurmaSelecionada.setText(selected.getDisciplina()+" com "+selected.getProfessor().getPessoa().getNome());
            }
            else {
                labelTurmaSelecionada.setText(labelTurmaEmptyText);
            }

        } catch (Exception err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }
        testaPodeSelecionarTurma();
    }

    @FXML
    public void selecionaAluno(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_alunos.fxml")));
            loader.setControllerFactory((t) -> new ListaAlunosController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Selecionar aluno");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaAlunosController controller = loader.getController();
            Aluno selected = controller.getSelectedItem();
            alunoSelecionado = selected;
            if (selected != null) {
                labelAlunoSelecionado.setText(selected.getPessoa().getNome());
            }
            else {
                labelAlunoSelecionado.setText(labelAlunoEmptyText);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }
        testaPodeSelecionarTurma();
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        if (alunoSelecionado == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Professor não selecionado");
            errAlert.setContentText("Você precisa selecionar um professor!");
            errAlert.show();
            return;
        }
        if (turmaSelecionada == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Disciplina não selecionada");
            errAlert.setContentText("Você precisa selecionar uma disciplina!");
            errAlert.show();
            return;
        }
        if (campoPeriodo.getCharacters().toString().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Período não selecionado");
            errAlert.setContentText("Você precisa digitar um período!");
            errAlert.show();
            return;
        }
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
                for (Alocacao_sala_turma ast : AlocacaoDAOHandler.getHorariosOf(turmaSelecionada)) {
                    for (Turma t : Stream.of(alunoSelecionado.inscricao_aluno.toArray()).map(Inscricao_aluno::getTurma).collect(Collectors.toList())) {
                        if (t.getId() == turmaSelecionada.getId()) continue;
                        for (Horariodeaula ja_usado : Stream.of(t.alocacao_sala_turma.toArray()).map(Alocacao_sala_turma::getHora).collect(Collectors.toList())) {
                            if (ast.getHora().getDia().equals(ja_usado.getDia())) {
                                Time start = ast.getHora().getHorarioInicio();
                                Time end = ast.getHora().getHorarioFim();
                                if (!(start.after(ja_usado.getHorarioFim()) || end.before(ja_usado.getHorarioInicio()))) {
                                    Alert errAlert = new Alert(Alert.AlertType.ERROR);
                                    errAlert.setTitle(errorDialogTitle);
                                    errAlert.setHeaderText("Conflito de horário");
                                    errAlert.setContentText("O aluno selecionado já está ocupado durante as aulas da turma selecionada.");
                                    errAlert.show();
                                    return;
                                }
                            }
                        }
                    }
                }
                if (original != null) {
                    original.setAluno(alunoSelecionado);
                    original.setTurma(turmaSelecionada);
                    Inscricao_alunoDAO.save(original);
                } else {
                    InscricaoDAOHandler.cadastraInscricao_aluno(
                            alunoSelecionado,
                            turmaSelecionada);
                }
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(successDialogTitle);
                successAlert.setHeaderText(successDialogHeader);
                successAlert.setContentText(successDialogContent);
                successAlert.show();
                botaoEnviar.getScene().getWindow().hide();
            } catch (Exception err) {
                try {
                    if (SCOAPersistentManager.instance().getSession().getTransaction().isActive()) {
                        SCOAPersistentManager.instance().getSession().getTransaction().rollback();
                    }
                    SCOAPersistentManager.instance().getSession().close();
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle(errorDialogTitle);
                errAlert.setHeaderText(err.toString());
                errAlert.setContentText(errorDialogContent);
                err.printStackTrace();
                errAlert.show();
            }
            finally {
                setEditable(true);
            }

        }
        else {
            setEditable(true);
        }
    }

    private void setEditable(boolean edit) {
        botaoSelecionarTurma.setDisable(!edit);
        botaoSelecionarAluno.setDisable(!edit);
        botaoEnviar.setDisable(!edit);
    }
}
