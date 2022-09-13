package Assignment.Model;

import java.io.Serializable;

public class ComboBoxProductsMakeModel implements Serializable {
    private String make;

    //Constructor
    public ComboBoxProductsMakeModel(String make) {
        this.make = make;
    }

    //Getter and Setter
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
