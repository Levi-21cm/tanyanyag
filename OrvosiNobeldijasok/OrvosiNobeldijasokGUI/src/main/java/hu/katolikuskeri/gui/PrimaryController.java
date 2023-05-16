package hu.katolikuskeri.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PrimaryController {

    @FXML
    private javafx.scene.control.TextField Ev_TF;

    @FXML
    private javafx.scene.control.TextField Nev_TF;

    @FXML
    private javafx.scene.control.TextField Orszag_TF;

    @FXML
    private javafx.scene.control.TextField szulHal_TF;

    public void click(javafx.scene.input.MouseEvent mouseEvent) {
        String ev = Ev_TF.getText();
        String nev = Nev_TF.getText();
        String orszag = Orszag_TF.getText();
        String szulHal = szulHal_TF.getText();

        if (ev.isEmpty() || nev.isEmpty() || orszag.isEmpty() || szulHal.isEmpty()) {
            Alert error_update_alert = new Alert(Alert.AlertType.CONFIRMATION);
            error_update_alert.setTitle("Hiba");
            error_update_alert.setHeaderText("Tötlse ki minden mezőt!");
            error_update_alert.show();
            return;

        }else {
            int evSzam = Integer.parseInt(ev);
            if (evSzam <= 1989) {
                Alert error_ev_alert = new Alert(Alert.AlertType.ERROR);
                error_ev_alert.setTitle("Hiba");
                error_ev_alert.setHeaderText("Az évszám nem megfelelő!");
                error_ev_alert.show();
                return;
        }
            try {
                // Szöveges állomány létrehozása és írása
                BufferedWriter writer = new BufferedWriter(new FileWriter("uj_dijazott.txt"));
                writer.write("Év;Név;SzületésHalálozás;Országkód");
                writer.newLine();
                writer.write(ev + ";" + nev + ";" + szulHal + ";" + orszag);
                writer.newLine();
                writer.close();

                // Sikeres írás után töröld a beviteli mezők tartalmát
                Ev_TF.clear();
                Nev_TF.clear();
                Orszag_TF.clear();
                szulHal_TF.clear();

                Alert success_alert = new Alert(Alert.AlertType.INFORMATION);
                success_alert.setTitle("Siker");
                success_alert.setHeaderText("Az állomány sikeresen létrehozva és írva!");
                success_alert.show();
            } catch (IOException e) {
                Alert error_file_alert = new Alert(Alert.AlertType.ERROR);
                error_file_alert.setTitle("Hiba");
                error_file_alert.setHeaderText("Hiba az állomány írásánál!");
                error_file_alert.show();
            }
    }


//    @FXML
//    void adatokMenteseButtonPressed(MouseEvent event) {
//        String ev = Ev_TF.getText();
//        String nev = Nev_TF.getText();
//        String orszag = Orszag_TF.getText();
//        String szulHal = szulHal_TF.getText();
//
//        if (ev.isEmpty() || nev.isEmpty() || orszag.isEmpty() || szulHal.isEmpty()) {
//            Alert error_update_alert = new Alert(Alert.AlertType.CONFIRMATION);
//            error_update_alert.setTitle("Hiba");
//            error_update_alert.setHeaderText("Tötlse ki minden mezőt!");
//            error_update_alert.show();
//            return;
//
//        }
//
//    }


}}
