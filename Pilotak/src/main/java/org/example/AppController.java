package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ListView<Pilotak> lista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Pilotak elem: App.pilotak){
            lista.getItems().add(elem);
        }
    }
}
