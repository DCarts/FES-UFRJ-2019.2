package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Area_disciplina;
import br.com.fes.scoa.model.Area_disciplinaDAO;
import br.com.fes.scoa.util.AreaDAOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroAreaController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextArea campoDescricao;

    @FXML
    public Button botaoEnviar;

    private final Area_disciplina original;
    private Area_disciplina novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroAreaController(Area_disciplina original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar area";
            confirmDialogHeader = "Confirmar atualização da area";
            confirmDialogContent = "Tem certeza que deseja atualizar a area?";
            successDialogTitle = "Area atualizada";
            successDialogHeader = "Area atualizada:";
            successDialogContent = "A area foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de area";
            confirmDialogContent = "Tem certeza que deseja cadastrar a area?";
            successDialogTitle = "Area cadastrada";
            successDialogHeader = "Area cadastrada:";
            successDialogContent = "A area foi cadastrada com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    public Area_disciplina getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            campoNome.setText(original.getNome());
            campoDescricao.setText(original.getDescricao());
        }
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        if (campoNome.getCharacters().toString().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Nome vazio");
            errAlert.setContentText("Você precisa digitar um nome!");
            errAlert.show();
            return;
        }
        if (campoDescricao.getText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Descrição vazia");
            errAlert.setContentText("Você precisa digitar uma descrição!");
            errAlert.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(confirmDialogTitle);
        alert.setHeaderText(confirmDialogHeader);
        alert.setContentText(confirmDialogContent);
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        setEditable(false);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                if (original == null) {
                    novo = AreaDAOHandler.cadastraArea_disciplina(
                            campoNome.getCharacters().toString(),
                            campoDescricao.getText());
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    original.setDescricao(campoDescricao.getText());
                    Area_disciplinaDAO.save(original);
                    novo = original;
                }
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(successDialogTitle);
                successAlert.setHeaderText(successDialogHeader);
                successAlert.setContentText(successDialogContent);
                successAlert.show();
            } catch (Exception err) {
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle(errorDialogTitle);
                errAlert.setHeaderText(err.toString());
                errAlert.setContentText(errorDialogContent);
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
}
