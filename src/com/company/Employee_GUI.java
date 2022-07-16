package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employee_GUI extends JFrame{
    JButton Add_B, Search_B,Update_B, Delete_B ,DisplayAll_B, Back_B;
    JLabel Employee_L;

    Employee_GUI(){
        JPanel Employee_P = new JPanel();
        setSize(500, 700);
        setTitle("TOURISM NETWORK");
        add(Employee_P);
        Employee_P.setLayout(null);
        Employee_P.setBackground(new Color(153,153,153));

        Employee_L = new JLabel("EMPLOYEE MENU");
        Employee_L.setFont(new Font("Serif", Font.BOLD,35));
        Employee_L.setBounds(90,55,400,35);
        Employee_L.setForeground(new Color(51,51,51));
        Employee_P.add(Employee_L);

        Add_B = new JButton("ADD");
        Add_B.setBounds(100,160,120,80);
        Add_B.setFont(new Font("Serif", Font.BOLD,12));
        Employee_P.add(Add_B);

        Search_B = new JButton("SEARCH");
        Search_B.setBounds(240,160,120,80);
        Search_B.setFont(new Font("Serif", Font.BOLD,12));
        Employee_P.add(Search_B);

        Update_B = new JButton("UPDATE");
        Update_B.setBounds(100,280,120,80);
        Update_B.setFont(new Font("Serif", Font.BOLD,12));
        Employee_P.add(Update_B);

        Delete_B = new JButton("DELETE");
        Delete_B.setBounds(240,280,120,80);
        Delete_B.setFont(new Font("Serif", Font.BOLD,12));
        Employee_P.add(Delete_B);


        DisplayAll_B = new JButton("DISPLAY");
        DisplayAll_B.setBounds(100,400,260,80);
        DisplayAll_B.setFont(new Font("Serif", Font.BOLD,12));
        Employee_P.add(DisplayAll_B);


        Back_B = new JButton("BACK");
        Back_B.setBounds(100,520,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        Employee_P.add(Back_B);

        setVisible(true);
        Employee_GUI.MyListener listener = new Employee_GUI.MyListener();
        Add_B.addActionListener(listener);
        Search_B.addActionListener(listener);
        Update_B.addActionListener(listener);
        Delete_B.addActionListener(listener);
        DisplayAll_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("ADD")) {
                dispose();
                ADDEmployee_GUI AE=new ADDEmployee_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("SEARCH")) {
                dispose();
                SEARCHEmployee_GUI S=new SEARCHEmployee_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("UPDATE")){
                dispose();
                UPDATEEmployee_GUI U=new UPDATEEmployee_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("DELETE")){
                dispose();
                DELETEEmployee_GUI D=new DELETEEmployee_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("DISPLAY")) {
                dispose();
                DISLAYEmployee_GUI D=new DISLAYEmployee_GUI();
            } else if(e.getActionCommand().equalsIgnoreCase("BACK")){
                dispose();
                Company_GUI C=new Company_GUI();
            }
        }
    }
}
