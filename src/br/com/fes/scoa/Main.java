package br.com.fes.scoa;

import br.com.fes.scoa.model.*;
import br.com.fes.scoa.teste.TesteConta;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.orm.PersistentException;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;

public class Main extends Application {
	
	public static EntityManager em;

    @Override
    public void start(Stage primaryStage) throws Exception {

        TesteConta.main(null);

        try {
            if (PessoaDAO.listPessoaByQuery(null, null).length == 0) {
                Pessoa p = PessoaDAO.createPessoa();
                p.setCpf("63333371022");
                p.setData_nascimento(Date.valueOf("2000-01-01"));
                p.setEmail("suporte@scoa.com");
                p.setEndereco("CCMN, UFRJ, RJ, BRASIL");
                p.setNome("sysadmin");
                p.setSenha("5ba70a9ea5769980f560c754e42b1544fc03d36b1d6b63fcc5bd02609686e9aa"); // senha eh wololo
                PessoaDAO.save(p);

                Sysadmins sa = SysadminsDAO.createSysadmins();
                sa.setPessoa(p);
                SysadminsDAO.save(sa);
            }
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    	
        Parent root = FXMLLoader.load(getClass().getResource("componente/fxml/login.fxml"));
        primaryStage.setTitle("SCOA");
        primaryStage.setScene(new Scene(root));
        primaryStage.onCloseRequestProperty().setValue(evt -> {
            try {
                SCOAPersistentManager.instance().disposePersistentManager();
            } catch (Exception err) {}
            Platform.exit();
        });
        primaryStage.show();
        Platform.runLater(primaryStage::requestFocus);
    }

    public static String lineConcat(List<String> strlist) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (; i < strlist.size()-1; i++) {
            sb.append(strlist.get(i));
            sb.append('\n');
        }
        if (strlist.size() > 0) {
            sb.append(strlist.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}