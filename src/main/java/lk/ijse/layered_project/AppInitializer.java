package lk.ijse.layered_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class
AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/layered_project/Session.fxml"))));
//        primaryStage.show();

        Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/layered_project/Clinic.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
    }
}
