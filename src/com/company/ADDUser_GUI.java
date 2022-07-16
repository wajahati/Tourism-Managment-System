package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADDUser_GUI extends JFrame{
    JButton Submit_B, Back_B;
    JLabel ADD_USER_L,Fname_L, Lname_L,Email_L,PhoneNo_L,Age_L;
    JTextField Fname_T, Lname_T,Email_T,PhoneNo_T,Age_T;

    public ADDUser_GUI(){
        JPanel ADD_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_USER_P);
        ADD_USER_P.setLayout(null);
        ADD_USER_P.setBackground(new Color(153,153,153));

        ADD_USER_L = new JLabel("ADD USER");
        ADD_USER_L.setFont(new Font("Serif", Font.BOLD,25));
        ADD_USER_L.setBounds(160,50,500,35);
        ADD_USER_L.setForeground(new Color(51,51,51));
        ADD_USER_P.add(ADD_USER_L);

        Fname_L = new JLabel("First Name :");
        Fname_L.setFont(new Font("Serif", Font.BOLD,15));
        Fname_L.setBounds(50,130,120,30);
        ADD_USER_P.add(Fname_L);

        Fname_T = new JTextField();
        Fname_T.setBounds(200,130,200,30);
        ADD_USER_P.add(Fname_T);

        Lname_L = new JLabel("Last Name :");
        Lname_L.setFont(new Font("Serif", Font.BOLD,15));
        Lname_L.setBounds(50,180,120,30);
        ADD_USER_P.add(Lname_L);

        Lname_T = new JTextField(20);
        Lname_T.setBounds(200,180,200,30);
        ADD_USER_P.add(Lname_T);

        Email_L = new JLabel("Email :");
        Email_L.setFont(new Font("Serif", Font.BOLD,15));
        Email_L .setBounds(50,230,120,30);
        ADD_USER_P.add(Email_L );

        Email_T = new JTextField(20);
        Email_T.setBounds(200,230,200,30);
        ADD_USER_P.add(Email_T);

        PhoneNo_L = new JLabel("Phone No :");
        PhoneNo_L.setFont(new Font("Serif", Font.BOLD,15));
        PhoneNo_L.setBounds(50,280,120,30);
        ADD_USER_P.add(PhoneNo_L);

        PhoneNo_T = new JTextField(20);
        PhoneNo_T.setBounds(200,280,200,30);
        ADD_USER_P.add(PhoneNo_T);

        Age_L = new JLabel("Age :");
        Age_L.setFont(new Font("Serif", Font.BOLD,15));
        Age_L.setBounds(50,330,120,30);
        ADD_USER_P.add(Age_L);

        Age_T = new JTextField(20);
        Age_T.setBounds(200,330,200,30);
        ADD_USER_P.add(Age_T);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,390,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_USER_P.add(Back_B);

        Submit_B = new JButton("SUBMIT");
        Submit_B.setBounds(280,390,80,25);

        Submit_B.setBackground(Color.BLUE);
        Submit_B.setForeground(Color.white);
        ADD_USER_P.add(Submit_B);

        setVisible(true);
        ADDUser_GUI.MyListener listener = new ADDUser_GUI.MyListener();
        Submit_B.addActionListener(listener);
        Back_B.addActionListener(listener);

    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equalsIgnoreCase("SUBMIT")){
            User U1 = new User(  Fname_T.getText(), Lname_T.getText(), Email_T.getText(), PhoneNo_T.getText(), Integer.parseInt(Age_T.getText()));
            JOptionPane.showMessageDialog(null, "User Data Entry Successful\nUSER NAME:\n"+
                    U1.getUserName()+"\nPASSWORD:\n"+U1.getPassword());
            User.writeToFile(U1);
            dispose();
            User_GUI M=new User_GUI();}
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                User_GUI N=new User_GUI();
            }
        }
    }
}
