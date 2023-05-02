package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FoAblakController implements Initializable {
    @FXML
    private ListView<Dolgozo> lst_dolgozok;

    @FXML
    private TextField tf_belepes;

    @FXML
    private TextField tf_ber;

    @FXML
    private TextField tf_neme;

    @FXML
    private TextField tf_nev;

    @FXML
    private TextField tf_reszleg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Dolgozo elem : App.dolgozok){
            lst_dolgozok.getItems().add(elem);
        }
    }
    @FXML
    public void adatbetoltes(){
        //listview kiválasztott elem lekérdezés
        int kiválaszott = lst_dolgozok.getSelectionModel().getSelectedIndex();
        Dolgozo kivDolgozó =lst_dolgozok.getItems().get(kiválaszott);
        lst_dolgozok.getItems().get(kiválaszott);

        tf_nev.setText(kivDolgozó.getNév());
        tf_neme.setText(kivDolgozó.getNeme());
        tf_ber.setText(String.valueOf(kivDolgozó.getBér()));

    }
    @FXML
    public void adatmodositas(){
        int kivalasztott = lst_dolgozok.getSelectionModel().getSelectedIndex();
        if (kivalasztott > 0) {
            lst_dolgozok.getItems().get(kivalasztott).setNév(tf_nev.getText());
            lst_dolgozok.getItems().get(kivalasztott).setNeme(tf_neme.getText());
            lst_dolgozok.getItems().get(kivalasztott).setBér(Integer.parseInt(tf_ber.getText()));
            lst_dolgozok.getItems().get(kivalasztott).setRészleg(tf_reszleg.getText());
            lst_dolgozok.getItems().get(kivalasztott).setBelepesÉve(Integer.parseInt(tf_belepes.getText()));
        }else {
            Alert hibauzenet = new Alert(Alert.AlertType.WARNING);
            hibauzenet.setTitle("nincs kiválasztott a listából");
            hibauzenet.setContentText("vállasz ki a listából egy dolgozót hé");
            hibauzenet.show();
        }

    }
}