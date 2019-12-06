package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.ProfessorDAOHandler;
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
    public Label labelAreaSelecionada;
    private Area_disciplina areaSelecionada = null;
    private final String labelAreaEmptyText = "Nenhuma área selecionada";

    @FXML
    public Button botaoSelecionarArea;

    @FXML
    public Button botaoEnviar;

    private final Professor original;
    private Professor novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogHeader;

    public CadastroProfessorController(Professor original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar professor";
            confirmDialogHeader = "Confirmar atualização do professor";
            confirmDialogContent = "Tem certeza que deseja atualizar o professor?";
            successDialogTitle = "Professor atualizado";
            successDialogHeader = "Professor atualizado:";
            successDialogContent = "O professor foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogHeader = "Erro na atualização.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de professor";
            confirmDialogContent = "Tem certeza que deseja cadastrar o professor?";
            successDialogTitle = "Professor cadastrado";
            successDialogHeader = "Professor cadastrado:";
            successDialogContent = "O professor foi cadastrado com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogHeader = "Erro no cadastro.";
        }
    }

    public Professor getNovo() {
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
            areaSelecionada = original.getArea_disciplina();
            labelAreaSelecionada.setText(areaSelecionada.getNome());
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
        if (areaSelecionada == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Área não selecionada");
            errAlert.setContentText("Você precisa selecionar uma área!");
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
                    novo = ProfessorDAOHandler.cadastraProfessor(
                            campoNome.getCharacters().toString(),
                            campoDataNasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            campoCPF.getPlainText(),
                            campoEndereco.getCharacters().toString(),
                            campoEmail.getCharacters().toString(),
                            areaSelecionada,
                            "wololo");

                }
                else {
                    original.getPessoa().setNome(campoNome.getCharacters().toString());
                    original.getPessoa().setData_nascimento(DateUtil.toDate(campoDataNasc.getValue()));
                    original.getPessoa().setCpf(campoCPF.getPlainText());
                    original.getPessoa().setEndereco(campoEndereco.getCharacters().toString());
                    original.getPessoa().setEmail(campoEmail.getCharacters().toString());
                    //original.getPessoa().setSenha();@TODO
                    ProfessorDAO.save(original);
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
    public void selecionaArea(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_areas.fxml")));
            loader.setControllerFactory((t) -> new ListaAreasController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaAreasController controller = loader.getController();
            Area_disciplina selected = controller.getSelectedItem();
            areaSelecionada = selected;
            if (selected != null) {
                // @TODO fazer selecao
                labelAreaSelecionada.setText(selected.getNome());
            }
            else {
                labelAreaSelecionada.setText(labelAreaEmptyText);
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
