package com.company;



import javax.swing.*;

public class Main   {

    public static void main(String[] args)  throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException
    {

        // wygląd wedle tego jak jest skonfigurowany sytem
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyGUI myGUI = new MyGUI();
                myGUI.setVisible(true);

            }
        });

    }
}
