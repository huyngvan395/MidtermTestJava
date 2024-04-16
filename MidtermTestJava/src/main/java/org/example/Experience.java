package org.example;

import java.util.Date;

public class Experience extends Employee implements IEmployee{
    private int expInYear;
    private String proSkill;

    public Experience() {}

    public Experience(int ID, String fullName, Date birthDay, int phone, String email, String employee_Type, int employee_Count, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employee_Type, employee_Count);
        this.expInYear=expInYear;
        this.proSkill=proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Exp In Year: "+expInYear);
        System.out.println("Pro Skill: "+proSkill);
    }
}
