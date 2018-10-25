package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Controller extends Acontroler {
    public javafx.scene.control.Button btn_create;

    public void create()
    {
        try{
            Stage stage=new Stage();
            stage.setTitle("Create new user");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("create.fxml").openStream());
            Scene scene = new Scene(root, 800, 500);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();


        } catch (Exception e) {

        }
        }


    public void read()
    {
        try{
            Stage stage=new Stage();
            stage.setTitle("search a user");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("read.fxml").openStream());
            Scene scene = new Scene(root, 800, 500);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();


        } catch (Exception e) {

        }
    }


    public void delete()
    {
        try{
            Stage stage=new Stage();
            stage.setTitle("delete a user");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("delete.fxml").openStream());
            Scene scene = new Scene(root, 800, 500);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();


        } catch (Exception e) {

        }
    }

    public void update()
    {
        try{
            Stage stage=new Stage();
            stage.setTitle("update a user");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("update.fxml").openStream());
            Scene scene = new Scene(root, 500, 800);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();


        } catch (Exception e) {

        }
    }


}

