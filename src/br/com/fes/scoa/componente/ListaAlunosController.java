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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ListaAlunosController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button botaoRemover;
    @FXML
    private TableView<Pessoa> tabela;
    @FXML
    private TableColumn<Pessoa, Boolean> selectCol;
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
        // EDITAR NOME
        // nomeCol.setCellFactory(
        //         TextFieldTableCell.forTableColumn());

        selectCol.setCellFactory(
                CheckBoxTableCell.forTableColumn(selectCol));
        tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tabela.setItems(listar());
        
    }

    private ObservableList<Pessoa> listar() {
        return AlunoDAO.listar();
    }

    public void onRemoverSelecionados(ActionEvent actionEvent) {
        List<Pessoa> selecionados = new ArrayList();
        tabela.getItems().forEach(item -> {
            if (item.isChecked()) selecionados.add(item);
        });
        tabela.getItems().removeAll(selecionados);
        AlunoDAO.remover(selecionados);
    }

    @FXML
    public void onCriar(ActionEvent actionEvent) {
        try {
        	FXMLLoader loader = new FXMLLoader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("br/com/fes/scoa/componente/cadastro_aluno.fxml")));
        	loader.setControllerFactory((t) -> new CadastroAlunoController(tabela.getItems()));
        	Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastrar aluno");
            stage.setScene(new Scene(root, 400, 400));
            stage.initOwner(titleLabel.getScene().getWindow());
            stage.show();
            Platform.runLater(stage::requestFocus);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void onBuscar(ActionEvent evt) {
    	throw new UnsupportedOperationException("falta fazer");
    	// @ TODO Implementar busca
    }
}
