package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Horariodeaula;
import br.com.fes.scoa.model.Professor;
import br.com.fes.scoa.model.Turma;
import br.com.fes.scoa.util.ProfessorDAOHandler;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


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
        disciplinaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper(r.getValue().getDisciplina().getNome());
            }
        });
        salaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper("derp");
            }
        });
        predioCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper("derp");
            }
        });
        andarCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper("derp");
            }
        });
        salaNomeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper("derp");
            }
        });
        horaCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Turma, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Turma, String> r) {
                return new ReadOnlyStringWrapper("derp");
            }
        });

        atualizarLista();
    }
    
    private String horaAsString(List<Horariodeaula> horarios) {
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
