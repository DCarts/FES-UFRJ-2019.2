package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Situacao;
import br.com.fes.scoa.util.SituacaoDAOHandler;
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


public class ListaSituacaoController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Situacao> tabela;
    @FXML
    private TableColumn<Situacao, Boolean> selectCol;
    @FXML
    private TableColumn<Situacao, String> editCol;
    @FXML
    private TableColumn<Situacao, String> nomeCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Situacao selectedItem = null;

    public Situacao getSelectedItem() {
        return selectedItem;
    }

    public ListaSituacaoController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getNome());});
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
                    new Callback<TableColumn<Situacao, String>, TableCell<Situacao, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Situacao, String> param) {
                            final TableCell<Situacao, String> cell = new TableCell<Situacao, String>() {
                                final Button btn = new Button("Editar");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Situacao situacao = getTableView().getItems().get(getIndex());
                                            onEditar(situacao);
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
            List<Situacao> toremove = tabela.getItems().filtered(selectCol::getCellData);
            SituacaoDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_situacao.fxml")));
        	loader.setControllerFactory((t) -> new CadastroSituacaoController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar situacao");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSituacaoController controller = loader.getController();
            Situacao novo = controller.getNovo();
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
    public void onEditar(Situacao situacao) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_situacao.fxml")));
            loader.setControllerFactory((t) -> new CadastroSituacaoController(situacao));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar situacao");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSituacaoController controller = loader.getController();
            Situacao novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(situacao);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Situacao> lista;
        try {
            if (text.length() > 0) {
                lista = SituacaoDAOHandler.buscar(text);
            } else {
                lista = SituacaoDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO PASSAR ERRO
        }
    }
}
