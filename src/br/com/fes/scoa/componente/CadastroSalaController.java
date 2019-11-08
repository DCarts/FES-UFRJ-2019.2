package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Aluno;
import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.util.AlunoDAO;
import br.com.fes.scoa.util.SalaDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import utils.MaskedTextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroSalaController implements Initializable {
    @FXML
    public TextField campoNome;
    @FXML
    public TextField campoPredio;
    @FXML
    public TextField campoAndar;
    @FXML
    public Button botaoEnviar;

    private final ObservableList<Sala> lista;
    private final Boolean modoEditar;
    private final Sala editarSala;
    private String confirmDialogTitle = "Confirmar cadastro";
    private String confirmDialogHeader = "Confirmar cadastro de sala";
    private String confirmDialogContent = "Tem certeza que deseja cadastrar a sala?";
    private String successDialogTitle = "Sala cadastrada";
    private String successDialogHeader = "Sala cadastrada:";
    private String successDialogContent = "A sala foi cadastrada com sucesso.";
    private String errorDialogTitle = "Erro no cadastro";
    private String errorDialogContent = "Cheque o console para mais informações.";

    public CadastroSalaController(ObservableList<Sala> items, Sala sala) {
        lista = items;
        editarSala = sala;
        modoEditar = sala != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (modoEditar) {
            String[] codigos = editarSala.getCodLocalizacao().split("::");
            campoPredio.setText(codigos[0]);
            campoAndar.setText(codigos[1]);
            campoNome.setText(codigos[2]);

            confirmDialogTitle = "Editar sala";
            confirmDialogHeader = "Confirmar atualização de sala";
            confirmDialogContent = "Tem certeza que deseja atualizar a sala?";
            successDialogTitle = "Sala atualizada";
            successDialogHeader = "Sala atualizada:";
            successDialogContent = "A sala foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
            botaoEnviar.setText("Salvar");
        }
    }

    @FXML
    public void onEnviar(ActionEvent event) {
        String s = "\n" +
                campoPredio.getCharacters() + '\n' +
                campoAndar.getCharacters() + '\n' +
                campoNome.getCharacters() + '\n';
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
                    Sala sala = SalaDAO.editarSala(
                        editarSala.getId(),
                            campoPredio.getCharacters().toString() + "::" +
                            campoAndar.getCharacters().toString() + "::" +
                            campoNome.getCharacters().toString()
                    );
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getId().equals(sala.getId())) {
                            lista.set(i,sala);
                            break;
                        }
                    }
                } else {
                    Sala sala = SalaDAO.cadastraSala(
                            campoPredio.getCharacters().toString() + "::" +
                                    campoAndar.getCharacters().toString() + "::" +
                                    campoNome.getCharacters().toString()
                    );
                    lista.add(sala);
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
            campoPredio.setEditable(edit);
            campoAndar.setEditable(edit);
            campoNome.setEditable(edit);
            botaoEnviar.setDisable(!edit);
    }
}
