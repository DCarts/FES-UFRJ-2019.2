package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.model.Sala;
import br.com.fes.scoa.model.SalaDAO;
import br.com.fes.scoa.util.SalaDAOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import org.orm.PersistentException;

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

    private final Sala original;
    private Sala novo = null;

    private final String confirmDialogTitle;
    private final String confirmDialogHeader;
    private final String confirmDialogContent;
    private final String successDialogTitle;
    private final String successDialogHeader;
    private final String successDialogContent;
    private final String errorDialogTitle;
    private final String errorDialogContent;

    public CadastroSalaController(Sala original) {
        this.original = original;
        if (original != null) {
            confirmDialogTitle = "Editar sala";
            confirmDialogHeader = "Confirmar atualização da sala";
            confirmDialogContent = "Tem certeza que deseja atualizar a sala?";
            successDialogTitle = "Sala atualizada";
            successDialogHeader = "Sala atualizada:";
            successDialogContent = "A sala foi atualizada com sucesso.";
            errorDialogTitle = "Erro na atualização";
            errorDialogContent = "Cheque o console para mais informações.";
        }
        else {
            confirmDialogTitle = "Confirmar cadastro";
            confirmDialogHeader = "Confirmar cadastro de sala";
            confirmDialogContent = "Tem certeza que deseja cadastrar a sala?";
            successDialogTitle = "Sala cadastrada";
            successDialogHeader = "Sala cadastrada:";
            successDialogContent = "A sala foi cadastrada com sucesso.";
            errorDialogTitle = "Erro no cadastro";
            errorDialogContent = "Cheque o console para mais informações.";
        }
    }

    public Sala getNovo() {
        return novo;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (original != null) {
            String[] codigos = original.getCodLocalizacao().split("::");
            campoPredio.setText(codigos[0]);
            campoAndar.setText(codigos[1]);
            campoNome.setText(codigos[2]);
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
        if (campoAndar.getCharacters().toString().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Andar vazio");
            errAlert.setContentText("Você precisa digitar um andar!");
            errAlert.show();
            return;
        }
        if (campoPredio.getCharacters().toString().trim().isEmpty()) {
            Alert errAlert = new Alert(Alert.AlertType.ERROR);
            errAlert.setTitle(errorDialogTitle);
            errAlert.setHeaderText("Prédio vazio");
            errAlert.setContentText("Você precisa digitar um prédio!");
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
                if (original != null) {
                    original.setCodLocalizacao(campoPredio.getCharacters().toString() + "::" +
                            campoAndar.getCharacters().toString() + "::" +
                            campoNome.getCharacters().toString());
                    SalaDAO.save(original);
                    novo = original;
                } else {
                    novo = SalaDAOHandler.cadastraSala(
                            campoPredio.getCharacters().toString() + "::" +
                                    campoAndar.getCharacters().toString() + "::" +
                                    campoNome.getCharacters().toString()
                    );
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
                    e.printStackTrace(); // ai complica
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

    private void setEditable(boolean edit) {
            campoPredio.setEditable(edit);
            campoAndar.setEditable(edit);
            campoNome.setEditable(edit);
            botaoEnviar.setDisable(!edit);
    }
}
