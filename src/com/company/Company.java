package com.company;

import java.io.*;
import java.util.ArrayList;

public class Company implements Serializable{
    private String Company_Name;
    private String Manager;
    private ArrayList<Organizer> Employees;
    private Address Company_location;
    private String Company_PhoneNo;

    public Company(String company_Name, String manager,
                   ArrayList<Organizer> employees,
                   Address company_location, String company_PhoneNo) {
        this.Company_Name = company_Name;
        this.Manager = manager;
        this.Employees = employees;
        this.Company_location = new Address(company_location);
        this.Company_PhoneNo = company_PhoneNo;
    }

    public Company( Company C){
        this.Company_Name=C.Company_Name;
        this.Manager=C.Manager;
        this.Employees=C.Employees;
        this.Company_location=C.Company_location;
        this.Company_PhoneNo=C.Company_PhoneNo;
    }


    public static void writeToFile(Company company){
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("CompanyData"));
            output.writeObject(company);
            output.close();
        } catch (IOException e) {
            System.out.println("Error Writing File");
        }
    }

    public static Company readFromFile() {
        Company CC = null;
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("CompanyData"));
            CC = (Company) input.readObject();
            input.close();
        } catch (IOException e){
            System.out.println("Error Reading File");
        } catch (ClassNotFoundException e1){
            System.out.println("Class Not found");
        }return CC;
    }

    public static void updateFile(Company cc){

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("CompanyData"));
            output.writeObject(cc);
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error Updating File");
        }
    }

    public static String Display(){
            Company c=Company.readFromFile();
            return "Company Name :"+c.getCompany_Name()+"\nManager :"+c.getManager()+"\nPhone no :"+c.getCompany_PhoneNo()+
                    "\nAddress : "+c.getCompany_location().getOfficeNo()+"  "+c.getCompany_location().getPlazaName()+" "+
                    c.getCompany_location().getCity();
    }

    public String getCompany_Name() { return Company_Name; }
    public void setCompany_Name(String company_Name) { Company_Name = company_Name;}

    public String getManager() { return Manager; }
    public void setManager(String manager) { Manager = manager; }

    public ArrayList<Organizer> getEmployees() { return Employees; }
    public void setEmployees(ArrayList<Organizer> employees) { Employees = employees; }

    public Address getCompany_location() { return Company_location; }
    public void setCompany_location(Address company_location) { Company_location = company_location; }

    public String getCompany_PhoneNo() { return Company_PhoneNo; }
    public void setCompany_PhoneNo(String company_PhoneNo) { Company_PhoneNo = company_PhoneNo; }
}
