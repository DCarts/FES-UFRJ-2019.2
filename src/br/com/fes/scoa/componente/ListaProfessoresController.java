package br.com.fes.scoa.componente;

import br.com.fes.scoa.modelo.Pessoa;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import br.com.fes.scoa.util.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ListaProfessoresController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Pessoa> tabela;
    @FXML
    private TableColumn<Pessoa, Boolean> selectCol;
    @FXML
    private TableColumn<Pessoa, String> editCol;
    @FXML
    private TableColumn<Pessoa, String> classesCol;
    @FXML
    private TableColumn<Pessoa, String> nomeCol;
    @FXML
    private TableColumn<Pessoa, String> cpfCol;
    @FXML
    private TableColumn<Pessoa, String> emailCol;
    @FXML
    private TableColumn<Pessoa, String> enderecoCol;
    @FXML
    private TableColumn<Pessoa, String> data_nascimentoCol;

    @FXML
    private TextField campoBuscar;

    @FXML
    private Button botaoBuscar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectCol.setCellValueFactory(
            param -> param.getValue().getChecked());
        editCol.setCellValueFactory(
            new PropertyValueFactory<>("nome"));
        classesCol.setCellValueFactory(
            new PropertyValueFactory<>("nome"));
        nomeCol.setCellValueFactory(
            new PropertyValueFactory<>("nome"));
        cpfCol.setCellValueFactory(
            new PropertyValueFactory<>("cpf"));
        emailCol.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        enderecoCol.setCellValueFactory(
            new PropertyValueFactory<>("endereco"));
        data_nascimentoCol.setCellValueFactory(
            new PropertyValueFactory<>("data_nascimento"));

        selectCol.setCellFactory(
            CheckBoxTableCell.forTableColumn(selectCol));
        editCol.setCellFactory(
            new Callback<TableColumn<Pessoa, String>, TableCell<Pessoa, String>>() {
                @Override
                public TableCell call(final TableColumn<Pessoa, String> param) {
                    final TableCell<Pessoa, String> cell = new TableCell<Pessoa, String>() {
                        final Button btn = new Button("Editar");
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    Pessoa pessoa = getTableView().getItems().get(getIndex());
                                    onEditar(pessoa);
                                });
                                setGraphic(btn);
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
        });
        classesCol.setCellFactory(
            new Callback<TableColumn<Pessoa, String>, TableCell<Pessoa, String>>() {
                @Override
                public TableCell call(final TableColumn<Pessoa, String> param) {
                    final TableCell<Pessoa, String> cell = new TableCell<Pessoa, String>() {
                        final Button btn = new Button("Turmas");
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                    Pessoa pessoa = getTableView().getItems().get(getIndex());
                                    onClasses(pessoa);
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
        List<Pessoa> selecionados = new ArrayList();
        tabela.getItems().forEach(item -> {
            if (item.isChecked()) selecionados.add(item);
        });
        tabela.getItems().removeAll(selecionados);
        ProfessorDAO.remover(selecionados);
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_professor.fxml")));
        	loader.setControllerFactory((t) -> new CadastroProfessorController(tabela.getItems(),null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar professor");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.show();
            Platform.runLater(stage::requestFocus);

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
    public void onEditar(Pessoa pessoa) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_professor.fxml")));
            loader.setControllerFactory((t) -> new CadastroProfessorController(tabela.getItems(), pessoa));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar professor");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClasses(Pessoa pessoa) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/turmas_professor.fxml")));
            loader.setControllerFactory((t) -> new TurmasProfessorController(pessoa));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Turmas do " + pessoa.getNome());
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.show();
            Platform.runLater(stage::requestFocus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarLista() {
        String text = campoBuscar.getText();
        ObservableList<Pessoa> lista;
        if (text.length() > 0) {
            lista = ProfessorDAO.buscar(text);
        } else {
            lista = ProfessorDAO.listar();
        }
        tabela.setItems(lista);
    }
}
