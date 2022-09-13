package Assignment.Model;

import java.io.Serializable;

public class ComboBoxProductsEngineTypeModel implements Serializable {
    private String engineType;

    //Constructor
    public ComboBoxProductsEngineTypeModel(String engineType) {
        this.engineType = engineType;
    }

    //Getter and Setter
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
