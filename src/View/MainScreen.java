package View;

import Model.Vacation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainScreen extends Acontrol {

    public javafx.scene.control.Button btn_LogIn;
    public javafx.scene.control.Button btn_Create;
    public javafx.scene.control.Button btn_sellaerInbox;
    public javafx.scene.control.Button btn_BuyerInbox;
    public javafx.scene.control.Button btn_AdvertiseVacation;
    public javafx.scene.control.Button btn_DeleteVacation;
    public javafx.scene.control.Button btn_SearchVacation;
    public javafx.scene.control.TextField f_country;
    //public ListView inboxSellar;

    public MainScreen(){}

    public void initializ(){
        btn_BuyerInbox.setDisable(true);
        btn_sellaerInbox.setDisable(true);
    }


    public void search(){
        String country=f_country.getText();
        if(country.equals(""))
            showAlert("Please choose destination country");
        else{
            ArrayList<Vacation> res=conection_layer.search(country);

        }
    }


    public void CheckSallerInbox(){
        Stage stage=new Stage();
        stage.setTitle("Sellar Inbox");
        FXMLLoader fxmlLoader=new FXMLLoader();
        try {
            Parent root=fxmlLoader.load(getClass().getResource("CheckSallerInbox.fxml").openStream());
            Scene scene=new Scene(root,400,320);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            //CheckBuyerInbox checkBuyerInbox=fxmlLoader.getController();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CheckBuyerInbox(){
        Stage stage=new Stage();
        stage.setTitle("Buyer Inbox");
        FXMLLoader fxmlLoader=new FXMLLoader();
        try {
            Parent root=fxmlLoader.load(getClass().getResource("CheckBuyerInbox.fxml").openStream());
            Scene scene=new Scene(root,400,320);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            //CheckBuyerInbox checkBuyerInbox=fxmlLoader.getController();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void LogInOrOut(){

        if(btn_LogIn.getText().equals("Log In")){
            Stage stage=new Stage();
            stage.setTitle("LogIn");
            FXMLLoader fxmlLoader=new FXMLLoader();
            try {
                Parent root=fxmlLoader.load(getClass().getResource("LogIn.fxml").openStream());
                Scene scene=new Scene(root,300,300);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                logIn logIn=fxmlLoader.getController();
                logIn.setStage(stage);
                logIn.setMainScreen(this);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(btn_LogIn.getText().equals("Log Out")){
            conection_layer.LogOut();
            btn_LogIn.setText("Log In");
        }
    }

    public void create()
    {
        try{
            Stage stage=new Stage();
            stage.setTitle("Create new user");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("create.fxml").openStream());
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            stage.show();


        } catch (Exception e) {

        }
    }


    public void advertise(){
        Stage stage=new Stage();
        stage.setTitle("Advertise Vacation");
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(getClass().getResource("adverties.fxml").openStream());
        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            adverties add=fxmlLoader.getController();
            add.Initiate();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
