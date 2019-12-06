package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Professor;
import br.com.fes.scoa.model.Turma;
import br.com.fes.scoa.util.TurmaDAOHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.orm.PersistentException;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TabProfessorController implements Initializable {

    @FXML
    public ListView<String> periodoListView;

    @FXML
    public AnchorPane turmasPane;

    private final Professor professor;

    public TabProfessorController(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        periodoListView.getSelectionModel().selectedItemProperty().addListener(
                (a, b, newSelection) -> selectionChanged(newSelection));
        try {
            periodoListView.setItems(TurmaDAOHandler.periodosProfessor(professor));
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    private void selectionChanged(String newEntry) {
        if (newEntry == null) {
            //unselected
            turmasPane.getChildren().clear();
        }
        else {
            //selected
            turmasPane.getChildren().add(listaTurmas(newEntry));
        }
    }

    private Parent listaTurmas(String periodo) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/turmas_professor.fxml")));
            ObservableList<Turma> turmas = TurmaDAOHandler.turmasProfessorPeriodo(professor,periodo);
            loader.setControllerFactory((t) -> new TurmasProfessorController(turmas, false, false));
            Parent root = loader.load();
            return root;
        } catch (Exception err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle("Erro");
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText("Erro ao listar turmas");
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
            err.printStackTrace();
            return null;
        }
    }

}
