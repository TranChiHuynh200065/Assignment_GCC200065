package Assignment.Model;

import java.io.Serializable;

public class ComboBoxProductsColorModel implements Serializable {
    private String color;

    public ComboBoxProductsColorModel(String color) {
        this.color = color;
    }

    //Getter and Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
