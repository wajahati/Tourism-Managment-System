package com.company;

import java.io.*;
import java.util.ArrayList;

public class Tour_Confirmation  implements Serializable,Services_and_Price {
    private User Customer;
    private Organizer Tour_Organizer;
    private Package Tour_Package_Details;
    private Vehicle Vehicle_For_Tour;
    private Hotel Hotel_For_Stay;

    public Tour_Confirmation(User customer, ArrayList<Organizer> tour_Organizer, Package tour_Package_Details,ArrayList <Vehicle> vehicle_For_Tour, ArrayList<Hotel>hotel_For_Stay) {
        this.Customer = customer;
        this.Tour_Package_Details = tour_Package_Details;
        Assign_Organizer(tour_Organizer);
        Assign_Vehicle(vehicle_For_Tour);
        Assign_Hotel(hotel_For_Stay);
    }

    private void Assign_Vehicle(ArrayList<Vehicle> V){
        for(Vehicle TransportVeh: V){
            if(Tour_Package_Details.getCapacity_Required()<=4 && TransportVeh.getCapacity()==4 && TransportVeh.isAvailability()){
                this.Vehicle_For_Tour =TransportVeh;
                break;
            }
            else if(Tour_Package_Details.getCapacity_Required()<=8 && TransportVeh.getCapacity()==8 && TransportVeh.isAvailability()){
                this.Vehicle_For_Tour =TransportVeh;
                break;
            }
            else if(Tour_Package_Details.getCapacity_Required()<=16 && TransportVeh.getCapacity()==16 && TransportVeh.isAvailability()){
                this.Vehicle_For_Tour =TransportVeh;
                break;
            }
            else{
                System.out.println("Vehicle not available");
            }
        }
    }
    private void Assign_Hotel(ArrayList<Hotel>H){
        for (Hotel HotelForStay: H){
            if(Tour_Package_Details.getLocation_For_trip().getTrip_To().equalsIgnoreCase("Murree") &&
                    HotelForStay.getLocation().getCity().equalsIgnoreCase("Murree")){
                this.Hotel_For_Stay=HotelForStay;
                break;
            } else if(Tour_Package_Details.getLocation_For_trip().getTrip_To().equalsIgnoreCase("Swat") &&
                    HotelForStay.getLocation().getCity().equalsIgnoreCase("Swat")){
                this.Hotel_For_Stay=HotelForStay;
                break;
            } else if(Tour_Package_Details.getLocation_For_trip().getTrip_To().equalsIgnoreCase("Naran") &&
                    HotelForStay.getLocation().getCity().equalsIgnoreCase("Naran")){
                this.Hotel_For_Stay=HotelForStay;
                break;
            }
        }
    }

    private void Assign_Organizer(ArrayList<Organizer> O){
        for(Organizer  TourOrganizer: O){
            if(TourOrganizer.isAvaliable()){
                this.Tour_Organizer=TourOrganizer;
                break;
            }
        }
    }

    public double Calculate_Total_For_Vehicle(){
        return Vehicle_For_Tour.getVehicle_Rent_For_24hours()*Tour_Package_Details.getTrip_For_No_of_Days();
    }

    public double Calculate_Total_For_Hotel(){
        return Hotel_For_Stay.getRoom_Cost_For_1_Night()*Tour_Package_Details.getTrip_For_No_of_Days();
    }

    public double Total_Cost_For_V_H(){
        return Calculate_Total_For_Vehicle()+Calculate_Total_For_Hotel();
    }

    public double Company_Charges_For_Services(){
        double charges_in_percentage;
        if(Calculate_Total_For_Hotel()>=20000 && Calculate_Total_For_Vehicle()>=20000){
            charges_in_percentage=20;
        }
        else if(Calculate_Total_For_Hotel()>=15000 && Calculate_Total_For_Vehicle()>=15000){
            charges_in_percentage=15;
        }
        else if(Calculate_Total_For_Hotel()>=8000 && Calculate_Total_For_Vehicle()>=8000){
            charges_in_percentage=8;
        }
        else{
            charges_in_percentage=4;
        }
        return (( Total_Cost_For_V_H()*charges_in_percentage ) / 100) + Total_Cost_For_V_H();
    }

    public double Final_Cost_After_Disc() {
        double Discount;
        if (Customer.getStatus().equalsIgnoreCase("Platinum (VIP)")) {
            Discount =20;
        }else if(Customer.getStatus().equalsIgnoreCase("Gold")){
            Discount=10;
        }else if (Customer.getStatus().equalsIgnoreCase("Silver")){
            Discount=5;
        }else {
            Discount=0;
        }
        return Company_Charges_For_Services()-(Company_Charges_For_Services()*Discount)/100;
    }



    public static void writeToFile(Tour_Confirmation CON){
        ArrayList<Tour_Confirmation> list = readFromFile();
        list.add(CON);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TourData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static ArrayList<Tour_Confirmation> readFromFile() {
        ArrayList<Tour_Confirmation> list = new ArrayList<Tour_Confirmation>();
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("TourData"));
            list = (ArrayList<Tour_Confirmation>) input.readObject();
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

    public static String displayAllData(String UserName, String Password){
        ArrayList<Tour_Confirmation> list = readFromFile();

        for (Tour_Confirmation Confirmation : list){
            if (Confirmation.getCustomer().getUserName().equalsIgnoreCase(UserName) && Confirmation.getCustomer().getPassword().equalsIgnoreCase(Password)) {
                return "Customer Name : " + Confirmation.Customer.getFirstName() + " " + Confirmation.Customer.getLastName() + "\nOrganizer Name : " +
                        Confirmation.Tour_Organizer.getFirstName() + " " + Confirmation.Tour_Organizer.getLastName() + "\nDestination details:\n From :" +
                        Confirmation.Tour_Package_Details.getLocation_For_trip().getTrip_From() + "\nTo : " + Confirmation.Tour_Package_Details.getLocation_For_trip().getTrip_To() +
                        "\nVehicle details : \nType : " + Confirmation.Vehicle_For_Tour.getVehicle_Type() + "\nNumber :" + Confirmation.Vehicle_For_Tour.getVehicle_No() +
                        "\nCapacity : " + Confirmation.Vehicle_For_Tour.getCapacity() + "\nHotel details : \nHotel Name : " + Confirmation.Hotel_For_Stay.getHotel_Name() +
                        "\nAddress :\nPLOT no : " + Confirmation.Hotel_For_Stay.getLocation().getOfficeNo() + ", Street No : " +
                        Confirmation.Hotel_For_Stay.getLocation().getPlazaName() + ", " + Confirmation.Hotel_For_Stay.getLocation().getCity();

            }
        }
        return "Record not found";
    }

    public static void updateFile(ArrayList<Tour_Confirmation> list){

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("TourData"));
            output.writeObject(list);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static String DeleteTourRecord(String UserName, String Password){
        ArrayList<Tour_Confirmation> list = readFromFile();

        for (Tour_Confirmation Confirmation : list){
            if(Confirmation.getCustomer().getUserName().equalsIgnoreCase(UserName) && Confirmation.getCustomer().getPassword().equalsIgnoreCase(Password)){
                list.remove(Confirmation);
                Tour_Confirmation.updateFile(list);
                return "Tour Record Deleted Successfully Data Deleted Successfully";
            }
        }
        return "Record not found";
    }

    public static boolean SearchUser(String UserName,String Password){
        ArrayList<Tour_Confirmation> list = readFromFile();

        for(Tour_Confirmation Confirmation:list){
            if(Confirmation.getCustomer().getUserName().equalsIgnoreCase(UserName) && Confirmation.getCustomer().getPassword().equalsIgnoreCase(Password)){
                return true;
            }
        }
        return false;
    }

    public static Tour_Confirmation Display_Tour(String UserName,String Password){
        ArrayList<Tour_Confirmation> list = readFromFile();

        for(Tour_Confirmation Confirmation:list){
            if(Confirmation.getCustomer().getUserName().equalsIgnoreCase(UserName) && Confirmation.getCustomer().getPassword().equalsIgnoreCase(Password)){
                return Confirmation;
            }
        }
        return null;
    }



    public User getCustomer() {
        return Customer;
    }

    public void setCustomer(User customer) {
        Customer = customer;
    }

    public Organizer getTour_Organizer() {
        return Tour_Organizer;
    }

    public void setTour_Organizer(Organizer tour_Organizer) {
        Tour_Organizer = tour_Organizer;
    }

    public Package getTour_Package_Details() {
        return Tour_Package_Details;
    }

    public void setTour_Package_Details(Package tour_Package_Details) {
        Tour_Package_Details = tour_Package_Details;
    }

    public Vehicle getVehicle_For_Tour() {
        return Vehicle_For_Tour;
    }

    public void setVehicle_For_Tour(Vehicle vehicle_For_Tour) {
        Vehicle_For_Tour = vehicle_For_Tour;
    }

    public Hotel getHotel_For_Stay() {
        return Hotel_For_Stay;
    }

    public void setHotel_For_Stay(Hotel hotel_For_Stay) {
        Hotel_For_Stay = hotel_For_Stay;
    }
}
