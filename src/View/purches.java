package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class purches extends Acontrol {

    public String vacationId;
    public javafx.scene.control.Button btn_done;
    public javafx.scene.control.TextField cvd;
    public javafx.scene.control.TextField cardnumber;
    public javafx.scene.control.TextField experation;
    public javafx.scene.control.ChoiceBox cardType;
    public ObservableList<String> list= FXCollections.observableArrayList();



    public void Init(String vacationId){
        this.vacationId=vacationId;
        list.add("masterCard");
        list.add("visa");
        list.add("american express");
        cardType.setItems(list);
    }

    public void done(){
        String cvd=this.cvd.getText();
        String experation=this.experation.getText();
        String cardnumber=this.cardnumber.getText();
        String cardType=this.cardType.getTypeSelector();
        if(cvd.equals("") || experation.equals("") || cardnumber.equals("") || cardType.equals(""))
            showAlert("please fill all the fields");
        else {
            conection_layer.buy_vacation(Integer.valueOf(vacationId), cardnumber, cvd, experation, cardType);
            showAlert("Dear user,\nWe have got your purchase request.\nPlease check soon for final approval in your buyerInbox");
        }
    }

}
