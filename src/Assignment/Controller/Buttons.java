package Assignment.Controller;

import Assignment.View.MotorcycleShopManagementSystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Buttons {

    public static void movedButtonsLight(JButton buttons){

        buttons.setForeground(new Color(255, 115, 65));
        buttons.setBorder(new RoundedButtonController(28));
        buttons.setBackground(new Color(242,242, 242));

    }
    public static void movedButtonsDark(JButton buttons){

        buttons.setForeground(new Color(255, 115, 65));
        buttons.setBorder(new RoundedButtonController(28));
        buttons.setBackground(new Color(60, 63, 65));

    }

    public static void exitedButtons(JButton buttons){
        buttons.setBackground(new Color(255, 115, 65));
        buttons.setForeground(new Color(242,242, 242));
    }

    public static void pressedButtonsLight(JButton buttons){
        buttons.setForeground(new Color(0, 0, 0));
        buttons.setBackground(new Color(242,242, 242));
    }
    public static void pressedButtonsDark(JButton buttons){
        buttons.setForeground(new Color(255, 255, 255));
        buttons.setBackground(new Color(60, 63, 65));
    }

    public static void releasedButtonsLight(JButton buttons){
        buttons.setForeground(new Color(255, 115, 65));
        buttons.setBackground(new Color(242,242, 242));
    }
    public static void releasedButtonsDark(JButton buttons){
        buttons.setForeground(new Color(255, 115, 65));
        buttons.setBackground(new Color(60, 63, 65));
    }

    public static void mouseNotRounded(JButton buttons){

        buttons.setForeground(new Color(255, 255, 255));
    }
    public static void exitedNotRounded(JButton buttons){

        buttons.setForeground(new Color(0, 0, 0));
    }
}
