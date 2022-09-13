package Assignment.Model;

import Assignment.Controller.DateStringController;

import java.io.Serializable;
import java.util.Date;

public class PurchaseModel implements Serializable {
    private String customerName;
    private String phone;
    private String no;
    private String model;
    private String color;
    private Double price;

    private Integer quantity;
    private Date tradeDate;

    public PurchaseModel(String customerName, String phone, String no, String model, String color, Double price, Integer quantity, String tradeDate) {
        this.customerName = customerName;
        this.phone = phone;
        this.no = no;
        this.model = model;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
