package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ADD_TOUR_PackageGUI extends JFrame {
    JButton Next_B, Back_B, Preview_B;
    JLabel DESTINATION_TRIP_L,From_Trips_L,To_Trips_L, Capacity_L , NoOfDays_L, Date_L, No_Room_L  ,Note_L;
    JTextField NoOfDays_T,Date_T;
    JComboBox<String> From_Trips_CB, To_Trips_CB,Capacity_CB, Month_CB,Year_CB, No_Room_CB;

    User CUSTOMER;

ADD_TOUR_PackageGUI(User CUSTO){

        this.CUSTOMER=CUSTO;

        JPanel ADD_DES_L = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_DES_L);
        ADD_DES_L.setLayout(null);
        ADD_DES_L.setBackground(new Color(153,153,153));

        DESTINATION_TRIP_L = new JLabel("ADD PACKAGE DETAILS");
        DESTINATION_TRIP_L.setFont(new Font("Serif", Font.BOLD,25));
        DESTINATION_TRIP_L.setBounds(100,20,500,35);
        DESTINATION_TRIP_L.setForeground(new Color(51,51,51));
        ADD_DES_L.add(DESTINATION_TRIP_L);

        From_Trips_L = new JLabel("TRIPS FROM :");
        From_Trips_L.setFont(new Font("Serif", Font.BOLD,15));
        From_Trips_L.setBounds(50,150,120,30);
        ADD_DES_L.add(From_Trips_L);

        From_Trips_CB = new JComboBox<String>(PACKAGE_INFO.TRIPS_FROM);
        From_Trips_CB.setBounds(200,150,200,30);
        ADD_DES_L.add(From_Trips_CB);

        To_Trips_L = new JLabel("TRIP To :");
        To_Trips_L.setFont(new Font("Serif", Font.BOLD,15));
        To_Trips_L.setBounds(50,200,120,30);
        ADD_DES_L.add(To_Trips_L);

        To_Trips_CB = new JComboBox<String>(PACKAGE_INFO.TRIPS_TO);
        To_Trips_CB.setBounds(200,200,200,30);
        ADD_DES_L.add(To_Trips_CB);

        Capacity_L = new JLabel("Capacity Req : ");
        Capacity_L.setFont(new Font("Serif", Font.BOLD,15));
        Capacity_L .setBounds(50,250,120,30);
        ADD_DES_L.add(Capacity_L );

        Capacity_CB = new JComboBox<String>(PACKAGE_INFO.CAPACITY);
        Capacity_CB.setBounds(200,250,200,30);
        ADD_DES_L.add(Capacity_CB);

        NoOfDays_L = new JLabel("No Of Days :");
        NoOfDays_L.setFont(new Font("Serif", Font.BOLD,15));
        NoOfDays_L.setBounds(50,300,120,30);
        ADD_DES_L.add(NoOfDays_L);

        NoOfDays_T = new JTextField(20);
        NoOfDays_T.setBounds(200,300,200,30);
        ADD_DES_L.add(NoOfDays_T);

        Date_L = new JLabel("Date :");
        Date_L.setFont(new Font("Serif", Font.BOLD,15));
        Date_L.setBounds(50,350,120,30);
        ADD_DES_L.add(Date_L);

        Date_T = new JTextField(20);
        Date_T.setBounds(200,350,40,30);
        ADD_DES_L.add(Date_T);

        Month_CB = new JComboBox<String>(PACKAGE_INFO.MONTH);
        Month_CB.setBounds(270,350,40,30);
        ADD_DES_L.add(Month_CB);

        Year_CB = new JComboBox<String>(PACKAGE_INFO.YEAR);
        Year_CB.setBounds(340,350,60,30);
        ADD_DES_L.add(Year_CB);

        No_Room_L = new JLabel("No Of Rooms : ");
        No_Room_L.setFont(new Font("Serif", Font.BOLD,15));
        No_Room_L.setBounds(50,400,120,30);
        ADD_DES_L.add(No_Room_L);

        No_Room_CB = new JComboBox<String>(PACKAGE_INFO.ROOMS);
        No_Room_CB.setBounds(200,400,200,30);
        ADD_DES_L.add(No_Room_CB);

        Next_B = new JButton("NEXT");
        Next_B.setBounds(280,460,80,25);
        Next_B.setBackground(Color.BLUE);
        Next_B.setForeground(Color.white);
        ADD_DES_L.add(Next_B);

        Preview_B = new JButton("PREVIEW");
        Preview_B.setBounds(170,460,100,25);
        Preview_B.setBackground(Color.BLUE);
        Preview_B.setForeground(Color.white);
        ADD_DES_L.add(Next_B);

        Back_B = new JButton("BACK");
        Back_B.setBounds(80,460,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_DES_L.add(Back_B);

        Note_L = new JLabel("NOTE : Preview data, Once data is saved no changes can be made.");
        Note_L.setFont(new Font("Serif", Font.BOLD,15));
        Note_L.setBounds(20,540,440,30);
        ADD_DES_L.add(Note_L);

        setVisible(true);
        ADD_TOUR_PackageGUI.MyListener listener = new ADD_TOUR_PackageGUI.MyListener();
        Next_B.addActionListener(listener);
        Back_B.addActionListener(listener);
        Preview_B.addActionListener(listener);

    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Package_GUI a = new Package_GUI(CUSTOMER);
            }
            else{

                String FROM = (String) From_Trips_CB.getSelectedItem();
                String To = (String) To_Trips_CB.getSelectedItem();
                int Cap = Integer.parseInt((String) Capacity_CB.getSelectedItem());
                int No_Of_Days = Integer.parseInt(NoOfDays_T.getText());
                int Date = Integer.parseInt(Date_T.getText());
                int Month = Integer.parseInt((String) Month_CB.getSelectedItem());
                int Year = Integer.parseInt((String) Year_CB.getSelectedItem());
                int Room = Integer.parseInt((String) No_Room_CB.getSelectedItem());

                if (e.getActionCommand().equalsIgnoreCase("PREVIEW")) {
                    JOptionPane.showMessageDialog(null, "\nTrip FROM : " + FROM + "\nTRIP TO : " + To + "\nCapacity Rec :"
                            + Cap + "\nNo Of Days : " + No_Of_Days + "\nDate :" + Date + "/" + Month + "/" + Year + "\nNo Of Rooms :" + Room);
                }
                if  (e.getActionCommand().equalsIgnoreCase("NEXT"))  {

                    Date DA = new Date(Date, Month, Year);
                    Destination D = new Destination(FROM, To);
                    Package P = new Package(D, Cap, No_Of_Days, DA, Room);

                    ArrayList<Vehicle> V = Vehicle.readFromFile();
                    ArrayList<Hotel> H = Hotel.readFromFile();
                    ArrayList<Organizer> O = Organizer.readFromFile();

                    Tour_Confirmation T = new Tour_Confirmation(CUSTOMER, O, P, V, H);
                    Tour_Confirmation.writeToFile(T);
                    Tour_Confirmation.readFromFile();

                    JOptionPane.showMessageDialog(null,Tour_Confirmation.displayAllData(CUSTOMER.getUserName(),CUSTOMER.getPassword()));
                    dispose();
                    Package_GUI PPPP=new Package_GUI(CUSTOMER);

                }
            }
        }
    }
}
