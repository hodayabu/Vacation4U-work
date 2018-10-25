package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.Model;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Model model=new Model();
        FXMLLoader fxm=new FXMLLoader();
        Parent root = fxm.load(getClass().getResource("View.fxml").openStream());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 900));
        Controller controler=fxm.getController();
        controler.setModel(model);


        primaryStage.show();


    }

/////////////////////////////////////////////////////////////////////////////////////////////
    //hodaya
    public static void main(String[] args) {
        launch(args);
    }
}
