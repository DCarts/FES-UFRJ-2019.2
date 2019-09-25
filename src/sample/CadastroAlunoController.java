package sample;

import br.com.caelum.financas.util.Cadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroAlunoController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextField campoDataNasc;

    @FXML
    public TextField campoCPF;

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
        sb.append(campoDataNasc.getCharacters()); sb.append('\n');
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
            Cadastro.cadastraAluno(campoNome.getCharacters().toString(),
                    LocalDate.parse(campoDataNasc.getCharacters()),
                    campoCPF.getCharacters().toString(),
                    campoEndereco.getCharacters().toString(),
                    campoEmail.getCharacters().toString());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
