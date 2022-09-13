package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerController implements WindowListener {
    private MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public WindowListenerController(MotorcycleShopManagementSystem motorcycleShopManagementSystem) {
        this.motorcycleShopManagementSystem = motorcycleShopManagementSystem;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        motorcycleShopManagementSystem.txtProductsNo.requestFocusInWindow();

    }

    @Override
    public void windowClosing(WindowEvent e) {
            int options = JOptionPane.showConfirmDialog(
                    motorcycleShopManagementSystem,
                    "Do you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (options == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
