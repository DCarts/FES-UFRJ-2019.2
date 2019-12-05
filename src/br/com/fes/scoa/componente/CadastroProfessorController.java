package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Area_disciplina;
import br.com.fes.scoa.model.Pessoa;
import br.com.fes.scoa.model.Professor;
import br.com.fes.scoa.model.ProfessorDAO;
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
    private final String errorDialogContent;

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
                    //original.getPessoa().setSenha();
                    ProfessorDAO.save(original);
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
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
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
