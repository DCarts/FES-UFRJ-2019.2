package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.SecretarioDAOHandler;
import javafx.application.Platform;
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
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroSecretarioController implements Initializable {

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
    public Label labelCursoSelecionado;
    private Curso cursoSelecionado = null;
    private final String labelCursoEmptyText = "Nenhuma curso selecionado";

    @FXML
    public Button botaoSelecionarCurso;

    @FXML
    public Button botaoEnviar;

    private final Secretario original;
    private Secretario novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogHeader;

    public CadastroSecretarioController(Secretario original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar secretario";
            confirmDialogHeader = "Confirmar atualização do secretario";
            confirmDialogContent = "Tem certeza que deseja atualizar o secretario?";
            successDialogTitle = "Secretario atualizado";
            successDialogHeader = "Secretario atualizado:";
            successDialogContent = "O secretario foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogHeader = "Erro na atualização.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de secretario";
            confirmDialogContent = "Tem certeza que deseja cadastrar o secretario?";
            successDialogTitle = "Secretario cadastrado";
            successDialogHeader = "Secretario cadastrado:";
            successDialogContent = "O secretario foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogHeader = "Erro no cadastro.";
        }
    }

    public Secretario getNovo() {
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
            cursoSelecionado = original.getCurso();
            labelCursoSelecionado.setText(cursoSelecionado.getNome());
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
            errAlert.setContentText("Você precisa digitar um email!");
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
                    novo = SecretarioDAOHandler.cadastraSecretario(
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString(),
                            cursoSelecionado,
                            "wololo");

                }
                else {
                    original.getPessoa().setNome(campoNome.getCharacters().toString());
                    original.getPessoa().setData_nascimento(DateUtil.toDate(campoDataNasc.getValue()));
                    original.getPessoa().setCpf(campoCPF.getPlainText());
                    original.getPessoa().setEndereco(campoEndereco.getCharacters().toString());
                    original.getPessoa().setEmail(campoEmail.getCharacters().toString());
                    //original.getPessoa().setSenha();@TODO
                    SecretarioDAO.save(original);
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
                labelCursoSelecionado.setText(selected.getNome());
            }
            else {
                labelCursoSelecionado.setText(labelCursoEmptyText);
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
        botaoEnviar.setDisable(!edit);
    }

}
