package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DISLAYEmployee_GUI extends JFrame{
    JButton BACK_B, DISPLAY_B;
    JLabel DISPLAY_L;

    DISLAYEmployee_GUI(){

        JPanel DIS_EMP_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(DIS_EMP_P);
        DIS_EMP_P.setLayout(null);
        DIS_EMP_P.setBackground(new Color(153,153,153));

        DISPLAY_L = new JLabel("DISPLAY EMPLOYEE");
        DISPLAY_L.setFont(new Font("Serif", Font.BOLD,25));
        DISPLAY_L.setBounds(100,20,500,35);
        DISPLAY_L.setForeground(new Color(51,51,51));
        DIS_EMP_P.add(DISPLAY_L);

        DISPLAY_B = new JButton("DISPLAY");
        DISPLAY_B.setBounds(260,210,100,25);
        DISPLAY_B.setBackground(Color.BLUE);
        DISPLAY_B.setForeground(Color.white);
        DIS_EMP_P.add(DISPLAY_B);

        BACK_B = new JButton("BACK");
        BACK_B.setBounds(100,210,80,25);
        BACK_B.setBackground(Color.BLUE);
        BACK_B.setForeground(Color.white);
        DIS_EMP_P.add(BACK_B);


        setVisible(true);
        DISLAYEmployee_GUI.MyListener listener = new DISLAYEmployee_GUI.MyListener();
        DISPLAY_B.addActionListener(listener);
        BACK_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Employee_GUI a = new Employee_GUI();
            }
            if (e.getActionCommand().equalsIgnoreCase("DISPLAY")) {
                ArrayList<Organizer> O_DATA=Organizer.readFromFile();
                for (Organizer O: O_DATA){
                    JOptionPane.showMessageDialog(null, Organizer.DisplayEmployee_Record(O.getUserName()));}

            }
        }

    }
}
