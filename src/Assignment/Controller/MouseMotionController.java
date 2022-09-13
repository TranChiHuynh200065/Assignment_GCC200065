package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseMotionController implements MouseMotionListener {

    private MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public MouseMotionController(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (FlatDarkLaf.isLafDark()) {
            if(e.getComponent().getName().equals("productsAdding")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnProductsAdd);

            }else if(e.getComponent().getName().equals("productsNew")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnProductsNew);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnProductsUpdate);
            }else if(e.getComponent().getName().equals("productsDelete")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnProductsDelete);
            }else if(e.getComponent().getName().equals("productsClose")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnProductsClose);
            }
            else if(e.getComponent().getName().equals("purchasePay")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchasePay);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchaseBillClear);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchaseSearch);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClear);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchaseClose);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectOne);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnStatisticClose);
            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                Buttons.movedButtonsDark(motorcycleShopManagementSystem.btnStatisticCollectAll);
            }

        } else {
            if(e.getComponent().getName().equals("productsAdding")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnProductsAdd);

            }else if(e.getComponent().getName().equals("productsNew")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnProductsNew);
            }else if(e.getComponent().getName().equals("productsUpdate")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnProductsUpdate);
            }else if(e.getComponent().getName().equals("productsDelete")) {

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnProductsDelete);
            }else if(e.getComponent().getName().equals("productsClose")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnProductsClose);
            }
            else if(e.getComponent().getName().equals("purchasePay")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchasePay);
            }
            else if(e.getComponent().getName().equals("purchaseClear")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchaseBillClear);
            }
            else if(e.getComponent().getName().equals("purchaseSearch")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchaseSearch);
            }
            else if(e.getComponent().getName().equals("purchaseSearchingClear")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClear);
            }
            else if(e.getComponent().getName().equals("purchaseClose")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchaseClose);
            }else if(e.getComponent().getName().equals("purchaseShowAllBills")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnPurchaseShowAllBills);
            }else if(e.getComponent().getName().equals("btnStatisticCollectOne")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectOne);
            }else if(e.getComponent().getName().equals("btnStatisticClose")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnStatisticClose);
            }else if(e.getComponent().getName().equals("btnStatisticCollectAll")){

                Buttons.movedButtonsLight(motorcycleShopManagementSystem.btnStatisticCollectAll);
            }

        }
        if (e.getComponent().getName().equals("Products")) {
            e.getComponent().setForeground(new Color(255, 115, 65));
            motorcycleShopManagementSystem.JPanelProducts.setOpaque(true);
            motorcycleShopManagementSystem.JPanelProducts.setBackground(new Color(255, 115, 65));
        } else if (e.getComponent().getName().equals("Statistic")) {
            e.getComponent().setForeground(new Color(255, 115, 65));
            motorcycleShopManagementSystem.JPanelStatistic.setOpaque(true);
            motorcycleShopManagementSystem.JPanelStatistic.setBackground(new Color(255, 115, 65));
        } else if (e.getComponent().getName().equals("Purchase")) {
            e.getComponent().setForeground(new Color(255, 115, 65));
            motorcycleShopManagementSystem.JPanelPurchase.setOpaque(true);
            motorcycleShopManagementSystem.JPanelPurchase.setBackground(new Color(255, 115, 65));
        }
        if(e.getComponent().getName().equals("cbbColor")){
            ComboBoxProductsController.moveCbbProductsColorFilling();
        }else if(e.getComponent().getName().equals("cbbCategory")){
            ComboBoxProductsController.moveCbbProductsCategoryFilling();
        }else if(e.getComponent().getName().equals("cbbMake")){
            ComboBoxProductsController.moveCbbProductsMakeFilling();
        }else if(e.getComponent().getName().equals("cbbEngineType")){
            ComboBoxProductsController.moveCbbProductsEngineTypeFilling();
        }else if(e.getComponent().getName().equals("cbbStatisticColor")){
            ComboBoxProductsController.moveCbbStatisticColorFilling();
        }else if(e.getComponent().getName().equals("cbbStatisticCategory")){
            ComboBoxProductsController.moveCbbStatisticCategoryFilling();
        }else if(e.getComponent().getName().equals("cbbStatisticMake")){
            ComboBoxProductsController.moveCbbStatisticMakeFilling();
        }else if(e.getComponent().getName().equals("cbbStatisticEngineType")){
            ComboBoxProductsController.moveCbbStatisticEngineTypeFilling();
        }else if(e.getComponent().getName().equals("cbbStatisticModel")){
            TableProductsController.moveCbbStatisticModelFilling();
        }else if(e.getComponent().getName().equals("purchaseCheck")){
            Buttons.mouseNotRounded(motorcycleShopManagementSystem.btnPurchaseCheck);
        }else if(e.getComponent().getName().equals("purchasePaste")){
            Buttons.mouseNotRounded(motorcycleShopManagementSystem.btnPurchasePaste);
        }else if(e.getComponent().getName().equals("purchaseCopy")){
            Buttons.mouseNotRounded(motorcycleShopManagementSystem.btnPurchaseCopy);
        }
    }
}
