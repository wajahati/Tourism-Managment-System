package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Organizer> O=Organizer.readFromFile();

        Address A1=new Address(123,"I-8 Markaz","Islamabad");

        Company C=new Company("Tourism Network","Naeem Ahmad",O,A1,"000111000");

        Company.writeToFile(C);

        Vehicle V1=new Vehicle("Cultus","LRP-1212",2500,4);
        Vehicle V2=new Vehicle("Wagon-R","LSP-2323",3000,4);
        Vehicle V3=new Vehicle("BRV","RIM-9348",5500,8);
        Vehicle V4=new Vehicle("BRV","RSP-4573",5500,8);
        Vehicle V5=new Vehicle("EVERY","ABD-5996",5000,8);
        Vehicle V6=new Vehicle("HILUX-VIGO","EWA-9573",5500,8);
        Vehicle V7=new Vehicle("HIACE","TDU-0969",6000,16);
        Vehicle V8=new Vehicle("Cultus","LRZ-953",2500,4);

        Vehicle.writeToFile(V1);
        Vehicle.writeToFile(V2);
        Vehicle.writeToFile(V3);
        Vehicle.writeToFile(V4);
        Vehicle.writeToFile(V5);
        Vehicle.writeToFile(V6);
        Vehicle.writeToFile(V7);
        Vehicle.writeToFile(V8);

        Address A2=new Address(11,"123","Swat");
        Address A3=new Address(22,"321","Murree");
        Address A4=new Address(33,"312","Naran");

        Hotel H1=new Hotel("Serena Hotel",A2,6000);
        Hotel H2=new Hotel("Swat Continental",A2,4500);
        Hotel H3=new Hotel("Swat View Hotel",A2,4000);
        Hotel H4=new Hotel("Bright Land Hotel",A3,5000);
        Hotel H5=new Hotel("Pearl Continental Hotel",A3,5500);
        Hotel H6=new Hotel("Millennium Inn Hotel",A4,5500);

        Hotel.writeToFile(H1);
        Hotel.writeToFile(H2);
        Hotel.writeToFile(H3);
        Hotel.writeToFile(H4);
        Hotel.writeToFile(H5);
        Hotel.writeToFile(H6);

        Tourism_Managment_System M=new Tourism_Managment_System();
    }
}
