package br.com.fes.scoa.componente;

import br.com.fes.scoa.model.Professor;
import br.com.fes.scoa.util.ProfessorDAOHandler;
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


public class ListaProfessoresController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Professor> tabela;
    @FXML
    private TableColumn<Professor, Boolean> selectCol;
    @FXML
    private TableColumn<Professor, String> editCol;
    @FXML
    private TableColumn<Professor, String> areaNomeCol;
    @FXML
    private TableColumn<Professor, String> classesCol;
    @FXML
    private TableColumn<Professor, String> nomeCol;
    @FXML
    private TableColumn<Professor, String> cpfCol;
    @FXML
    private TableColumn<Professor, String> emailCol;
    @FXML
    private TableColumn<Professor, String> enderecoCol;
    @FXML
    private TableColumn<Professor, String> data_nascimentoCol;
    
    @FXML
    private TextField campoBuscar;
    
    @FXML
    private Button botaoBuscar;

    private final boolean doSelect;
    private Professor selectedItem = null;

    public Professor getSelectedItem() {
        return selectedItem;
    }

    public ListaProfessoresController(boolean doSelect) {
        this.doSelect = doSelect;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getNome());});
        areaNomeCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getArea_disciplina().getNome());});
        cpfCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getCpf());});
        emailCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getEmail());});
        enderecoCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getEndereco());});
        data_nascimentoCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getPessoa().getData_nascimento().toString());});
        classesCol.setCellFactory(
                new Callback<TableColumn<Professor, String>, TableCell<Professor, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Professor, String> param) {
                        final TableCell<Professor, String> cell = new TableCell<Professor, String>() {
                            final Button btn = new Button("Turmas");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Professor professor = getTableView().getItems().get(getIndex());
                                        onClasses(professor);
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
            });
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
            classesCol.setCellValueFactory(
                    new PropertyValueFactory<>("nome"));
            selectCol.setCellFactory(
                    CheckBoxTableCell.forTableColumn(selectCol));
            editCol.setCellFactory(
                    new Callback<TableColumn<Professor, String>, TableCell<Professor, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Professor, String> param) {
                            final TableCell<Professor, String> cell = new TableCell<Professor, String>() {
                                final Button btn = new Button("Editar");
                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Professor professor = getTableView().getItems().get(getIndex());
                                            onEditar(professor);
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
            List<Professor> toremove = tabela.getItems().filtered(selectCol::getCellData);
            ProfessorDAOHandler.remover(toremove);
            tabela.getItems().removeAll(toremove);
        } catch (PersistentException e) {
            e.printStackTrace(); //@TODO mostrar erro
        }
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_professor.fxml")));
        	loader.setControllerFactory((t) -> new CadastroProfessorController(null));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar professor");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            Platform.runLater(stage::requestFocus);
            stage.showAndWait();
            CadastroProfessorController controller = loader.getController();
            Professor novo = controller.getNovo();
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
    public void onEditar(Professor professor) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/cadastro_professor.fxml")));
            loader.setControllerFactory((t) -> new CadastroProfessorController(professor));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Editar professor");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.showAndWait();
            Platform.runLater(stage::requestFocus);
            CadastroProfessorController controller = loader.getController();
            Professor novo = controller.getNovo();
            if (novo != null) {
                tabela.getItems().remove(professor);
                tabela.getItems().add(novo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void onClasses(Professor professor) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/fxml/turmas_professor.fxml")));
            loader.setControllerFactory((t) -> new TurmasProfessorController(professor));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Turmas do " + professor.getPessoa().getNome());
            stage.setScene(new Scene(root));
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
        ObservableList<Professor> lista;
        try {
            if (text.length() > 0) {
                lista = ProfessorDAOHandler.buscar(text);
            } else {
                lista = ProfessorDAOHandler.listar();
            }
            tabela.setItems(lista);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
