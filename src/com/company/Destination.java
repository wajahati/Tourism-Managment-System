package com.company;

import java.io.Serializable;

public class Destination implements Serializable {
    private String Trip_From;
    private String Trip_To;

    public Destination(String trip_From, String trip_To){
        if(  (trip_From.equalsIgnoreCase("Islamabad") ||trip_From.equalsIgnoreCase("Lahore")  ) &&
                ( trip_To.equalsIgnoreCase("Murree") || trip_To.equalsIgnoreCase("Swat")
                        || trip_To.equalsIgnoreCase("Naran"))) {
            this.Trip_From = trip_From;
            this.Trip_To = trip_To;

        }
        else{
            System.out.println("Our Tourism Services From"+trip_From+" to "+trip_To+"  "+" Does Not Exist");
        }
    }
    public Destination(Destination D){
        this.Trip_From=D.Trip_From;
        this.Trip_To=D.Trip_To;
    }

    public String getTrip_From() {
        return Trip_From;
    }
    public void setTrip_From(String trip_From) {
        Trip_From = trip_From;
    }

    public String getTrip_To() {
        return Trip_To;
    }
    public void setTrip_To(String trip_To) {
        Trip_To = trip_To;
    }
}


