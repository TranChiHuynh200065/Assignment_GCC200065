package Assignment.Model;

import Assignment.Controller.DateStringController;

import java.io.Serializable;
import java.util.Date;

public class ProductsModel implements Serializable {
    private String no;
    private String model;
    private String color;
    private String category;
    private String make;
    private String engineType;
    private Double displacement;
    private Double fuelCapacity;
    private Double dryWeight;
    private Integer quantity;
    private Double price;
    private Date date;

    public ProductsModel(String no, String model, String color, String category, String make, String engineType, Double displacement, Double fuelCapacity, Double dryWeight, Integer quantity, Double price, String date) {
        this.no = no;
        this.model = model;
        this.color = color;
        this.category = category;
        this.make = make;
        this.engineType = engineType;
        this.displacement = displacement;
        this.fuelCapacity = fuelCapacity;
        this.dryWeight = dryWeight;
        this.quantity = quantity;
        this.price = price;
        this.date = DateStringController.stringToDate(date);
    }

    //Getter and Setter

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Double getDryWeight() {
        return dryWeight;
    }

    public void setDryWeight(Double dryWeight) {
        this.dryWeight = dryWeight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
