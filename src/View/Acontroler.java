package View;

import Model.Model;
import javafx.scene.control.Alert;

public  abstract class Acontroler {
   protected static Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void showAlert(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();

    }
}
