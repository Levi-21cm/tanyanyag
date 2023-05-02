package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    //file->projekt sutruktura->global libaries-> + gomb és Java->javafx mappa tallózás(bin mappa és lin mappa)->átnevezni javaFxre fent->moduls->dependences-> + gomb libary és a Javafx(amit az előbb neveztünk át) ha kell-> apply-> com.example.valami és Main osztályt kell létrehozni(psvm bele (public static void main),HelloApplication.main(args))->file porjek strukture artifacts-> + gomb jar from moduls with dependences->main-t kiválasztani> directoryban a resoources mappát választani->artifacts és a Javafx-re 2x kattintani hogy átrakja a baloldalra->build build artifacts->

    public static void main(String[] args) {
        launch();
    }
}