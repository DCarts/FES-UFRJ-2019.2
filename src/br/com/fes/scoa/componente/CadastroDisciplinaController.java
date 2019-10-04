package br.com.fes.scoa.componente;

import br.com.fes.scoa.util.AlunoDAO;
import br.com.fes.scoa.util.DisciplinaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import utils.MaskedTextField;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroDisciplinaController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextArea campoDescricao;

    @FXML
    public Button botaoEnviar;

    @FXML
    public void onEnviar(ActionEvent event) {
        String s = "\n" +
                campoNome.getCharacters() + '\n' +
                campoDescricao + '\n';
        System.out.println(s);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cadastro");
        alert.setHeaderText("Confirmar cadastro de disciplina");
        alert.setContentText("Tem certeza que deseja cadastrar a disciplina " + campoNome.getCharacters() + " ?");
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        setEditable(false);
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {

            try {
                DisciplinaDAO.cadastraDisciplina(
                        campoNome.getCharacters().toString(),
                        campoDescricao.getText());
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Disciplina cadastrada");
                successAlert.setHeaderText("Disciplina cadastrada:");
                successAlert.setContentText("A disciplina foi cadastrado com sucesso.");
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
        campoDescricao.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
