package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DELETEUser_GUI extends JFrame{
    JButton Delete_B, Back_B;
    JLabel DELETE_USER_L,Username_L;
    JTextField Username_T;

    public DELETEUser_GUI() {
        JPanel ADD_USER_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_USER_P);
        ADD_USER_P.setLayout(null);
        ADD_USER_P.setBackground(new Color(153,153,153));

        DELETE_USER_L = new JLabel("DELETE USER");
        DELETE_USER_L.setFont(new Font("Serif", Font.BOLD,25));
        DELETE_USER_L.setBounds(150,20,500,35);
        DELETE_USER_L.setForeground(new Color(51,51,51));
        ADD_USER_P.add(DELETE_USER_L);

        Username_L = new JLabel("Username : ");
        Username_L.setFont(new Font("Serif", Font.BOLD,15));
        Username_L.setBounds(50,150,120,30);
        ADD_USER_P.add(Username_L);

        Username_T = new JTextField();
        Username_T.setBounds(200,150,200,30);
        ADD_USER_P.add(Username_T);

        Delete_B = new JButton("DELETE");
        Delete_B.setBounds(260,210,100,25);
        Delete_B.setBackground(Color.BLUE);
        Delete_B.setForeground(Color.white);
        ADD_USER_P.add(Delete_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,210,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_USER_P.add(Back_B);


        setVisible(true);
        DELETEUser_GUI.MyListener listener = new DELETEUser_GUI.MyListener();
        Delete_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("DELETE")){
                String UnameGUI=Username_T.getText();
                JOptionPane.showMessageDialog(null, User.DeleteUser_Record(UnameGUI));
                dispose();
                User_GUI U=new User_GUI();
            }
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                User_GUI N=new User_GUI();
            }
        }
    }
}
