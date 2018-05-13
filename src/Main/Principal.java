package Main;


import DAO.CriarTabelas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {

    public static Stage myStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CriarTabelas.chamar();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/Login.fxml")));
        myStage = stage;
        Image icone = new Image(getClass().getResourceAsStream("/Img/LogoTitulo.png"));
        stage.getIcons().add(icone);
        stage.setTitle("Safety Plan");
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();    
    }
}
