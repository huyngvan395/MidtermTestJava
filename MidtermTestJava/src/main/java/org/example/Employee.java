package org.example;

import java.util.Date;

public class Employee implements IEmployee{
    private int ID;
    private String fullName;
    private Date birthDay;
    private int phone;
    private String email;
    private String employee_Type;
    private int employee_Count;

    public Employee() {}
    public Employee(int ID, String fullName, Date birthDay, int phone, String email, String employee_Type, int employee_Count) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employee_Type = employee_Type;
        this.employee_Count=employee_Count;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_Type() {
        return employee_Type;
    }

    public void setEmployee_Type(String employee_Type) {
        this.employee_Type = employee_Type;
    }

    public int getEmployee_Count() {
        return employee_Count;
    }

    public void setEmployee_Count(int employee_Count) {
        this.employee_Count = employee_Count;
    }

    public void showInfo(){
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birthday: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employee_Type);
        System.out.println("Employee Count: " + employee_Count);
    }
}
