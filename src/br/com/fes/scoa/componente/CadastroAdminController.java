package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Pessoa;
import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.model.Sysadmins;
import br.com.fes.scoa.model.SysadminsDAO;
import br.com.fes.scoa.util.SysadminsDAOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import org.orm.PersistentException;
import utils.DateUtil;
import utils.MaskedTextField;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroAdminController implements Initializable {

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

    private final Sysadmins original;
    private Sysadmins novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogHeader;

    public CadastroAdminController(Sysadmins original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar administrador";
            confirmDialogHeader = "Confirmar atualização de administrador";
            confirmDialogContent = "Tem certeza que deseja atualizar o administrador?";
            successDialogTitle = "Administrador atualizado";
            successDialogHeader = "Administrador atualizado:";
            successDialogContent = "O administrador foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogHeader = "Erro na atualização.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de administrador";
            confirmDialogContent = "Tem certeza que deseja cadastrar o administrador?";
            successDialogTitle = "Administrador cadastrado";
            successDialogHeader = "Administrador cadastrado:";
            successDialogContent = "O administrador foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogHeader = "Erro no cadastro.";
        }
    }

    public Sysadmins getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            Pessoa p = original.getPessoa();
            campoNome.setText(p.getNome());
            campoDataNasc.setValue(DateUtil.toLocalDate(p.getData_nascimento()));
            campoCPF.setPlainText(p.getCpf());
            campoEndereco.setText(p.getEndereco());
            campoEmail.setText(p.getEmail());
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
        if (campoCPF.getPlainText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("CPF vazio");
            errAlert.setContentText("Você precisa digitar um CPF!");
            errAlert.show();
            return;
        }
        if (campoEndereco.getText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Endereço vazio");
            errAlert.setContentText("Você precisa digitar um endereço!");
            errAlert.show();
            return;
        }
        if (campoEmail.getText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Email vazio");
            errAlert.setContentText("Você precisa digitar um emal!");
            errAlert.show();
            return;
        }
        if (campoDataNasc.getValue() == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Data de nascimento não selecionada");
            errAlert.setContentText("Você precisa selecionar uma data de nascimento!");
            errAlert.show();
            return;
        }
        System.out.println(campoCPF.getPlainText());
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
                    novo = SysadminsDAOHandler.cadastraSysadmins(
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString(),
                            "wololo");

                }
                else {
                    original.getPessoa().setNome(campoNome.getCharacters().toString());
                    original.getPessoa().setData_nascimento(DateUtil.toDate(campoDataNasc.getValue()));
                    original.getPessoa().setCpf(campoCPF.getPlainText());
                    original.getPessoa().setEndereco(campoEndereco.getCharacters().toString());
                    original.getPessoa().setEmail(campoEmail.getCharacters().toString());
                    //original.getPessoa().setSenha();@TODO
                    SysadminsDAO.save(original);
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
        campoCPF.setEditable(edit);
        campoDataNasc.setEditable(edit);
        campoEmail.setEditable(edit);
        campoEndereco.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }

}
