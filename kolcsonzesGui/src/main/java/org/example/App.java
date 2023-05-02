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

    public static ArrayList<Kolcsonzes> kolcsonzes;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FileChooser megnyitasablak = new FileChooser();
        //megnyitasablak.setInitialDirectory(new File("C:\\Users\\Tarnóczi Levente\\Desktop\\berek2020.txt"));
        File fajl = megnyitasablak.showOpenDialog(stage);
        String path = fajl.getAbsolutePath();
        kolcsonzes = Kolcsonzes.beolvasas(path);
        System.out.println(kolcsonzes);
        scene = new Scene(loadFXML("primary"), 640, 480);
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