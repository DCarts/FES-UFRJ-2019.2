package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Professor;
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

    private final Pessoa original;
    private Pessoa novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroProfessorController(Pessoa original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar professor";
            confirmDialogHeader = "Confirmar atualização do professor";
            confirmDialogContent = "Tem certeza que deseja atualizar o professor?";
            successDialogTitle = "Professor atualizado";
            successDialogHeader = "Professor atualizado:";
            successDialogContent = "O professor foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de professor";
            confirmDialogContent = "Tem certeza que deseja cadastrar o professor?";
            successDialogTitle = "Professor cadastrado";
            successDialogHeader = "Professor cadastrado:";
            successDialogContent = "O professor foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    public Pessoa getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            campoNome.setText(original.getNome());
            campoDataNasc.setValue(original.getData_nascimento());
            campoCPF.setPlainText(original.getCpf());
            campoEndereco.setText(original.getEndereco());
            campoEmail.setText(original.getEmail());
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
                    novo = ProfessorDAO.cadastraProfessor(
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString()).getPessoa();
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    original.setData_nascimento(campoDataNasc.getValue());
                    original.setCpf(campoCPF.getPlainText());
                    original.setEndereco(campoEndereco.getCharacters().toString());
                    original.setEmail(campoEmail.getCharacters().toString());
                    ProfessorDAO.atualiza(original);
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
        campoCPF.setEditable(edit);
        campoDataNasc.setEditable(edit);
        campoEmail.setEditable(edit);
        campoEndereco.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }

}
