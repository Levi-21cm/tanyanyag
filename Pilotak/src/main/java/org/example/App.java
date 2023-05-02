package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    public static ArrayList<Pilotak> pilotak;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasablak = new FileChooser();
        File fajl = megnyitasablak.showOpenDialog(stage);
        String path = fajl.getAbsolutePath();
        pilotak = Pilotak.beolvasas(path);


        scene = new Scene(loadFXML("Foablak"), 640, 480);
        stage.setScene(scene);
        stage.show();


    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}