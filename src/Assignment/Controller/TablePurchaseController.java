package Assignment.Controller;

import Assignment.Model.PurchaseModel;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Assignment.Controller.ComboBoxProductsController.motorcycleShopManagementSystem;

public class TablePurchaseController {

    static List<PurchaseModel> tbPurchaseModelList;
    static DefaultTableModel tbPurchaseModel;
    static DefaultTableModel tbPurchaseSearching = (DefaultTableModel) motorcycleShopManagementSystem.tbPurchaseSearching.getModel();
    static String purchaseFile = "src/Assignment/Model/fPurchaseModel.dat";

    public static boolean checkBillInformation(){

        Matcher customerNameMatcher;
        customerNameMatcher = TableProductsController.getMatcher("(^[a-zA-Z]+\\s[a-zA-Z]+$)|(^[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+$)|(^[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+$)|(^[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+$)|(^[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+$)", motorcycleShopManagementSystem.txtPurchaseCustomerName.getText());
        Matcher phone =TableProductsController.getMatcher("^0[3-9]\\d{8}", motorcycleShopManagementSystem.txtPurchasePhone.getText());
        Matcher matcherPurchaseQuantity = TableProductsController.getMatcher("(^0|(^[1-9]\\d{0,3}$))", motorcycleShopManagementSystem.txtPurchaseQuantity.getText());


        if(motorcycleShopManagementSystem.txtPurchaseCustomerName.getText().equals("") ){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the customer name!",
                    "Customer Name Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchaseCustomerName.requestFocusInWindow();
            return false;

        }else if(!customerNameMatcher.matches()){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the middle name + first name or last name + first name or full name! Sample format: " +
                            "Van A, Tran A, Tran Van A, etc.",
                    "Customer Name Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchaseCustomerName.requestFocusInWindow();
            return false;
        }

        if(motorcycleShopManagementSystem.txtPurchasePhone.getText().equals("") ){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the number phone!",
                    "Number Phone Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchasePhone.requestFocusInWindow();
            return false;

        }else if(!phone.matches()){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a valid phone number! " +
                            "First numbers: 03, 04, 05, 06, 07, 08, and 09; and the phone number must have 10 digits. " +
                            "Sample format: 0912456789, 0363777700, ect.",
                    "Number Phone Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchasePhone.requestFocusInWindow();
            return false;
        }

        if(motorcycleShopManagementSystem.txtPurchaseNo.getText().equals("") ){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter \"No Product\" and click the Check button!",
                    "No Products Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            motorcycleShopManagementSystem.txtPurchaseNo.requestFocusInWindow();
            return false;
        }
        if(motorcycleShopManagementSystem.txtPurchaseModel.getText().equals("") ){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter \"No Product\" and click the Check button!",
                    "Check Button Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            motorcycleShopManagementSystem.txtPurchaseNo.requestFocusInWindow();
            return false;
        }

        if(motorcycleShopManagementSystem.txtPurchaseQuantity.getText().equals("") ) {
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the number of products that the customer wants to pay for!",
                    "No Products Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            motorcycleShopManagementSystem.txtPurchaseQuantity.requestFocusInWindow();
            return false;
        }else if(!matcherPurchaseQuantity.matches()){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The input value is incorrect. Please re-enter it. Sample format: 1, 2, 10, 100, 1000, etc.",
                    "Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchaseQuantity.requestFocusInWindow();
            return false;

        }else if(Integer.parseInt(motorcycleShopManagementSystem.txtPurchaseQuantity.getText()) > 10000) {

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter a value not exceeding 10,000!",
                    "Quantity Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchaseQuantity.requestFocusInWindow();
            return false;
        }
        return true;
    }
    public static void checkPurchaseModel() {
        tbPurchaseModelList = (List<PurchaseModel>) FileController.readObject(purchaseFile);
        if (tbPurchaseModelList == null || tbPurchaseModelList.size() == 0) {
            tbPurchaseModelList = new ArrayList<>();
            tbPurchaseModelList.add(new PurchaseModel("Tran Chi Huynh", "0844044045",
                    "TCH180120", "Exciter 150", "Blue",
                    52000000.0, 1, "2022-08-29"));
            FileController.writeObject(purchaseFile, tbPurchaseModelList);
        }
    }

    public static void clearPurchasePay(){
        motorcycleShopManagementSystem.txtPurchaseCustomerName.setText("");
        motorcycleShopManagementSystem.txtPurchaseCustomerName.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseCustomerName.requestFocusInWindow();
        motorcycleShopManagementSystem.txtPurchasePhone.setText("");
        motorcycleShopManagementSystem.txtPurchasePhone.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseNo.setText("");
        motorcycleShopManagementSystem.txtPurchaseNo.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseModel.setText("");
        motorcycleShopManagementSystem.txtPurchaseModel.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseColor.setText("");
        motorcycleShopManagementSystem.txtPurchaseColor.setEditable(true);
        motorcycleShopManagementSystem.txtPurchasePrice.setText("");
        motorcycleShopManagementSystem.txtPurchasePrice.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseStock.setText("");
        motorcycleShopManagementSystem.txtPurchaseStock.setEditable(true);
        motorcycleShopManagementSystem.txtPurchaseQuantity.setText("");
        motorcycleShopManagementSystem.txtPurchaseQuantity.setEditable(true);
        setPurchaseTime(motorcycleShopManagementSystem.JDatePickerPurchase);
        motorcycleShopManagementSystem.btnPurchasePay.setEnabled(true);
        motorcycleShopManagementSystem.btnPurchaseCheck.setEnabled(true);
    }

    public static void clearPurchaseSearchingInformation(){

        JTextField txtPurchaseSearchingModel = motorcycleShopManagementSystem.txtPurchaseSearchingModel;
        JTextField txtPurchaseSearchingColor = motorcycleShopManagementSystem.txtPurchaseSearchingColor;
        JTextField txtPurchaseSearchingCategory = motorcycleShopManagementSystem.txtPurchaseSearchingCategory;
        JTextField txtPurchaseSearchingMake = motorcycleShopManagementSystem.txtPurchaseSearchingMake;
        JTextField txtPurchaseNoCopy  = motorcycleShopManagementSystem.txtPurchaseNoCopy;
        JButton btnPurchasePaste =  motorcycleShopManagementSystem.btnPurchasePaste;

        txtPurchaseSearchingModel.setText("");
        txtPurchaseSearchingColor.setText("");
        txtPurchaseSearchingCategory.setText("");
        txtPurchaseSearchingMake.setText("");
        txtPurchaseNoCopy.setText("");
        btnPurchasePaste.setEnabled(false);

        tbPurchaseSearching.setRowCount(0);


    }
    public static void addPurchaseBill(){
        Pattern pattern = Pattern.compile("(^[a-z]|( [a-z]))");
        Matcher matcher = pattern.matcher(motorcycleShopManagementSystem.txtPurchaseCustomerName.getText());
        String newCustomerName = matcher.replaceAll(x->x.group().toUpperCase()).trim();
        try {
            tbPurchaseModelList = (List<PurchaseModel>) FileController.readObject(purchaseFile);
            PurchaseModel p = new PurchaseModel(
                    newCustomerName,
                    motorcycleShopManagementSystem.txtPurchasePhone.getText().trim(),
                    motorcycleShopManagementSystem.txtPurchaseNo.getText().trim(),
                    motorcycleShopManagementSystem.txtPurchaseModel.getText(),
                    motorcycleShopManagementSystem.txtPurchaseColor.getText(),
                    Double.parseDouble(motorcycleShopManagementSystem.txtPurchasePrice.getText()),
                    Integer.parseInt(motorcycleShopManagementSystem.txtPurchaseQuantity.getText().trim()),
                    DateStringController.dateToString((Date) motorcycleShopManagementSystem.JDatePickerPurchase.getModel().getValue()));
            tbPurchaseModelList.add(p);
            FileController.writeObject(purchaseFile, tbPurchaseModelList);

        }catch (Exception e) {

            System.err.println(e);
        }
    }
    public static void fillToPurchaseTable() {

        try {
            tbPurchaseModelList = (List<PurchaseModel>) FileController.readObject(purchaseFile);
            tbPurchaseModel = (DefaultTableModel) motorcycleShopManagementSystem.tbPurchasePaying.getModel();
            tbPurchaseModel.setRowCount(0);
            for (PurchaseModel p : tbPurchaseModelList) {
                Object[] row = new Object[]{
                        p.getCustomerName(), p.getPhone(), p.getNo(), p.getModel(),
                        p.getColor(), p.getPrice(), p.getQuantity(),
                        DateStringController.dateToString(p.getTradeDate())
                };
                tbPurchaseModel.addRow(row);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The list of invoices is empty. Please add a new invoice.",
                    "List of Invoices Information!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void addOneElementIntoTables(){

        tbPurchaseModelList = (List<PurchaseModel>) FileController.readObject(purchaseFile);
        tbPurchaseModel = (DefaultTableModel) motorcycleShopManagementSystem.tbPurchasePaying.getModel();
        PurchaseModel purchaseModel = tbPurchaseModelList.get(tbPurchaseModelList.size() - 1);
        tbPurchaseModel.setRowCount(0);
        Object[] row = new Object[]{
                purchaseModel.getCustomerName(), purchaseModel.getPhone(), purchaseModel.getNo(), purchaseModel.getModel(),
                purchaseModel.getColor(), purchaseModel.getPrice(), purchaseModel.getQuantity(),
                DateStringController.dateToString(purchaseModel.getTradeDate())
        };
        tbPurchaseModel.addRow(row);
    }


    public static boolean clickCheckingPurchaseButton(){

        String txtProductsNo = motorcycleShopManagementSystem.txtPurchaseNo.getText().trim();

        if(txtProductsNo.equals("")){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter \"No Product\" and click the Check button!",
                    "No Products Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            motorcycleShopManagementSystem.txtPurchaseNo.requestFocusInWindow();

            return false;
        }
        return TableProductsController.findAndFillPurchaseData();
    }

    public static void clickPayingPurchaseButton(){

        String txtProductsNo = motorcycleShopManagementSystem.txtPurchaseNo.getText().trim();

        if(checkBillInformation()){

            if(TableProductsController.checkAfterBeforeProductsNoInformation()){

                Integer paidQuantity = Integer.valueOf(motorcycleShopManagementSystem.txtPurchaseQuantity.getText());
                int indexProductsNo = TableProductsController.findIndexNoProducts(txtProductsNo);

                if(TableProductsController.updateProductsModelQuantity(indexProductsNo, paidQuantity)){
                    addPurchaseBill();
                    addOneElementIntoTables();
                    TableStatisticController.fillToStatisticTable();
                    TableProductsController.findAndFillPurchaseData();
                }
            }
        }
    }
    public static void setPurchaseTime(JDatePickerImpl jDatePicker){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted = current.format(formatter);
        Calendar c = Calendar.getInstance();
        c.setTime(DateStringController.stringToDate(formatted));
        jDatePicker.getJFormattedTextField().setValue(c);
    }

    static void showPurchaseProductsNo(int row) {

        try {
            String no = (String) motorcycleShopManagementSystem.tbPurchaseSearching.getValueAt(row, 0);
            motorcycleShopManagementSystem.txtPurchaseNoCopy.setText(no);

        } catch (Exception e) {
            //Do nothing
        }
    }

    public static void showDetailPurchaseTable(int row){

        try {
            String customerName = (String) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 0);
            motorcycleShopManagementSystem.txtPurchaseCustomerName.setText(customerName);
            motorcycleShopManagementSystem.txtPurchaseCustomerName.setEditable(false);
            String phone = (String) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 1);
            motorcycleShopManagementSystem.txtPurchasePhone.setText(phone);
            motorcycleShopManagementSystem.txtPurchasePhone.setEditable(false);
            String no = (String) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 2);
            motorcycleShopManagementSystem.txtPurchaseNo.setText(no);
            motorcycleShopManagementSystem.txtPurchaseNo.setEditable(false);
            String model = (String) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 3);
            motorcycleShopManagementSystem.txtPurchaseModel.setText(model);
            motorcycleShopManagementSystem.txtPurchaseModel.setEditable(false);
            String color = (String) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 4);
            motorcycleShopManagementSystem.txtPurchaseColor.setText(color);
            motorcycleShopManagementSystem.txtPurchaseColor.setEditable(false);
            Double price = (Double) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 5);
            motorcycleShopManagementSystem.txtPurchasePrice.setText(String.valueOf(price));
            motorcycleShopManagementSystem.txtPurchasePrice.setEditable(false);
            Integer quantity = (Integer) motorcycleShopManagementSystem.tbPurchasePaying.getValueAt(row, 6);
            motorcycleShopManagementSystem.txtPurchaseQuantity.setText(String.valueOf(quantity));
            motorcycleShopManagementSystem.txtPurchaseQuantity.setEditable(false);
            motorcycleShopManagementSystem.txtPurchaseStock.setText("");
            motorcycleShopManagementSystem.txtPurchaseStock.setEditable(false);
            motorcycleShopManagementSystem.btnPurchasePay.setEnabled(false);
            motorcycleShopManagementSystem.btnPurchaseCheck.setEnabled(false);
            String tradeDate = (String) motorcycleShopManagementSystem.tbProducts.getValueAt(row, 7);
            Calendar c = Calendar.getInstance();
            c.setTime(DateStringController.stringToDate(tradeDate));
            motorcycleShopManagementSystem.JDatePickerPurchase.getJFormattedTextField().setValue(c);
        }catch (Exception e){
            //Do nothing
            System.out.println(e);
        }
    }

    public static void chooseSearchingOptions(){

        JCheckBox chbPurchaseModel = motorcycleShopManagementSystem.chbPurchaseModel;
        JCheckBox chbPurchaseColor = motorcycleShopManagementSystem.chbPurchaseColor;
        JCheckBox chbPurchaseCategory = motorcycleShopManagementSystem.chbPurchaseCategory;
        JCheckBox chbPurchaseMake = motorcycleShopManagementSystem.chbPurchaseMake;
        JTextField txtPurchaseSearchingModel = motorcycleShopManagementSystem.txtPurchaseSearchingModel;
        JTextField txtPurchaseSearchingColor = motorcycleShopManagementSystem.txtPurchaseSearchingColor;
        JTextField txtPurchaseSearchingCategory = motorcycleShopManagementSystem.txtPurchaseSearchingCategory;
        JTextField txtPurchaseSearchingMake = motorcycleShopManagementSystem.txtPurchaseSearchingMake;

        if(!chbPurchaseModel.isSelected() && !chbPurchaseColor.isSelected() &
        !chbPurchaseCategory.isSelected() && !chbPurchaseMake.isSelected()){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please check the option you want to search!",
                    "CheckBox Information!",
                    JOptionPane.INFORMATION_MESSAGE);

        }else if(chbPurchaseModel.isSelected() && txtPurchaseSearchingModel.getText().equals("")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the product model you want to search for!",
                    "Model Searching Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            txtPurchaseSearchingModel.requestFocusInWindow();

        }else if(chbPurchaseColor.isSelected() && txtPurchaseSearchingColor.getText().equals("")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the product color you want to search for!",
                    "Color Searching Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            txtPurchaseSearchingColor.requestFocusInWindow();

        }else if(chbPurchaseCategory.isSelected() && txtPurchaseSearchingCategory.getText().equals("")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the product category you want to search for!",
                    "Category Searching Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            txtPurchaseSearchingCategory.requestFocusInWindow();

        }else if(chbPurchaseMake.isSelected() && txtPurchaseSearchingMake.getText().equals("")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please enter the product make you want to search for!",
                    "Make Searching Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            txtPurchaseSearchingMake.requestFocusInWindow();
        }
        if(chbPurchaseModel.isSelected() && !txtPurchaseSearchingModel.getText().equals("")){
                String model = txtPurchaseSearchingModel.getText().trim();
                TableProductsController.searchProductsModel(model);

            }else if(chbPurchaseColor.isSelected() && !txtPurchaseSearchingColor.getText().equals("")){

                String color = txtPurchaseSearchingColor.getText().trim();
                TableProductsController.searchProductsColor(color);

            }else if(chbPurchaseCategory.isSelected() && !txtPurchaseSearchingCategory.getText().equals("")){

                String category = txtPurchaseSearchingCategory.getText().trim();
                TableProductsController.searchProductsCategory(category);

            }else if(chbPurchaseMake.isSelected() && !txtPurchaseSearchingMake.getText().equals("")){

                String make = txtPurchaseSearchingMake.getText().trim();
                TableProductsController.searchProductsMake(make);
            }
        }

        public static Clipboard copyPurchaseProductsNo(){

            String textProductsNo = motorcycleShopManagementSystem.txtPurchaseNoCopy.getText();

            if(!textProductsNo.equals("")) {

                motorcycleShopManagementSystem.btnPurchasePaste.setEnabled(true);

                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(textProductsNo);
                clip.setContents(stringSelection, stringSelection);

                motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();

                return clip;
            }
        return null;
    }

    public static void pastePurchaseProductsNo(){

        if(copyPurchaseProductsNo() != null){

            Clipboard clipboard = copyPurchaseProductsNo();

            Transferable clipData = clipboard.getContents(motorcycleShopManagementSystem);

            String string;

            try{

                string = (String) (clipData.getTransferData(DataFlavor.stringFlavor));

            } catch (IOException e) {

                throw new RuntimeException(e);

            } catch (UnsupportedFlavorException e) {

                throw new RuntimeException(e);
            }

            motorcycleShopManagementSystem.txtPurchaseNo.setText(string);
            motorcycleShopManagementSystem.txtPurchaseNo.requestFocusInWindow();
        }
    }


    }
