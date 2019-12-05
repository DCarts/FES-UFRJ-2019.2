package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Area_disciplina;
import br.com.fes.scoa.util.AreaDAOHandler;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
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


public class ListaAreasController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Area_disciplina> tabela;
    @FXML
    private TableColumn<Area_disciplina, Boolean> selectCol;
    @FXML
    private TableColumn<Area_disciplina, String> editCol;
    @FXML
    private TableColumn<Area_disciplina, String> nomeCol;
    @FXML
    private TableColumn<Area_disciplina, String> descricaoCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Area_disciplina selectedItem = null;

    public Area_disciplina getSelectedItem() {
        return selectedItem;
    }

    public ListaAreasController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getNome());});
        descricaoCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getDescricao());});
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
            selectCol.setCellValueFactory(
                    param -> param.getValue().getChecked());
            editCol.setCellValueFactory(
                    new PropertyValueFactory<>("nome"));

            selectCol.setCellFactory(
                    CheckBoxTableCell.forTableColumn(selectCol));
            editCol.setCellFactory(
                    new Callback<TableColumn<Area_disciplina, String>, TableCell<Area_disciplina, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Area_disciplina, String> param) {
                            final TableCell<Area_disciplina, String> cell = new TableCell<Area_disciplina, String>() {
                                final Button btn = new Button("Editar");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Area_disciplina area = getTableView().getItems().get(getIndex());
                                            onEditar(area);
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
            List<Area_disciplina> toremove = tabela.getItems().filtered(selectCol::getCellData);
            AreaDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_area.fxml")));
        	loader.setControllerFactory((t) -> new CadastroAreaController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar area");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroAreaController controller = loader.getController();
            Area_disciplina novo = controller.getNovo();
            if (novo != null) {
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
    public void onEditar(Area_disciplina area) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_area.fxml")));
            loader.setControllerFactory((t) -> new CadastroAreaController(area));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar área");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroAreaController controller = loader.getController();
            Area_disciplina novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(area);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Area_disciplina> lista;
        try {
            if (text.length() > 0) {
                lista = AreaDAOHandler.buscar(text);
            } else {
                lista = AreaDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO PASSAR ERRO
        }
    }
}
