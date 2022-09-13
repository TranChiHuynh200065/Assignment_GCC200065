package Assignment.Controller;

import Assignment.Model.ComboBoxProductsColorModel;
import Assignment.Model.ProductsModel;
import Assignment.Model.PurchaseModel;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Assignment.Controller.ComboBoxProductsController.motorcycleShopManagementSystem;

public class TableProductsController {

    static ComboBoxProductsController comboBoxProductsController;
    static List<ProductsModel> tbProductsModelList;
    static DefaultComboBoxModel cbbStatisticModelModel;
    static DefaultTableModel tbProductModel = (DefaultTableModel) motorcycleShopManagementSystem.tbProducts.getModel();
    static DefaultTableModel tbPurchaseSearchingTablesModel = (DefaultTableModel) motorcycleShopManagementSystem.tbPurchaseSearching.getModel();
    static String file = "src/Assignment/Model/fProductModel.dat";
    private static int productsTableRow = -1;
    private static int indexProductsNoSaving = -2;

    public static void checkProductModel() {
        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        if (tbProductsModelList == null || tbProductsModelList.size() == 0) {
            tbProductsModelList = new ArrayList<>();
            tbProductsModelList.add(new ProductsModel("TCH180120", "Exciter 150", "Blue", "Underbone",
                    "Yamaha", "Single Cylinder", 150.0, 4.0, 138.0,
                    100, 52000000.0, "2022-08-27"));
            FileController.writeObject(file, tbProductsModelList);
        }
    }

    public static Matcher getMatcher(String regex, String text) {
        Matcher matcher;
        String regexObject = regex;
        Pattern pattern = Pattern.compile(regexObject);
        matcher = pattern.matcher(text);
        return matcher;

    }

    public static boolean checkProductsNo() {

        Matcher matcherProductsNo = getMatcher("^(TCH)\\d{6}$", motorcycleShopManagementSystem.txtProductsNo.getText().toUpperCase());
        if (motorcycleShopManagementSystem.txtProductsNo.getText().equals("")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the product No!",
                    "No Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();
            return false;

        } else if (!matcherProductsNo.matches()) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The data format of \"No.\" is invalid. Please enter the following format correctly: " +
                            "\"TCHxxxxxx\". Therein, xxxxxx is six digits from 0 to 9. " +
                            "Sample format: TCH000000, TCH111111, TCH012345, TCH567890, etc.",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
            motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();
            return false;

        } else {
            tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

            for (int i = 0; i < tbProductsModelList.size(); i++) {

                String checkNo = tbProductsModelList.get(i).getNo();

                if (motorcycleShopManagementSystem.txtProductsNo.getText().equals(checkNo)) {

                    JOptionPane.showMessageDialog(
                            motorcycleShopManagementSystem,
                            "\"No.\" is not allowed to be duplicated. Please change it to another one!",
                            "Warning!",
                            JOptionPane.WARNING_MESSAGE);

                    motorcycleShopManagementSystem.txtProductsNo.setEnabled(true);
                    motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();
                    return false;
                }
            }
        }
        checkProductsData();
        return true;
    }

    public static boolean checkProductsData() {

        Matcher matcherProductsModel = getMatcher("^[a-zA-z][a-zA-Z\\d-_\\s]*$", motorcycleShopManagementSystem.txtProductsModel.getText());
        Matcher matcherProductsDisplacement = getMatcher("^[1-9]\\d{1,3}[.]\\d+", motorcycleShopManagementSystem.txtProductsDisplacement.getText());
        Matcher matcherProductsFuelCapacity = getMatcher("^[1-9]\\d?[.]\\d+", motorcycleShopManagementSystem.txtProductsFuelCapacity.getText());
        Matcher matcherProductsDryWeight = getMatcher("^[1-9]\\d{1,2}[.]\\d+", motorcycleShopManagementSystem.txtProductsDryWeight.getText());
        Matcher matcherProductsQuantity = getMatcher("(^0|(^[1-9]\\d{0,3}$))", motorcycleShopManagementSystem.txtProductsQuantity.getText());
        Matcher matcherProductsPrice = getMatcher("((^0)|(^[1-9]\\d{3,11}[.]\\d*)|(^[1-9][.]\\d+E[1-9]{1,2}$)|(^[1-9][.]0E[1-9]{1,2}$))", motorcycleShopManagementSystem.txtProductsPrice.getText());

        //Check the model
        if (motorcycleShopManagementSystem.txtProductsModel.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the model!",
                    "Model Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsModel.requestFocusInWindow();
            return false;

        } else if (!matcherProductsModel.matches()) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the model starting with the letters! Sample format: " +
                            "Exciter 150, Z1000, BMW 1000 RR, etc.",
                    "Model Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsModel.requestFocusInWindow();
            return false;
        }

        //Check colors
        if (motorcycleShopManagementSystem.cbColor.getSelectedItem().equals("<Choose a color>")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose a color!",
                    "Color Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.cbColor.requestFocusInWindow();
            return false;
        }

        //Check categories
        if (motorcycleShopManagementSystem.cbCategory.getSelectedItem().equals("<Choose a category>")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose a category!",
                    "Category Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.cbCategory.requestFocusInWindow();
            return false;
        }

        //Check make
        if (motorcycleShopManagementSystem.cbMake.getSelectedItem().equals("<Choose a make>")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose a make!",
                    "Make Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.cbMake.requestFocusInWindow();
            return false;
        }
        //Check engine types
        if (motorcycleShopManagementSystem.cbEngineType.getSelectedItem().equals("<Choose a engine type>")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose a engine type!",
                    "Engine Type Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.cbEngineType.requestFocusInWindow();
            return false;
        }
        //Check the displacement
        if (motorcycleShopManagementSystem.txtProductsDisplacement.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the displacement!",
                    "Displacement Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDisplacement.requestFocusInWindow();
            return false;

        } else if (!matcherProductsDisplacement.matches()) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the appropriate value. " +
                            "Sample format: 50.0, 150.0, 250.25, 600.15, 1000.0, 1200.0, etc.",
                    "Displacement Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDisplacement.requestFocusInWindow();
            return false;

        } else if (Double.parseDouble(motorcycleShopManagementSystem.txtProductsDisplacement.getText()) > 1300.0 ||
                Double.parseDouble(motorcycleShopManagementSystem.txtProductsDisplacement.getText()) < 50.0) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a value that is between 50 and 1300!",
                    "Displacement Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDisplacement.requestFocusInWindow();
            return false;
        }
        //Check the fuel capacity
        if (motorcycleShopManagementSystem.txtProductsFuelCapacity.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the fuel capacity!",
                    "Fuel Capacity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsFuelCapacity.requestFocusInWindow();
            return false;

        } else if (!matcherProductsFuelCapacity.matches()) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The value entered is not in the correct format. Please re-enter it. " +
                            "Sample format: 2.0, 4.5, 12.9, 22.3, etc.",
                    "Fuel Capacity Information!!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsFuelCapacity.requestFocusInWindow();
            return false;

        } else if (Double.parseDouble(motorcycleShopManagementSystem.txtProductsFuelCapacity.getText()) > 30 ||
                Double.parseDouble(motorcycleShopManagementSystem.txtProductsFuelCapacity.getText()) < 2) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a value that is between 2 and 30!",
                    "Fuel Capacity Information!!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsFuelCapacity.requestFocusInWindow();
            return false;
        }
        //Check the dry weight
        if (motorcycleShopManagementSystem.txtProductsDryWeight.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the dry weight!",
                    "Dry Weight Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDryWeight.requestFocusInWindow();
            return false;

        } else if (!matcherProductsDryWeight.matches()) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The value entered is not in the correct format. Please re-enter it. " +
                            "Sample format: 50.0, 60.5, 120.5, 400.0, 500.0, etc.",
                    "Dry Weight Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDryWeight.requestFocusInWindow();
            return false;

        } else if (Double.parseDouble(motorcycleShopManagementSystem.txtProductsDryWeight.getText()) > 500 ||
                Double.parseDouble(motorcycleShopManagementSystem.txtProductsDryWeight.getText()) < 10) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a value that is between 10 and 500",
                    "Dry Weight Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsDryWeight.requestFocusInWindow();
            return false;
        }
        //Check quantities
        if (motorcycleShopManagementSystem.txtProductsQuantity.getText().equals("")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the quantity!",
                    "Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsQuantity.requestFocusInWindow();
            return false;

        } else if (!matcherProductsQuantity.matches()) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The input value is incorrect. Please re-enter it. Sample format: 1, 2, 10, 100, 1000, etc.",
                    "Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsQuantity.requestFocusInWindow();
            return false;

        } else if (Integer.parseInt(motorcycleShopManagementSystem.txtProductsQuantity.getText()) > 10000) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a value not exceeding 10,000!",
                    "Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsQuantity.requestFocusInWindow();
            return false;
        }
        //Check the price
        if (motorcycleShopManagementSystem.txtProductsPrice.getText().equals("")) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the price!",
                    "Price Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsPrice.requestFocusInWindow();
            return false;

        } else if (!matcherProductsPrice.matches()) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The value entered is not in the correct format. Please re-enter it. " +
                            "Sample format: 10000000.0, 25000000.0, 500000000.0, or 5.2E7, 9.8E7, etc",
                    "Price Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsPrice.requestFocusInWindow();
            return false;

        } else if (Double.parseDouble(motorcycleShopManagementSystem.txtProductsPrice.getText()) > 100000000000.0) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The input value is too large. Please review carefully! " +
                            "The input value does not exceed 100,000,000,000.",
                    "Price Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtProductsPrice.requestFocusInWindow();
            return false;
        }

        //Check date
        if (motorcycleShopManagementSystem.JDatePickerProducts.getJFormattedTextField().getValue() == null) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose a date!",
                    "Date Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.JDatePickerProducts.getJFormattedTextField().requestFocusInWindow();
            return false;
        }
        return true;
    }

    public static void clear() {

        productsTableRow = -1;
        motorcycleShopManagementSystem.txtProductsNo.setText("");
        motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();
        motorcycleShopManagementSystem.txtProductsModel.setText("");
        ComboBoxProductsController.fillCbbProductsColor();
        ComboBoxProductsController.fillCbbProductsCategory();
        ComboBoxProductsController.fillCbbProductsMake();
        ComboBoxProductsController.fillCbbProductsEngineType();
        motorcycleShopManagementSystem.txtProductsDisplacement.setText("");
        motorcycleShopManagementSystem.txtProductsFuelCapacity.setText("");
        motorcycleShopManagementSystem.txtProductsDryWeight.setText("");
        motorcycleShopManagementSystem.txtProductsQuantity.setText("");
        motorcycleShopManagementSystem.txtProductsPrice.setText("");
        TablePurchaseController.setPurchaseTime(motorcycleShopManagementSystem.JDatePickerProducts);
    }

    public static void addProductsModel() {
        Pattern pattern = Pattern.compile("(^[a-z]|( [a-z]))");
        Matcher matcher = pattern.matcher(motorcycleShopManagementSystem.txtProductsModel.getText());
        String newModel = matcher.replaceAll(x->x.group().toUpperCase()).trim();
        if (checkProductsNo()) {
            try {
                ProductsModel c = new ProductsModel(
                        motorcycleShopManagementSystem.txtProductsNo.getText().trim().toUpperCase(),
                        newModel,
                        (String) motorcycleShopManagementSystem.cbColor.getSelectedItem(),
                        (String) motorcycleShopManagementSystem.cbCategory.getSelectedItem(),
                        (String) motorcycleShopManagementSystem.cbMake.getSelectedItem(),
                        (String) motorcycleShopManagementSystem.cbEngineType.getSelectedItem(),
                        Double.parseDouble(motorcycleShopManagementSystem.txtProductsDisplacement.getText().trim()),
                        Double.parseDouble(motorcycleShopManagementSystem.txtProductsFuelCapacity.getText().trim()),
                        Double.parseDouble(motorcycleShopManagementSystem.txtProductsDryWeight.getText().trim()),
                        Integer.parseInt(motorcycleShopManagementSystem.txtProductsQuantity.getText().trim()),
                        Double.parseDouble(motorcycleShopManagementSystem.txtProductsPrice.getText().trim()),
                        DateStringController.dateToString((Date) motorcycleShopManagementSystem.JDatePickerProducts.getModel().getValue()));
                tbProductsModelList.add(c);
                FileController.writeObject(file, tbProductsModelList);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void fillToTable() {
        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        tbProductModel = (DefaultTableModel) motorcycleShopManagementSystem.tbProducts.getModel();
        tbProductModel.setRowCount(0);

        for (ProductsModel p : tbProductsModelList) {
            Object[] row = new Object[]{
                    p.getNo(), p.getModel(), p.getColor(), p.getCategory(), p.getMake(),
                    p.getEngineType(), p.getDisplacement(), p.getFuelCapacity(), p.getDryWeight(), p.getQuantity(),
                    p.getPrice(), DateStringController.dateToString(p.getDate())
            };
            tbProductModel.addRow(row);
        }
    }

    public static void fillToStatisticComboBoxModel() {

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        cbbStatisticModelModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticModel.getModel();

        if(cbbStatisticModelModel == null || cbbStatisticModelModel.getSize() == 0){
            cbbStatisticModelModel.addElement("<Choose a model>");
        }
        if(cbbStatisticModelModel.getElementAt(0).equals("<Choose a model>"))
        {
            boolean flag = true;

            for(int i = 0; i < tbProductsModelList.size(); i++){

                flag = true;

                String getModel = tbProductsModelList.get(i).getModel();

                for(int j = 0; j < cbbStatisticModelModel.getSize(); j++){

                    String elementComboBox = (String) cbbStatisticModelModel.getElementAt(j);

                    if(getModel.equals(elementComboBox))
                    {
                        flag = false;
                    }
                }

                if(flag){

                    cbbStatisticModelModel.addElement(getModel);
                }
            }
        }

    }
    //ComboBox Statistic Model
    public static void moveCbbStatisticModelFilling(){
        cbbStatisticModelModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticModel.getModel();
        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);

        String firstElements = (String) cbbStatisticModelModel.getElementAt(0);
        String selectedItem = (String) cbbStatisticModelModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a model>")){
            cbbStatisticModelModel.removeElement("<Choose a model>");
        }
        if(!firstElements.equals("<Choose a model>")) {

            cbbStatisticModelModel.removeAllElements();
            if(!selectedItem.equals(firstElements)){
                cbbStatisticModelModel.addElement(selectedItem);
                for (int i = 0; i < tbProductsModelList.size(); i++) {

                    if (!tbProductsModelList.get(i).getModel().equals(selectedItem)) {

                        boolean flag = true;

                        for(int j = 0; j < tbProductsModelList.size(); j++){

                            flag = true;

                            String getModel = tbProductsModelList.get(j).getModel();

                            for(int k = 0; k < cbbStatisticModelModel.getSize(); k++){

                                String elementComboBox = (String) cbbStatisticModelModel.getElementAt(k);

                                if(getModel.equals(elementComboBox))
                                {
                                    flag = false;
                                }
                            }

                            if(flag){

                                cbbStatisticModelModel.addElement(getModel);
                            }
                        }
                    }
                }
            }else {
                cbbStatisticModelModel.addElement(firstElements);

                for (int i = 0; i < tbProductsModelList.size(); i++) {

                    if (!tbProductsModelList.get(i).getModel().equals(firstElements)) {

                        boolean flag = true;

                        for(int j = 0; j < tbProductsModelList.size(); j++){

                            flag = true;

                            String getModel = tbProductsModelList.get(j).getModel();

                            for(int k = 0; k < cbbStatisticModelModel.getSize(); k++){

                                String elementComboBox = (String) cbbStatisticModelModel.getElementAt(k);

                                if(getModel.equals(elementComboBox))
                                {
                                    flag = false;
                                }
                            }

                            if(flag){

                                cbbStatisticModelModel.addElement(getModel);
                            }
                        }
                    }
                }
            }
            cbbStatisticModelModel.removeElement("<Choose a model>");
        }
    }


    public static void saveProductModel() {
        //Get all data from form -> add new a candidate-> add List
        addProductsModel();
        //Fill to the table
        fillToTable();
        //Save a file
        FileController.writeObject(file, tbProductsModelList);
    }

    public static void addCbbProductsElements(String color, JComboBox comboBox) {
        if (color != "") {
            DefaultComboBoxModel cbb = (DefaultComboBoxModel) comboBox.getModel();
            cbb.removeAllElements();
            cbb.addElement(color);
        }
    }

    static void showProductsDetail(int row) {
        productsTableRow = row;
        try {
            motorcycleShopManagementSystem.txtProductsNo.setEnabled(false);
            String no = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 0);
            motorcycleShopManagementSystem.txtProductsNo.setText(no);

            String model = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 1);
            motorcycleShopManagementSystem.txtProductsModel.setText(model);

            String color = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 2);
            addCbbProductsElements(color, motorcycleShopManagementSystem.cbColor);


            String category = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 3);
            addCbbProductsElements(category, motorcycleShopManagementSystem.cbCategory);

            String make = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 4);
            addCbbProductsElements(make, motorcycleShopManagementSystem.cbMake);

            String engineType = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 5);
            addCbbProductsElements(engineType, motorcycleShopManagementSystem.cbEngineType);

            Double displacement = (Double) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 6);
            motorcycleShopManagementSystem.txtProductsDisplacement.setText(String.valueOf(displacement));

            Double fuelCapacity = (Double) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 7);
            motorcycleShopManagementSystem.txtProductsFuelCapacity.setText(fuelCapacity.toString(fuelCapacity));

            Double dryWeight = (Double) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 8);
            motorcycleShopManagementSystem.txtProductsDryWeight.setText(String.valueOf(dryWeight));

            int quantity = (int) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 9);
            motorcycleShopManagementSystem.txtProductsQuantity.setText(String.valueOf(quantity));

            Double price = (Double) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 10);
            motorcycleShopManagementSystem.txtProductsPrice.setText(String.valueOf(price));

            String date = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(productsTableRow, 11);
            Calendar c = Calendar.getInstance();
            c.setTime(DateStringController.stringToDate(date));
            motorcycleShopManagementSystem.JDatePickerProducts.getJFormattedTextField().setValue(c);
        } catch (Exception e) {
            //Do nothing
        }
    }

    public static void updateProductsModelList() {
        if (productsTableRow == -1) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please click on the product information you need to update!",
                    "Products Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (checkProductsData()) {
            tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
            ProductsModel productsModel = tbProductsModelList.get(productsTableRow);
            productsModel.setModel(motorcycleShopManagementSystem.txtProductsModel.getText());
            productsModel.setColor((String) motorcycleShopManagementSystem.cbColor.getSelectedItem());
            productsModel.setCategory((String) motorcycleShopManagementSystem.cbCategory.getSelectedItem());
            productsModel.setMake((String) motorcycleShopManagementSystem.cbMake.getSelectedItem());
            productsModel.setEngineType((String) motorcycleShopManagementSystem.cbEngineType.getSelectedItem());
            productsModel.setDisplacement(Double.valueOf(motorcycleShopManagementSystem.txtProductsDisplacement.getText()));
            productsModel.setFuelCapacity(Double.valueOf(motorcycleShopManagementSystem.txtProductsFuelCapacity.getText()));
            productsModel.setDryWeight(Double.valueOf(motorcycleShopManagementSystem.txtProductsDryWeight.getText()));
            productsModel.setQuantity(Integer.valueOf(motorcycleShopManagementSystem.txtProductsQuantity.getText()));
            productsModel.setPrice(Double.valueOf(motorcycleShopManagementSystem.txtProductsPrice.getText()));
            productsModel.setDate((Date) motorcycleShopManagementSystem.JDatePickerProducts.getModel().getValue());

            FileController.writeObject(file, tbProductsModelList);
            fillToTable();
            motorcycleShopManagementSystem.tbProducts.setRowSelectionInterval(productsTableRow, productsTableRow);
        }
    }

    public static void deleteProductsModelList() {

        if (productsTableRow > -1) {
            int options = JOptionPane.showConfirmDialog(
                    motorcycleShopManagementSystem,
                    "Do you want to remove it?",
                    "Warning!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (options == JOptionPane.YES_OPTION) {
                tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
                tbProductsModelList.remove(productsTableRow);
                FileController.writeObject(file, tbProductsModelList);
                fillToTable();
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please click on the product information you need to delete!",
                    "Products Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    public static void deleteAllProductsModelList() {
        int options = JOptionPane.showConfirmDialog(
                motorcycleShopManagementSystem,
                "Are you sure you want to delete all product data? " +
                        "If you click \"Yes\", all data will be deleted and cannot be recovered!",
                "Warning!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (options == JOptionPane.YES_OPTION) {
            tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
            tbProductModel = (DefaultTableModel) motorcycleShopManagementSystem.tbProducts.getModel();
            tbProductModel.setRowCount(0);
            tbProductsModelList.removeAll(tbProductsModelList);
            FileController.writeObject(file, tbProductsModelList);
            clear();
        }
    }

    public static void closeProgram() {
        int options = JOptionPane.showConfirmDialog(
                motorcycleShopManagementSystem,
                "Do you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (options == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static boolean findAndFillPurchaseData() {
        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        String productSNo = motorcycleShopManagementSystem.txtPurchaseNo.getText();
        int indexProductsNo = findIndexNoProducts(productSNo);

        if (indexProductsNo == -1) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "\"No.\" does not exist. Please redefine the information!",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (indexProductsNo != -1) {

            motorcycleShopManagementSystem.txtPurchaseModel.setText(tbProductsModelList.get(indexProductsNo).getModel());
            motorcycleShopManagementSystem.txtPurchaseModel.setEditable(false);
            motorcycleShopManagementSystem.txtPurchaseColor.setText(tbProductsModelList.get(indexProductsNo).getColor());
            motorcycleShopManagementSystem.txtPurchaseColor.setEditable(false);
            motorcycleShopManagementSystem.txtPurchasePrice.setText(String.valueOf(tbProductsModelList.get(indexProductsNo).getPrice()));
            motorcycleShopManagementSystem.txtPurchasePrice.setEditable(false);
            motorcycleShopManagementSystem.txtPurchaseStock.setText(String.valueOf(tbProductsModelList.get(indexProductsNo).getQuantity()));
            motorcycleShopManagementSystem.txtPurchaseStock.setEditable(false);

            if(motorcycleShopManagementSystem.txtPurchaseCustomerName.getText().equals("")){

                motorcycleShopManagementSystem.txtPurchaseCustomerName.requestFocusInWindow();

            }else if(motorcycleShopManagementSystem.txtPurchasePhone.getText().equals("")){

                motorcycleShopManagementSystem.txtPurchasePhone.requestFocusInWindow();

            }else if(motorcycleShopManagementSystem.txtPurchaseQuantity.getText().equals("")){

                motorcycleShopManagementSystem.txtPurchaseQuantity.requestFocusInWindow();
            }

            indexProductsNoSaving = indexProductsNo;
            return true;
        }

        return false;


    }

    public static boolean checkAfterBeforeProductsNoInformation() {
        String productSNo = motorcycleShopManagementSystem.txtPurchaseNo.getText();
        int indexProductsNo = findIndexNoProducts(productSNo);
        if ((indexProductsNoSaving != indexProductsNo) && (indexProductsNoSaving != -2)) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Information of \"No.\" does not match the information entered before. " +
                            "Please confirm and re-enter, then click the \"Check\" button " +
                            "so that the information is filled in the most accurate way.",
                    "Warning!",
                    JOptionPane.WARNING_MESSAGE);
            motorcycleShopManagementSystem.txtPurchaseNo.requestFocusInWindow();
            return false;

        }
        return true;
    }

    public static int findIndexNoProducts(String productsNo) {
        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String checkNo = tbProductsModelList.get(i).getNo();

            if (productsNo.equals(checkNo)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean updateProductsModelQuantity(int productsNoIndex, Integer paidQuantity) {

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        ProductsModel productsModel = tbProductsModelList.get(productsNoIndex);
        Integer existingQuantity = productsModel.getQuantity();
        Integer updatedQuantity = existingQuantity - paidQuantity;

        if (updatedQuantity < 0) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The quantity of the product in stock is " + existingQuantity + ". " +
                            "This is not enough to meet the customer's request. " +
                            "Please update the quantity of this product in stock or " +
                            "change the quantity of the product you want to pay for.",
                    "Products Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            motorcycleShopManagementSystem.txtPurchaseQuantity.requestFocusInWindow();
            return false;
        } else if (updatedQuantity == 0) {
            int options = JOptionPane.showConfirmDialog(
                    motorcycleShopManagementSystem,
                    "The current number of products in stock is 0. Do you want to update the quantity again?",
                    "The Stock Information",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            productsModel.setQuantity(updatedQuantity);
            FileController.writeObject(file, tbProductsModelList);
            fillToTable();

            if (options == JOptionPane.YES_OPTION) {

                JPanel contentSide = motorcycleShopManagementSystem.contentSide;
                CardLayout cardLayout = (CardLayout) contentSide.getLayout();
                cardLayout.show(contentSide, "cardProducts");
                showProductsDetail(productsNoIndex);

                ModeController.setLblProductsColor();
                if(FlatDarkLaf.isLafDark()){

                    MouseListenerController.productsSwitch = true;
                    MouseListenerController.purchaseSwitch = false;

                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(60, 63, 65));

                }else{

                    MouseListenerController.productsSwitch = true;
                    MouseListenerController.purchaseSwitch = false;

                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(242, 242, 242));

                }
                motorcycleShopManagementSystem.txtProductsQuantity.requestFocusInWindow();
            }
            return true;

        } else {
            productsModel.setQuantity(updatedQuantity);
            FileController.writeObject(file, tbProductsModelList);
            fillToTable();

            return true;
        }
    }

    public static void searchProductsModel(String text) {

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);


        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        tbPurchaseSearchingTablesModel.setRowCount(0);

        boolean flag = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getModel();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {
                ProductsModel productsModel = tbProductsModelList.get(i);
                Object[] elements = new Object[]{
                        productsModel.getNo(), productsModel.getModel(), productsModel.getColor(),
                        productsModel.getCategory(), productsModel.getMake(),
                        productsModel.getEngineType(), productsModel.getDisplacement(),
                        productsModel.getFuelCapacity(), productsModel.getDryWeight(), productsModel.getQuantity(),
                        productsModel.getPrice()};

                tbPurchaseSearchingTablesModel.addRow(elements);

                flag = true;
            }
        }
        if(!flag){

            showProductsSearchingMessage();
            motorcycleShopManagementSystem.txtPurchaseSearchingModel.requestFocusInWindow();
        }
    }
    public static void searchProductsColor(String text) {

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        tbPurchaseSearchingTablesModel.setRowCount(0);

        boolean flag = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getColor();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {
                ProductsModel productsModel = tbProductsModelList.get(i);
                Object[] elements = new Object[]{
                        productsModel.getNo(), productsModel.getModel(), productsModel.getColor(),
                        productsModel.getCategory(), productsModel.getMake(),
                        productsModel.getEngineType(), productsModel.getDisplacement(),
                        productsModel.getFuelCapacity(), productsModel.getDryWeight(), productsModel.getQuantity(),
                        productsModel.getPrice()};

                tbPurchaseSearchingTablesModel.addRow(elements);

                flag = true;
            }
        }
        if(!flag){

            showProductsSearchingMessage();
            motorcycleShopManagementSystem.txtPurchaseSearchingColor.requestFocusInWindow();
        }
    }
    public static void searchProductsCategory(String text) {

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        tbPurchaseSearchingTablesModel.setRowCount(0);

        boolean flag = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getCategory();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {
                ProductsModel productsModel = tbProductsModelList.get(i);
                Object[] elements = new Object[]{
                        productsModel.getNo(), productsModel.getModel(), productsModel.getColor(),
                        productsModel.getCategory(), productsModel.getMake(),
                        productsModel.getEngineType(), productsModel.getDisplacement(),
                        productsModel.getFuelCapacity(), productsModel.getDryWeight(), productsModel.getQuantity(),
                        productsModel.getPrice()};

                tbPurchaseSearchingTablesModel.addRow(elements);

                flag = true;
            }
        }
        if(!flag){

            showProductsSearchingMessage();
            motorcycleShopManagementSystem.txtPurchaseSearchingCategory.requestFocusInWindow();
        }
    }
    public static void searchProductsMake(String text) {

        String regex = ".*" + text + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
        tbPurchaseSearchingTablesModel.setRowCount(0);

        boolean flag = false;

        for (int i = 0; i < tbProductsModelList.size(); i++) {

            String elementsName = tbProductsModelList.get(i).getMake();

            Matcher matcher = pattern.matcher(elementsName);

            if (matcher.matches()) {
                ProductsModel productsModel = tbProductsModelList.get(i);
                Object[] elements = new Object[]{
                        productsModel.getNo(), productsModel.getModel(), productsModel.getColor(),
                        productsModel.getCategory(), productsModel.getMake(),
                        productsModel.getEngineType(), productsModel.getDisplacement(),
                        productsModel.getFuelCapacity(), productsModel.getDryWeight(), productsModel.getQuantity(),
                        productsModel.getPrice()};

                tbPurchaseSearchingTablesModel.addRow(elements);

                flag = true;
            }
        }
        if(!flag){

            showProductsSearchingMessage();
            motorcycleShopManagementSystem.txtPurchaseSearchingMake.requestFocusInWindow();
        }

    }
    public static void showProductsSearchingMessage(){
        JOptionPane.showMessageDialog(
                motorcycleShopManagementSystem,
                "Not found the product. " +
                        "Please confirm your search information or search for a new product!",
                "Searching Information!",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
