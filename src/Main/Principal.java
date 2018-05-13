package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    public static Stage myStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
        myStage = stage;
        stage.setTitle("Safety Plan");
        stage.setScene(scene);
        stage.show();    
    }
}
