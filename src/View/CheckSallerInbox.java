package View;

import Model.Vacation;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CheckSallerInbox extends Acontrol {

    private TableView<Inbox> table = new TableView<Inbox>();
    public javafx.scene.control.Button btn_inbox;




    public void checkInbox() {
        Stage stage=new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Inbox");
        stage.setWidth(900);
        stage.setHeight(500);

        final Label label = new Label("Inbox");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn dest = new TableColumn("Destination City");
        TableColumn buyer = new TableColumn("Buyer Name");
        TableColumn deparDate = new TableColumn("Departure Date");
        TableColumn arriveDate = new TableColumn("Arrival Date");
        //TableColumn approve = new TableColumn("Approve");
        //TableColumn disapprove = new TableColumn("Not Approve");

        table.getColumns().addAll(dest, buyer, deparDate,arriveDate/**,approve,disapprove**/);

        ObservableList<Inbox> data= FXCollections.observableArrayList();
        HashMap<Vacation,String> ans=conection_layer.inboxSaller();
        for(Map.Entry<Vacation,String> entry : ans.entrySet())
            data.add(new Inbox(entry.getKey().getDestinationCity(),entry.getValue(),entry.getKey().getDateDepar(),entry.getKey().getDateArrive()/**,entry.getKey().getVacation_id()**/));

        dest.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Destination City"));
        buyer.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Buyer Name"));
        deparDate.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Departure Date"));
        arriveDate.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Arrival Date"));
        //approve.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Approve"));
        //disapprove.setCellValueFactory(new PropertyValueFactory<Inbox,String>("Not Approve"));

        table.setItems(data);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}