package View;

import Model.Model;
public  abstract class Acontroler {
   protected static Model model;

    public void setModel(Model model) {
        this.model = model;
    }
}
