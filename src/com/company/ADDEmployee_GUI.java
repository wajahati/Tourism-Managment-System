package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ADDEmployee_GUI extends JFrame{

    JButton Submit_B, Back_B;
    JLabel ADD_Employee_L,Fname_L, Lname_L,Email_L,PhoneNo_L,Designation_L,Availability_L;
    JTextField Fname_T, Lname_T,Email_T,PhoneNo_T;
    JComboBox<String> Designation_CB;
    JCheckBox Availability_CB1,Availability_CB2;

    boolean Availability;

    ADDEmployee_GUI(){

        JPanel ADD_Employee_P = new JPanel();
        setSize(500, 700);
        setTitle("Tourism Network");
        add(ADD_Employee_P);
        ADD_Employee_P.setLayout(null);
        ADD_Employee_P.setBackground(new Color(153,153,153));

        ADD_Employee_L = new JLabel("ADD EMPLOYEE");
        ADD_Employee_L.setFont(new Font("Serif", Font.BOLD,25));
        ADD_Employee_L.setBounds(130,50,500,35);
        ADD_Employee_L.setForeground(new Color(51,51,51));
        ADD_Employee_P.add(ADD_Employee_L);

        Fname_L = new JLabel("First Name :");
        Fname_L.setFont(new Font("Serif", Font.BOLD,15));
        Fname_L.setBounds(50,130,120,30);
        ADD_Employee_P.add(Fname_L);

        Fname_T = new JTextField();
        Fname_T.setBounds(200,130,200,30);
        ADD_Employee_P.add(Fname_T);

        Lname_L = new JLabel("Last Name :");
        Lname_L.setFont(new Font("Serif", Font.BOLD,15));
        Lname_L.setBounds(50,180,120,30);
        ADD_Employee_P.add(Lname_L);

        Lname_T = new JTextField(20);
        Lname_T.setBounds(200,180,200,30);
        ADD_Employee_P.add(Lname_T);

        Email_L = new JLabel("Email :");
        Email_L.setFont(new Font("Serif", Font.BOLD,15));
        Email_L .setBounds(50,230,120,30);
        ADD_Employee_P.add(Email_L );

        Email_T = new JTextField(20);
        Email_T.setBounds(200,230,200,30);
        ADD_Employee_P.add(Email_T);

        PhoneNo_L = new JLabel("Phone No :");
        PhoneNo_L.setFont(new Font("Serif", Font.BOLD,15));
        PhoneNo_L.setBounds(50,280,120,30);
        ADD_Employee_P.add(PhoneNo_L);

        PhoneNo_T = new JTextField(20);
        PhoneNo_T.setBounds(200,280,200,30);
        ADD_Employee_P.add(PhoneNo_T);

        Designation_L = new JLabel("Designation :");
        Designation_L.setFont(new Font("Serif", Font.BOLD,15));
        Designation_L.setBounds(50,330,120,30);
        ADD_Employee_P.add(Designation_L);

        Designation_CB = new JComboBox<String>(PACKAGE_INFO.Designation);
        Designation_CB.setBounds(200,330,200,30);
        ADD_Employee_P.add(Designation_CB);

        Availability_L = new JLabel("Availability :");
        Availability_L.setFont(new Font("Serif", Font.BOLD,15));
        Availability_L.setBounds(50,380,120,30);
        ADD_Employee_P.add(Availability_L);

        Availability_CB1 = new JCheckBox("Yes");
        Availability_CB1.setBounds(200,380,60,30);
        ADD_Employee_P.add(Availability_CB1);

        Availability_CB2 = new JCheckBox("No");
        Availability_CB2.setBounds(270,380,60,30);
        ADD_Employee_P.add(Availability_CB2);

        Back_B = new JButton("BACK");
        Back_B.setBounds(100,440,80,25);
        Back_B.setBackground(Color.BLUE);
        Back_B.setForeground(Color.white);
        ADD_Employee_P.add(Back_B);

        Submit_B = new JButton("SUBMIT");
        Submit_B.setBounds(280,440,80,25);

        Submit_B.setBackground(Color.BLUE);
        Submit_B.setForeground(Color.white);
        ADD_Employee_P.add(Submit_B);

        setVisible(true);
        ADDEmployee_GUI.CheckBoxHandler Handler = new ADDEmployee_GUI.CheckBoxHandler();
        Availability_CB1.addItemListener(Handler);
        Availability_CB2.addItemListener(Handler);

        ADDEmployee_GUI.MyListener listener = new ADDEmployee_GUI.MyListener();
        Submit_B.addActionListener(listener);
        Back_B.addActionListener(listener);
    }

    public class CheckBoxHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event){

            Availability= false;
            if(Availability_CB1.isSelected()&& !Availability_CB2.isSelected()){
                Availability=true;
            } else if(!Availability_CB1.isSelected()&& Availability_CB2.isSelected()){
                Availability=false;
            } else if(Availability_CB1.isSelected()&& Availability_CB2.isSelected()){
                JOptionPane.showMessageDialog(null,"Select One check box only");
            }
        }
    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!Availability_CB1.isSelected()&& !Availability_CB2.isSelected() && e.getActionCommand().equalsIgnoreCase("SUBMIT")){
                JOptionPane.showMessageDialog(null,"Select at least One check box");
            } else if(e.getActionCommand().equalsIgnoreCase("SUBMIT")){
                Organizer O1 = new Organizer(  Fname_T.getText(), Lname_T.getText(), Email_T.getText(), PhoneNo_T.getText(), (String) Designation_CB.getSelectedItem(),Availability);
                JOptionPane.showMessageDialog(null, "Employee Data Entry Successful\nUSER NAME:\n"+
                        O1.getUserName()+"\nPASSWORD:\n"+O1.getPassword());
                Organizer.writeToFile(O1);
                dispose();
                Employee_GUI M=new Employee_GUI();
            } else if (e.getActionCommand().equalsIgnoreCase("BACK")) {
                dispose();
                Employee_GUI N=new Employee_GUI();
            }
        }
    }
}
