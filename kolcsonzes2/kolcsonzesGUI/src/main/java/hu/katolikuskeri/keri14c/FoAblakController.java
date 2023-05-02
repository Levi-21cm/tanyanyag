package hu.katolikuskeri.keri14c;

import java.io.IOException;
import javafx.fxml.FXML;

public class FoAblakController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
