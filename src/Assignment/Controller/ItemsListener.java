package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemsListener implements ItemListener {
    private MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public ItemsListener(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
