package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UPDATECompany_GUI extends JFrame{
    JButton Submit_B, Back_B;
    JLabel UP_COMP_L,CNAME_L, C_MName_L,CPhoneNo_L,Address_L;
    JTextField CNAME_T, C_MName_T,CPhoneNo_T,O_Address_T,P_Address_T,C_Address_T;

    UPDATECompany_GUI(){
        JPanel UPP_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(UPP_USER_P);
        UPP_USER_P.setLayout(null);
        UPP_USER_P.setBackground(new Color(153,153,153));

        UP_COMP_L = new JLabel("UPDATE COMPANY");
        UP_COMP_L.setFont(new Font("Serif", Font.BOLD,25));
        UP_COMP_L.setBounds(120,50,500,35);
        UP_COMP_L.setForeground(new Color(51,51,51));
        UPP_USER_P.add(UP_COMP_L);

        CNAME_L = new JLabel("Company Name :");
        CNAME_L.setFont(new Font("Serif", Font.BOLD,15));
        CNAME_L.setBounds(50,130,120,30);
        UPP_USER_P.add(CNAME_L);

        CNAME_T = new JTextField();
        CNAME_T.setBounds(200,130,200,30);
        UPP_USER_P.add(CNAME_T);

        C_MName_L = new JLabel("Manager Name :");
        C_MName_L.setFont(new Font("Serif", Font.BOLD,15));
        C_MName_L.setBounds(50,180,120,30);
        UPP_USER_P.add(C_MName_L);

        C_MName_T = new JTextField(20);
        C_MName_T.setBounds(200,180,200,30);
        UPP_USER_P.add(C_MName_T);

        CPhoneNo_L = new JLabel("Pone No :");
        CPhoneNo_L.setFont(new Font("Serif", Font.BOLD,15));
        CPhoneNo_L .setBounds(50,230,120,30);
        UPP_USER_P.add(CPhoneNo_L );

        CPhoneNo_T = new JTextField(20);
        CPhoneNo_T.setBounds(200,230,200,30);
        UPP_USER_P.add(CPhoneNo_T);

        Address_L = new JLabel("Address OfNO/PlNM/Cty :");
        Address_L.setFont(new Font("Serif", Font.BOLD,15));
        Address_L.setBounds(50,280,120,30);
        UPP_USER_P.add(Address_L);

        O_Address_T = new JTextField(20);
        O_Address_T.setBounds(200,280,50,30);
        UPP_USER_P.add(O_Address_T);

        P_Address_T = new JTextField(20);
        P_Address_T.setBounds(260,280,50,30);
        UPP_USER_P.add(P_Address_T);

        C_Address_T = new JTextField(20);
        C_Address_T.setBounds(320,280,50,30);
        UPP_USER_P.add(C_Address_T);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,390,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        UPP_USER_P.add(Back_B);

        Submit_B = new JButton("SUBMIT");
        Submit_B.setBounds(280,390,80,25);

        Submit_B.setBackground(Color.BLUE);
        Submit_B.setForeground(Color.white);
        UPP_USER_P.add(Submit_B);

        setVisible(true);
        UPDATECompany_GUI.MyListener listener = new UPDATECompany_GUI.MyListener();
        Submit_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equalsIgnoreCase("SUBMIT")){
                Address A=new Address(Integer.parseInt(O_Address_T.getText()),P_Address_T.getText(),C_Address_T.getText());
                ArrayList<Organizer> O=Organizer.readFromFile();
                Company C1 = new Company(  CNAME_T.getText(), C_MName_T.getText(),O, A,CPhoneNo_T.getText());
                Company.updateFile(C1);
                JOptionPane.showMessageDialog(null, "Updated successfully\n"+Company.Display());
                dispose();
                Company_GUI M=new Company_GUI();
            }if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Company_GUI N=new Company_GUI();
            }
        }
    }


}
