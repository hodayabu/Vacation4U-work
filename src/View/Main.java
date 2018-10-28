package View;

import Controller.Controller;
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
        Controller controller=new Controller();
        controller.setModel(model);
        FXMLLoader fxm=new FXMLLoader();
        Parent root = fxm.load(getClass().getResource("View.fxml").openStream());
        primaryStage.setTitle("Vacation 4 U");
        primaryStage.setScene(new Scene(root, 800, 600));
        View Main_control=fxm.getController();
        Main_control.setController(controller);


        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
