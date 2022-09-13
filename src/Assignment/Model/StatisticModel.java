package Assignment.Model;

import Assignment.Controller.DateStringController;
import Assignment.Controller.FileController;

import java.util.Date;

public class StatisticModel {

    private String customerName;
    private String phone;
    private String no;
    private String model;
    private String color;
    private String category;
    private String make;
    private String engineType;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Date tradeDate;

    //Constructor
    public StatisticModel(String customerName, String phone, String no, String model, String color, String category, String make, String engineType, Integer quantity, Double price, Double totalPrice, String tradeDate) {
        this.customerName = customerName;
        this.phone = phone;
        this.no = no;
        this.model = model;
        this.color = color;
        this.category = category;
        this.make = make;
        this.engineType = engineType;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.tradeDate = DateStringController.stringToDate(tradeDate);
    }

    //Getter and Setter

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
}
