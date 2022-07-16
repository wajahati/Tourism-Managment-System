package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Company_GUI extends JFrame{
    JButton DisplayComp_B, UpdateComp_B, Employee_B, Back_B;
    JLabel Menu_L,Company_L;

    Company_GUI(){
        JPanel Menu_P = new JPanel();
        setSize(500, 700);
        setTitle("TOURISM NETWORK");
        add(Menu_P);
        Menu_P.setLayout(null);
        Menu_P.setBackground(new Color(153,153,153));

        Company_L = new JLabel("TOURISM NETWORK");
        Company_L.setFont(new Font("Serif", Font.BOLD,35));
        Company_L.setBounds(65,10,400,35);
        Company_L.setForeground(new Color(153,0,0));
        Menu_P.add(Company_L);

        Menu_L = new JLabel("COMPANY DATA");
        Menu_L.setFont(new Font("Serif", Font.BOLD,30));
        Menu_L.setBounds(120,60,300,30);
        Menu_L.setForeground(new Color(51,51,51));
        Menu_P.add(Menu_L);

        DisplayComp_B = new JButton("DISPLAY");
        DisplayComp_B.setBounds(100,160,120,80);
        DisplayComp_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(DisplayComp_B);

        UpdateComp_B = new JButton("UPDATE");
        UpdateComp_B.setBounds(240,160,120,80);
        UpdateComp_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(UpdateComp_B);

        Employee_B = new JButton("EMPLOYEES");
        Employee_B.setBounds(100,280,260,80);
        Employee_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Employee_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,400,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        Back_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Back_B);

        setVisible(true);

        Company_GUI.MyListener listener = new Company_GUI.MyListener();
        DisplayComp_B.addActionListener(listener);
        UpdateComp_B.addActionListener(listener);
        Employee_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("DISPLAY")) {
                dispose();
                DISPLAY_Company_GUI GUI=new DISPLAY_Company_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("UPDATE")) {
                dispose();
                UPDATECompany_GUI UC=new UPDATECompany_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("EMPLOYEES")){
                dispose();
                Employee_GUI E=new Employee_GUI();
            }  else if (e.getActionCommand().equalsIgnoreCase("BACK")){
                dispose();
                Tourism_Managment_System t=new Tourism_Managment_System();
            }
        }
    }

}
