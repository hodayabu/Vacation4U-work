package View;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read extends Acontroler{

    public javafx.scene.control.Button btn_search;
    public javafx.scene.control.TextField userName;

    public void read() throws InterruptedException {
        String user=model.read(userName.getText());
        System.out.println(user);
        if(user!=null) {
            showAlert(user);
        }

         else
            showAlert("this user name doesn't exist");

    }

}
