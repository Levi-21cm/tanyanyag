package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

public class korSzamitasAblakController {
    public static Stage korszamitasAblak;
    // Label: Születési dátum
    @FXML
    private DatePicker dpSzuletesiDatum;
    // Gomb: Számítás
    // 3 db Label: Év, Hónap, Nap
    @FXML
    private Label txtEv;
    @FXML
    private Label txtHonap;
    @FXML
    private Label txtNap;


    @FXML
    private Label txtSzulNapHEv;

    @FXML
    private Label txtSzulnapHHó;

    @FXML
    private Label txtSzulnapHNap;

    @FXML
    public void szamitas() {
        // A Számítás gombra kattintva végrehajtandó műveletek
        LocalDate mai = LocalDate.now();
        LocalDate szulDatum = dpSzuletesiDatum.getValue();

        if (szulDatum == null){
            App.uzenetMegjelenítése(Alert.AlertType.WARNING, "Nincs adat.", null, "Adja meg a születési dátumát!", korszamitasAblak);
        }

        Period elteltido = Period.between(szulDatum, mai);

        txtEv.setText("Év: " + Integer.toString(elteltido.getYears()));
        txtHonap.setText("Hónap: " + Integer.toString(elteltido.getMonths()));
        txtNap.setText("Nap: " + Integer.toString(elteltido.getDays()));

        double elteltHonap = (elteltido.getYears() * 12 )+ elteltido.getMonths() + ((double)elteltido.getDays() / 30);
        double elteltHet = elteltHonap*4;
        double elteltNap = (elteltido.getYears() * 365.25 )+ (elteltido.getMonths() * 30) + elteltido.getDays();
        double elteltOra = elteltNap*24;
        double elteltPerc = elteltOra*60;

        elteltHonapok.setText("Hónapokban: " + Double.toString(elteltHonap));
        elteltHetek.setText("Hetekben: " + Double.toString(elteltHet));
        elteltOrak.setText("Órák: " + Double.toString(elteltOra));
        elteltPercek.setText("Percek: " + Double.toString(elteltPerc));
        elteltNapok.setText("Napok: " + Double.toString(elteltNap));


        LocalDate szuletesNapAzAktualisEven = LocalDate.of(mai.getYear(), szulDatum.getMonth(), szulDatum.getDayOfMonth());
        if (szuletesNapAzAktualisEven.isAfter(mai)){
            //még az éven nem volt születésnapja
            Month honap = szulDatum.getMonth();
            int nap = szuletesNapAzAktualisEven.getDayOfMonth();
            int aktév= mai.getYear();
            LocalDate kövSzülinap = LocalDate.of(aktév,honap,nap);

            Period hátravan = Period.between( mai,kövSzülinap);

            txtSzulNapHEv.setText("Év: " +String.valueOf(hátravan.getYears()));
            txtSzulnapHHó.setText("Hónap: "+String.valueOf(hátravan.getMonths()));
            txtSzulnapHNap.setText("Nap: "+String.valueOf(hátravan.getDays()));

        }
        else {
            // Az éven volt már születésnapja
            Month honap = szulDatum.getMonth();
            int nap = szuletesNapAzAktualisEven.getDayOfMonth();
            int kövtév= mai.getYear();
            kövtév+=1;
            LocalDate kövSzülinap = LocalDate.of(kövtév,honap,nap);

            Period hátravan = Period.between( mai,kövSzülinap);

            txtSzulNapHEv.setText("Év: " +String.valueOf(hátravan.getYears()));
            txtSzulnapHHó.setText("Hónap: "+String.valueOf(hátravan.getMonths()));
            txtSzulnapHNap.setText("Nap: "+String.valueOf(hátravan.getDays()));
        }


    }

    @FXML
    private Label elteltHetek;

    @FXML
    private Label elteltHonapok;

    @FXML
    private Label elteltNapok;

    @FXML
    private Label elteltOrak;

    @FXML
    private Label elteltPercek;



}
