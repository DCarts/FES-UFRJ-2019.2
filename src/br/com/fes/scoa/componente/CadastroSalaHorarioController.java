package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Horariodeaula;
import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.model.Sala;
import br.com.fes.scoa.util.HorariodeaulaDAOHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import org.orm.PersistentException;
import utils.TimeSpinner;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroSalaHorarioController implements Initializable {
    @FXML
    public ComboBox<Dia> campoDia;
    @FXML
    public TimeSpinner campoInicio;
    @FXML
    public TimeSpinner campoFim;

    @FXML
    public Button botaoSelecionarSala;

    @FXML
    public Label labelSalaSelecionada;
    private Sala salaSelecionada = null;
    private final String labelSalaEmptyText = "Nenhuma sala selecionada";

    @FXML
    public Button botaoEnviar;
    private final Horariodeaula original;
    private Horariodeaula novo = null;

    public static enum Dia implements Serializable {
        DOMINGO("Domingo"),
        SEGUNDA("Segunda-feira"),
        TERCA("Terça-feira"),
        QUARTA("Quarta-feira"),
        QUINTA("Quinta-feira"),
        SEXTA("Sexta-feira"),
        SABADO("Sábado");

        private String nome;

        private Dia(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    private static class DiaConverter extends StringConverter<Dia> {

        @Override
        public String toString(Dia dia) {
            if (dia != null)
                return dia.getNome();
            else
                return "";
        }

        @Override
        public Dia fromString(String nome) {
            for (Dia d : Dia.values()) {
                if (d.getNome().equals(nome)) {
                    return d;
                }
            }
            return null;
        }
    }

    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de horário";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar o horário?";
    private String successDialogTitle = "Horário cadastrado";
    private String successDialogHeader = "Horário cadastrado:";
    private String successDialogContent = "O horário foi cadastrado com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    private final DiaConverter dc = new DiaConverter();

    public CadastroSalaHorarioController(Horariodeaula original) {
        this.original = original;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        campoDia.setItems(FXCollections.observableArrayList(Dia.values()));
        campoDia.setConverter(new DiaConverter());
        campoDia.getSelectionModel().selectFirst();
        if (original != null) {
            campoDia.getSelectionModel().select(dc.fromString(original.getDia()));
            campoInicio.getValueFactory().setValue(original.getHorarioInicio().toLocalTime().truncatedTo(ChronoUnit.MINUTES));
            campoFim.getValueFactory().setValue(original.getHorarioFim().toLocalTime().truncatedTo(ChronoUnit.MINUTES));

            confirmDialogTitle = "Editar sala";
            confirmDialogHeader = "Confirmar atualização do horário";
            confirmDialogContent = "Tem certeza que deseja atualizar o horário?";
            successDialogTitle = "Horário atualizado";
            successDialogHeader = "Horário atualizado:";
            successDialogContent = "O horário foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
            botaoEnviar.setText("Salvar");
        }
    }

    public Horariodeaula getNovo() {
        return novo;
    }

    public Sala getSala() {
        return salaSelecionada;
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        if (campoDia.getSelectionModel().getSelectedItem() == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Dia vazio");
            errAlert.setContentText("Você precisa selecionar um dia!");
            errAlert.show();
            return;
        }
        if (salaSelecionada == null) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Sala não selecionada");
            errAlert.setContentText("Você precisa selecionar uma sala!");
            errAlert.show();
            return;
        }
        System.out.println(campoDia.getValue());
        System.out.println(campoInicio.getValue().truncatedTo(ChronoUnit.MINUTES));
        System.out.println(campoFim.getValue().truncatedTo(ChronoUnit.MINUTES));
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
                novo = HorariodeaulaDAOHandler.cadastraHorario(
                        campoDia.getSelectionModel().getSelectedItem(),
                        campoInicio.getValue().truncatedTo(ChronoUnit.MINUTES),
                        campoFim.getValue().truncatedTo(ChronoUnit.MINUTES)
                );



                /*Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(successDialogTitle);
                successAlert.setHeaderText(successDialogHeader);
                successAlert.setContentText(successDialogContent);
                successAlert.show();*/
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
                errAlert.setHeaderText(err.toString());
                errAlert.setContentText(errorDialogContent);
                err.printStackTrace();
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
    public void selecionaSala(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/lista_salas.fxml")));
            loader.setControllerFactory((t) -> new ListaSalasController(true));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Adicionar horário");
            stage.setScene(new Scene(root));
            stage.initOwner(botaoEnviar.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            ListaSalasController controller = loader.getController();
            Sala selected = controller.getSelectedItem();
            salaSelecionada = selected;
            if (selected != null) {
                // @TODO fazer selecao
                labelSalaSelecionada.setText(selected.getCodLocalizacao().split("::")[2]);
            }
            else {
                labelSalaSelecionada.setText(labelSalaEmptyText);
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
        campoDia.setEditable(edit);
        campoInicio.setEditable(edit);
        campoFim.setEditable(edit);
        botaoSelecionarSala.setDisable(!edit);
        botaoEnviar.setDisable(!edit);
    }
}
