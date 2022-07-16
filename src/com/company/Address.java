package com.company;


import java.io.Serializable;

public class Address implements Serializable {
    private  int PlotNo;
    private String StreetNo;
    private String city;

    public Address(int h, String s,String c){
        this.PlotNo =h;
        this.StreetNo =s;
        this.city=c;
    }
    public Address(Address a){
        this.PlotNo =a.PlotNo;
        this.StreetNo =a.StreetNo;
        this.city=a.city;
    }

    public int getOfficeNo() {
        return PlotNo;
    }
    public void setOfficeNo(int officeNo) {
        this.PlotNo = officeNo;
    }

    public String getPlazaName() {
        return StreetNo;
    }
    public void setPlazaName(String plazaName) {
        this.StreetNo = plazaName;
    }


    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}

