package components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import java.sql.Date;

import models.Aluno;
import utils.MaskedTextField;

public class CadastroAlunoController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public DatePicker campoDataNasc;

    @FXML
    public MaskedTextField campoCPF;

    @FXML
    public TextField campoEndereco;

    @FXML
    public TextField campoEmail;

    @FXML
    public Button botaoEnviar;

    @FXML
    public void onEnviar(ActionEvent event) {
        StringBuilder sb = new StringBuilder(); sb.append('\n');
        sb.append(campoNome.getCharacters()); sb.append('\n');
        sb.append(campoDataNasc); sb.append('\n');
        sb.append(campoCPF.getCharacters()); sb.append('\n');
        sb.append(campoEndereco.getCharacters()); sb.append('\n');
        sb.append(campoEmail.getCharacters()); sb.append('\n');
        System.out.println(sb.toString());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cadastro");
        alert.setHeaderText("Confirmar cadastro de aluno");
        alert.setContentText("Tem certeza que deseja cadastrar o aluno " + campoNome.getCharacters() + " ?");
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            Aluno novoAluno = new Aluno(
                    campoNome.getCharacters().toString(),
                    campoCPF.getPlainText(),
                    campoEmail.getCharacters().toString(),
                    campoEndereco.getCharacters().toString(),
                    Date.valueOf(campoDataNasc.getValue()));
            try {
                novoAluno.save();
                Alert errAlert = new Alert(Alert.AlertType.INFORMATION);
                errAlert.setTitle("Aluno Cadastrado");
                errAlert.setHeaderText("Aluno Cadastrado:");
                errAlert.setContentText("O aluno \"" + novoAluno.toString() + "\" foi cadastrado com sucesso.");
                errAlert.show();
            } catch (Exception err) {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle("Erro no cadastro");
                errAlert.setHeaderText("Segue o erro no cadastro");
                errAlert.setContentText(err.getLocalizedMessage());
                errAlert.show();
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


/*    @FXML
    public void metodoX() {
        throw new UnsupportedOperationException("Nao foi implementado ainda.");
    }*/
}
