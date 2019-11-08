package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Disciplina;
import br.com.fes.scoa.util.DisciplinaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroDisciplinaController implements Initializable {
    @FXML
    public TextField campoNome;
    @FXML
    public TextArea campoDescricao;
    @FXML
    public Button botaoEnviar;

    private final ObservableList<Disciplina> lista;
    private Boolean modoEditar = false;
    private Disciplina editarDisciplina = null;
    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de disciplina";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar o disciplina?";
    private String successDialogTitle = "Disciplina cadastrado";
    private String successDialogHeader = "Disciplina cadastrado:";
    private String successDialogContent = "O disciplina foi cadastrado com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    public CadastroDisciplinaController(ObservableList<Disciplina> items, Disciplina disciplina) {
        lista = items;
        editarDisciplina = disciplina;
        modoEditar = disciplina != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (modoEditar) {
            campoNome.setText(editarDisciplina.getNome());
            campoDescricao.setText(editarDisciplina.getDescricao());

            confirmDialogTitle = "Editar disciplina";
            confirmDialogHeader = "Confirmar atualização do disciplina";
            confirmDialogContent = "Tem certeza que deseja atualizar o disciplina?";
            successDialogTitle = "Disciplina atualizado";
            successDialogHeader = "Disciplina atualizado:";
            successDialogContent = "O disciplina foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
            botaoEnviar.setText("Salvar");
        }
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        String s = "\n" +
                campoNome.getCharacters() + '\n' +
                campoDescricao + '\n';
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
                    Disciplina disciplina = DisciplinaDAO.editar(
                        editarDisciplina.getId(),
                        campoNome.getCharacters().toString(),
                        campoDescricao.getText());
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equals(disciplina.getId())) {
                            lista.set(i,disciplina);
                            break;
                        }
                    }
                } else {
                    Disciplina disciplina = DisciplinaDAO.cadastrar(
                        campoNome.getCharacters().toString(),
                        campoDescricao.getText());
                    lista.add(disciplina);
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
