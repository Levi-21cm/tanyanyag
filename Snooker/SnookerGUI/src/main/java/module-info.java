module hu.katolikuskeri.snooker.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires SnookerCLI;

    opens hu.katolikuskeri.snooker.gui to javafx.fxml;
    exports hu.katolikuskeri.snooker.gui;
}
