package Assignment.View;


import Assignment.Controller.*;
import com.formdev.flatlaf.FlatLightLaf;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;


public class MotorcycleShopManagementSystem extends JFrame {
    private JPanel mainPanel;
    private JPanel topSide;
    private JPanel leftSide;
    public JPanel contentSide;
    private JPanel footerSide;
    private JPanel productsSide;
    public JButton btnProductsAdd;
    private JPanel statisticSide;
    private JPanel purchaseSide;
    public JLabel lblProducts;
    public JLabel lblStatistic;
    public JLabel lblPurchase;
    public JDatePickerImpl JDatePickerStatistic;
    public JDatePickerImpl JDatePickerProducts;
    public JTable tbProducts;
    public JCheckBox chbStatisticCategory;
    public JCheckBox chbStatisticEngineType;
    public JCheckBox chbStatisticColor;
    public JTextField txtStatisticRevenues;
    public JTextField txtStatisticFees;
    public JTextField txtStatisticIncome;
    public JTable tbStatistic;
    public JCheckBox chbStatisticTradeDate;
    public JTable tbPurchaseSearching;
    public JCheckBox chbPurchaseModel;
    public JTextField txtPurchaseSearchingModel;
    public JCheckBox chbPurchaseColor;
    public JTextField txtPurchaseSearchingColor;
    public JCheckBox chbPurchaseCategory;
    public JCheckBox chbPurchaseMake;
    public JTextField txtPurchaseSearchingCategory;
    public JTextField txtPurchaseSearchingMake;
    public JTextField txtPurchaseCustomerName;
    public JDatePickerImpl JDatePickerPurchase;
    private JPanel jPanel1;
    private JPanel jPanel2;
    public JPanel JPanelStatistic;
    public JPanel JPanelPurchase;
    private JPanel jPanel6;
    private JPanel jPanel8;
    private JPanel jPanel9;
    public JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel21;
    private JMenuItem menuItemDark;
    private JMenuItem menuItemLight;
    public JTextField txtProductsModel;
    public  JTextField txtProductsColor;
    public  JTextField txtProductsMake;
    public  JTextField txtProductsEngineType;
    public  JTextField txtProductsDisplacement;
    public  JTextField txtProductsFuelCapacity;
    public  JTextField txtProductsDryWeight;
    public  JTextField txtProductsQuantity;
    public  JTextField txtProductsPrice;
    public JPanel JPanelProducts;

    public Border initialButton = btnProductsAdd.getBorder();
    public JTable tbPurchasePaying;
    public JComboBox cbColor;
    public JComboBox cbCategory;
    public JComboBox cbMake;
    public JComboBox cbEngineType;
    public JTextField txtProductsNo;
    public JLabel lblMake;
    public JButton btnProductsNew;
    public JButton btnProductsUpdate;
    public JButton btnProductsDelete;
    public JButton btnProductsDeleteAll;
    public JButton btnProductsClose;
    public JButton btnPurchasePay;
    public JButton btnPurchaseBillClear;
    public JButton btnPurchaseSearch;
    public JButton btnPurchaseClear;
    public JButton btnPurchaseClose;
    public JButton btnStatisticCollectAll;
    public JButton btnStatisticCollectOne;
    public JButton btnStatisticClear;
    public JButton btnStatisticClose;
    public JTextField txtPurchasePhone;
    public JTextField txtPurchaseModel;
    public JTextField txtPurchaseColor;
    public JTextField txtPurchaseQuantity;
    public JTextField txtPurchasePrice;
    public JTextField txtPurchaseNo;
    public JButton btnPurchaseCheck;
    public JButton btnPurchaseShowAllBills;
    public JComboBox cbbStatisticMake;
    public JComboBox cbbStatisticEngineType;
    public JComboBox cbbStatisticCategory;
    public JComboBox cbbStatisticColor;
    public JCheckBox chbStatisticMake;
    public JCheckBox chbStatisticModel;
    public JComboBox cbbStatisticModel;
    public JTextField txtPurchaseStock;
    public JTextField txtPurchaseNoCopy;
    public JButton btnPurchaseCopy;
    public JButton btnPurchasePaste;
    private JDatePickerImpl a;
    private CardLayout cardLayout;


    int row;
    public MotorcycleShopManagementSystem(String title) {

        //Design a layout
        super(title);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(1070, 620);
        this.setLocationRelativeTo(null);


        //Create objects
        MouseListenerController mouseListenerController = new MouseListenerController(this);
        ActionListenerController actionListenerController = new ActionListenerController(this);
        MouseMotionController mouseMotionController = new MouseMotionController(this);
        WindowListenerController windowListenerController = new WindowListenerController(this);
        ComboBoxProductsController comboBoxProductsController = new ComboBoxProductsController(this);

        //Design tables
        tbProducts.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "No.", "Model", "Color", "Category", "Make", "Engine Type", "Displacement (CC)",
                        "Fuel Capacity (L)", "Dry Weight (Kg)", "Quantity", "Price (VND)", "Date"
                }
        ));
        tbStatistic.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Customer Name", "Phone", "No.", "Model", "Color", "Category", "Make", "Engine Type",
                        "Price (VND)", "Quantity", "Total Price (VND)", "Trade Date"
                }
        ));
        tbPurchaseSearching.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "No.", "Model", "Color", "Category", "Make", "Engine Type", "Displacement (CC)",
                        "Fuel Capacity (L)", "Dry Weight (Kg)", "Quantity", "Price (VND)"
                }
        ));
        tbPurchasePaying.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Customer Name", "Phone","No.", "Model", "Color","Price (VND)", "Quantity", "Trade Date"
                }
        ));

    //This
        this.addWindowListener(windowListenerController);

    //Label
        lblProducts.addMouseListener(mouseListenerController);
        lblStatistic.addMouseListener(mouseListenerController);
        lblPurchase.addMouseListener(mouseListenerController);
        lblProducts.addMouseMotionListener(mouseMotionController);
        lblStatistic.addMouseMotionListener(mouseMotionController);
        lblPurchase.addMouseMotionListener(mouseMotionController);

    //JPanel

    //Menu
        menuItemLight.addActionListener(actionListenerController);
        menuItemDark.addActionListener(actionListenerController);


    //Buttons
        //Add products
        btnProductsAdd.addActionListener(actionListenerController);
        btnProductsAdd.addMouseListener(mouseListenerController);
        btnProductsAdd.addMouseMotionListener(mouseMotionController);

        //New products
        btnProductsNew.addActionListener(actionListenerController);
        btnProductsNew.addMouseMotionListener(mouseMotionController);
        btnProductsNew.addMouseListener(mouseListenerController);

        //Update products
        btnProductsUpdate.addActionListener(actionListenerController);
        btnProductsUpdate.addMouseMotionListener(mouseMotionController);
        btnProductsUpdate.addMouseListener(mouseListenerController);

        //Delete products
        btnProductsDelete.addActionListener(actionListenerController);
        btnProductsDelete.addMouseMotionListener(mouseMotionController);
        btnProductsDelete.addMouseListener(mouseListenerController);

        //Delete all products
        btnProductsDeleteAll.addActionListener(actionListenerController);
        btnProductsDeleteAll.addMouseListener(mouseListenerController);

        //Close products
        btnProductsClose.addActionListener(actionListenerController);
        btnProductsClose.addMouseMotionListener(mouseMotionController);
        btnProductsClose.addMouseListener(mouseListenerController);

        //Close purchase
        btnPurchaseClose.addActionListener(actionListenerController);
        btnPurchaseClose.addMouseMotionListener(mouseMotionController);
        btnPurchaseClose.addMouseListener(mouseListenerController);

        //Check purchase
        btnPurchaseCheck.addActionListener(actionListenerController);
        btnPurchaseCheck.addMouseMotionListener(mouseMotionController);
        btnPurchaseCheck.addMouseListener(mouseListenerController);

        //Pay purchase
        btnPurchasePay.addActionListener(actionListenerController);
        btnPurchasePay.addMouseMotionListener(mouseMotionController);
        btnPurchasePay.addMouseListener(mouseListenerController);

        //Clear purchase bill
        btnPurchaseBillClear.addMouseMotionListener(mouseMotionController);
        btnPurchaseBillClear.addMouseListener(mouseListenerController);


        //Show all bills
        btnPurchaseShowAllBills.addActionListener(actionListenerController);
        btnPurchaseShowAllBills.addMouseMotionListener(mouseMotionController);
        btnPurchaseShowAllBills.addMouseListener(mouseListenerController);

        //Search products
        btnPurchaseSearch.addActionListener(actionListenerController);
        btnPurchaseSearch.addMouseMotionListener(mouseMotionController);
        btnPurchaseSearch.addMouseListener(mouseListenerController);

        //Clear searching
        btnPurchaseClear.addActionListener(actionListenerController);
        btnPurchaseClear.addMouseMotionListener(mouseMotionController);
        btnPurchaseClear.addMouseListener(mouseListenerController);

        //Collect all statistic
        btnStatisticCollectAll.addActionListener(actionListenerController);
        btnStatisticCollectAll.addMouseMotionListener(mouseMotionController);
        btnStatisticCollectAll.addMouseListener(mouseListenerController);

        //Collect one statistic
        btnStatisticCollectOne.addActionListener(actionListenerController);
        btnStatisticCollectOne.addMouseMotionListener(mouseMotionController);
        btnStatisticCollectOne.addMouseListener(mouseListenerController);

        //Close statistic
        btnStatisticClose.addActionListener(actionListenerController);
        btnStatisticClose.addMouseMotionListener(mouseMotionController);
        btnStatisticClose.addMouseListener(mouseListenerController);

    //JDatePicker

        //Products
        TablePurchaseController.setPurchaseTime(JDatePickerProducts);


    //Tables
        //Products
        TableProductsController.checkProductModel();
        TableProductsController.fillToTable();
        JTableUtilitiesController.setCellsAlignment(tbProducts, SwingConstants.CENTER);

        tbProducts.setDefaultEditor(Object.class, null);
        tbProducts.getTableHeader().setReorderingAllowed(false);
        tbProducts.addMouseListener(mouseListenerController);

        //Purchase Paying
        TablePurchaseController.checkPurchaseModel();
        tbPurchasePaying.addMouseListener(mouseListenerController);

        JTableUtilitiesController.setCellsAlignment(tbPurchasePaying, SwingConstants.CENTER);
        tbPurchasePaying.setDefaultEditor(Object.class, null);
        tbPurchasePaying.getTableHeader().setReorderingAllowed(false);

        //Purchase Searching
        JTableUtilitiesController.setCellsAlignment(tbPurchaseSearching, SwingConstants.CENTER);
        tbPurchaseSearching.setDefaultEditor(Object.class, null);
        tbPurchaseSearching.getTableHeader().setReorderingAllowed(false);

        tbPurchaseSearching.addMouseListener(mouseListenerController);

        //Purchase Copy
        btnPurchaseCopy.addActionListener(actionListenerController);
        btnPurchaseCopy.addMouseMotionListener(mouseMotionController);
        btnPurchaseCopy.addMouseListener(mouseListenerController);

        //Purchase Paste
        btnPurchasePaste.addActionListener(actionListenerController);
        btnPurchasePaste.addMouseMotionListener(mouseMotionController);
        btnPurchasePaste.addMouseListener(mouseListenerController);

        //Statistic
        TableStatisticController.fillToStatisticTable();


        JTableUtilitiesController.setCellsAlignment(tbStatistic, SwingConstants.CENTER);
        tbStatistic.setDefaultEditor(Object.class, null);
        tbStatistic.getTableHeader().setReorderingAllowed(false);

    //ComboBox
        //Products color
        cbColor.addMouseMotionListener(mouseMotionController);
        comboBoxProductsController.checkCbbProductsColorList();
        comboBoxProductsController.fillCbbProductsColor();

        //Products Category
        cbCategory.addMouseMotionListener(mouseMotionController);
        comboBoxProductsController.checkCbbProductsCategoryList();
        comboBoxProductsController.fillCbbProductsCategory();

        //Products Make
        cbMake.addMouseMotionListener(mouseMotionController);
        comboBoxProductsController.checkCbbProductsMakeList();
        comboBoxProductsController.fillCbbProductsMake();

        //Products Engine Type
        cbEngineType.addMouseMotionListener(mouseMotionController);
        comboBoxProductsController.checkCbbProductsEngineTypeList();
        comboBoxProductsController.fillCbbProductsEngineType();

        //Statistic color
        comboBoxProductsController.fillCbbStatisticColor();
        cbbStatisticColor.addMouseMotionListener(mouseMotionController);

        //Statistic make
        comboBoxProductsController.fillCbbStatisticMake();
        cbbStatisticMake.addMouseMotionListener(mouseMotionController);

        //Statistic category
        comboBoxProductsController.fillCbbStatisticCategory();
        cbbStatisticCategory.addMouseMotionListener(mouseMotionController);

        //Statistic engine type
        comboBoxProductsController.fillCbbStatisticEngineType();
        cbbStatisticEngineType.addMouseMotionListener(mouseMotionController);

        //Statistic model
        TableProductsController.fillToStatisticComboBoxModel();
        cbbStatisticModel.addMouseMotionListener(mouseMotionController);

    }

    //JDatePicker
    public void createUIComponents() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerProducts = new JDatePickerImpl(datePanel, new DateLabelFormatController());
        JDatePickerStatistic = new JDatePickerImpl(datePanel, new DateLabelFormatController());
        JDatePickerPurchase = new JDatePickerImpl(datePanel, new DateLabelFormatController());
        a = new JDatePickerImpl(datePanel, new DateLabelFormatController());
    }


    //Main
    public static void main(String[] args){

        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){
            System.err.println(e);
        }

        MotorcycleShopManagementSystem motorcycleShopManagementSystem = new MotorcycleShopManagementSystem("Motorcycle Shop");
        motorcycleShopManagementSystem.setVisible(true);
        motorcycleShopManagementSystem.setResizable(false);

    }
}
