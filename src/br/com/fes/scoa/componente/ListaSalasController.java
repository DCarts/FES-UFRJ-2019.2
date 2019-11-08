package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.util.AlunoDAO;
import br.com.fes.scoa.util.SalaDAO;
import javafx.application.Platform;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editCol.setCellValueFactory(
                new PropertyValueFactory<>("edit"));
        predioCol.setCellValueFactory(
                new PropertyValueFactory<>("predio"));
        andarCol.setCellValueFactory(
                new PropertyValueFactory<>("andar"));
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("nome"));

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
        atualizarLista();
    }

    public void onRemoverSelecionados(ActionEvent actionEvent) {
        List<Sala> selecionados = new ArrayList();
        tabela.getItems().forEach(item -> {
            if (selectCol.getCellData(item)) selecionados.add(item);
        });
        tabela.getItems().removeAll(selecionados);
        SalaDAO.remover(selecionados);
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_sala.fxml")));
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
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_sala.fxml")));
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
        if (text.length() > 0) {
            lista = SalaDAO.buscar(text);
        } else {
            lista = SalaDAO.listar();
        }
        tabela.setItems(lista);
    }
}
