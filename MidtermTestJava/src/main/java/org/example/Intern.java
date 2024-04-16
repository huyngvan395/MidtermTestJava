package org.example;

import java.util.Date;

public class Intern extends Employee implements IEmployee{
    private String majors;
    private String semester;
    private String university_Name;

    public Intern() {}

    public Intern(int ID, String fullName, Date birthDay, int phone, String email, String employee_Type, int employee_Count, String university_Name, String majors, String semester) {
        super(ID, fullName, birthDay, phone, email, employee_Type, employee_Count);
        this.majors = majors;
        this.semester = semester;
        this.university_Name = university_Name;
    }
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_Name() {
        return university_Name;
    }

    public void setUniversity_Name(String university_Name) {
        this.university_Name = university_Name;
    }

}
