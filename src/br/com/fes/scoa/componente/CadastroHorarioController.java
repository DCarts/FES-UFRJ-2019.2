package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Horariodeaula;
import br.com.fes.scoa.util.HorariodeaulaDAOHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import utils.TimeSpinner;

import java.io.Serializable;
import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroHorarioController implements Initializable {
    @FXML
    public ComboBox<Dia> campoDia;
    @FXML
    public TimeSpinner campoInicio;
    @FXML
    public TimeSpinner campoFim;
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
            return dia.getNome();
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

    public CadastroHorarioController(Horariodeaula original) {
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

    @FXML
    public void onEnviar(ActionEvent event) {
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
        campoDia.setEditable(edit);
        campoInicio.setEditable(edit);
        campoFim.setEditable(edit);
        botaoEnviar.setDisable(!edit);
    }
}
