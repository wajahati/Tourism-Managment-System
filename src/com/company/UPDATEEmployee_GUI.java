package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UPDATEEmployee_GUI extends JFrame{

    JButton Search_TO_UPDATE_B, Back_B;
    JLabel Search_TO_UPDATE_L,Username_L;
    JTextField Username_T;
    boolean Availability;

    JButton Submit_B, Back_Up_B;
    JLabel oldUsername_L,newUsername_L,newPassword_L, UPP_USER_L,Fname_L, Lname_L,Email_L,PhoneNo_L,Designation_L,Availability_L;
    JTextField newUsername_T,newPassword_T,Fname_T, Lname_T,Email_T,PhoneNo_T;
    JComboBox<String> Designation_CB;
    JCheckBox Availability_CB1,Availability_CB2;

    String UnameGUI;
    UPDATEEmployee_GUI() {
        JPanel ADD_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_USER_P);
        ADD_USER_P.setLayout(null);
        ADD_USER_P.setBackground(new Color(153,153,153));

        Search_TO_UPDATE_L = new JLabel("UPDATE EMPLOYEE");
        Search_TO_UPDATE_L.setFont(new Font("Serif", Font.BOLD,25));
        Search_TO_UPDATE_L.setBounds(120,20,500,35);
        Search_TO_UPDATE_L.setForeground(new Color(51,51,51));
        ADD_USER_P.add(Search_TO_UPDATE_L);

        Username_L = new JLabel("Username : ");
        Username_L.setFont(new Font("Serif", Font.BOLD,15));
        Username_L.setBounds(50,150,120,30);
        ADD_USER_P.add(Username_L);

        Username_T = new JTextField();
        Username_T.setBounds(200,150,200,30);
        ADD_USER_P.add(Username_T);

        Search_TO_UPDATE_B = new JButton("SEARCH");
        Search_TO_UPDATE_B.setBounds(260,210,100,25);
        Search_TO_UPDATE_B.setBackground(Color.BLUE);
        Search_TO_UPDATE_B.setForeground(Color.white);
        ADD_USER_P.add(Search_TO_UPDATE_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,210,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_USER_P.add(Back_B);

        setVisible(true);
        com.company.UPDATEEmployee_GUI.MyListener listener = new com.company.UPDATEEmployee_GUI.MyListener();
        Search_TO_UPDATE_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Employee_GUI N=new Employee_GUI();
            }
            if (e.getActionCommand().equalsIgnoreCase("SEARCH")) {
                UnameGUI = Username_T.getText();
                if (Organizer.SearchEmployee(UnameGUI)) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Employee found\nPress OK to Update User Data");
                    com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2 uu = new com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2();
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found");


                }
            }
        }
    }
    public class UPDATE_EMPLOYEE_GUI2 extends JFrame{
        public UPDATE_EMPLOYEE_GUI2(){

            setSize(500, 700);
            JPanel UPD_USER_P = new JPanel();
            setTitle("Tourism Network");
            add(UPD_USER_P);
            UPD_USER_P.setLayout(null);
            UPD_USER_P.setBackground(new Color(153,153,153));

            UPP_USER_L = new JLabel("UPDATE USER");
            UPP_USER_L.setFont(new Font("Serif", Font.BOLD,25));
            UPP_USER_L.setBounds(160,50,500,35);
            UPP_USER_L.setForeground(new Color(51,51,51));
            UPD_USER_P.add(UPP_USER_L);

            oldUsername_L = new JLabel("Old Username :               "+UnameGUI);
            oldUsername_L.setFont(new Font("Serif", Font.BOLD,15));
            oldUsername_L.setBounds(50,130,320,30);
            UPD_USER_P.add(oldUsername_L);

            newUsername_L = new JLabel("New Username ");
            newUsername_L.setFont(new Font("Serif", Font.BOLD,15));
            newUsername_L.setBounds(50,180,120,30);
            UPD_USER_P.add(newUsername_L);

            newUsername_T = new JTextField();
            newUsername_T.setBounds(200,180,200,30);
            UPD_USER_P.add(newUsername_T);


            newPassword_L = new JLabel("New Password");
            newPassword_L.setFont(new Font("Serif", Font.BOLD,15));
            newPassword_L.setBounds(50,230,120,30);
            UPD_USER_P.add(newPassword_L);


            newPassword_T = new JTextField();
            newPassword_T.setBounds(200,230,200,30);
            UPD_USER_P.add(newPassword_T);

            Fname_L = new JLabel("First Name ");
            Fname_L.setFont(new Font("Serif", Font.BOLD,15));
            Fname_L.setBounds(50,280,120,30);
            UPD_USER_P.add(Fname_L);

            Fname_T = new JTextField();
            Fname_T.setBounds(200,280,200,30);
            UPD_USER_P.add(Fname_T);

            Lname_L = new JLabel("Last Name: ");
            Lname_L.setBounds(50,330,120,30);
            Lname_L.setFont(new Font("Serif", Font.BOLD,15));
            UPD_USER_P.add(Lname_L);

            Lname_T = new JTextField(20);
            Lname_T.setBounds(200,330,200,30);
            UPD_USER_P.add(Lname_T);

            Email_L = new JLabel("Email: ");
            Email_L .setBounds(50,380,120,30);
            Email_L.setFont(new Font("Serif", Font.BOLD,15));
            UPD_USER_P.add(Email_L );

            Email_T = new JTextField(20);
            Email_T.setBounds(200,380,200,30);;
            UPD_USER_P.add(Email_T);

            PhoneNo_L = new JLabel("Phone No: ");
            PhoneNo_L.setBounds(50,430,120,30);
            PhoneNo_L.setFont(new Font("Serif", Font.BOLD,15));
            UPD_USER_P.add(PhoneNo_L);

            PhoneNo_T = new JTextField(20);
            PhoneNo_T.setBounds(200,430,200,30);
            UPD_USER_P.add(PhoneNo_T);

            Designation_L = new JLabel("Designation :");
            Designation_L.setFont(new Font("Serif", Font.BOLD,15));
            Designation_L.setBounds(50,480,120,30);
            UPD_USER_P.add(Designation_L);

            Designation_CB = new JComboBox<String>(PACKAGE_INFO.Designation);
            Designation_CB.setBounds(200,480,200,30);
            UPD_USER_P.add(Designation_CB);

            Availability_L = new JLabel("Availability :");
            Availability_L.setFont(new Font("Serif", Font.BOLD,15));
            Availability_L.setBounds(50,530,120,30);
            UPD_USER_P.add(Availability_L);

            Availability_CB1 = new JCheckBox("Yes");
            Availability_CB1.setBounds(200,530,60,30);
            UPD_USER_P.add(Availability_CB1);

            Availability_CB2 = new JCheckBox("No");
            Availability_CB2.setBounds(270,530,60,30);
            UPD_USER_P.add(Availability_CB2);

            Back_Up_B = new JButton("BACK");
            Back_Up_B.setBounds(100,590,80,25);
            Back_Up_B.setBackground(Color.BLUE);
            Back_Up_B.setForeground(Color.white);
            UPD_USER_P.add(Back_Up_B);

            Submit_B = new JButton("SUBMIT");
            Submit_B.setBounds(280,590,80,25);
            Submit_B.setBackground(Color.BLUE);
            Submit_B.setForeground(Color.white);
            UPD_USER_P.add(Submit_B);

            setVisible(true);

            com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2.CheckBoxHandler Handler = new com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2.CheckBoxHandler();
            Availability_CB1.addItemListener(Handler);
            Availability_CB2.addItemListener(Handler);

            com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2.MyListener1 listener = new com.company.UPDATEEmployee_GUI.UPDATE_EMPLOYEE_GUI2.MyListener1();
            Submit_B.addActionListener(listener);
            Back_Up_B.addActionListener(listener);
            Availability_CB1.addActionListener(listener);
            Availability_CB2.addActionListener(listener);

        }
        public class CheckBoxHandler implements ItemListener {

            public void itemStateChanged(ItemEvent event){

                Availability= false;

                if(Availability_CB1.isSelected()&& !Availability_CB2.isSelected()){
                    Availability=true;
                }
                else if(!Availability_CB1.isSelected()&& Availability_CB2.isSelected()){
                    Availability=false;
                }
                else if(Availability_CB1.isSelected()&& Availability_CB2.isSelected()){
                    JOptionPane.showMessageDialog(null,"Select One chack box only");
                }
            }
        }
        public class MyListener1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("SUBMIT")){
                    Organizer O1 = new Organizer(  Fname_T.getText(), Lname_T.getText(), Email_T.getText(), PhoneNo_T.getText(), (String) Designation_CB.getSelectedItem(),Availability);
                    dispose();
                    JOptionPane.showMessageDialog(null, "User Data Updated Sucessfull\n New USER NAME:\n"+
                            newUsername_T.getText()+"\n New PASSWORD:\n"+newPassword_T.getText());
                    Organizer.updateEmployee(UnameGUI,O1,newUsername_T.getText(),newPassword_T.getText());
                    Employee_GUI E=new Employee_GUI();
                }
                else if (e.getActionCommand().equalsIgnoreCase("BACK")){
                    dispose();
                    Employee_GUI N=new Employee_GUI();
                }
            }
        }
    }
}
