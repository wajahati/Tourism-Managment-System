package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DISPLAYUser_GUI extends JFrame {
    JButton BACK_B, DISPLAY_B;
    JLabel DISPLAY_L;

    DISPLAYUser_GUI(){
        JPanel DIS_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(DIS_USER_P);
        DIS_USER_P.setLayout(null);
        DIS_USER_P.setBackground(new Color(153,153,153));

        DISPLAY_L = new JLabel("DISPLAY USERS");
        DISPLAY_L.setFont(new Font("Serif", Font.BOLD,25));
        DISPLAY_L.setBounds(150,20,500,35);
        DISPLAY_L.setForeground(new Color(51,51,51));
        DIS_USER_P.add(DISPLAY_L);

        DISPLAY_B = new JButton("DISPLAY");
        DISPLAY_B.setBounds(260,210,100,25);
        DISPLAY_B.setBackground(Color.BLUE);
        DISPLAY_B.setForeground(Color.white);
        DIS_USER_P.add(DISPLAY_B);

        BACK_B = new JButton("BACK");
        BACK_B.setBounds(100,210,80,25);
        BACK_B.setBackground(Color.BLUE);
        BACK_B.setForeground(Color.white);
        DIS_USER_P.add(BACK_B);


        setVisible(true);
        DISPLAYUser_GUI.MyListener listener = new DISPLAYUser_GUI.MyListener();
        DISPLAY_B.addActionListener(listener);
        BACK_B.addActionListener(listener);

    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                User_GUI a = new User_GUI();
            }
            if (e.getActionCommand().equalsIgnoreCase("DISPLAY")) {
                ArrayList<User> U_DATA=User.readFromFile();
                for (User U: U_DATA){
                    JOptionPane.showMessageDialog(null, User.DisplayUser_Record(U.getUserName()));}

            }
        }

    }
}

