package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.fes.scoa.util.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;


public class TurmasProfessorController implements Initializable {
    @FXML
    public TableColumn<SalasTurmas, String> predioCol;
    @FXML
    public TableColumn<SalasTurmas, String> andarCol;
    @FXML
    public TableColumn<SalasTurmas, String> salaNomeCol;
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<SalasTurmas> tabela;
    @FXML
    private TableColumn<SalasTurmas, String> disciplinaCol;
    @FXML
    private TableColumn<SalasTurmas, String> salaCol;
    @FXML
    private TableColumn<SalasTurmas, String> horaCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final ObservableList<SalasTurmas> lista;
    private Pessoa pessoa = null;

    public TurmasProfessorController(Pessoa pessoa1) {
        lista = ProfessorDAO.turmas(pessoa);
        pessoa = pessoa1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disciplinaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getTurma().getDisciplina().getNomeProperty();
            }
        });
        salaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getSala().getCodLocalizacaoProperty();
            }
        });
        predioCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getSala().getSalaPredioProperty();
            }
        });
        andarCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getSala().getSalaAndarProperty();
            }
        });
        salaNomeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getSala().getSalaNomeProperty();
            }
        });
        horaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SalasTurmas, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SalasTurmas, String> r) {
                return r.getValue().getHoraProperty();
            }
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
        if (pessoa == null) return;
        String text = "";
        if (campoBuscar != null) text = campoBuscar.getText();
        ObservableList<SalasTurmas> lista;
        if (text.length() > 0) {
            lista = ProfessorDAO.buscarTurmas(text);
        } else {
            lista = ProfessorDAO.turmas(pessoa);
        }
        tabela.setItems(lista);
    }
}
