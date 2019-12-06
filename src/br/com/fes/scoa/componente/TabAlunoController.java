package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Aluno;
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

public class TabAlunoController implements Initializable {

    @FXML
    public ListView<String> periodoListView;

    @FXML
    public AnchorPane turmasPane;

    private final Aluno aluno;

    public TabAlunoController(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        periodoListView.getSelectionModel().selectedItemProperty().addListener(
                (a, b, newSelection) -> selectionChanged(newSelection));
        try {
            periodoListView.setItems(TurmaDAOHandler.periodosAluno(aluno));
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/turmas_aluno.fxml")));
            ObservableList<Turma> turmas = TurmaDAOHandler.turmasAlunoPeriodo(aluno,periodo);
            loader.setControllerFactory((t) -> new TurmasAlunoController(aluno, turmas));
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
