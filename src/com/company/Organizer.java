package com.company;

import java.io.*;
import java.util.ArrayList;

public class Organizer extends Person  implements Serializable {


    private String Designation;
    private boolean IsAvaliable;


    public Organizer( String FirstName, String LastName,String Email, String PhoneNo,String Designation, boolean Avaliable){
        super(  FirstName, LastName,Email, PhoneNo);
        super.setUserName(User_PassWord());
        super.setPassword(User_PassWord());
        this.Designation=Designation;
        this.IsAvaliable=Avaliable;
    }

    public Organizer(Organizer O){
        super(O);
        this.Designation=O.Designation;
    }


    private String User_PassWord() {
        String User_Password= "";
        try {
            ArrayList<Organizer> list = Organizer.readFromFile();
            int Size = list.size();

            User_Password =getFirstName() + (Size+1);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return User_Password;

    }


    public static void writeToFile(Organizer Employee){
        ArrayList<Organizer> list = readFromFile();
        list.add(Employee);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("OrganizerData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static ArrayList<Organizer> readFromFile() {
        ArrayList<Organizer> list = new ArrayList<Organizer>();
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("OrganizerData"));
            list = (ArrayList<Organizer>) input.readObject();
            input.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        catch (ClassNotFoundException e1){
            System.out.println("Class Not found");
        }
        return list;
    }



    public static void updateFile(ArrayList<Organizer> list){

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("OrganizerData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void updateEmployee(String UserName,Organizer Emp,String newUserName, String newPassword){
        ArrayList<Organizer> list = readFromFile();

        for(Organizer Employee:list){
            if(Employee.getUserName().equalsIgnoreCase(UserName)){
                Employee.setFirstName(Emp.getFirstName());
                Employee.setLastName(Emp.getLastName());
                Employee.setPassword(newPassword);
                Employee.setUserName(newUserName);
                Employee.setEmail(Emp.getEmail());
                Employee.setPhoneNo(Emp.getPhoneNo());
                Employee.setDesignation(Emp.getDesignation());
                Employee.setAvaliable(Emp.isAvaliable());
                updateFile(list);
                break;
            }
        }
    }

    public static boolean SearchEmployee(String UserName){
        ArrayList<Organizer> list = readFromFile();

        for(Organizer Employee:list){

            if(Employee.getUserName().equalsIgnoreCase(UserName)){
                return true;
            }
        }
        return false;
    }

    public static boolean SearchPassword(String Username,String Password){
        ArrayList<Organizer> list = readFromFile();

        for(Organizer Employee:list){

            if(Employee.getUserName().equalsIgnoreCase(Username) && Employee.getPassword().equalsIgnoreCase(Password)){
                return true;
            }
        }
        return false;
    }

    public static String DisplayEmployee_Record(String UserName){
        ArrayList<Organizer> list = readFromFile();
        if(SearchEmployee(UserName)){
            for(Organizer Employee:list){
                if(Employee.getUserName().equalsIgnoreCase(UserName)){

                    return "First Name :    "+Employee.getFirstName()+"\nLast Name:    "+Employee.getLastName()+"\n" +
                            "User Name :    "+Employee.getUserName()+"\nPassword :    "+Employee.getPassword()+"\n" +
                            "Designation :    "+Employee.getDesignation()+"\nAvailability :   "+Employee.isAvaliable();

                }
            }
        }
        return  "User not found";

    }

    public static String DeleteEmployee_Record(String UserName){
        ArrayList<Organizer> list = readFromFile();
        if(SearchEmployee(UserName)){
            for(Organizer Employee:list){
                if(Employee.getUserName().equalsIgnoreCase(UserName)){
                    list.remove(Employee);
                    Organizer.updateFile(list);
                    return "Employee Data Deleted Successfully";

                }
            }
        }
        return  "Employee not found";

    }



    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public boolean isAvaliable() {
        return IsAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        IsAvaliable = avaliable;
    }
}
