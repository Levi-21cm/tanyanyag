package hu.katolikuskeri.keri14c;

import hu.katolikuskeri.keri14c.cl.Kolcsonzes;
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

    public ArrayList<Kolcsonzes> kölcsönzések = new ArrayList<>();
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasAblak = new FileChooser();
        megnyitasAblak.setTitle("kérem adja meg az állományt");
        megnyitasAblak.setInitialDirectory(new File("."));//hol nyissa meg
        //megnyitasAblak.showOpenDialog(stage);

        kölcsönzések= Kolcsonzes.beolvas(megnyitasAblak.showOpenDialog(stage).getAbsolutePath());//megnyitás
        //System.out.println(kölcsönzések.size());
        scene = new Scene(loadFXML("FoAblakView"), 650, 400);
        stage.setScene(scene);
        stage.setTitle("Kölcsönzések Kezelése");
        stage.centerOnScreen();//középre rakja
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