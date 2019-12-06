package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Aluno;
import br.com.fes.scoa.model.Curso;
import br.com.fes.scoa.model.Pessoa;
import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.util.AlunoDAOHandler;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.orm.PersistentException;
import utils.DateUtil;
import utils.MaskedTextField;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    @FXML
    public Label labelCursoSelecionada;
    private Curso cursoSelecionado = null;
    private final String labelCursoEmptyText = "Nenhum curso selecionado";

    @FXML
    public Button botaoSelecionarCurso;

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
    private String errorDialogHeader = "Erro no cadastro.";

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
            cursoSelecionado = editarAluno.getCurso();
            labelCursoSelecionada.setText(cursoSelecionado.getNome());

            confirmDialogTitle = "Editar aluno";
            confirmDialogHeader = "Confirmar atualização do aluno";
            confirmDialogContent = "Tem certeza que deseja atualizar o aluno?";
            successDialogTitle = "Aluno atualizado";
            successDialogHeader = "Aluno atualizado:";
            successDialogContent = "O aluno foi atualizado com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogHeader = "Erro na atualização.";
            botaoEnviar.setText("Salvar");
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
        if (cursoSelecionado == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Curso não selecionado");
            errAlert.setContentText("Você precisa selecionar um curso!");
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
                        cursoSelecionado
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
                        cursoSelecionado);
                    lista.add(aluno);
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

    @FXML
    public void selecionaCurso(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_cursos.fxml")));
            loader.setControllerFactory((t) -> new ListaCursosController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Selecionar curso");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaCursosController controller = loader.getController();
            Curso selected = controller.getSelectedItem();
            cursoSelecionado = selected;
            if (selected != null) {
                // @TODO fazer selecao
                labelCursoSelecionada.setText(selected.getNome());
            }
            else {
                labelCursoSelecionada.setText(labelCursoEmptyText);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText(errorDialogHeader);
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
            err.printStackTrace();
        }

    }

    private void setEditable(boolean edit) {
            campoNome.setEditable(edit);
            campoCPF.setEditable(edit);
            campoDataNasc.setEditable(edit);
            campoEmail.setEditable(edit);
            campoEndereco.setEditable(edit);
            botaoSelecionarCurso.setDisable(!edit);
            botaoEnviar.setDisable(!edit);
    }
}
