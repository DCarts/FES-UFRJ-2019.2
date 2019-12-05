package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Area_disciplina;
import br.com.fes.scoa.model.Curso;
import br.com.fes.scoa.model.Disciplina;
import br.com.fes.scoa.model.DisciplinaDAO;
import br.com.fes.scoa.util.DisciplinaDAOHandler;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroDisciplinaController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextField campoCodigo;

    @FXML
    public TextArea campoDescricao;

    @FXML
    public Label labelAreaSelecionada;
    private Area_disciplina areaSelecionada = null;
    private final String labelAreaEmptyText = "Nenhuma área selecionada";

    @FXML
    public Button botaoSelecionarArea;

    @FXML
    public Label labelCursoSelecionada;
    private Curso cursoSelecionado = null;
    private final String labelCursoEmptyText = "Nenhum curso selecionado";

    @FXML
    public Button botaoSelecionarCurso;

    @FXML
    public Button botaoEnviar;

    private final Disciplina original;
    private Disciplina novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroDisciplinaController(Disciplina original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar disciplina";
            confirmDialogHeader = "Confirmar atualização da disciplina";
            confirmDialogContent = "Tem certeza que deseja atualizar a disciplina?";
            successDialogTitle = "Disciplina atualizada";
            successDialogHeader = "Disciplina atualizada:";
            successDialogContent = "A disciplina foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de disciplina";
            confirmDialogContent = "Tem certeza que deseja cadastrar a disciplina?";
            successDialogTitle = "Disciplina cadastrada";
            successDialogHeader = "Disciplina cadastrada:";
            successDialogContent = "A disciplina foi cadastrada com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    public Disciplina getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            campoNome.setText(original.getNome());
            campoDescricao.setText(original.getDescricao());
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
                    novo = DisciplinaDAOHandler.cadastraDisciplina(
                            campoNome.getCharacters().toString(),
                            campoCodigo.getCharacters().toString(),
                            campoDescricao.getText(),
                            areaSelecionada,
                            cursoSelecionado);
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    original.setCodigo(campoCodigo.getCharacters().toString());
                    original.setDescricao(campoDescricao.getText());
                    original.setArea_disciplina(areaSelecionada);
                    original.setCurso(cursoSelecionado);
                    DisciplinaDAO.save(original);
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
            stage.setTitle("Selecionar área");
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
            errAlert.setHeaderText(err.toString());
            errAlert.setContentText(errorDialogContent);
            err.printStackTrace();
            errAlert.show();
        }

    }
    private void setEditable(boolean edit) {
        campoNome.setEditable(edit);
        campoDescricao.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }
}
