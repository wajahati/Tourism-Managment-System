package com.company;

import java.io.Serializable;

public class Date implements Serializable {
    int day;
    int month;
    int year;

    public Date(int d, int m, int y){
        if (d<1 || d>31 || m<1 || m>12){
            System.out.println("Invalid Date");
        }
        else {
            this.day = d;
            this.month = m;
            this.year = y;
        }
    }

    public Date (Date dt){
        this.day = dt.day;
        this.month = dt.month;
        this.year = dt.year;
    }

    public int getDay() {
        return day; }
    public void setDay(int day) {
        this.day = day; }


    public int getMonth() {
        return month; }
    public void setMonth(int month) {
        this.month = month; }


    public int getYear() {
        return year; }
    public void setYear(int year) {
        this.year = year; }


}
