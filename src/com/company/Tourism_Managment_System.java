package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tourism_Managment_System extends JFrame {

    JButton Company_B, User_B,Tour_Con_B, Help_B ,Exit_B;
    JLabel Menu_L,Company_L;


    public Tourism_Managment_System (){
        JPanel Menu_P = new JPanel();
        setSize(500, 700);
        setTitle("TOURISM NETWORK");
        add(Menu_P);
        Menu_P.setLayout(null);
        Menu_P.setBackground(new Color(153,153,153));

        Company_L = new JLabel("TOURISM NETWORK");
        Company_L.setFont(new Font("Serif", Font.BOLD,35));
        Company_L.setBounds(65,10,400,35);
        Company_L.setForeground(new Color(51,51,51));
        Menu_P.add(Company_L);

        Menu_L = new JLabel("MAIN MENU");
        Menu_L.setFont(new Font("Serif", Font.BOLD,30));
        Menu_L.setBounds(145,60,300,30);
        Menu_L.setForeground(new Color(51,51,51));
        Menu_P.add(Menu_L);

        Company_B = new JButton("COMPANY");
        Company_B.setBounds(100,160,120,80);
        Company_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Company_B);

        User_B = new JButton("USER");
        User_B.setBounds(240,160,120,80);
        User_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(User_B);

        Tour_Con_B = new JButton("TOUR CONFIRMATION");
        Tour_Con_B.setBounds(100,280,260,80);
        Tour_Con_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Tour_Con_B);

        Help_B = new JButton("HELP");
        Help_B.setBounds(280,400,80,25);
        Help_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Help_B);

        Exit_B = new JButton("EXIT");
        Exit_B.setBounds(100,400,80,25);
        Exit_B.setBackground(Color.BLUE);
        Exit_B.setForeground(Color.white);
        Exit_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Exit_B);

        setVisible(true);

        MyListener listener = new MyListener();
        Company_B.addActionListener(listener);
        User_B.addActionListener(listener);
        Tour_Con_B.addActionListener(listener);
        Help_B.addActionListener(listener);
        Exit_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("USER")) {
                dispose();
                User_GUI u=new User_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("COMPANY")) {
                dispose();
                Company_GUI C=new Company_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("TOUR CONFIRMATION")){
                dispose();
                LOGINUser_GUI G=new LOGINUser_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("HELP")){
                Company C=Company.readFromFile();
                JOptionPane.showMessageDialog(null, "For Any Query Contact us at : \n "+C.getCompany_PhoneNo()+"\n or vist out main office at \nOffice No : "+C.getCompany_location().getOfficeNo()+"\nPlaza No :  "+C.getCompany_location().getPlazaName()+", "+C.getCompany_location().getCity());
            } else {
                dispose();
            }
        }
    }

}
