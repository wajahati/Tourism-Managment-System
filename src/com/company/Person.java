package com.company;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String UserName;
    private String Password;
    private String Email;
    private String FirstName;
    private String LastName;
    private String PhoneNo;


    public Person(String FirstName, String LastName, String Email, String PhoneNo) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PhoneNo = PhoneNo;

    }

    public Person(Person P){
        this.UserName = P.UserName;
        this.Password =P.Password;
        this.FirstName = P.FirstName;
        this.LastName = P.LastName;
        this.Email = P.Email;
        this.PhoneNo = P.PhoneNo;

    }

    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}