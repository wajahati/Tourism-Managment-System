package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DISPLAY_Company_GUI extends JFrame{
    JLabel DISP_COM_L,C_Name_L, M_Name_L, C_Phone_No,C_Off_Address_L,C_Pl_City_Address_L,C_City_Address_L;
    JButton Back_B;

    DISPLAY_Company_GUI(){
        Company c=Company.readFromFile();

        JPanel ADD_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_USER_P);
        ADD_USER_P.setLayout(null);
        ADD_USER_P.setBackground(new Color(153,153,153));

        DISP_COM_L = new JLabel("COMPANY INFO");
        DISP_COM_L.setFont(new Font("Serif", Font.BOLD,25));
        DISP_COM_L.setBounds(145,50,500,35);
        DISP_COM_L.setForeground(new Color(51,51,51));
        ADD_USER_P.add(DISP_COM_L);

        C_Name_L = new JLabel("COMPANY NAME : "+c.getCompany_Name());
        C_Name_L.setFont(new Font("Serif", Font.BOLD,15));
        C_Name_L.setBounds(50,130,500,30);
        ADD_USER_P.add(C_Name_L);

        M_Name_L = new JLabel("MANAGER NAME : "+c.getManager());
        M_Name_L.setFont(new Font("Serif", Font.BOLD,15));
        M_Name_L.setBounds(50,180,500,30);
        ADD_USER_P.add(M_Name_L);

        C_Phone_No = new JLabel("COMPANY PHONE NO : "+c.getCompany_PhoneNo());
        C_Phone_No.setFont(new Font("Serif", Font.BOLD,15));
        C_Phone_No .setBounds(50,230,500,30);
        ADD_USER_P.add(C_Phone_No );

        C_Off_Address_L = new JLabel("COMPANY ADDRESS :   Office No: "+c.getCompany_location().getOfficeNo());
        C_Off_Address_L.setFont(new Font("Serif", Font.BOLD,15));
        C_Off_Address_L.setBounds(50,280,500,30);
        ADD_USER_P.add(C_Off_Address_L);

        C_Pl_City_Address_L = new JLabel(" Plaza Name : "
                +c.getCompany_location().getPlazaName()+", "+c.getCompany_location().getCity());
        C_Pl_City_Address_L.setFont(new Font("Serif", Font.BOLD,15));
        C_Pl_City_Address_L.setBounds(200,300,500,30);
        ADD_USER_P.add(C_Pl_City_Address_L);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,360,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_USER_P.add(Back_B);

        setVisible(true);

        DISPLAY_Company_GUI.MyListener listener = new DISPLAY_Company_GUI.MyListener();
        Back_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Company_GUI N=new Company_GUI();
            }
        }
    }
}
