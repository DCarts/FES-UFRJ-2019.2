package br.com.fes.scoa;

import br.com.fes.scoa.model.SCOAPersistentManager;
import br.com.fes.scoa.teste.TesteConta;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import java.util.List;

public class Main extends Application {
	
	public static EntityManager em;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	
    	/*Thread t1 = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	em = JPAUtil.abreConexao();
    	    }
    	});  
    	t1.start();
        em = JPAUtil.abreConexao();*/

        TesteConta.main(null);
  		
    	
        Parent root = FXMLLoader.load(getClass().getResource("componente/fxml/home_secretario.fxml"));
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