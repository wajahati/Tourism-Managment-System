package com.company;

import java.io.*;
import java.util.ArrayList;

public class Hotel  implements Serializable {
    private String Hotel_Name;
    private Address Location;
    private double Room_Cost_For_1_Night;


    public Hotel(String hotel_Name, Address location, double room_Cost_For_1_Night) {
        this.Hotel_Name = hotel_Name;
        this.Location = location;
        this.Room_Cost_For_1_Night = room_Cost_For_1_Night;
    }

    public Hotel(Hotel H){
        this.Hotel_Name = H.Hotel_Name;
        this.Location = H.Location;
        this.Room_Cost_For_1_Night = H.Room_Cost_For_1_Night;

    }

    public static void writeToFile(Hotel H){
        ArrayList<Hotel> list = readFromFile();
        list.add(H);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("HotelData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error write hotel");
        }
    }

    public static ArrayList<Hotel> readFromFile() {
        ArrayList<Hotel> list = new ArrayList<Hotel>();
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("HotelData"));
            list = (ArrayList<Hotel>) input.readObject();
            input.close();
        }
        catch (IOException e){
            System.out.println("Error  read Hotel");
        }
        catch (ClassNotFoundException e1){
            System.out.println("Class Not found");
        }
        return list;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }
    public void setHotel_Name(String hotel_Name) {
        Hotel_Name = hotel_Name;
    }

    public Address getLocation() {
        return Location;
    }
    public void setLocation(Address location) {
        Location = location;
    }

    public double getRoom_Cost_For_1_Night() {
        return Room_Cost_For_1_Night;
    }
    public void setRoom_Cost_For_1_Night(double room_Cost_For_1_Night) { Room_Cost_For_1_Night = room_Cost_For_1_Night; }
}
