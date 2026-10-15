PROGRAM:


import javax.swing.*;
import java.awt.*;

public class FlowDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout");

        f.setLayout(new FlowLayout());

        String[] b = {"New", "Open", "Save", "Print", "Exit"};

        for (String s : b) {
            f.add(new JButton(s));
        }

        f.setSize(300, 120);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}


INPUT:
Run the FlowDemo Java program.
Layout = FlowLayout
Buttons = New, Open, Save, Print, Exit

  OUTPUT:
THE OUTPUT IS DIAGRAM


  Result:
The program displays a window titled FlowLayout with five buttons: New, Open, Save, Print, and Exit. The buttons are arranged from left to right and centered by default.
