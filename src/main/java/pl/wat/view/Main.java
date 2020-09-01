package pl.wat.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane mainGridPane = FXMLLoader.load(getClass().getResource("/CoreView.fxml"));
        Scene mainScene = new Scene(mainGridPane);
        stage.setScene(mainScene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
