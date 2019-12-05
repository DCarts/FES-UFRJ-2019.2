package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Aluno;
import br.com.fes.scoa.model.CursoDAO;
import br.com.fes.scoa.model.Pessoa;
import br.com.fes.scoa.util.AlunoDAOHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import utils.DateUtil;
import utils.MaskedTextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

    private final ObservableList<Aluno> lista;
    private Boolean modoEditar = false;
    private Aluno editarAluno = null;
    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de aluno";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar o aluno?";
    private String successDialogTitle = "Aluno cadastrado";
    private String successDialogHeader = "Aluno cadastrado:";
    private String successDialogContent = "O aluno foi cadastrado com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    public CadastroAlunoController(ObservableList<Aluno> items, Aluno aluno) {
        lista = items;
        editarAluno= aluno;
        modoEditar = aluno != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (modoEditar) {
            Pessoa pessoa = editarAluno.getPessoa();
            campoNome.setText(pessoa.getNome());
            campoDataNasc.setValue(DateUtil.toLocalDate(pessoa.getData_nascimento()));
            campoCPF.setPlainText(pessoa.getCpf());
            campoEndereco.setText(pessoa.getEndereco());
            campoEmail.setText(pessoa.getEmail());

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
        setEditable(false);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
            try {
                if (modoEditar) {
                    Aluno aluno = AlunoDAOHandler.editar(
                        editarAluno.getPessoaId(),
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString(),
                        CursoDAO.getCursoByORMID(1)
                    );
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getPessoaId() == aluno.getPessoa().getId()) {
                            lista.set(i,aluno);
                            break;
                        }
                    }
                } else {
                    Aluno aluno = AlunoDAOHandler.cadastrar(
                        campoNome.getCharacters().toString(),
                        campoDataNasc.getValue().toString(),
                        campoCPF.getPlainText(),
                        campoEndereco.getCharacters().toString(),
                        campoEmail.getCharacters().toString(),
                        "wololo",
                        CursoDAO.getCursoByORMID(1));
                    lista.add(aluno);
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
