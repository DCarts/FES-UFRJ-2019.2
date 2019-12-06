package br.com.fes.scoa.componente;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.model.Aluno;
import br.com.fes.scoa.model.Inscricao_aluno;
import br.com.fes.scoa.model.Situacao;
import br.com.fes.scoa.model.Turma;
import br.com.fes.scoa.util.HorariodeaulaDAOHandler;
import br.com.fes.scoa.util.SalaDAOHandler;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TurmasAlunoController implements Initializable {
    @FXML
    public TableColumn<Turma, String> predioCol;
    @FXML
    public TableColumn<Turma, String> andarCol;
    @FXML
    public TableColumn<Turma, String> salaNomeCol;
    @FXML
    private Label titleLabel;
    @FXML
    private TableView<Turma> tabela;
    @FXML
    private TableColumn<Turma, String> inscricaoCol;
    @FXML
    private TableColumn<Turma, String> notaCol;
    @FXML
    private TableColumn<Turma, String> frequenciaCol;
    @FXML
    private TableColumn<Turma, String> situacaoCol;
    @FXML
    private TableColumn<Turma, String> disciplinaCol;
    @FXML
    private TableColumn<Turma, String> salaCol;
    @FXML
    private TableColumn<Turma, String> horaCol;

    private final ObservableList<Turma> lista;
    private final Aluno aluno;

    public TurmasAlunoController(Aluno aluno, ObservableList<Turma> turmas) {
        lista = turmas;
        this.aluno = aluno;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        disciplinaCol.setCellValueFactory(param -> {return new ReadOnlyStringWrapper(param.getValue().getDisciplina().getNome());});
        situacaoCol.setCellValueFactory(param -> {
            Situacao st = Stream.of(param.getValue().inscricao_aluno.toArray()).filter(ia -> ia.getAluno().getPessoaId()==aluno.getPessoaId()).map(
                    Inscricao_aluno::getSituacao).map(Optional::ofNullable).findFirst().flatMap(Function.identity())
                    .orElse(null);
            return new ReadOnlyStringWrapper(st == null? "" : st.getNome());
        });
        notaCol.setCellValueFactory(param -> {
            String st = Stream.of(param.getValue().inscricao_aluno.toArray()).filter(ia -> ia.getAluno().getPessoaId()==aluno.getPessoaId()).map(
                    Inscricao_aluno::getNota).map(Optional::ofNullable).findFirst().flatMap(Function.identity())
                    .orElse(BigDecimal.valueOf(-5)).toString();
            return new ReadOnlyStringWrapper(st.equals("-5")? "" : st);
        });
        frequenciaCol.setCellValueFactory(param -> {
            String st = Stream.of(param.getValue().inscricao_aluno.toArray()).filter(ia -> ia.getAluno().getPessoaId()==aluno.getPessoaId()).map(
                    Inscricao_aluno::getFrequencia).map(Optional::ofNullable).findFirst().flatMap(Function.identity())
                    .orElse(BigDecimal.valueOf(-5)).toString();
            return new ReadOnlyStringWrapper(st.equals("-5")? "" : st);
        });
        horaCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> HorariodeaulaDAOHandler.horarioToString(ast.getHora())).collect(Collectors.toList())));
        });
        andarCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getAndar(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        salaNomeCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getSalaNome(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        predioCol.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(Main.lineConcat(Stream.of(param.getValue().alocacao_sala_turma.toArray()).map(
                    ast -> SalaDAOHandler.getPredio(ast.getSala().getCodLocalizacao())).collect(Collectors.toList())));
        });
        tabela.setItems(lista);
    }
}
