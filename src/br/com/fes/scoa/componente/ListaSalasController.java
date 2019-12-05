package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Sala;
import br.com.fes.scoa.util.SalaDAOHandler;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.orm.PersistentException;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class ListaSalasController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Sala> tabela;
    @FXML
    private TableColumn<Sala, Boolean> selectCol;
    @FXML
    private TableColumn<Sala, String> editCol;
    @FXML
    private TableColumn<Sala, String> predioCol;
    @FXML
    private TableColumn<Sala, String> andarCol;
    @FXML
    private TableColumn<Sala, String> nomeCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Sala selectedItem = null;

    public Sala getSelectedItem() {
        return selectedItem;
    }

    public ListaSalasController(boolean doSelect) {
        this.doSelect = doSelect;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        predioCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCodLocalizacao().split("::")[0]));
        andarCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCodLocalizacao().split("::")[1]));
        nomeCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCodLocalizacao().split("::")[2]));
        if (doSelect) {
            botaoRemover.setDisable(true);
            botaoRemover.setText("Selecionar");
            tabela.getSelectionModel().selectedItemProperty().addListener((a, b, newSelection) -> {
                selectedItem = newSelection;
                if (newSelection != null) {
                    botaoRemover.setDisable(false);
                }
                else {
                    botaoRemover.setDisable(true);
                }
            });
        }
        else {
            editCol.setCellValueFactory(
                    new PropertyValueFactory<>("edit"));

            selectCol.setCellFactory(
                    CheckBoxTableCell.forTableColumn(selectCol));
            editCol.setCellFactory(
                    new Callback<TableColumn<Sala, String>, TableCell<Sala, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Sala, String> param) {
                            final TableCell<Sala, String> cell = new TableCell<Sala, String>() {
                                final Button btn = new Button("Editar");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Sala sala = getTableView().getItems().get(getIndex());
                                            onEditar(sala);
                                        });
                                        setGraphic(btn);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    });
        }
        atualizarLista();
    }

    public void onRemoverSelecionados(ActionEvent actionEvent) {
        if (doSelect) {
            botaoRemover.getScene().getWindow().hide();
            return;
        }

        try {
            List<Sala> toremove = tabela.getItems().filtered(selectCol::getCellData);
            SalaDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_sala.fxml")));
        	loader.setControllerFactory((t) -> new CadastroSalaController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar sala");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSalaController controller = loader.getController();
            Sala novo = controller.getNovo();
            if (novo != null) {
                System.out.println("chegou aqui");
                tabela.getItems().add(novo);
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void onBuscar(KeyEvent evt) {
        String busca = campoBuscar.getText();
        System.out.println("busca: "+busca);
        if (busca.length() > 0) {
            if (botaoBuscar.isDisabled()) botaoBuscar.setDisable(false);
            if (evt.getCode() == KeyCode.ENTER) atualizarLista();
        } else {
            if (!botaoBuscar.isDisabled()) botaoBuscar.setDisable(true);
            atualizarLista();
        }
    }

    @FXML
    public void onEditar(Sala sala) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_sala.fxml")));
            loader.setControllerFactory((t) -> new CadastroSalaController(sala));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar aluno");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSalaController controller = loader.getController();
            Sala novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(sala);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Sala> lista;
        try {
            if (text.length() > 0) {
                lista = SalaDAOHandler.buscar(text);
            } else {
                lista = SalaDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO PASSAR ERRO
        }
    }
}
