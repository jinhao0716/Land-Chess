package main.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(this.getClass().getResource("/fxml/board.fxml"));

            Parent parent = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("陆战棋");
            stage.setMaximized(true);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/main/resources/css/board.css")).toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
