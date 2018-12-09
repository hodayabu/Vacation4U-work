package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class adverties extends Acontrol {

    public javafx.scene.control.Button btn_AddVavation;
    public javafx.scene.control.TextField f_DestanationContry;
    public javafx.scene.control.TextField f_DestanationCity;
    public javafx.scene.control.TextField f_Luggege;
    public javafx.scene.control.TextField f_Price;
    public javafx.scene.control.TextField f_NumOfTickets;
    public javafx.scene.control.TextField f_FligthCompany;
    public javafx.scene.control.DatePicker d_departure;
    public javafx.scene.control.DatePicker d_arrival;
    public javafx.scene.control.CheckBox c_returnTicket;
    public javafx.scene.control.ChoiceBox c_ticketType;
    public ObservableList<String> list= FXCollections.observableArrayList();

    public void Initiate(){
        list.add("Adult");
        list.add("Child");
        list.add("Baby");
        c_ticketType.setItems(list);
    }

    public void Add(){
       if(d_departure.getValue().equals("")||d_arrival.getValue().equals("")||f_DestanationCity.getText().equals("")||f_DestanationContry.getText().equals("")|| f_Luggege.getText().equals("")||f_Price.getText().equals("")||f_NumOfTickets.getText().equals("")||f_FligthCompany.getText().equals("")||c_ticketType.getValue().equals("")) {
           showAlert("please fill all the fileds");
       }
       else{
           boolean add=conection_layer.advertize( f_FligthCompany.getText(), d_departure.getValue().toString(),d_arrival.getValue().toString(),f_Luggege.getText(),f_NumOfTickets.getText(),f_DestanationContry.getText(),f_DestanationCity.getText(),c_returnTicket.isSelected(),c_ticketType.getValue().toString(),f_Price.getText());
            if(!add)
                showAlert("Before publish vacation, you need first to log in");
            else showAlert("Your vacation has published");
       }

    }





}
