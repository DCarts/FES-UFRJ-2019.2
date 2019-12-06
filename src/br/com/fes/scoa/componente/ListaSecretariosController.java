package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Secretario;
import br.com.fes.scoa.util.SecretarioDAOHandler;
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


public class ListaSecretariosController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Secretario> tabela;
    @FXML
    private TableColumn<Secretario, Boolean> selectCol;
    @FXML
    private TableColumn<Secretario, String> editCol;
    @FXML
    private TableColumn<Secretario, String> cursoNomeCol;
    @FXML
    private TableColumn<Secretario, String> nomeCol;
    @FXML
    private TableColumn<Secretario, String> cpfCol;
    @FXML
    private TableColumn<Secretario, String> emailCol;
    @FXML
    private TableColumn<Secretario, String> enderecoCol;
    @FXML
    private TableColumn<Secretario, String> data_nascimentoCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Secretario selectedItem = null;

    public Secretario getSelectedItem() {
        return selectedItem;
    }

    public ListaSecretariosController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getNome());});
        cursoNomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getCurso().getNome());});
        cpfCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getCpf());});
        emailCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getEmail());});
        enderecoCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getEndereco());});
        data_nascimentoCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getData_nascimento().toString());});

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
                    new Callback<TableColumn<Secretario, String>, TableCell<Secretario, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Secretario, String> param) {
                            final TableCell<Secretario, String> cell = new TableCell<Secretario, String>() {
                                final Button btn = new Button("Editar");
                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Secretario secretario = getTableView().getItems().get(getIndex());
                                            onEditar(secretario);
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
            List<Secretario> toremove = tabela.getItems().filtered(selectCol::getCellData);
            SecretarioDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_secretario.fxml")));
        	loader.setControllerFactory((t) -> new CadastroSecretarioController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar secretario");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroSecretarioController controller = loader.getController();
            Secretario novo = controller.getNovo();
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
    public void onEditar(Secretario secretario) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_secretario.fxml")));
            loader.setControllerFactory((t) -> new CadastroSecretarioController(secretario));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar secretário");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.showAndWait();
            Platform.runLater(stage::requestFocus);
            CadastroSecretarioController controller = loader.getController();
            Secretario novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(secretario);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Secretario> lista;
        try {
            if (text.length() > 0) {
                lista = SecretarioDAOHandler.buscar(text);
            } else {
                lista = SecretarioDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
