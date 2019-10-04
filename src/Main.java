import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("components/home_secretario.fxml"));
        primaryStage.setTitle("SCOA");
        primaryStage.setScene(new Scene(root));
        primaryStage.onCloseRequestProperty().setValue(evt -> Platform.exit());
        primaryStage.show();
        Platform.runLater(primaryStage::requestFocus);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
