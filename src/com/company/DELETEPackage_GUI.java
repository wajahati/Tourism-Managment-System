package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DELETEPackage_GUI extends JFrame{
    JButton BACK_B, DELETE_B;
    JLabel DELETE_L;

    User CUSTOMER;

    DELETEPackage_GUI(User Custo){
        this.CUSTOMER=Custo;
        JPanel DIS_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(DIS_USER_P);
        DIS_USER_P.setLayout(null);
        DIS_USER_P.setBackground(new Color(153,153,153));

        DELETE_L = new JLabel("DELETE PACKAGE");
        DELETE_L.setFont(new Font("Serif", Font.BOLD,25));
        DELETE_L.setBounds(120,20,500,35);
        DELETE_L.setForeground(new Color(51,51,51));
        DIS_USER_P.add(DELETE_L);

        DELETE_B = new JButton("DELETE");
        DELETE_B.setBounds(260,210,100,25);
        DELETE_B.setBackground(Color.BLUE);
        DELETE_B.setForeground(Color.white);
        DIS_USER_P.add(DELETE_B);

        BACK_B = new JButton("BACK");
        BACK_B.setBounds(100,210,80,25);
        BACK_B.setBackground(Color.BLUE);
        BACK_B.setForeground(Color.white);
        DIS_USER_P.add(BACK_B);


        setVisible(true);
        DELETEPackage_GUI.MyListener listener = new DELETEPackage_GUI.MyListener();
        DELETE_B.addActionListener(listener);
        BACK_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Package_GUI a = new Package_GUI(CUSTOMER);
            }
            if (e.getActionCommand().equalsIgnoreCase("DELETE")) {
                ArrayList<Tour_Confirmation> T=Tour_Confirmation.readFromFile();
                for (Tour_Confirmation TT: T){
                    JOptionPane.showMessageDialog(null, Tour_Confirmation.DeleteTourRecord(CUSTOMER.getUserName(),CUSTOMER.getPassword()));
                break;
                }
            }
        }

    }

}
