package Assignment.Controller;

import Assignment.Model.ComboBoxProductsCategoryModel;
import Assignment.Model.ComboBoxProductsColorModel;
import Assignment.Model.ComboBoxProductsEngineTypeModel;
import Assignment.Model.ComboBoxProductsMakeModel;
import Assignment.View.MotorcycleShopManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComboBoxProductsController {
    static MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public ComboBoxProductsController(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }

    static List<ComboBoxProductsColorModel> cbbProductsColorList;
    static List<ComboBoxProductsCategoryModel> cbbProductsCategoryList;
    static List<ComboBoxProductsMakeModel> cbbProductsMakeList;
    static List<ComboBoxProductsEngineTypeModel> cbbProductsEngineTypeList;
    static DefaultComboBoxModel cbbProductsColorModel;
    static DefaultComboBoxModel cbbProductsCategoryModel;
    static DefaultComboBoxModel cbbProductsMakeModel;
    static DefaultComboBoxModel cbbProductsEngineTypeModel;
    static DefaultComboBoxModel cbbStatisticMakeModel;
    static DefaultComboBoxModel cbbStatisticEngineTypeModel;
    static DefaultComboBoxModel cbbStatisticCategoryModel;
    static DefaultComboBoxModel cbbStatisticColorModel;


    static String colorFile = "src/Assignment/Model/fComboBoxProductsColorModel.dat";
    static String categoryFile = "src/Assignment/Model/fComboBoxProductsCategoryModel.dat";
    static String makeFile = "src/Assignment/Model/fComboBoxProductsMakeModel.dat";
    static String engineTypeFile = "src/Assignment/Model/fComboBoxProductsEngineTypeModel.dat";

    //ComboBox Color
    public void checkCbbProductsColorList(){
        cbbProductsColorList = (List<ComboBoxProductsColorModel>) FileController.readObject(colorFile);
        if(cbbProductsColorList == null || cbbProductsColorList.size() == 0){
            cbbProductsColorList = new ArrayList<>();

            cbbProductsColorList.add(new ComboBoxProductsColorModel("<Choose a color>"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Red"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Blue"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("White"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Black"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Gray"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Pink"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Orange"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Peacock blue"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Plum"));
            cbbProductsColorList.add(new ComboBoxProductsColorModel("Brown"));
            FileController.writeObject(colorFile, cbbProductsColorList);
        }
    }
    public static void fillCbbProductsColor(){
        cbbProductsColorList = (List<ComboBoxProductsColorModel>) FileController.readObject(colorFile);
        cbbProductsColorModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbColor.getModel();
        cbbProductsColorModel.removeAllElements();
        for(ComboBoxProductsColorModel cbb : cbbProductsColorList){
            cbbProductsColorModel.addElement(cbb.getColor());
        }
    }
    public static void fillCbbStatisticColor(){
        cbbProductsColorList = (List<ComboBoxProductsColorModel>) FileController.readObject(colorFile);
        cbbStatisticColorModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticColor.getModel();
        cbbStatisticColorModel.removeAllElements();
        for(ComboBoxProductsColorModel cbb : cbbProductsColorList){
            cbbStatisticColorModel.addElement(cbb.getColor());
        }
    }
    public static void moveCbbProductsColorFilling(){
        cbbProductsColorModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbColor.getModel();
        cbbProductsColorList = (List<ComboBoxProductsColorModel>) FileController.readObject(colorFile);

        String firstElements = (String) cbbProductsColorModel.getElementAt(0);
        String selectedItem = (String) cbbProductsColorModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a color>")){
            cbbProductsColorModel.removeElement("<Choose a color>");
        }
        if(!firstElements.equals("<Choose a color>")) {

            if(!selectedItem.equals(firstElements)){
                cbbProductsColorModel.removeAllElements();
                cbbProductsColorModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsColorList.get(i).getColor().equals(selectedItem)) {

                        cbbProductsColorModel.addElement(cbbProductsColorList.get(i).getColor());
                    }
                }
            }else {
                cbbProductsColorModel.removeAllElements();
                cbbProductsColorModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsColorList.get(i).getColor().equals(firstElements)) {

                        cbbProductsColorModel.addElement(cbbProductsColorList.get(i).getColor());
                    }
                }
            }
            cbbProductsColorModel.removeElement("<Choose a color>");
        }
    }
    public static void moveCbbStatisticColorFilling(){
        cbbStatisticMakeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticColor.getModel();
        cbbProductsColorList = (List<ComboBoxProductsColorModel>) FileController.readObject(colorFile);

        String firstElements = (String) cbbStatisticMakeModel.getElementAt(0);
        String selectedItem = (String) cbbStatisticMakeModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a color>")){
            cbbStatisticMakeModel.removeElement("<Choose a color>");
        }
        if(!firstElements.equals("<Choose a color>")) {

            if(!selectedItem.equals(firstElements)){
                cbbStatisticMakeModel.removeAllElements();
                cbbStatisticMakeModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsColorList.get(i).getColor().equals(selectedItem)) {

                        cbbStatisticMakeModel.addElement(cbbProductsColorList.get(i).getColor());
                    }
                }
            }else {
                cbbStatisticMakeModel.removeAllElements();
                cbbStatisticMakeModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsColorList.get(i).getColor().equals(firstElements)) {

                        cbbStatisticMakeModel.addElement(cbbProductsColorList.get(i).getColor());
                    }
                }
            }
            cbbStatisticMakeModel.removeElement("<Choose a color>");
        }
    }

    //ComboBox Category
    public void checkCbbProductsCategoryList(){
        cbbProductsCategoryList = (List<ComboBoxProductsCategoryModel>) FileController.readObject(categoryFile);
        if(cbbProductsCategoryList == null || cbbProductsCategoryList.size() == 0){
            cbbProductsCategoryList = new ArrayList<>();

            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("<Choose a category>"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Underbone"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Scooter Classic"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Scooter-Underbone"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Touring"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Sport Touring"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Naked Bike"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Sport Bike"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Cruiser"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Off Road"));
            cbbProductsCategoryList.add(new ComboBoxProductsCategoryModel("Adventure"));
            FileController.writeObject(categoryFile, cbbProductsCategoryList);
        }
    }

    public static void fillCbbProductsCategory(){
        cbbProductsCategoryList = (List<ComboBoxProductsCategoryModel>) FileController.readObject(categoryFile);
        cbbProductsCategoryModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbCategory.getModel();
        cbbProductsCategoryModel.removeAllElements();
        for(ComboBoxProductsCategoryModel cbb : cbbProductsCategoryList){
            cbbProductsCategoryModel.addElement(cbb.getCategory());
        }
    }

    //Statistic ComboBox
    public static void fillCbbStatisticCategory(){
        cbbProductsCategoryList = (List<ComboBoxProductsCategoryModel>) FileController.readObject(categoryFile);
        cbbStatisticCategoryModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticCategory.getModel();
        cbbStatisticCategoryModel.removeAllElements();
        for(ComboBoxProductsCategoryModel cbb : cbbProductsCategoryList){
            cbbStatisticCategoryModel.addElement(cbb.getCategory());
        }
    }

    public static void moveCbbProductsCategoryFilling(){
        cbbProductsCategoryModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbCategory.getModel();
        cbbProductsCategoryList = (List<ComboBoxProductsCategoryModel>) FileController.readObject(categoryFile);

        String firstElements = (String) cbbProductsCategoryModel.getElementAt(0);
        String selectedItem = (String) cbbProductsCategoryModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a category>")){
            cbbProductsCategoryModel.removeElement("<Choose a category>");
        }

        if(!firstElements.equals("<Choose a category>")) {

            if(!selectedItem.equals(firstElements)){
                cbbProductsCategoryModel.removeAllElements();
                cbbProductsCategoryModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsCategoryList.size(); i++) {

                    if (!cbbProductsCategoryList.get(i).getCategory().equals(selectedItem)) {

                        cbbProductsCategoryModel.addElement(cbbProductsCategoryList.get(i).getCategory());
                    }
                }
            }else {
                cbbProductsCategoryModel.removeAllElements();
                cbbProductsCategoryModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsCategoryList.size(); i++) {

                    if (!cbbProductsCategoryList.get(i).getCategory().equals(firstElements)) {

                        cbbProductsCategoryModel.addElement(cbbProductsCategoryList.get(i).getCategory());
                    }
                }
            }
            cbbProductsCategoryModel.removeElement("<Choose a category>");
        }
    }
    //Statistic ComboBox
    public static void moveCbbStatisticCategoryFilling(){
        cbbStatisticCategoryModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticCategory.getModel();
        cbbProductsCategoryList = (List<ComboBoxProductsCategoryModel>) FileController.readObject(categoryFile);

        String firstElements = (String) cbbStatisticCategoryModel.getElementAt(0);
        String selectedItem = (String) cbbStatisticCategoryModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a category>")){
            cbbStatisticCategoryModel.removeElement("<Choose a category>");
        }

        if(!firstElements.equals("<Choose a category>")) {

            if(!selectedItem.equals(firstElements)){
                cbbStatisticCategoryModel.removeAllElements();
                cbbStatisticCategoryModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsCategoryList.size(); i++) {

                    if (!cbbProductsCategoryList.get(i).getCategory().equals(selectedItem)) {

                        cbbStatisticCategoryModel.addElement(cbbProductsCategoryList.get(i).getCategory());
                    }
                }
            }else {
                cbbStatisticCategoryModel.removeAllElements();
                cbbStatisticCategoryModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsCategoryList.size(); i++) {

                    if (!cbbProductsCategoryList.get(i).getCategory().equals(firstElements)) {

                        cbbStatisticCategoryModel.addElement(cbbProductsCategoryList.get(i).getCategory());
                    }
                }
            }
            cbbStatisticCategoryModel.removeElement("<Choose a category>");
        }
    }

    //ComboBox Make
    public void checkCbbProductsMakeList(){
        cbbProductsMakeList = (List<ComboBoxProductsMakeModel>) FileController.readObject(makeFile);
        if(cbbProductsMakeList == null || cbbProductsMakeList.size() == 0){
            cbbProductsMakeList = new ArrayList<>();

            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("<Choose a make>"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Vinfast"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Honda"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Yamaha"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Kawasaki"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Ducati"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("Suzuki"));
            cbbProductsMakeList.add(new ComboBoxProductsMakeModel("BMW"));
            FileController.writeObject(makeFile, cbbProductsMakeList);
        }
    }
    public static void fillCbbProductsMake(){
        cbbProductsMakeList = (List<ComboBoxProductsMakeModel>) FileController.readObject(makeFile);
        cbbProductsMakeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbMake.getModel();
        cbbProductsMakeModel.removeAllElements();
        for(ComboBoxProductsMakeModel cbb : cbbProductsMakeList){
            cbbProductsMakeModel.addElement(cbb.getMake());
        }
    }

    //Statistic Make
    public static void fillCbbStatisticMake(){
        cbbProductsMakeList = (List<ComboBoxProductsMakeModel>) FileController.readObject(makeFile);
        cbbStatisticMakeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticMake.getModel();
        cbbStatisticMakeModel.removeAllElements();
        for(ComboBoxProductsMakeModel cbb : cbbProductsMakeList){
            cbbStatisticMakeModel.addElement(cbb.getMake());
        }
    }
    public static void moveCbbProductsMakeFilling(){
        cbbProductsMakeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbMake.getModel();
        cbbProductsMakeList = (List<ComboBoxProductsMakeModel>) FileController.readObject(makeFile);

        String firstElements = (String) cbbProductsMakeModel.getElementAt(0);
        String selectedItem = (String) cbbProductsMakeModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a make>")){
            cbbProductsMakeModel.removeElement("<Choose a make>");
        }
        if(!firstElements.equals("<Choose a make>")) {

            if(!selectedItem.equals(firstElements)){
                cbbProductsMakeModel.removeAllElements();
                cbbProductsMakeModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsMakeList.get(i).getMake().equals(selectedItem)) {

                        cbbProductsMakeModel.addElement(cbbProductsMakeList.get(i).getMake());
                    }
                }
            }else {
                cbbProductsMakeModel.removeAllElements();
                cbbProductsMakeModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsMakeList.get(i).getMake().equals(firstElements)) {

                        cbbProductsMakeModel.addElement(cbbProductsMakeList.get(i).getMake());
                    }
                }
            }
            cbbProductsMakeModel.removeElement("<Choose a make>");
        }
    }

    //Statistic Make
    public static void moveCbbStatisticMakeFilling(){
        cbbStatisticMakeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticMake.getModel();
        cbbProductsMakeList = (List<ComboBoxProductsMakeModel>) FileController.readObject(makeFile);

        String firstElements = (String) cbbStatisticMakeModel.getElementAt(0);
        String selectedItem = (String) cbbStatisticMakeModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a make>")){
            cbbStatisticMakeModel.removeElement("<Choose a make>");
        }
        if(!firstElements.equals("<Choose a make>")) {

            if(!selectedItem.equals(firstElements)){
                cbbStatisticMakeModel.removeAllElements();
                cbbStatisticMakeModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsMakeList.get(i).getMake().equals(selectedItem)) {

                        cbbStatisticMakeModel.addElement(cbbProductsMakeList.get(i).getMake());
                    }
                }
            }else {
                cbbStatisticMakeModel.removeAllElements();
                cbbStatisticMakeModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsMakeList.size(); i++) {

                    if (!cbbProductsMakeList.get(i).getMake().equals(firstElements)) {

                        cbbStatisticMakeModel.addElement(cbbProductsMakeList.get(i).getMake());
                    }
                }
            }
            cbbStatisticMakeModel.removeElement("<Choose a make>");
        }
    }
    //ComboBox Engine Type
    public void checkCbbProductsEngineTypeList(){
        cbbProductsEngineTypeList = (List<ComboBoxProductsEngineTypeModel>) FileController.readObject(engineTypeFile);
        if(cbbProductsEngineTypeList == null || cbbProductsEngineTypeList.size() == 0){
            cbbProductsEngineTypeList = new ArrayList<>();

            cbbProductsEngineTypeList.add(new ComboBoxProductsEngineTypeModel("<Choose a engine type>"));
            cbbProductsEngineTypeList.add(new ComboBoxProductsEngineTypeModel("Single Cylinder"));
            cbbProductsEngineTypeList.add(new ComboBoxProductsEngineTypeModel("Parallel Twin"));
            cbbProductsEngineTypeList.add(new ComboBoxProductsEngineTypeModel("V Twin"));
            cbbProductsEngineTypeList.add(new ComboBoxProductsEngineTypeModel("V Four"));
            FileController.writeObject(engineTypeFile, cbbProductsEngineTypeList);
        }
    }
    public static void fillCbbProductsEngineType(){
        cbbProductsEngineTypeList = (List<ComboBoxProductsEngineTypeModel>) FileController.readObject(engineTypeFile);
        cbbProductsEngineTypeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbEngineType.getModel();
        cbbProductsEngineTypeModel.removeAllElements();
        for(ComboBoxProductsEngineTypeModel cbb : cbbProductsEngineTypeList){
            cbbProductsEngineTypeModel.addElement(cbb.getEngineType());
        }
    }

    //Statistic Engine Type
    public static void fillCbbStatisticEngineType(){
        cbbProductsEngineTypeList = (List<ComboBoxProductsEngineTypeModel>) FileController.readObject(engineTypeFile);
        cbbStatisticEngineTypeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticEngineType.getModel();
        cbbStatisticEngineTypeModel.removeAllElements();
        for(ComboBoxProductsEngineTypeModel cbb : cbbProductsEngineTypeList){
            cbbStatisticEngineTypeModel.addElement(cbb.getEngineType());
        }
    }
    
    public static void moveCbbProductsEngineTypeFilling(){
        cbbProductsEngineTypeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbEngineType.getModel();
        cbbProductsEngineTypeList = (List<ComboBoxProductsEngineTypeModel>) FileController.readObject(engineTypeFile);

        String firstElements = (String) cbbProductsEngineTypeModel.getElementAt(0);
        String selectedItem = (String) cbbProductsEngineTypeModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a engine type>")){
            cbbProductsEngineTypeModel.removeElement("<Choose a engine type>");
        }

        if(!firstElements.equals("<Choose a engine type>")) {


            if(!selectedItem.equals(firstElements)){
                cbbProductsEngineTypeModel.removeAllElements();
                cbbProductsEngineTypeModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsEngineTypeList.size(); i++) {

                    if (!cbbProductsEngineTypeList.get(i).getEngineType().equals(selectedItem)) {

                        cbbProductsEngineTypeModel.addElement(cbbProductsEngineTypeList.get(i).getEngineType());
                    }
                }
            }else {
                cbbProductsEngineTypeModel.removeAllElements();
                cbbProductsEngineTypeModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsEngineTypeList.size(); i++) {

                    if (!cbbProductsEngineTypeList.get(i).getEngineType().equals(firstElements)) {

                        cbbProductsEngineTypeModel.addElement(cbbProductsEngineTypeList.get(i).getEngineType());
                    }
                }
            }
            cbbProductsEngineTypeModel.removeElement("<Choose a engine type>");
        }
    }

    public static void moveCbbStatisticEngineTypeFilling(){
        cbbStatisticEngineTypeModel = (DefaultComboBoxModel) motorcycleShopManagementSystem.cbbStatisticEngineType.getModel();
        cbbProductsEngineTypeList = (List<ComboBoxProductsEngineTypeModel>) FileController.readObject(engineTypeFile);

        String firstElements = (String) cbbStatisticEngineTypeModel.getElementAt(0);
        String selectedItem = (String) cbbStatisticEngineTypeModel.getSelectedItem();

        if(!selectedItem.equals("<Choose a engine type>")){
            cbbStatisticEngineTypeModel.removeElement("<Choose a engine type>");
        }

        if(!firstElements.equals("<Choose a engine type>")) {


            if(!selectedItem.equals(firstElements)){
                cbbStatisticEngineTypeModel.removeAllElements();
                cbbStatisticEngineTypeModel.addElement(selectedItem);
                for (int i = 0; i < cbbProductsEngineTypeList.size(); i++) {

                    if (!cbbProductsEngineTypeList.get(i).getEngineType().equals(selectedItem)) {

                        cbbStatisticEngineTypeModel.addElement(cbbProductsEngineTypeList.get(i).getEngineType());
                    }
                }
            }else {
                cbbStatisticEngineTypeModel.removeAllElements();
                cbbStatisticEngineTypeModel.addElement(firstElements);

                for (int i = 0; i < cbbProductsEngineTypeList.size(); i++) {

                    if (!cbbProductsEngineTypeList.get(i).getEngineType().equals(firstElements)) {

                        cbbStatisticEngineTypeModel.addElement(cbbProductsEngineTypeList.get(i).getEngineType());
                    }
                }
            }
            cbbStatisticEngineTypeModel.removeElement("<Choose a engine type>");
        }
    }
}
