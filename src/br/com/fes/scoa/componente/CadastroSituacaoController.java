package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.model.Situacao;
import br.com.fes.scoa.model.SituacaoDAO;
import br.com.fes.scoa.util.SituacaoDAOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import org.orm.PersistentException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroSituacaoController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public Button botaoEnviar;

    private final Situacao original;
    private Situacao novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogHeader;

    public CadastroSituacaoController(Situacao original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar situacao";
            confirmDialogHeader = "Confirmar atualização do situacao";
            confirmDialogContent = "Tem certeza que deseja atualizar o situacao?";
            successDialogTitle = "Situacao atualizado";
            successDialogHeader = "Situacao atualizado:";
            successDialogContent = "O situacao foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogHeader = "Erro na atualização.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de situacao";
            confirmDialogContent = "Tem certeza que deseja cadastrar o situacao?";
            successDialogTitle = "Situacao cadastrado";
            successDialogHeader = "Situacao cadastrado:";
            successDialogContent = "Osituacao foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogHeader = "Erro no cadastro.";
        }
    }

    public Situacao getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            campoNome.setText(original.getNome());
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
                    novo = SituacaoDAOHandler.cadastraSituacao(
                            campoNome.getCharacters().toString());
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    SituacaoDAO.save(original);
                    novo = original;
                }
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(successDialogTitle);
                successAlert.setHeaderText(successDialogHeader);
                successAlert.setContentText(successDialogContent);
                successAlert.show();
                botaoEnviar.getScene().getWindow().hide();
            } catch (Exception err) {
                try {
                    if (SCOAPersistentManager.instance().getSession().getTransaction().isActive()) {
                        SCOAPersistentManager.instance().getSession().getTransaction().rollback();
                    }
                    SCOAPersistentManager.instance().getSession().close();
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                Alert errAlert = new Alert(Alert.AlertType.ERROR);
                errAlert.setTitle(errorDialogTitle);
                Throwable cause = err;
                while (cause.getCause() != null) cause = cause.getCause();
                errAlert.setHeaderText(errorDialogHeader);
                errAlert.setContentText(cause.getMessage());
                errAlert.show();
            }
            finally {
                setEditable(true);
            }
        }
        else {
            setEditable(true);
        }
    }

    private void setEditable(boolean edit) {
        campoNome.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }
}
