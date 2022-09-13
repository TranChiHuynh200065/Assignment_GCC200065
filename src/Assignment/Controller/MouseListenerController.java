package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerController implements MouseListener {

    private MotorcycleShopManagementSystem motorcycleShopManagementSystem;
    public static boolean productsSwitch = true;
    public static boolean statisticSwitch = false;
    public static boolean purchaseSwitch = false;
    public MouseListenerController(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().getName() == "tbProducts") {
            int row = motorcycleShopManagementSystem.tbProducts.getSelectedRow();
            TableProductsController.showProductsDetail(row);
        }if (e.getComponent().getName() == "tbPurchaseSearching") {
            int row = motorcycleShopManagementSystem.tbPurchaseSearching.getSelectedRow();
            TablePurchaseController.showPurchaseProductsNo(row);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JPanel contentSide = motorcycleShopManagementSystem.contentSide;
        CardLayout cardLayout = (CardLayout) contentSide.getLayout();

        if (e.getComponent().getName() == "Products") {
            cardLayout.show(contentSide, "cardProducts");

        } else if (e.getComponent().getName() == "Statistic") {
            cardLayout.show(contentSide, "cardStatistic");

        } else if (e.getComponent().getName() == "Purchase") {
            TablePurchaseController.setPurchaseTime(motorcycleShopManagementSystem.JDatePickerPurchase);
            cardLayout.show(contentSide, "cardPurchase");

        }else if (e.getComponent().getName() == "tbProducts") {
            int row = motorcycleShopManagementSystem.tbProducts.getSelectedRow();
            TableProductsController.showProductsDetail(row);

        }else if (e.getComponent().getName() == "tbPurchaseTables") {
            int row = motorcycleShopManagementSystem.tbPurchasePaying.getSelectedRow();
            TablePurchaseController.showDetailPurchaseTable(row);
        }else if (e.getComponent().getName() == "purchaseClear") {
            TablePurchaseController.clearPurchasePay();
        }if (e.getComponent().getName() == "tbPurchaseSearching") {
            int row = motorcycleShopManagementSystem.tbPurchaseSearching.getSelectedRow();
            TablePurchaseController.showPurchaseProductsNo(row);
        }
        if (FlatDarkLaf.isLafDark()) {
            if (e.getComponent().getName() == "Products") {
                productsSwitch = true;
                statisticSwitch = false;
                purchaseSwitch = false;
                e.getComponent().setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(255, 115, 65));
                if (purchaseSwitch == false || statisticSwitch == false) {
                    motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(60, 63, 65));
                    motorcycleShopManagementSystem.lblStatistic.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(60, 63, 65));
                }

            } else if (e.getComponent().getName() == "Statistic") {
                statisticSwitch = true;
                productsSwitch = false;
                purchaseSwitch = false;
                e.getComponent().setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(255, 115, 65));
                if (purchaseSwitch == false || productsSwitch == false) {
                    motorcycleShopManagementSystem.lblProducts.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(60, 63, 65));
                    motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(60, 63, 65));

                }
            } else if (e.getComponent().getName() == "Purchase") {
                purchaseSwitch = true;
                productsSwitch = false;
                statisticSwitch = false;
                motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(255, 115, 65));
                if (productsSwitch == false || statisticSwitch == false) {
                    motorcycleShopManagementSystem.lblProducts.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(60, 63, 65));
                    motorcycleShopManagementSystem.lblStatistic.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(60, 63, 65));
                }
            }
            if(e.getComponent().getName() == "productsAdding"){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsAdd);

            }else if(e.getComponent().getName() == "productsNew"){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsNew);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsUpdate);
            }else if(e.getComponent().getName().equals("productsDelete")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsDelete);
            }else if(e.getComponent().getName().equals("productsDeleteAll")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsDeleteAll);
            }else if(e.getComponent().getName().equals("productsClose")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnProductsClose);
            }else if(e.getComponent().getName().equals("purchasePay")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchasePay);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchaseBillClear);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchaseSearch);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClear);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClose);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectOne);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnStatisticClose);
            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                Buttons.pressedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectAll);
            }


        } else {
            if(e.getComponent().getName() == "productsAdding"){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsAdd);;

            }else if(e.getComponent().getName() == "productsNew"){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsNew);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsUpdate);
            }else if(e.getComponent().getName().equals("productsDelete")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsDelete);
            }else if(e.getComponent().getName().equals("productsDeleteAll")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsDeleteAll);
            }else if(e.getComponent().getName().equals("productsClose")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnProductsClose);
            }else if(e.getComponent().getName().equals("purchasePay")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchasePay);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchaseBillClear);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchaseSearch);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClear);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClose);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectOne);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnStatisticClose);
            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                Buttons.pressedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectAll);
            }

            if (e.getComponent().getName() == "Products") {
                productsSwitch = true;
                statisticSwitch = false;
                purchaseSwitch = false;
                e.getComponent().setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(255, 115, 65));
                if (purchaseSwitch == false || statisticSwitch == false) {
                    motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(242, 242, 242));
                    motorcycleShopManagementSystem.lblStatistic.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(242, 242, 242));
                }

            } else if (e.getComponent().getName() == "Statistic") {
                statisticSwitch = true;
                productsSwitch = false;
                purchaseSwitch = false;
                e.getComponent().setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(255, 115, 65));
                if (purchaseSwitch == false || productsSwitch == false) {
                    motorcycleShopManagementSystem.lblProducts.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(242, 242, 242));
                    motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(242, 242, 242));

                }
            } else if (e.getComponent().getName() == "Purchase") {
                purchaseSwitch = true;
                productsSwitch = false;
                statisticSwitch = false;
                motorcycleShopManagementSystem.lblPurchase.setForeground(new Color(255, 115, 65));
                motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(255, 115, 65));
                if (productsSwitch == false || statisticSwitch == false) {
                    motorcycleShopManagementSystem.lblProducts.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(242, 242, 242));
                    motorcycleShopManagementSystem.lblStatistic.setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(242, 242, 242));
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getComponent().getName() == "tbProducts") {
            int row = motorcycleShopManagementSystem.tbProducts.getSelectedRow();
            TableProductsController.showProductsDetail(row);

        }
        if (FlatDarkLaf.isLafDark()) {
            if (e.getComponent().getName() == "productsAdding") {

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsAdd);
            }else if (e.getComponent().getName() == "productsNew") {

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsNew);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsUpdate);
            }else if(e.getComponent().getName().equals("productsDelete")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsDelete);
            }else if(e.getComponent().getName().equals("productsDeleteAll")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsDeleteAll);
            }else if(e.getComponent().getName().equals("productsClose")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnProductsClose);

            }else if(e.getComponent().getName().equals("purchasePay")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchasePay);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchaseBillClear);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchaseSearch);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClear);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClose);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectOne);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnStatisticClose);
            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                Buttons.releasedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectAll);
            }
        }else {
                if (e.getComponent().getName() == "productsAdding") {
                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsAdd);
                }else if (e.getComponent().getName() == "productsNew") {
                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsNew);
                }else if(e.getComponent().getName().equals("productsUpdate")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsUpdate);
                }else if(e.getComponent().getName().equals("productsDelete")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsDelete);
                }else if(e.getComponent().getName().equals("productsDeleteAll")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsDeleteAll);
                }else if(e.getComponent().getName().equals("productsClose")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnProductsClose);
                }else if(e.getComponent().getName().equals("purchasePay")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchasePay);
                }
                else if(e.getComponent().getName().equals("purchaseClear")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchaseBillClear);
                }
                else if(e.getComponent().getName().equals("purchaseSearch")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchaseSearch);
                }
                else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClear);
                }
                else if(e.getComponent().getName().equals("purchaseClose")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClose);
                }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
                }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectOne);
                }else if(e.getComponent().getName().equals("btnStatisticClose")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnStatisticClose);
                }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                    Buttons.releasedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectAll);
                }
            }
        }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (FlatDarkLaf.isLafDark()) {
            if (e.getComponent().getName() == "Products") {
                if(productsSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(60, 63, 65));
                }
            } else if (e.getComponent().getName() == "Statistic") {
                if(statisticSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(60, 63, 65));
                }
            } else if (e.getComponent().getName() == "Purchase") {
                if(purchaseSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(60, 63, 65));
                }
            }
            if(e.getComponent().getName() == "productsAdding"){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsAdd);
                motorcycleShopManagementSystem.btnProductsAdd.setBorder(button);

            }else if(e.getComponent().getName() == "productsNew"){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsNew);
                motorcycleShopManagementSystem.btnProductsNew.setBorder(button);

            }else if(e.getComponent().getName().equals("productsUpdate")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsUpdate);
                motorcycleShopManagementSystem.btnProductsUpdate.setBorder(button);

            }else if(e.getComponent().getName().equals("productsDelete")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsDelete);
                motorcycleShopManagementSystem.btnProductsDelete.setBorder(button);

            }else if(e.getComponent().getName().equals("productsDeleteAll")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsDeleteAll);
                motorcycleShopManagementSystem.btnProductsDeleteAll.setBorder(button);

            }else if(e.getComponent().getName().equals("productsClose")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsClose);
                motorcycleShopManagementSystem.btnProductsClose.setBorder(button);
            }else if(e.getComponent().getName().equals("purchasePay")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchasePay);
                motorcycleShopManagementSystem.btnPurchasePay.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseBillClear);
                motorcycleShopManagementSystem.btnPurchaseBillClear.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseSearch);
                motorcycleShopManagementSystem.btnPurchaseSearch.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseClear);
                motorcycleShopManagementSystem.btnPurchaseClear.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseClose);
                motorcycleShopManagementSystem.btnPurchaseClose.setBorder(button);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
                motorcycleShopManagementSystem.btnPurchaseShowAllBills.setBorder(button);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticCollectOne);
                motorcycleShopManagementSystem.btnStatisticCollectOne.setBorder(button);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticClose);
                motorcycleShopManagementSystem.btnStatisticClose.setBorder(button);

            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticCollectAll);
                motorcycleShopManagementSystem.btnStatisticCollectAll.setBorder(button);

            }

        } else {
            if (e.getComponent().getName() == "Products") {
                if(productsSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(242,242,242));
                }
            } else if (e.getComponent().getName() == "Statistic") {
                if(statisticSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(242,242,242));
                }
            } else if (e.getComponent().getName() == "Purchase") {
                if(purchaseSwitch == false) {
                    e.getComponent().setForeground(new Color(52, 179, 241));
                    motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(242,242,242));
                }
            }
            if(e.getComponent().getName() == "productsAdding"){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsAdd);
                motorcycleShopManagementSystem.btnProductsAdd.setBorder(button);
            }else if(e.getComponent().getName() == "productsNew"){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsNew);
                motorcycleShopManagementSystem.btnProductsNew.setBorder(button);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsUpdate);
                motorcycleShopManagementSystem.btnProductsUpdate.setBorder(button);

            }else if(e.getComponent().getName().equals("productsDelete")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsDelete);
                motorcycleShopManagementSystem.btnProductsDelete.setBorder(button);

            }else if(e.getComponent().getName().equals("productsDeleteAll")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsDeleteAll);
                motorcycleShopManagementSystem.btnProductsDeleteAll.setBorder(button);

            }else if(e.getComponent().getName().equals("productsClose")){

                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnProductsClose);
                motorcycleShopManagementSystem.btnProductsClose.setBorder(button);
            }else if(e.getComponent().getName().equals("purchasePay")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchasePay);
                motorcycleShopManagementSystem.btnPurchasePay.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseBillClear);
                motorcycleShopManagementSystem.btnPurchaseBillClear.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseSearch);
                motorcycleShopManagementSystem.btnPurchaseSearch.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseClear);
                motorcycleShopManagementSystem.btnPurchaseClear.setBorder(button);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseClose);
                motorcycleShopManagementSystem.btnPurchaseClose.setBorder(button);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
                motorcycleShopManagementSystem.btnPurchaseShowAllBills.setBorder(button);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticCollectOne);
                motorcycleShopManagementSystem.btnStatisticCollectOne.setBorder(button);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticClose);
                motorcycleShopManagementSystem.btnStatisticClose.setBorder(button);

            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){
                Border button = motorcycleShopManagementSystem.initialButton;
                Buttons.exitedButtons(motorcycleShopManagementSystem.btnStatisticCollectAll);
                motorcycleShopManagementSystem.btnStatisticCollectAll.setBorder(button);

            }
        }
        if(e.getComponent().getName().equals("purchaseCheck")){
            Buttons.exitedNotRounded(motorcycleShopManagementSystem.btnPurchaseCheck);
        }else if(e.getComponent().getName().equals("purchasePaste")){
            Buttons.exitedNotRounded(motorcycleShopManagementSystem.btnPurchasePaste);
        }else if(e.getComponent().getName().equals("purchaseCopy")){
            Buttons.exitedNotRounded(motorcycleShopManagementSystem.btnPurchaseCopy);
        }
    }

}
