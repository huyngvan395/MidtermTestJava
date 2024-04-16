package org.example;

import java.util.Date;

public class Fresher extends Employee implements IEmployee {
    private Date graduation_Date;
    private String graduation_Rank;
    private String education;

    public Fresher(){}

    public Fresher(int ID, String fullName, Date birthDay, int phone, String email, String employee_Type, int employee_Count, Date graduation_Date, String graduation_Rank, String education) {
        super(ID, fullName, birthDay, phone, email, employee_Type, employee_Count);
        this.graduation_Date = graduation_Date;
        this.graduation_Rank = graduation_Rank;
        this.education = education;
    }

    public Date getGraduation_Date() {
        return graduation_Date;
    }

    public void setGraduation_Date(Date graduation_Date) {
        this.graduation_Date = graduation_Date;
    }

    public String getGraduation_Rank() {
        return graduation_Rank;
    }

    public void setGraduation_Rank(String graduation_Rank) {
        this.graduation_Rank = graduation_Rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Graduation Date: " + graduation_Date);
        System.out.println("Graduation Rank: " + graduation_Rank);
        System.out.println("Education: " + education);
    }
}
