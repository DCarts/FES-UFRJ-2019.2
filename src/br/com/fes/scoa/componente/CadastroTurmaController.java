package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.AlocacaoDAOHandler;
import br.com.fes.scoa.util.HorariodeaulaDAOHandler;
import br.com.fes.scoa.util.SalaDAOHandler;
import br.com.fes.scoa.util.TurmaDAOHandler;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import org.orm.PersistentException;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CadastroTurmaController implements Initializable {


    @FXML
    public TextField campoPeriodo;

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
    public Button botaoAdicionarHorario;

    @FXML
    private TableColumn<SimpleEntry<Sala,Horariodeaula>, String> salaCol;
    @FXML
    public TableColumn<SimpleEntry<Sala,Horariodeaula>, String> predioCol;
    @FXML
    public TableColumn<SimpleEntry<Sala,Horariodeaula>, String> andarCol;
    @FXML
    public TableColumn<SimpleEntry<Sala,Horariodeaula>, String> salaNomeCol;
    @FXML
    public TableColumn<SimpleEntry<Sala,Horariodeaula>, String> horarioCol;
    @FXML
    private TableView<SimpleEntry<Sala,Horariodeaula>> horariosSelecionadosView;

    private final ObservableList<SimpleEntry<Sala,Horariodeaula>> horariosSelecionados = FXCollections.observableArrayList();

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
        horarioCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(HorariodeaulaDAOHandler.horarioToString(param.getValue().getValue()));
        });
        andarCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(SalaDAOHandler.getAndar(param.getValue().getKey().getCodLocalizacao()));
        });
        salaNomeCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(SalaDAOHandler.getSalaNome(param.getValue().getKey().getCodLocalizacao()));
        });
        predioCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(SalaDAOHandler.getPredio(param.getValue().getKey().getCodLocalizacao()));
        });

        campoPeriodo.textProperty().addListener((observable, oldValue, newValue) -> {
            if ((oldValue == null && newValue != null)
                || oldValue != null && !oldValue.equals(newValue)) {
                horariosSelecionados.clear();
            }
            testaPodeAdicionarHorario();
        });
        horariosSelecionadosView.setItems(horariosSelecionados);
        if (original != null) {
            professorSelecionado = original.getProfessor();
            labelProfessorSelecionado.setText(professorSelecionado.getPessoa().getNome());
            disciplinaSelecionada = original.getDisciplina();
            labelDisciplinaSelecionada.setText(disciplinaSelecionada.getNome());
            try {
                horariosSelecionados.addAll(AlocacaoDAOHandler.getHorariosOf(original).stream().map(ast -> new AbstractMap.SimpleEntry<Sala,Horariodeaula>(ast.getSala(), ast.getHora())).collect(Collectors.toList()));
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            botaoEnviar.setText("Salvar");
        }

    }

    private void testaPodeAdicionarHorario() {
            botaoAdicionarHorario.setDisable(campoPeriodo.getCharacters().toString().trim().isEmpty()
                    || disciplinaSelecionada == null
                    || professorSelecionado == null);
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
            if (disciplinaSelecionada != selected)
                horariosSelecionados.clear();
            disciplinaSelecionada = selected;
            if (selected != null) {
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
        testaPodeAdicionarHorario();
    }

    @FXML
    public void selecionaProfessor(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_professores.fxml")));
            loader.setControllerFactory((t) -> new ListaProfessoresController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Selecionar professor");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaProfessoresController controller = loader.getController();
            Professor selected = controller.getSelectedItem();
            if (professorSelecionado != selected)
                horariosSelecionados.clear();
            professorSelecionado = selected;
            if (selected != null) {
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
        testaPodeAdicionarHorario();
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
            Horariodeaula novohorario = controller.getNovo();
            Sala novasala = controller.getSala();
            if (novohorario != null && novasala != null) {
                for (SimpleEntry<Sala,Horariodeaula> e : horariosSelecionados) {
                    if (e.getKey().getId() == novasala.getId()
                            && e.getValue().getDia().equals(novohorario.getDia())) {
                        Time start = e.getValue().getHorarioInicio();
                        Time end = e.getValue().getHorarioFim();
                        if (!(start.after(novohorario.getHorarioFim()) || end.before(novohorario.getHorarioInicio()))) {
                            Alert errAlert = new Alert(Alert.AlertType.ERROR);
                            errAlert.setTitle(errorDialogTitle);
                            errAlert.setHeaderText("Conflito de horário");
                            errAlert.setContentText("Você já está cadastrando um horário incompatível com esse.");
                            errAlert.show();
                            return;
                        }
                    }
                }
                for (Horariodeaula h : AlocacaoDAOHandler.getHorariosOf(professorSelecionado, campoPeriodo.getCharacters().toString())) {
                    if (h.getDia().equals(novohorario.getDia())) {
                        Time start = h.getHorarioInicio();
                        Time end = h.getHorarioFim();
                        if (!(start.after(novohorario.getHorarioFim()) || end.before(novohorario.getHorarioInicio()))) {
                            Alert errAlert = new Alert(Alert.AlertType.ERROR);
                            errAlert.setTitle(errorDialogTitle);
                            errAlert.setHeaderText("Conflito de horário");
                            errAlert.setContentText("O professor selecionado já tem alguma turma aula no horário selecionado.");
                            errAlert.show();
                            return;
                        }
                    }
                }
                for (Horariodeaula h : AlocacaoDAOHandler.getHorariosOf(novasala, campoPeriodo.getCharacters().toString())) {
                    if (h.getDia().equals(novohorario.getDia())) {
                        Time start = h.getHorarioInicio();
                        Time end = h.getHorarioFim();
                        if (!(start.after(novohorario.getHorarioFim()) || end.before(novohorario.getHorarioInicio()))) {
                            Alert errAlert = new Alert(Alert.AlertType.ERROR);
                            errAlert.setTitle(errorDialogTitle);
                            errAlert.setHeaderText("Conflito de horário");
                            errAlert.setContentText("A sala selecionado já tem alguma turma aula no horário selecionado.");
                            errAlert.show();
                            return;
                        }
                    }
                }
                horariosSelecionados.add(new SimpleEntry<>(novasala, novohorario));
            }

        } catch (Exception err) {
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
        if (campoPeriodo.getCharacters().toString().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Período não selecionado");
            errAlert.setContentText("Você precisa digitar um período!");
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
                    original.setPeriodo(campoPeriodo.getCharacters().toString());
                    //@todo original.setSala(salaSelecionado);
                    //@todo original.setHorario(horariosSelecionados);
                    TurmaDAO.save(original);
                } else {
                    TurmaDAOHandler.cadastraTurma(
                            disciplinaSelecionada,
                            professorSelecionado,
                            campoPeriodo.getCharacters().toString(),
                            horariosSelecionados
                    );
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
        horariosSelecionadosView.setEditable(edit);
        botaoAdicionarHorario.setDisable(!edit);
        botaoSelecionarDisciplina.setDisable(!edit);
        botaoSelecionarProfessor.setDisable(!edit);
        botaoEnviar.setDisable(!edit);
    }
}
