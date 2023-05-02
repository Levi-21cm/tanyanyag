package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("foAblakView"), 300, 400);
        foAblakController.foAblak = stage;
        stage.setScene(scene);
        stage.setTitle("Kalkulátor");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void uzenetMegjelenítése(Alert.AlertType tipus, String cím, String header, String content, Stage ablak){
        Alert alert = new Alert(tipus);
        alert.setTitle(cím);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.initOwner(ablak);
        alert.initModality(Modality.WINDOW_MODAL);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}