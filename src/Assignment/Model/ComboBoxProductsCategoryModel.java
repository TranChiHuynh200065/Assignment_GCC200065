package Assignment.Model;

import java.io.Serializable;

public class ComboBoxProductsCategoryModel implements Serializable {
    private String category;

    //Constructor
    public ComboBoxProductsCategoryModel(String category) {
        this.category = category;
    }

    //Getter and Setter
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
