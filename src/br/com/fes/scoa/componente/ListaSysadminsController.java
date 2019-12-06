package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Sysadmins;
import br.com.fes.scoa.util.SysadminsDAOHandler;
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


public class ListaSysadminsController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Sysadmins> tabela;
    @FXML
    private TableColumn<Sysadmins, Boolean> selectCol;
    @FXML
    private TableColumn<Sysadmins, String> editCol;
    @FXML
    private TableColumn<Sysadmins, String> nomeCol;
    @FXML
    private TableColumn<Sysadmins, String> cpfCol;
    @FXML
    private TableColumn<Sysadmins, String> emailCol;
    @FXML
    private TableColumn<Sysadmins, String> enderecoCol;
    @FXML
    private TableColumn<Sysadmins, String> data_nascimentoCol;
    
    @FXML
    private TextField campoBuscar;
    
    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Sysadmins selectedItem = null;

    public Sysadmins getSelectedItem() {
        return selectedItem;
    }

    public ListaSysadminsController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getNome());});
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
                    new Callback<TableColumn<Sysadmins, String>, TableCell<Sysadmins, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Sysadmins, String> param) {
                            final TableCell<Sysadmins, String> cell = new TableCell<Sysadmins, String>() {
                                final Button btn = new Button("Editar");
                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Sysadmins admin = getTableView().getItems().get(getIndex());
                                            onEditar(admin);
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
            List<Sysadmins> toremove = tabela.getItems().filtered(selectCol::getCellData);
            SysadminsDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_admin.fxml")));
        	loader.setControllerFactory((t) -> new CadastroAdminController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar admin");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroAdminController controller = loader.getController();
            Sysadmins novo = controller.getNovo();
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
    public void onEditar(Sysadmins admin) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_admin.fxml")));
            loader.setControllerFactory((t) -> new CadastroAdminController(admin));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar admin");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.showAndWait();
            Platform.runLater(stage::requestFocus);
            CadastroAdminController controller = loader.getController();
            Sysadmins novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(admin);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Sysadmins> lista;
        try {
            if (text.length() > 0) {
                lista = SysadminsDAOHandler.buscar(text);
            } else {
                lista = SysadminsDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
