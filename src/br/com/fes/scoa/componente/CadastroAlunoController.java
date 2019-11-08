package br.com.fes.scoa.componente;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.fes.scoa.modelo.Aluno;
import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.util.*;

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

    private final ObservableList<Pessoa> lista;
    private Boolean modoEditar = false;
    private Pessoa editarPessoa = null;
    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de aluno";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar o aluno?";
    private String successDialogTitle = "Aluno cadastrado";
    private String successDialogHeader = "Aluno cadastrado:";
    private String successDialogContent = "O aluno foi cadastrado com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    public CadastroAlunoController(ObservableList<Pessoa> items, Pessoa pessoa) {
        lista = items;
        editarPessoa = pessoa;
        modoEditar = pessoa != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (modoEditar) {
            campoNome.setText(editarPessoa.getNome());
            campoDataNasc.setValue(editarPessoa.getData_nascimento());
            campoCPF.setPlainText(editarPessoa.getCpf());
            campoEndereco.setText(editarPessoa.getEndereco());
            campoEmail.setText(editarPessoa.getEmail());

            confirmDialogTitle = "Editar aluno";
            confirmDialogHeader = "Confirmar atualização do aluno";
            confirmDialogContent = "Tem certeza que deseja atualizar o aluno?";
            successDialogTitle = "Aluno atualizado";
            successDialogHeader = "Aluno atualizado:";
            successDialogContent = "O aluno foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
            botaoEnviar.setText("Salvar");
        }
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        String s = "\n" +
                campoNome.getCharacters() + '\n' +
                campoDataNasc.getValue().toString() + '\n' +
                campoCPF.getPlainText() + '\n' +
                campoEndereco.getCharacters() + '\n' +
                campoEmail.getCharacters() + '\n';
        System.out.println(s);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(confirmDialogTitle);
        alert.setHeaderText(confirmDialogHeader);
        alert.setContentText(confirmDialogContent);
        alert.initStyle(StageStyle.UTILITY);
        alert.initOwner(botaoEnviar.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        setEditable(false);
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                if (modoEditar) {
                    Aluno aluno = AlunoDAO.editarAluno(
                        editarPessoa.getId(),
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equals(aluno.getPessoa().getId())) {
                            lista.set(i,aluno.getPessoa());
                            break;
                        }
                    }
                } else {
                    Aluno aluno = AlunoDAO.cadastraAluno(
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                    lista.add(aluno.getPessoa());
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
