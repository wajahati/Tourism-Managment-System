package com.company;

import java.io.Serializable;

public class Package implements Serializable {

    private Destination location_For_trip;
    private int Capacity_Required;
    private int Trip_For_No_of_Days;
    private Date Starting_Date;
    private int No_of_Room_required;

    public Package(Destination locationofTrip, int capacity_Required, int trip_For_No_of_Days,Date StartingDate, int NoOFRoomReq) {
            this.location_For_trip=locationofTrip;
            this.Capacity_Required = capacity_Required;
            this.Trip_For_No_of_Days = trip_For_No_of_Days;
            this.Starting_Date = new Date(StartingDate);
            this.No_of_Room_required=NoOFRoomReq;

    }

    public Package(Package P){
        this.location_For_trip=new Destination(P.location_For_trip);
        this.Capacity_Required=P.Capacity_Required;
        this.Trip_For_No_of_Days=P.Trip_For_No_of_Days;
        this.Starting_Date=new Date(P.Starting_Date);
        this.No_of_Room_required=P.No_of_Room_required;
    }

    public int getCapacity_Required() {
        return Capacity_Required;
    }

    public void setCapacity_Required(int capacity_Required) {
        Capacity_Required = capacity_Required;
    }

    public int getTrip_For_No_of_Days() {
        return Trip_For_No_of_Days;
    }

    public void setTrip_For_No_of_Days(int trip_For_No_of_Days) {
        Trip_For_No_of_Days = trip_For_No_of_Days;
    }

    public Date getStarting_Date() {
        return Starting_Date;
    }

    public void setStarting_Date(Date starting_Date) {
        Starting_Date = starting_Date;
    }

    public int getNo_of_Room_required() {
        return No_of_Room_required;
    }

    public void setNo_of_Room_required(int no_of_Room_required) {
        No_of_Room_required = no_of_Room_required;
    }

    public Destination getLocation_For_trip() {
        return location_For_trip;
    }

    public void setLocation_For_trip(Destination location_For_trip) {
        this.location_For_trip = location_For_trip;
    }
}
