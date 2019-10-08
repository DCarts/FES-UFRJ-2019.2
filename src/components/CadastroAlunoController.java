package components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.fes.scoa.util.*;


import java.time.format.DateTimeFormatter;

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
        String s = "\n" +
                campoNome.getCharacters() + '\n' +
                campoDataNasc + '\n' +
                campoCPF.getCharacters() + '\n' +
                campoEndereco.getCharacters() + '\n' +
                campoEmail.getCharacters() + '\n';
        System.out.println(s);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cadastro");
        alert.setHeaderText("Confirmar cadastro de aluno");
        alert.setContentText("Tem certeza que deseja cadastrar o aluno " + campoNome.getCharacters() + " ?");
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        setEditable(false);
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                AlunoDAO.cadastraAluno(
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Aluno cadastrado");
                successAlert.setHeaderText("Aluno cadastrado:");
                successAlert.setContentText("O aluno foi cadastrado com sucesso.");
                successAlert.show();
            } catch (Exception err) {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle("Erro no cadastro");
                errAlert.setHeaderText(err.toString());
                errAlert.setContentText("Cheque o console para mais informações.");
                err.printStackTrace();
                errAlert.show();
            }
            finally {
                botaoEnviar.getScene().getWindow().hide();
            }

        }
        else {
            setEditable(true);
        }
    }

    private void setEditable(boolean edit) {
            campoNome.setEditable(edit);
            campoCPF.setEditable(edit);
            campoDataNasc.setEditable(edit);
            campoEmail.setEditable(edit);
            campoEndereco.setEditable(edit);
            botaoEnviar.setDisable(!edit);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


/*    @FXML
    public void metodoX() {
        throw new UnsupportedOperationException("Nao foi implementado ainda.");
    }*/
}
