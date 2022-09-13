package Assignment.Controller;
import Assignment.Model.ProductsModel;
import Assignment.Model.PurchaseModel;
import Assignment.Model.StatisticModel;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Assignment.Controller.ComboBoxProductsController.motorcycleShopManagementSystem;
import static Assignment.Controller.TablePurchaseController.*;
import static Assignment.Controller.TableProductsController.*;

public class TableStatisticController {

   public static List<StatisticModel> tbDescendingStatisticQuantitiesModel = new ArrayList<>();
    public static DefaultTableModel tbStatisticModel =(DefaultTableModel) motorcycleShopManagementSystem.tbStatistic.getModel();

    public static void fillToStatisticTable(){

         tbPurchaseModelList = (List<PurchaseModel>) FileController.readObject(purchaseFile);
         tbProductsModelList = (List<ProductsModel>) FileController.readObject(file);
         tbStatisticModel.setRowCount(0);
         tbDescendingStatisticQuantitiesModel.removeAll(tbDescendingStatisticQuantitiesModel);
         for(int i = 0; i < tbPurchaseModelList.size(); i++){

             String purchaseNo = tbPurchaseModelList.get(i).getNo();

             for(int j = 0; j < tbProductsModelList.size(); j++){

                 String productsNo = tbProductsModelList.get(j).getNo();

                 if(purchaseNo.equals(productsNo)){

                     Double totalPrice = tbPurchaseModelList.get(i).getQuantity() * tbPurchaseModelList.get(i).getPrice();

                     StatisticModel combinedElements = new StatisticModel(

                             tbPurchaseModelList.get(i).getCustomerName(),
                             tbPurchaseModelList.get(i).getPhone(),
                             tbPurchaseModelList.get(i).getNo(),
                             tbPurchaseModelList.get(i).getModel(),
                             tbPurchaseModelList.get(i).getColor(),
                             tbProductsModelList.get(j).getCategory(),
                             tbProductsModelList.get(j).getMake(),
                             tbProductsModelList.get(j).getEngineType(),
                             tbPurchaseModelList.get(i).getQuantity(),
                             tbPurchaseModelList.get(i).getPrice(),
                             totalPrice,
                             DateStringController.dateToString(tbPurchaseModelList.get(i).getTradeDate()));

                     tbDescendingStatisticQuantitiesModel.add((combinedElements));

                     break;
                 }

             }

         }
        if(tbDescendingStatisticQuantitiesModel != null || tbDescendingStatisticQuantitiesModel.size() > 0){

            for(int i = 0; i < tbDescendingStatisticQuantitiesModel.size(); i++){

                for(int j = i +1; j < tbDescendingStatisticQuantitiesModel.size(); j++ ){

                    StatisticModel tempList;

                    Integer jQuantity = tbDescendingStatisticQuantitiesModel.get(j).getQuantity();
                    Integer iQuantity = tbDescendingStatisticQuantitiesModel.get(i).getQuantity();

                    Double iTotalPrice = tbDescendingStatisticQuantitiesModel.get(i).getTotalPrice();
                    Double jTotalPrice = tbDescendingStatisticQuantitiesModel.get(j).getTotalPrice();

                    if(iQuantity < jQuantity){

                        tempList = tbDescendingStatisticQuantitiesModel.get(i);
                        tbDescendingStatisticQuantitiesModel.set(i, tbDescendingStatisticQuantitiesModel.get(j));
                        tbDescendingStatisticQuantitiesModel.set(j, tempList);

                    }else if (iQuantity.equals(jQuantity)) {

                        if(iTotalPrice < jTotalPrice) {

                            tempList = tbDescendingStatisticQuantitiesModel.get(i);
                            tbDescendingStatisticQuantitiesModel.set(i, tbDescendingStatisticQuantitiesModel.get(j));
                            tbDescendingStatisticQuantitiesModel.set(j, tempList);
                        }
                    }
                }
            }
            // Total store revenues
            Double revenues = 0.0;

            //Total store fees
            Double fees = 0.0;

            //Total store income
            Double income = 0.0;

            for(StatisticModel s : tbDescendingStatisticQuantitiesModel) {

                Object[] row = new Object[]{
                        s.getCustomerName(),
                        s.getPhone(),
                        s.getNo(),
                        s.getModel(),
                        s.getColor(),
                        s.getCategory(),
                        s.getMake(),
                        s.getEngineType(),
                        changeNumberFormat(s.getPrice()),
                        s.getQuantity(),
                        changeNumberFormat(s.getTotalPrice()),
                        DateStringController.dateToString(s.getTradeDate())};

                // Revenues = 100%
                revenues += s.getTotalPrice();

                tbStatisticModel.addRow(row);
            }

            /*
            Total fees equals total revenue multiplied by 0.3.
            Total fees = 30% of revenues
            */
            fees = revenues * 0.3;

            /*
            Total income equals total revenue multiplied by 0.7.
            Total income = 70% of revenues
            */
            income = revenues * 0.7;


            motorcycleShopManagementSystem.txtStatisticRevenues.setText(changeNumberFormat(revenues) + " VND");
            motorcycleShopManagementSystem.txtStatisticFees.setText(changeNumberFormat(fees) + " VND");
            motorcycleShopManagementSystem.txtStatisticIncome.setText(changeNumberFormat(income) + " VND");


        }
    }

    public static String changeNumberFormat(Double numbers){

        NumberFormat currentLocale = NumberFormat.getInstance();
        String changedNumbers = currentLocale.format(numbers);

        return changedNumbers;
    }

    public static boolean checkCheckedCheckBox(){

        JCheckBox chbStatisticModel = motorcycleShopManagementSystem.chbStatisticModel;
        JCheckBox chbStatisticEngineType = motorcycleShopManagementSystem.chbStatisticEngineType;
        JCheckBox chbStatisticTradeDate = motorcycleShopManagementSystem.chbStatisticTradeDate;
        JCheckBox chbStatisticMake = motorcycleShopManagementSystem.chbStatisticMake;
        JCheckBox chbStatisticColor = motorcycleShopManagementSystem.chbStatisticColor;
        JCheckBox chbStatisticCategory = motorcycleShopManagementSystem.chbStatisticCategory;

        JComboBox cbbStatisticModel = motorcycleShopManagementSystem.cbbStatisticModel;
        JComboBox cbbStatisticEngineType = motorcycleShopManagementSystem.cbbStatisticEngineType;
        JComboBox cbbStatisticMake = motorcycleShopManagementSystem.cbbStatisticMake;
        JComboBox cbbStatisticColor = motorcycleShopManagementSystem.cbbStatisticColor;
        JComboBox cbbStatisticCategory = motorcycleShopManagementSystem.cbbStatisticCategory;
        JDatePickerImpl jDatePickerStatistic = motorcycleShopManagementSystem.JDatePickerStatistic;


        if(!chbStatisticModel.isSelected() && !chbStatisticEngineType.isSelected() &&
        !chbStatisticTradeDate.isSelected() && !chbStatisticMake.isSelected() &&
        !chbStatisticColor.isSelected() && !chbStatisticCategory.isSelected()){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please check the option you want to collect!",
                    "CheckBox Information!",
                    JOptionPane.INFORMATION_MESSAGE);

            return false;

        }else if(chbStatisticModel.isSelected() && cbbStatisticModel.getSelectedItem().equals("<Choose a model>")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the model you want to collect!",
                    "Model Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            cbbStatisticModel.requestFocusInWindow();

            return false;

        }else if(chbStatisticEngineType.isSelected() && cbbStatisticEngineType.getSelectedItem().equals("<Choose a engine type>")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the engine type you want to collect!",
                    "Engine Type Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            cbbStatisticEngineType.requestFocusInWindow();

            return false;

        }else if(chbStatisticTradeDate.isSelected() && (jDatePickerStatistic.getJFormattedTextField().getValue() == null)){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the date you want to collect!",
                    "Date Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            jDatePickerStatistic.getJFormattedTextField().requestFocusInWindow();

        }else if(chbStatisticMake.isSelected() && cbbStatisticMake.getSelectedItem().equals("<Choose a make>")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the make you want to collect!",
                    "Make Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            cbbStatisticMake.requestFocusInWindow();

            return false;

        }else if(chbStatisticColor.isSelected() && cbbStatisticColor.getSelectedItem().equals("<Choose a color>")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the color you want to collect!",
                    "Color Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            cbbStatisticColor.requestFocusInWindow();

            return false;

        }else if(chbStatisticCategory.isSelected() && cbbStatisticCategory.getSelectedItem().equals("<Choose a category>")){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "Please choose the category you want to collect!",
                    "Category Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            cbbStatisticCategory.requestFocusInWindow();

            return false;

        }

        return true;
    }

    public static void clickCollectStatisticModel(){

        JCheckBox chbStatisticModel = motorcycleShopManagementSystem.chbStatisticModel;
        JCheckBox chbStatisticEngineType = motorcycleShopManagementSystem.chbStatisticEngineType;
        JCheckBox chbStatisticTradeDate = motorcycleShopManagementSystem.chbStatisticTradeDate;
        JCheckBox chbStatisticMake = motorcycleShopManagementSystem.chbStatisticMake;
        JCheckBox chbStatisticColor = motorcycleShopManagementSystem.chbStatisticColor;
        JCheckBox chbStatisticCategory = motorcycleShopManagementSystem.chbStatisticCategory;

        JComboBox cbbStatisticModel = motorcycleShopManagementSystem.cbbStatisticModel;
        JComboBox cbbStatisticEngineType = motorcycleShopManagementSystem.cbbStatisticEngineType;
        JComboBox cbbStatisticMake = motorcycleShopManagementSystem.cbbStatisticMake;
        JComboBox cbbStatisticColor = motorcycleShopManagementSystem.cbbStatisticColor;
        JComboBox cbbStatisticCategory = motorcycleShopManagementSystem.cbbStatisticCategory;
        JDatePickerImpl jDatePickerStatistic = motorcycleShopManagementSystem.JDatePickerStatistic;

        if(checkCheckedCheckBox()){

            tbStatisticModel.setRowCount(0);
            if(chbStatisticModel.isSelected() && !cbbStatisticModel.getSelectedItem().equals("<Choose a model>")){

                collectStatisticInformation(cbbStatisticModel, "getModel()");

            }else if(chbStatisticEngineType.isSelected() && !cbbStatisticEngineType.getSelectedItem().equals("<Choose a engine type>")){

                collectStatisticInformation(cbbStatisticEngineType, "getEngineType()");

            }else if(chbStatisticMake.isSelected() && !cbbStatisticMake.getSelectedItem().equals("<Choose a make>")){

                collectStatisticInformation(cbbStatisticMake, "getMake()");

            }else if(chbStatisticColor.isSelected() && !cbbStatisticColor.getSelectedItem().equals("<Choose a color>")){

                collectStatisticInformation(cbbStatisticColor, "getColor()");

            }else if(chbStatisticCategory.isSelected() && !cbbStatisticCategory.getSelectedItem().equals("<Choose a category>")){

                collectStatisticInformation(cbbStatisticCategory, "getCategory()");

            }else if(chbStatisticTradeDate.isSelected() && (jDatePickerStatistic.getJFormattedTextField() != null)){

                collectStatisticDateInformation();

            }

        }
    }

    public static void collectStatisticDateInformation() {

        JDatePickerImpl jDatePickerStatistic = motorcycleShopManagementSystem.JDatePickerStatistic;

        boolean flag = false;

        String selectedOptions = DateStringController.dateToString((Date) jDatePickerStatistic.getModel().getValue());

        // Total store revenues
        Double revenues = 0.0;

        //Total store fees
        Double fees = 0.0;

        //Total store income
        Double income = 0.0;

        for (int i = 0; i < tbDescendingStatisticQuantitiesModel.size(); i++) {

            String matcherOptions = DateStringController.dateToString(tbDescendingStatisticQuantitiesModel.get(i).getTradeDate());

            if(selectedOptions.equals(matcherOptions)){

                StatisticModel statisticModel = tbDescendingStatisticQuantitiesModel.get(i);
                Object[] matchedObjects = new Object[]{

                        statisticModel.getCustomerName(),
                        statisticModel.getPhone(),
                        statisticModel.getNo(),
                        statisticModel.getModel(),
                        statisticModel.getColor(),
                        statisticModel.getCategory(),
                        statisticModel.getMake(),
                        statisticModel.getEngineType(),
                        changeNumberFormat(statisticModel.getPrice()),
                        statisticModel.getQuantity(),
                        changeNumberFormat(statisticModel.getTotalPrice()),
                        DateStringController.dateToString(statisticModel.getTradeDate())};

                revenues += statisticModel.getTotalPrice();

                tbStatisticModel.addRow(matchedObjects);

                flag = true;
            };
        }
        /*
            Total fees equals total revenue multiplied by 0.3.
            Total fees = 30% of revenues
            */
        fees = revenues * 0.3;

            /*
            Total income equals total revenue multiplied by 0.7.
            Total income = 70% of revenues
            */
        income = revenues * 0.7;


        motorcycleShopManagementSystem.txtStatisticRevenues.setText(changeNumberFormat(revenues) + " VND");
        motorcycleShopManagementSystem.txtStatisticFees.setText(changeNumberFormat(fees) + " VND");
        motorcycleShopManagementSystem.txtStatisticIncome.setText(changeNumberFormat(income) + " VND");

        if (flag == false){

            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "No products were sold that day!",
                    "Collection Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            jDatePickerStatistic.getJFormattedTextField().requestFocusInWindow();
        }

    }
    public static void collectStatisticInformation(JComboBox comboBox, String getNames){
        boolean flag = false;
        String selectedOptions = (String) comboBox.getSelectedItem();

        // Total store revenues
        Double revenues = 0.0;

        //Total store fees
        Double fees = 0.0;

        //Total store income
        Double income = 0.0;

        for(int i = 0; i < tbDescendingStatisticQuantitiesModel.size(); i++){

            String matcherOptions = "";
            if(getNames.equals("getModel()")){
                matcherOptions = tbDescendingStatisticQuantitiesModel.get(i).getModel();
            }else if(getNames.equals("getEngineType()")){
                matcherOptions = tbDescendingStatisticQuantitiesModel.get(i).getEngineType();
            }else if(getNames.equals("getMake()")){
                matcherOptions = tbDescendingStatisticQuantitiesModel.get(i).getMake();
            }else if(getNames.equals("getColor()")){
                matcherOptions = tbDescendingStatisticQuantitiesModel.get(i).getColor();
            }else if(getNames.equals("getCategory()")){
                matcherOptions = tbDescendingStatisticQuantitiesModel.get(i).getCategory();
            }


            if(selectedOptions.equals(matcherOptions)){

                StatisticModel statisticModel = tbDescendingStatisticQuantitiesModel.get(i);
                Object[] matchedObjects = new Object[]{

                        statisticModel.getCustomerName(),
                        statisticModel.getPhone(),
                        statisticModel.getNo(),
                        statisticModel.getModel(),
                        statisticModel.getColor(),
                        statisticModel.getCategory(),
                        statisticModel.getMake(),
                        statisticModel.getEngineType(),
                        changeNumberFormat(statisticModel.getPrice()),
                        statisticModel.getQuantity(),
                        changeNumberFormat(statisticModel.getTotalPrice()),
                        DateStringController.dateToString(statisticModel.getTradeDate())};

                revenues += statisticModel.getTotalPrice();

                tbStatisticModel.addRow(matchedObjects);

                flag = true;
            };
        }

        /*
            Total fees equals total revenue multiplied by 0.3.
            Total fees = 30% of revenues
            */
        fees = revenues * 0.3;

            /*
            Total income equals total revenue multiplied by 0.7.
            Total income = 70% of revenues
            */
        income = revenues * 0.7;


        motorcycleShopManagementSystem.txtStatisticRevenues.setText(changeNumberFormat(revenues) + " VND");
        motorcycleShopManagementSystem.txtStatisticFees.setText(changeNumberFormat(fees) + " VND");
        motorcycleShopManagementSystem.txtStatisticIncome.setText(changeNumberFormat(income) + " VND");

        if (flag == false){

            showProductsCollectingMessage();
            comboBox.requestFocusInWindow();

        }
    }

    public static void showProductsCollectingMessage(){
        JOptionPane.showMessageDialog(
                motorcycleShopManagementSystem,
                "The product has not been sold, so information cannot be collected.",
                "Collection Information!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
