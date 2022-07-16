package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Package_GUI extends JFrame{
    JButton DisplayPACKAGE_B, DeletePACKAGE_B, AddPACKAGE_B,Total_COST_B, Back_B;
    JLabel PACKAGE_L, MAIN_L;
    User CUSTOMER;

    Package_GUI(User Custo){
        this.CUSTOMER=Custo;
        JPanel Menu_P = new JPanel();
        setSize(500, 700);
        setTitle("TOURISM NETWORK");
        add(Menu_P);
        Menu_P.setLayout(null);
        Menu_P.setBackground(new Color(153,153,153));

        MAIN_L = new JLabel("TOUR CONFIRMATION");
        MAIN_L.setFont(new Font("Serif", Font.BOLD,35));
        MAIN_L.setBounds(60,10,400,35);
        MAIN_L.setForeground(new Color(51,0,0));
        Menu_P.add(MAIN_L);

        PACKAGE_L = new JLabel("PACKAGE DATA");
        PACKAGE_L.setFont(new Font("Serif", Font.BOLD,30));
        PACKAGE_L.setBounds(130,60,300,30);
        PACKAGE_L.setForeground(new Color(51,51,51));
        Menu_P.add(PACKAGE_L);

        DisplayPACKAGE_B = new JButton("ADD");
        DisplayPACKAGE_B.setBounds(100,160,120,80);
        DisplayPACKAGE_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(DisplayPACKAGE_B);

        DeletePACKAGE_B = new JButton("DELETE");
        DeletePACKAGE_B.setBounds(240,160,120,80);
        DeletePACKAGE_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(DeletePACKAGE_B);

        AddPACKAGE_B = new JButton("DISPLAY");
        AddPACKAGE_B.setBounds(100,280,260,80);
        AddPACKAGE_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(AddPACKAGE_B);

        Total_COST_B = new JButton("DISPLAY COST");
        Total_COST_B.setBounds(100,400,260,80);
        Total_COST_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Total_COST_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,520,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        Back_B.setFont(new Font("Serif", Font.BOLD,15));
        Menu_P.add(Back_B);

        setVisible(true);

        Package_GUI.MyListener listener = new Package_GUI.MyListener();
        DisplayPACKAGE_B.addActionListener(listener);
        DeletePACKAGE_B.addActionListener(listener);
        AddPACKAGE_B.addActionListener(listener);
        Total_COST_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }

    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("ADD")) {
                if(Tour_Confirmation.SearchUser(CUSTOMER.getUserName(),CUSTOMER.getPassword())){
                    JOptionPane.showMessageDialog(null, "Complete or Delete your previous trip ot schedule another ");
                }else{
                        dispose();
                        ADD_TOUR_PackageGUI P=new ADD_TOUR_PackageGUI(CUSTOMER);}
            } else if (e.getActionCommand().equalsIgnoreCase("DELETE")) {
                dispose();
                DELETEPackage_GUI D=new DELETEPackage_GUI(CUSTOMER);
            } else if (e.getActionCommand().equalsIgnoreCase("DISPLAY")){
                dispose();
                DISPLAY_PACKAGE_GUI DO=new DISPLAY_PACKAGE_GUI(CUSTOMER);
            } else if (e.getActionCommand().equalsIgnoreCase("DISPLAY COST")){

                if(Tour_Confirmation.SearchUser(CUSTOMER.getUserName(),CUSTOMER.getPassword())){
                    dispose();
                    COST_BILL_GUI CB=new COST_BILL_GUI(CUSTOMER,Tour_Confirmation.Display_Tour(CUSTOMER.getUserName(),CUSTOMER.getPassword()));
                }
                else{
                    JOptionPane.showMessageDialog(null, "No data found");
                }

            } else if (e.getActionCommand().equalsIgnoreCase("BACK")){
                dispose();
                Tourism_Managment_System t=new Tourism_Managment_System();
            }
        }
    }
}
