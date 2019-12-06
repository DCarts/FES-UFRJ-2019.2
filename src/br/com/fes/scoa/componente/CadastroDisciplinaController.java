package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.util.DisciplinaDAOHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class CadastroDisciplinaController implements Initializable {

    @FXML
    public TextField campoNome;

    @FXML
    public TextField campoCodigo;

    @FXML
    public TextField campoCreditos;

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
    public Label labelEquivalenciaSelecionada;
    private ObservableList<Disciplina> equivalenciasSelecionadas = FXCollections.observableArrayList();
    private final String labelEquivalenciasEmptyText = "Nenhuma equivalencia selecionada";

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
    private final String errorDialogHeader;

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
            errorDialogHeader = "Erro na atualização.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de disciplina";
            confirmDialogContent = "Tem certeza que deseja cadastrar a disciplina?";
            successDialogTitle = "Disciplina cadastrada";
            successDialogHeader = "Disciplina cadastrada:";
            successDialogContent = "A disciplina foi cadastrada com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogHeader = "Erro no cadastro.";
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
            campoCodigo.setText(original.getCodigo());
            campoCreditos.setText(Integer.toString(original.getCreditos()));
            areaSelecionada = original.getArea_disciplina();
            labelAreaSelecionada.setText(areaSelecionada.getNome());
            cursoSelecionado = original.getCurso();
            labelCursoSelecionada.setText(cursoSelecionado.getNome());

            try {
                labelEquivalenciaSelecionada.setText(DisciplinaDAOHandler.getEquivalentes(original).stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
            } catch (PersistentException e) {
                e.printStackTrace();
            }
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
        if (campoDescricao.getText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Descrição vazia");
            errAlert.setContentText("Você precisa digitar uma descrição!");
            errAlert.show();
            return;
        }
        try {
            int x = Integer.parseInt(campoCreditos.getCharacters().toString());
            if (x <= 0) throw new NumberFormatException();
        }
        catch (NumberFormatException ex) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Créditos inválidos");
            errAlert.setContentText("Você precisa digitar um número de créditos válido!");
            errAlert.show();
            return;
        }
        if (campoCodigo.getText().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Código vazio");
            errAlert.setContentText("Você precisa digitar um código!");
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
        if (areaSelecionada == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Área não selecionada");
            errAlert.setContentText("Você precisa selecionar uma área!");
            errAlert.show();
            return;
        }
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
                            campoCreditos.getCharacters().toString(),
                            campoDescricao.getText(),
                            areaSelecionada,
                            cursoSelecionado,
                            equivalenciasSelecionadas);
                }
                else {
                    original.setNome(campoNome.getCharacters().toString());
                    original.setCodigo(campoCodigo.getCharacters().toString());
                    original.setDescricao(campoDescricao.getText());
                    original.setArea_disciplina(areaSelecionada);
                    original.setCurso(cursoSelecionado);
                    DisciplinaDAOHandler.getEquivalentes(original).forEach(d -> {
                        original.disciplina1.remove(d);
                        original.disciplina2.remove(d);
                    });
                    equivalenciasSelecionadas.forEach(original.disciplina1::add);
                    DisciplinaDAO.save(original);
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
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText(errorDialogHeader);
            errAlert.setContentText(cause.getMessage());
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
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText(errorDialogHeader);
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
        }

    }
    private void setEditable(boolean edit) {
        campoNome.setEditable(edit);
        campoDescricao.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }

    public void selecionaEquivalencia(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_disciplinas.fxml")));
            loader.setControllerFactory((t) -> new ListaDisciplinasController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Selecionar Equivalências");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaDisciplinasController controller = loader.getController();
            List<Disciplina> selecteds = controller.getSelectedItems();
            equivalenciasSelecionadas = FXCollections.observableArrayList(selecteds);
            if (selecteds != null && selecteds.size() > 0) {
                // @TODO fazer selecao
                labelEquivalenciaSelecionada.setText(selecteds.stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
            }
            else {
                labelEquivalenciaSelecionada.setText(labelEquivalenciasEmptyText);
            }

        } catch (IOException err) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            Throwable cause = err;
            while (cause.getCause() != null) cause = cause.getCause();
            errAlert.setHeaderText(errorDialogHeader);
            errAlert.setContentText(cause.getMessage());
            errAlert.show();
        }
    }
}
