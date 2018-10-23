package View;

import Model.Model;
import javafx.event.ActionEvent;

public class create extends Acontroler {
    public javafx.scene.control.Button btn_ImDone;
    public javafx.scene.control.TextField f_name;
    public javafx.scene.control.TextField l_name;
    public javafx.scene.control.TextField u_name;
    public javafx.scene.control.TextField password;
    public javafx.scene.control.TextField city;
    public javafx.scene.control.TextField BDay;


    public void Insert() {
        model.Insert(u_name.getText(), password.getText(), BDay.getText(), f_name.getText(), l_name.getText(), city.getText());
    }
}
