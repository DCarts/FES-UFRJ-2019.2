package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.fes.scoa.util.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;


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
    private Pessoa pessoa = null;

    public TurmasProfessorController(Pessoa pessoa) {
        lista = ProfessorDAO.turmas(pessoa);
        this.pessoa = pessoa;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disciplinaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return r.getValue().getDisciplina().getNomeProperty();
            }
        });
        salaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return r.getValue().getSala().getCodLocalizacaoProperty();
            }
        });
        predioCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return r.getValue().getSala().getSalaPredioProperty();
            }
        });
        andarCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return r.getValue().getSala().getSalaAndarProperty();
            }
        });
        salaNomeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return r.getValue().getSala().getSalaNomeProperty();
            }
        });
        horaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new SimpleStringProperty(horaAsString(r.getValue().getHorario()));
            }
        });

        atualizarLista();
    }
    
    private String horaAsString(List<HorarioDeAula> horarios) {
    	StringBuilder sb = new StringBuilder();
    	
    	int i = 0;
    	for (; i < horarios.size()-1; i++) {
    		sb.append(horarios.get(i).toString());
    		sb.append('\n');
    	}
    	if (horarios.size() > 0) {
    		sb.append(horarios.get(i));
    	}
    	
    	return sb.toString();
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
        ObservableList<Turma> lista;
        if (text.length() > 0) {
            lista = ProfessorDAO.buscarTurmas(text);
        } else {
            lista = ProfessorDAO.turmas(pessoa);
        }
        tabela.setItems(lista);
    }
}
