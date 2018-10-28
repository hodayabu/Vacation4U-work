package Controller;

import Model.Model;
import View.View;

public class Controller {

    public Model model;
    public View view;

    public void setModel(Model model){this.model=model;}


    public void Insert(String user, String pass, String birth, String first, String last, String city){
        model.Insert(user,pass,birth,first,last,city);
    }

    public boolean exist(String userr) {
       return model.exist(userr);
    }

    public String read(String userr) throws InterruptedException {
        return model.read(userr);
    }

    public void delete(String userr) {
        model.delete(userr);
    }


    public void update(String currentuser, String newuser ,String pass, String birth, String first, String last, String city) {
    model.update(currentuser,newuser,pass,birth,first,last,city);
    }

    }
