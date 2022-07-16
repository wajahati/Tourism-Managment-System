package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LOGINUser_GUI extends JFrame{
    JButton LOGIN_B, Back_B;
    JLabel LOGIN_USER_L,Username_L,Password_L;
    JTextField Username_T,Password_T;

    LOGINUser_GUI(){
        JPanel LOGIN_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(LOGIN_USER_P);
        LOGIN_USER_P.setLayout(null);
        LOGIN_USER_P.setBackground(new Color(153,153,153));

        LOGIN_USER_L = new JLabel("LOGIN USER");
        LOGIN_USER_L.setFont(new Font("Serif", Font.BOLD,25));
        LOGIN_USER_L.setBounds(150,20,500,35);
        LOGIN_USER_L.setForeground(new Color(51,51,51));
        LOGIN_USER_P.add(LOGIN_USER_L);

        Username_L = new JLabel("Username : ");
        Username_L.setFont(new Font("Serif", Font.BOLD,15));
        Username_L.setBounds(50,150,120,30);
        LOGIN_USER_P.add(Username_L);

        Username_T = new JTextField();
        Username_T.setBounds(200,150,200,30);
        LOGIN_USER_P.add(Username_T);

        Password_L = new JLabel("Password : ");
        Password_L.setFont(new Font("Serif", Font.BOLD,15));
        Password_L.setBounds(50,200,120,30);
        LOGIN_USER_P.add(Password_L);

        Password_T = new JTextField();
        Password_T.setBounds(200,200,200,30);
        LOGIN_USER_P.add(Password_T);

        LOGIN_B = new JButton("LOGIN");
        LOGIN_B.setBounds(260,260,100,25);
        LOGIN_B.setBackground(Color.BLUE);
        LOGIN_B.setForeground(Color.white);
        LOGIN_USER_P.add(LOGIN_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,260,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        LOGIN_USER_P.add(Back_B);

        setVisible(true);
        LOGINUser_GUI.MyListener listener = new LOGINUser_GUI.MyListener();
        LOGIN_B.addActionListener(listener);
        Back_B.addActionListener(listener);

    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Tourism_Managment_System M=new Tourism_Managment_System();
            }
            if (e.getActionCommand().equalsIgnoreCase("LOGIN")) {
                String UnameGUI = Username_T.getText();
                String Password= Password_T.getText();
                if (User.SearchUser(UnameGUI)) {
                    ArrayList<User> list = User.readFromFile();
                    for(User Customer:list){
                        if(Customer.getUserName().equalsIgnoreCase(UnameGUI) && Customer.getPassword().equalsIgnoreCase(Password)){
                            JOptionPane.showMessageDialog(null, "User Found \nPress OK to select Package");
                            dispose();
                            Package_GUI P=new Package_GUI(Customer);
                        }
                        else if (Customer.getUserName().equalsIgnoreCase(UnameGUI) && !Customer.getPassword().equals(Password)){
                            JOptionPane.showMessageDialog(null, "Password Incorrect");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User not found");


                }
            }
        }

    }


}
