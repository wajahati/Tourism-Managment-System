package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COST_BILL_GUI extends JFrame{
    JLabel COST_BILL,Cost_Veh_L1, Cost_Veh_L2,Cost_Hot_L1, Cost_Hot_L2, Total_Cost_L1, Total_Cost_L2, Cost_After_Commission_L1,
            Cost_After_Commission_L2,Cost_After_Discount_L1,Cost_After_Discount_L2;
    Tour_Confirmation TOURIST;
    User CUSTOMER;
    JButton BACK_B;

    COST_BILL_GUI(User CUSTO,Tour_Confirmation Tourist){
        this.CUSTOMER=CUSTO;
        this.TOURIST=Tourist;
        JPanel ADD_DES_L = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_DES_L);
        ADD_DES_L.setLayout(null);
        ADD_DES_L.setBackground(new Color(153,153,153));

        COST_BILL = new JLabel("COST FOR TOUR");
        COST_BILL.setFont(new Font("Serif", Font.BOLD,25));
        COST_BILL.setBounds(150,20,500,35);
        COST_BILL.setForeground(new Color(51,51,51));
        ADD_DES_L.add(COST_BILL);

        Cost_Veh_L1 = new JLabel("Cost for vehicle :");
        Cost_Veh_L1.setFont(new Font("Serif", Font.BOLD,15));
        Cost_Veh_L1.setBounds(50,150,170,30);
        ADD_DES_L.add(Cost_Veh_L1);

        Cost_Veh_L2 = new JLabel(String.valueOf(TOURIST.Calculate_Total_For_Vehicle()));
        Cost_Veh_L2.setBounds(240,150,200,30);
        ADD_DES_L.add(Cost_Veh_L2);

        Cost_Hot_L1 = new JLabel("Cost for hotel :");
        Cost_Hot_L1.setFont(new Font("Serif", Font.BOLD,15));
        Cost_Hot_L1.setBounds(50,200,170,30);
        ADD_DES_L.add(Cost_Hot_L1);

        Cost_Hot_L2 = new JLabel(String.valueOf(TOURIST.Calculate_Total_For_Hotel()));
        Cost_Hot_L2.setBounds(240,200,200,30);
        ADD_DES_L.add(Cost_Hot_L2);

        Total_Cost_L1 = new JLabel("Combine Cost : ");
        Total_Cost_L1.setFont(new Font("Serif", Font.BOLD,15));
        Total_Cost_L1 .setBounds(50,250,170,30);
        ADD_DES_L.add(Total_Cost_L1 );

        Total_Cost_L2 = new JLabel(String.valueOf(TOURIST.Total_Cost_For_V_H()));
        Total_Cost_L2.setBounds(240,250,200,30);
        ADD_DES_L.add(Total_Cost_L2);

        Cost_After_Commission_L1 = new JLabel("Cost After Commission :");
        Cost_After_Commission_L1.setFont(new Font("Serif", Font.BOLD,15));
        Cost_After_Commission_L1.setBounds(50,300,170,30);
        ADD_DES_L.add(Cost_After_Commission_L1);

        Cost_After_Commission_L2 = new JLabel(String.valueOf(TOURIST.Company_Charges_For_Services()));
        Cost_After_Commission_L2.setBounds(240,300,200,30);
        ADD_DES_L.add(Cost_After_Commission_L2);

        Cost_After_Discount_L1 = new JLabel("Final Cost After Dis :");
        Cost_After_Discount_L1.setFont(new Font("Serif", Font.BOLD,15));
        Cost_After_Discount_L1.setBounds(50,350,170,30);
        ADD_DES_L.add(Cost_After_Discount_L1);

        Cost_After_Discount_L2 = new JLabel(String.valueOf(TOURIST.Final_Cost_After_Disc()));
        Cost_After_Discount_L2.setBounds(240,350,200,30);
        ADD_DES_L.add(Cost_After_Discount_L2);

        BACK_B = new JButton("BACK");
        BACK_B.setBounds(100,410,80,25);
        BACK_B.setBackground(Color.BLUE);
        BACK_B.setForeground(Color.white);
        ADD_DES_L.add(BACK_B);

        setVisible(true);
        COST_BILL_GUI.MyListener listener = new COST_BILL_GUI.MyListener();

        BACK_B.addActionListener(listener);
    }
    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Package_GUI a = new Package_GUI(CUSTOMER);
            }
        }
    }
}
