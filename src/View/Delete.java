package View;

public class Delete extends Acontroler {

    public javafx.scene.control.Button btn_delete;
    public javafx.scene.control.TextField userName;

    public void delete() throws InterruptedException {
        if(model.exist(userName.getText())) {
            model.delete(userName.getText());
            showAlert("the user deleted succesfully");
        }

        else
            showAlert("this user name doesn't exist");
    }

}
