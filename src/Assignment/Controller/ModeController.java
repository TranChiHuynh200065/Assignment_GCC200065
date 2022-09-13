package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

import java.awt.*;

import static Assignment.Controller.ComboBoxProductsController.motorcycleShopManagementSystem;

public class ModeController {

    static Font myFont = new Font("Broadway", Font.BOLD, 20);
    static Font btnFont = new Font("Comic Sans MS", Font.BOLD, 10);

    public static void isLightMode(JLabel product, JLabel statistic, JLabel purchase,
                                   JButton btnProductsNew, JButton btnProductsAdd,
                                   JButton btnProductsUpdate, JButton btnProductsDelete, JButton btnProductsDeleteAll,
                                   JButton btnProductsClose,
                                   JButton btnStatisticCollectAll,
                                   JButton btnStatisticCollectOne,
                                   JButton btnStatisticClose, JButton btnPurchaseSearch,
                                   JButton btnPurchaseClear, JButton btnPurchaseClose,
                                   JButton btnPurchaseCopy, JButton btnPurchasePaste,
                                   JButton btnPurchasePay, JButton btnPurchaseBillClear,JButton btnPurchaseBillCheck,
                                   JButton btnPurchaseShowAllBills){
        try{

            product.setFont(myFont);
            statistic.setFont(myFont);
            purchase.setFont(myFont);
            btnProductsNew.setFont(btnFont);
            btnProductsAdd.setFont(btnFont);
            btnProductsUpdate.setFont(btnFont);
            btnProductsDelete.setFont(btnFont);
            btnProductsDeleteAll.setFont(btnFont);
            btnProductsClose.setFont(btnFont);
            btnStatisticCollectAll.setFont(btnFont);
            btnStatisticCollectOne.setFont(btnFont);
            btnStatisticClose.setFont(btnFont);
            btnPurchaseSearch.setFont(btnFont);
            btnPurchaseClear.setFont(btnFont);
            btnPurchaseClose.setFont(btnFont);
            btnPurchaseCopy.setFont(btnFont);
            btnPurchasePaste.setFont(btnFont);
            btnPurchasePay.setFont(btnFont);
            btnPurchaseBillClear.setFont(btnFont);
            btnPurchaseBillCheck.setFont(btnFont);
            btnPurchaseShowAllBills.setFont(btnFont);

            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception modeDarkError){
            System.err.println(modeDarkError);
        }
    }
    
    public static void isDarkMode(JLabel product, JLabel statistic, JLabel purchase,
                                  JButton btnProductsNew, JButton btnProductsAdd,
                                  JButton btnProductsUpdate, JButton btnProductsDelete, JButton btnProductsDeleteAll,
                                  JButton btnProductsClose,
                                  JButton btnStatisticCollectAll,
                                  JButton btnStatisticCollectOne,
                                  JButton btnStatisticClose, JButton btnPurchaseSearch,
                                  JButton btnPurchaseClear, JButton btnPurchaseClose,
                                  JButton btnPurchaseCopy, JButton btnPurchasePaste,
                                  JButton btnPurchasePay, JButton btnPurchaseBillClear, JButton btnPurchaseBillCheck,
                                  JButton btnPurchaseShowAllBills){
        try{

            product.setFont(myFont);
            statistic.setFont(myFont);
            purchase.setFont(myFont);
            btnProductsNew.setFont(btnFont);
            btnProductsAdd.setFont(btnFont);
            btnProductsUpdate.setFont(btnFont);
            btnProductsDelete.setFont(btnFont);
            btnProductsDeleteAll.setFont(btnFont);
            btnProductsClose.setFont(btnFont);
            btnStatisticCollectAll.setFont(btnFont);
            btnStatisticCollectOne.setFont(btnFont);
            btnStatisticClose.setFont(btnFont);
            btnPurchaseSearch.setFont(btnFont);
            btnPurchaseClear.setFont(btnFont);
            btnPurchaseClose.setFont(btnFont);
            btnPurchaseCopy.setFont(btnFont);
            btnPurchasePaste.setFont(btnFont);
            btnPurchasePay.setFont(btnFont);
            btnPurchaseBillClear.setFont(btnFont);
            btnPurchaseBillCheck.setFont(btnFont);
            btnPurchaseShowAllBills.setFont(btnFont);

            UIManager.setLookAndFeel(new FlatDarkLaf());

        }catch (Exception modeDarkError){
            System.err.println(modeDarkError);
        }
    }

    public static void setLblProductsColor(){

        motorcycleShopManagementSystem.lblProducts.setForeground(new Color(255, 115, 65));
        motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(255, 115, 65));
        motorcycleShopManagementSystem.JPanelProducts.setOpaque(true);
        motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(255, 115, 65));
        motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(52, 179, 241));
    }


}
