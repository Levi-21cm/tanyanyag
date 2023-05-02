package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {
    public static ArrayList<Dolgozo> dolgozok;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasablak = new FileChooser();
        //megnyitasablak.setInitialDirectory(new File("C:\\Users\\Tarnóczi Levente\\Desktop\\berek2020.txt"));
        File fajl = megnyitasablak.showOpenDialog(stage);
        String path = fajl.getAbsolutePath();
        dolgozok = Dolgozo.beolvasas(path);

        scene = new Scene(loadFXML("foablak-view"), 640, 480);
        stage.setScene(scene);
        stage.setOnCloseRequest((windowEvent -> {
            Alert kerdes = new Alert(Alert.AlertType.CONFIRMATION);
            kerdes.setTitle("kilépés");
            kerdes.setContentText("biztosan kilép mentés nélkül");
            ButtonType igengomb = new ButtonType("igen", ButtonBar.ButtonData.YES);
            ButtonType mengomb = new ButtonType("nem", ButtonBar.ButtonData.NO);
            ButtonType megsegomb = new ButtonType("mégsem", ButtonBar.ButtonData.CANCEL_CLOSE);
            kerdes.getButtonTypes().addAll(igengomb,megsegomb,mengomb);

            Optional<ButtonType> eredmeny = kerdes.showAndWait();
            if (eredmeny.get()==igengomb){
                FileChooser mentésAblak = new FileChooser();
                mentésAblak.setTitle("dolgozó adatai mentése");
                File menteshelye =mentésAblak.showOpenDialog(stage);
                try {
                    FileWriter iro = new FileWriter(menteshelye, Charset.forName("UTF-8"),false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (eredmeny.get()==mengomb) {

            }else {

            }
            kerdes.show();
        }));

        stage.show();  }
        HashMap<String,Integer> dolgozókRészlegenként = new HashMap<>();
        /*dolgozókRészlegenként.put("beszerzés",15);
        dolgozókRészlegenként.put("beszerzés",34);
        System.out.println(dolgozókRészlegenként.get("beszerzés"));
        System.out.println(dolgozókRészlegenként.getOrDefault("IT",0));*/
        for (Dolgozo elem: dolgozok){
            if (dolgozókRészlegenként.containsKey(elem.getRészleg())){
                //van ilyen részleg
                int eddig = dolgozókRészlegenként.get(elem.getRészleg());
                eddig++;
                dolgozókRészlegenként.put(elem.getRészleg(),eddig);
            }else {
                dolgozókRészlegenként.put(elem.getRészleg(),1);
                //nincs ilyen részleg
            }
        for (Map.Entry<String,Integer> elem: dolgozókRészlegenként.entrySet()){
            System.out.printf("%s: %d fő\n",elem.getKey(),elem.getValue());
        }
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