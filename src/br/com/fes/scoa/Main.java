package br.com.fes.scoa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.Thread;

import javax.persistence.EntityManager;

import br.com.fes.scoa.util.JPAUtil;

public class Main extends Application {
	
	public static EntityManager em;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	
    	Thread t1 = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    	em = JPAUtil.abreConexao();
    	    }
    	});  
    	t1.start();
  		
    	
        Parent root = FXMLLoader.load(getClass().getResource("./componente/home_secretario.fxml"));
        primaryStage.setTitle("SCOA");
        primaryStage.setScene(new Scene(root));
        primaryStage.onCloseRequestProperty().setValue(evt -> {em.close(); Platform.exit();});
        primaryStage.show();
        Platform.runLater(primaryStage::requestFocus);
    }

    public static void main(String[] args) {
        launch(args);
    }
}