package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class foAblakController {

    public static Stage foAblak;

    // Főablakban van 4 gomb, amelyekre kattintva
    // elérhetjük az egyes funkciókat.

    @FXML
    public void korSzamitas() throws IOException {
        Stage korSzamitasAblak = new Stage();
        korSzamitasAblakController.korszamitasAblak = korSzamitasAblak;
        Scene ablakTartalma = new Scene(App.loadFXML("korszamitasAblakView"), 800, 600);
        korSzamitasAblak.setScene(ablakTartalma);
        korSzamitasAblak.setTitle("Kor kiszámítása");
        korSzamitasAblak.initOwner(foAblak);
        korSzamitasAblak.initModality(Modality.WINDOW_MODAL);
        korSzamitasAblak.showAndWait();
    }

    @FXML
    public void datumKulonbsegSzamitas() {

    }

    @FXML
    public void idoKulonbsegSzamitas() {

    }
}
