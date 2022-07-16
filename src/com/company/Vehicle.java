package com.company;

import java.io.*;
import java.util.ArrayList;

public class Vehicle  implements Serializable {

    private String Vehicle_Type;
    private String Vehicle_No;
    private int Capacity;
    private Double Vehicle_Rent_For_24hours;
    private boolean Availability;


    public Vehicle(String VehicleTyp, String VehiclNo,double VehicleRent, int Cap){
        if((Cap%8==0||Cap==4 ) && Cap<=64){
            this.Vehicle_Type=VehicleTyp;
            this.Vehicle_No=VehiclNo;
            this.Capacity=Cap;
            this.Vehicle_Rent_For_24hours =VehicleRent;
            this.Availability=true;
        }else{
            System.out.println("Vehicle capacity not valid\nVehicle capacity e.g:4,8,16,32,64 ");
        }
    }
    public Vehicle(Vehicle V){
        this.Vehicle_Type=V.Vehicle_Type;
        this.Vehicle_No=V.Vehicle_No;
        this.Capacity=V.Capacity;
        this.Vehicle_Rent_For_24hours =V.Vehicle_Rent_For_24hours;
        this.Availability=V.Availability;
    }

    public static void writeToFile(Vehicle V){
        ArrayList<Vehicle> list = readFromFile();
        list.add(V);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("VehicleData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error Write Veh");
        }
    }

    public static ArrayList<Vehicle> readFromFile() {
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("VehicleData"));
            list = (ArrayList<Vehicle>) input.readObject();
            input.close();
        }
        catch (IOException e){
            System.out.println("Error Read VEh");
        }
        catch (ClassNotFoundException e1){
            System.out.println("Class Not found");
        }
        return list;
    }

    public String getVehicle_Type() {
        return Vehicle_Type;
    }

    public void setVehicle_Type(String vehicle_Type) {
        Vehicle_Type = vehicle_Type;
    }

    public String getVehicle_No() {
        return Vehicle_No;
    }

    public void setVehicle_No(String vehicle_No) {
        Vehicle_No = vehicle_No;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public Double getVehicle_Rent_For_24hours() {
        return Vehicle_Rent_For_24hours;
    }

    public void setVehicle_Rent_For_24hours(Double vehicle_Rent_For_24hours) {
        Vehicle_Rent_For_24hours = vehicle_Rent_For_24hours;
    }
}
