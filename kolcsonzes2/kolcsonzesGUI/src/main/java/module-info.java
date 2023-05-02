module hu.katolikuskeri.keri14c {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.katolikuskeri.keri14c to javafx.fxml;
    exports hu.katolikuskeri.keri14c;

    requires asd;
}
