package com.company;

import java.io.*;
import java.util.ArrayList;

public class User extends Person implements Serializable {
    private String Status;
    private int NO_OF_TRIPS;
    private int Age;

    public User( String FirstName, String LastName, String Email,String PhoneNo, int Age) {
        super(FirstName, LastName, Email, PhoneNo);
        super.setUserName(User_PassWord());
        super.setPassword(User_PassWord());
        this.NO_OF_TRIPS = Display_no_of_trips(super.getUserName());
        this.Age = Age;
        this.Status=Find_Status();
    }

    public User(User u){
        super(u);
        this.NO_OF_TRIPS =u.NO_OF_TRIPS;
        this.Age = u.Age;
        this.Status=u.Status;
    }


    public String Find_Status(){
        if(User.Display_no_of_trips(super.getUserName())>=10){
           return this.Status="Platinum (VIP)";
        }
        else if (User.Display_no_of_trips(super.getUserName())>5){
           return this.Status="Gold";
        }
        else if (User.Display_no_of_trips(super.getUserName())>3){
            return this.Status="Silver";
        }
        else{
            return this.Status="Ordinary";
        }
    }
    private String User_PassWord() {
        String User_Password= "";
        try {
            ArrayList<User> list = readFromFile();
            int Size = list.size();

            User_Password =getFirstName() + (Size+1);
        } catch (Exception e) {
            System.out.println("Error");
        }
        return User_Password;
    }


    private static int Display_no_of_trips(String UserName){
        ArrayList<User> list = readFromFile();
        if(SearchUser(UserName)){
            for(User Customer:list){
                if(Customer.getUserName().equalsIgnoreCase(UserName)){
                    return Customer.getNO_OF_TRIPS();
                }
            }
        }
        return 0;
    }

    public static void writeToFile(User Customer){
        ArrayList<User> list = readFromFile();
        list.add(Customer);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("UserData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static ArrayList<User> readFromFile() {
        ArrayList<User> list = new ArrayList<User>();
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("UserData"));
            list = (ArrayList<User>) input.readObject();
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



    public static void updateFile(ArrayList<User> list){

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("UserData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void updateUser(String UserName,User Cust,String newUserName, String newPassword){
        ArrayList<User> list = readFromFile();

        for(User Customer:list){
            if(Customer.getUserName().equalsIgnoreCase(UserName)){
                Customer.setFirstName(Cust.getFirstName());
                Customer.setLastName(Cust.getLastName());
                Customer.setPassword(newPassword);
                Customer.setUserName(newUserName);
                Customer.setEmail(Cust.getEmail());
                Customer.setPhoneNo(Cust.getPhoneNo());
                Customer.setAge(Cust.getAge());
                Customer.setNO_OF_TRIPS(Cust.getNO_OF_TRIPS());
                Customer.setStatus(Cust.getStatus());
                updateFile(list);
                break;
            }
        }
    }

    public static boolean SearchUser(String UserName){
        ArrayList<User> list = readFromFile();

        for(User Customer:list){

            if(Customer.getUserName().equalsIgnoreCase(UserName)){
                return true;
            }
        }
        return false;
    }

    public static boolean SearchPassword(String Username,String Password){
        ArrayList<User> list = readFromFile();

        for(User Customer:list){

            if(Customer.getUserName().equalsIgnoreCase(Username) && Customer.getPassword().equalsIgnoreCase(Password)){
                return true;
            }
        }
        return false;
    }

    public static String DisplayUser_Record(String UserName){
        ArrayList<User> list = readFromFile();
        if(SearchUser(UserName)){
            for(User Customer:list){
                if(Customer.getUserName().equalsIgnoreCase(UserName)){

                    return "First Name :    "+Customer.getFirstName()+"\nLast Name:    "+Customer.getLastName()+"\n" +
                            "User Name :    "+Customer.getUserName()+"\nPassword :    "+Customer.getPassword()+"\n" +
                            "Status :    "+Customer.getStatus()+"\nNo of Trips Taken :   "+Customer.getNO_OF_TRIPS();

                }
            }
        }
        return  "User not found";

    }

    public static String DeleteUser_Record(String UserName){
        ArrayList<User> list = readFromFile();
        if(SearchUser(UserName)){
            for(User Customer:list){
                if(Customer.getUserName().equalsIgnoreCase(UserName)){
                    list.remove(Customer);
                    User.updateFile(list);
                    return "User Data Deleted Successfully";

                }
            }
        }
        return  "User not found";

    }

    public String getStatus() { return Status; }
    public void setStatus(String status) { Status = status; }

    public int getAge() { return Age; }
    public void setAge(int age) { Age = age; }

    public int getNO_OF_TRIPS() { return NO_OF_TRIPS; }
    public void setNO_OF_TRIPS(int NO_OF_TRIPS) { this.NO_OF_TRIPS = NO_OF_TRIPS; }
}
