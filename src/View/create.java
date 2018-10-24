package View;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import static java.lang.Thread.sleep;

public class create extends Acontroler {
    public javafx.scene.control.Button btn_ImDone;
    public javafx.scene.control.TextField f_name;
    public javafx.scene.control.TextField l_name;
    public javafx.scene.control.TextField u_name;
    public javafx.scene.control.TextField password;
    public javafx.scene.control.TextField city;
    public javafx.scene.control.TextField BDay;


    public void Insert() throws InterruptedException {
        if (!(model.exist(u_name.getText()))) {
            model.Insert(u_name.getText(), password.getText(), BDay.getText(), f_name.getText(), l_name.getText(), city.getText());
            showAlert("you have sign in sucssesfully");
            //sleep(2000);
        } else
            showAlert("this user name is already exist, please choose another one");


    }

    private void showAlert(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();

    }
}