package br.com.fes.scoa.componente;

import javafx.collections.ObservableList;
import br.com.fes.scoa.util.ProfessorDAO;
import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import utils.MaskedTextField;

import java.net.URL;
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

    private final ObservableList<Pessoa> lista;
    private Boolean modoEditar = false;
    private Pessoa editarPessoa = null;
    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de professor";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar o professor?";
    private String successDialogTitle = "Professor cadastrado";
    private String successDialogHeader = "Professor cadastrado:";
    private String successDialogContent = "O professor foi cadastrado com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    public CadastroProfessorController(ObservableList<Pessoa> items, Pessoa pessoa) {
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

            confirmDialogTitle = "Editar professor";
            confirmDialogHeader = "Confirmar atualização do professor";
            confirmDialogContent = "Tem certeza que deseja atualizar o professor?";
            successDialogTitle = "Professor atualizado";
            successDialogHeader = "Professor atualizado:";
            successDialogContent = "O Professor foi atualizado com sucesso.";
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
                    Professor professor = ProfessorDAO.editar(
                        editarPessoa.getId(),
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equals(professor.getPessoa().getId())) {
                            lista.set(i,professor.getPessoa());
                            break;
                        }
                    }
                } else {
                    Professor professor = ProfessorDAO.cadastrar(
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString());
                    lista.add(professor.getPessoa());
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
