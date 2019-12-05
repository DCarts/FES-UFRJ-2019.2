package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Curso;
import br.com.fes.scoa.model.CursoDAO;
import br.com.fes.scoa.util.CursoDAOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroCursoController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextArea campoDescricao;

    @FXML
    public Button botaoEnviar;

    private final Curso original;
    private Curso novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroCursoController(Curso original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar curso";
            confirmDialogHeader = "Confirmar atualização do curso";
            confirmDialogContent = "Tem certeza que deseja atualizar o curso?";
            successDialogTitle = "Curso atualizado";
            successDialogHeader = "Curso atualizado:";
            successDialogContent = "O curso foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de curso";
            confirmDialogContent = "Tem certeza que deseja cadastrar o curso?";
            successDialogTitle = "Curso cadastrado";
            successDialogHeader = "Curso cadastrado:";
            successDialogContent = "Ocurso foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    public Curso getNovo() {
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
                    novo = CursoDAOHandler.cadastraCurso(
                            campoNome.getCharacters().toString(),
                            campoDescricao.getText());
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    original.setDescricao(campoDescricao.getText());
                    CursoDAO.save(original);
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
