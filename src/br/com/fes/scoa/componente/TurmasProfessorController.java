package br.com.fes.scoa.componente;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.model.Professor;
import br.com.fes.scoa.model.Turma;
import br.com.fes.scoa.util.HorariodeaulaDAOHandler;
import br.com.fes.scoa.util.ProfessorDAOHandler;
import br.com.fes.scoa.util.SalaDAOHandler;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.orm.PersistentException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TurmasProfessorController implements Initializable {
    @FXML
    public TableColumn<Turma, String> predioCol;
    @FXML
    public TableColumn<Turma, String> andarCol;
    @FXML
    public TableColumn<Turma, String> salaNomeCol;
    @FXML
    private Label titleLabel;
    @FXML
    private TableView<Turma> tabela;
    @FXML
    private TableColumn<Turma, String> disciplinaCol;
    @FXML
    private TableColumn<Turma, String> salaCol;
    @FXML
    private TableColumn<Turma, String> horaCol;

    @FXML
    private Button botaoSelecionar;

    private final ObservableList<Turma> lista;

    private final boolean doSelect;

    private final boolean includeTeacher;

    private Turma selected = null;

    public TurmasProfessorController(Professor professor) {
        lista = FXCollections.observableArrayList();
        try {
            lista.addAll(ProfessorDAOHandler.turmas(professor));
        } catch (PersistentException e) {
            e.printStackTrace(); // @TODO passar erro
        }
        doSelect = false;
        includeTeacher = false;
    }

    public TurmasProfessorController(ObservableList<Turma> turmas, boolean doSelect, boolean includeTeacher) {
        lista = turmas;
        this.doSelect = doSelect;
        this.includeTeacher = includeTeacher;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disciplinaCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getDisciplina().getNome());});
        horaCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> HorariodeaulaDAOHandler.horarioToString(ast.getHora())).collect(Collectors.toList())));
        });
        andarCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getAndar(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        salaNomeCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getSalaNome(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        predioCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getPredio(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        if (includeTeacher) {
            TableColumn<Turma, String> professorCol = new TableColumn<>();
            professorCol.setText("Professor");
            professorCol.setCellValueFactory(param -> {
                return new ReadOnlyStringWrapper(param.getValue().getProfessor().getPessoa().getNome());
            });
            tabela.getColumns().add(1,professorCol);
        }
        tabela.setItems(lista);
        if (doSelect) {
            tabela.getSelectionModel().selectedItemProperty().addListener((a, b, newSelection) -> {
                selected = newSelection;
                botaoSelecionar.setDisable(selected == null);
            });

        }
        else {
            botaoSelecionar.setDisable(true);
            botaoSelecionar.setGraphic(null);
        }
    }

    public Turma getSelected() {
        return selected;
    }

    @FXML
    public void onSeleciona(ActionEvent event) {
        botaoSelecionar.getScene().getWindow().hide();
    }
}
