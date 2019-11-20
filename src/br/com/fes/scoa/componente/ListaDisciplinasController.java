package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Disciplina;
import br.com.fes.scoa.util.DisciplinaDAO;
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


public class ListaDisciplinasController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Disciplina> tabela;
    @FXML
    private TableColumn<Disciplina, Boolean> selectCol;
    @FXML
    private TableColumn<Disciplina, String> editCol;
    @FXML
    private TableColumn<Disciplina, String> nomeCol;
    @FXML
    private TableColumn<Disciplina, String> descricaoCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Disciplina selectedItem = null;

    public Disciplina getSelectedItem() {
        return selectedItem;
    }

    public ListaDisciplinasController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        descricaoCol.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
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
                    new Callback<TableColumn<Disciplina, String>, TableCell<Disciplina, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Disciplina, String> param) {
                            final TableCell<Disciplina, String> cell = new TableCell<Disciplina, String>() {
                                final Button btn = new Button("Editar");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Disciplina disciplina = getTableView().getItems().get(getIndex());
                                            onEditar(disciplina);
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
        List<Disciplina> selecionados = new ArrayList();
        tabela.getItems().forEach(item -> {
            if (item.isChecked()) selecionados.add(item);
        });
        tabela.getItems().removeAll(selecionados);
        DisciplinaDAO.remover(selecionados);
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_disciplina.fxml")));
        	loader.setControllerFactory((t) -> new CadastroDisciplinaController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar disciplina");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroDisciplinaController controller = loader.getController();
            Disciplina novo = controller.getNovo();
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
    public void onEditar(Disciplina disciplina) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_disciplina.fxml")));
            loader.setControllerFactory((t) -> new CadastroDisciplinaController(disciplina));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar disciplina");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroDisciplinaController controller = loader.getController();
            Disciplina novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(disciplina);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Disciplina> lista;
        if (text.length() > 0) {
            lista = DisciplinaDAO.buscar(text);
        } else {
            lista = DisciplinaDAO.listar();
        }
        tabela.setItems(lista);
    }
}
