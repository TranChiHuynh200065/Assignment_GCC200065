package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerController implements ActionListener {

    private MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public ActionListenerController(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Light") {

            ModeController.isLightMode(motorcycleShopManagementSystem.lblProducts,
                    motorcycleShopManagementSystem.lblStatistic,
                    motorcycleShopManagementSystem.lblPurchase,
                    motorcycleShopManagementSystem.btnProductsNew,
                    motorcycleShopManagementSystem.btnProductsAdd,
                    motorcycleShopManagementSystem.btnProductsUpdate,
                    motorcycleShopManagementSystem.btnProductsDelete,
                    motorcycleShopManagementSystem.btnProductsDeleteAll,
                    motorcycleShopManagementSystem.btnProductsClose,
                    motorcycleShopManagementSystem.btnStatisticCollectAll,
                    motorcycleShopManagementSystem.btnStatisticCollectOne,
                    motorcycleShopManagementSystem.btnStatisticClose,
                    motorcycleShopManagementSystem.btnPurchaseSearch,
                    motorcycleShopManagementSystem.btnPurchaseClose,
                    motorcycleShopManagementSystem.btnPurchaseClear,
                    motorcycleShopManagementSystem.btnPurchaseCopy,
                    motorcycleShopManagementSystem.btnPurchasePaste,
                    motorcycleShopManagementSystem.btnPurchasePay,
                    motorcycleShopManagementSystem.btnPurchaseBillClear,
                    motorcycleShopManagementSystem.btnPurchaseCheck,
                    motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            if (MouseListenerController.productsSwitch) {
                motorcycleShopManagementSystem.JPanelProducts.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelProducts.setOpaque(false);
            }
            if (MouseListenerController.statisticSwitch) {
                motorcycleShopManagementSystem.JPanelStatistic.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelStatistic.setOpaque(false);
            }
            if (MouseListenerController.purchaseSwitch) {
                motorcycleShopManagementSystem.JPanelPurchase.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelPurchase.setOpaque(false);
            }

            motorcycleShopManagementSystem.jPanel10.setBackground(Color.BLACK);

            SwingUtilities.updateComponentTreeUI(motorcycleShopManagementSystem.getComponent(0));

        } else if (e.getActionCommand() == "Dark") {

            ModeController.isDarkMode(motorcycleShopManagementSystem.lblProducts,
                    motorcycleShopManagementSystem.lblStatistic,
                    motorcycleShopManagementSystem.lblPurchase,
                    motorcycleShopManagementSystem.btnProductsNew,
                    motorcycleShopManagementSystem.btnProductsAdd,
                    motorcycleShopManagementSystem.btnProductsUpdate,
                    motorcycleShopManagementSystem.btnProductsDelete,
                    motorcycleShopManagementSystem.btnProductsDeleteAll,
                    motorcycleShopManagementSystem.btnProductsClose,
                    motorcycleShopManagementSystem.btnStatisticCollectAll,
                    motorcycleShopManagementSystem.btnStatisticCollectOne,
                    motorcycleShopManagementSystem.btnStatisticClose,
                    motorcycleShopManagementSystem.btnPurchaseSearch,
                    motorcycleShopManagementSystem.btnPurchaseClear,
                    motorcycleShopManagementSystem.btnPurchaseClose,
                    motorcycleShopManagementSystem.btnPurchaseCopy,
                    motorcycleShopManagementSystem.btnPurchasePaste,
                    motorcycleShopManagementSystem.btnPurchasePay,
                    motorcycleShopManagementSystem.btnPurchaseBillClear,
                    motorcycleShopManagementSystem.btnPurchaseCheck,
                    motorcycleShopManagementSystem.btnPurchaseShowAllBills);

            if (MouseListenerController.productsSwitch) {
                motorcycleShopManagementSystem.JPanelProducts.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelProducts.setOpaque(false);
            }
            if (MouseListenerController.statisticSwitch) {
                motorcycleShopManagementSystem.JPanelStatistic.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelStatistic.setOpaque(false);
            }
            if (MouseListenerController.purchaseSwitch) {
                motorcycleShopManagementSystem.JPanelPurchase.setOpaque(true);
            } else {
                motorcycleShopManagementSystem.JPanelPurchase.setOpaque(false);
            }

            motorcycleShopManagementSystem.jPanel10.setBackground(Color.WHITE);

            SwingUtilities.updateComponentTreeUI(motorcycleShopManagementSystem.getComponent(0));

        } else if (e.getActionCommand() == "AddProducts") {
            TableProductsController.saveProductModel();
        } else if (e.getActionCommand() == "NewProducts") {
            motorcycleShopManagementSystem.txtProductsNo.setEnabled(true);
            motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();
            TableProductsController.clear();
        } else if (e.getActionCommand() == "UpdateProducts") {
            TableProductsController.updateProductsModelList();
        } else if (e.getActionCommand() == "DeleteProducts") {
            TableProductsController.deleteProductsModelList();
        } else if (e.getActionCommand() == "DeleteAllProducts") {
            TableProductsController.deleteAllProductsModelList();
        } else if (e.getActionCommand() == "CloseProducts") {
            TableProductsController.closeProgram();
        }else if (e.getActionCommand() == "CheckPurchase") {
            TablePurchaseController.clickCheckingPurchaseButton();
        }else if (e.getActionCommand() == "purchasePay") {
            TablePurchaseController.clickPayingPurchaseButton();
        }else if (e.getActionCommand() == "ShowAllBills") {
            TablePurchaseController.fillToPurchaseTable();
        }else if (e.getActionCommand() == "SearchPurchaseProducts") {
            TablePurchaseController.chooseSearchingOptions();
        }else if (e.getActionCommand() == "ClosePurchase") {
            TableProductsController.closeProgram();
        }else if (e.getActionCommand() == "ClearPurchaseSearch") {
            TablePurchaseController.clearPurchaseSearchingInformation();
        }else if (e.getActionCommand() == "CloseStatistic") {
//            TableProductsController.closeProgram();
        }else if (e.getActionCommand() == "CollectOneStatistic") {
            TableStatisticController.clickCollectStatisticModel();
        }else if (e.getActionCommand() == "CollectAllStatistic") {
            TableStatisticController.fillToStatisticTable();
        }else if (e.getActionCommand() == "CopyPurchase") {
            TablePurchaseController.copyPurchaseProductsNo();
        }else if (e.getActionCommand() == "PastePurchase") {
            TablePurchaseController.pastePurchaseProductsNo();
        }else if (e.getActionCommand() == "CloseStatisticAnnoying") {
            TableProductsController.closeProgram();
        }
    }
}
