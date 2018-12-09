package View;

import javafx.beans.property.SimpleStringProperty;

import java.awt.*;

public class Inbox {
    public final SimpleStringProperty dest;
    public final SimpleStringProperty buyer;
    public final SimpleStringProperty depar;



    public final SimpleStringProperty arrive;
    //public Button approve;
    //public Button notApprove;
    //public int Vacation_Id;



    public String getDest() {
        return dest.get();
    }


    public void setDest(String dest) {
        this.dest.set(dest);
    }

    public String getBuyer() {
        return buyer.get();
    }

    public void setBuyer(String buyer) {
        this.buyer.set(buyer);
    }

    public String getDepar() {
        return depar.get();
    }


    public void setDepar(String depar) {
        this.depar.set(depar);
    }

    public String getArrive() {
        return arrive.get();
    }


    public void setArrive(String arrive) {
        this.arrive.set(arrive);
    }

//    public Button getApprove() {
//        return approve;
//    }
//
//    public void setApprove(Button approve) {
//        this.approve = approve;
//    }
//
//    public Button getNotApprove() {
//        return notApprove;
//    }
//
//    public void setNotApprove(Button notApprove) {
//        this.notApprove = notApprove;
//    }

    public Inbox(String dest,String buyer,String depar,String arrive/**,int Vacation_id**/){
        this.dest=new SimpleStringProperty(dest);
        this.buyer=new SimpleStringProperty(buyer);
        this.depar=new SimpleStringProperty(depar);
        this.arrive=new SimpleStringProperty(arrive);
        //this.approve=new Button("Approve");
        //this.notApprove=new Button("Disapprove");
        //this.Vacation_Id=Vacation_id;
    }



}
