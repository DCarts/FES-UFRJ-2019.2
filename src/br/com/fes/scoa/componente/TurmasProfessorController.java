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
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
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
    private Button botaoRemover;
    @FXML
    private TableView<Turma> tabela;
    @FXML
    private TableColumn<Turma, String> disciplinaCol;
    @FXML
    private TableColumn<Turma, String> salaCol;
    @FXML
    private TableColumn<Turma, String> horaCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final ObservableList<Turma> lista;
    private Professor professor = null;

    public TurmasProfessorController(Professor professor) {
        lista = FXCollections.observableArrayList();
        try {
            lista.addAll(ProfessorDAOHandler.turmas(professor));
        } catch (PersistentException e) {
            e.printStackTrace(); // @TODO passar erro
        }
        this.professor = professor;
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

        atualizarLista();
    }

    public void onRemoverSelecionados(ActionEvent actionEvent) {}

    @FXML
    public void onCriar(ActionEvent actionEvent) {}

    @FXML
    public void onBuscar(KeyEvent evt) {}

    @FXML
    public void atualizarLista() {
        if (professor == null) return;
        String text = "";
        if (campoBuscar != null) text = campoBuscar.getText();
        ObservableList<Turma> lista;
        try {
            if (text.length() > 0) {
                lista = ProfessorDAOHandler.buscarTurmas(text);
            } else {
                lista = ProfessorDAOHandler.turmas(professor);
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace(); // @TODO passar erro
        }
    }
}
