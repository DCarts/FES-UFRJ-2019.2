package br.com.fes.scoa.componente;

import br.com.fes.scoa.util.AlunoDAO;
import br.com.fes.scoa.util.ProfessorDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.MaskedTextField;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroProfessorController implements Initializable {

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
                campoDataNasc.getValue().toString() + '\n' +
                campoCPF.getCharacters() + '\n' +
                campoEndereco.getCharacters() + '\n' +
                campoEmail.getCharacters() + '\n';
        System.out.println(s);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cadastro");
        alert.setHeaderText("Confirmar cadastro de professor");
        alert.setContentText("Tem certeza que deseja cadastrar o professor " + campoNome.getCharacters() + " ?");
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        setEditable(false);
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                ProfessorDAO.cadastraProfessor(
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Professor cadastrado");
                successAlert.setHeaderText("Professor cadastrado:");
                successAlert.setContentText("O professor foi cadastrado com sucesso.");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void setEditable(boolean edit) {
        campoNome.setEditable(edit);
        campoCPF.setEditable(edit);
        campoDataNasc.setEditable(edit);
        campoEmail.setEditable(edit);
        campoEndereco.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }

}
