package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class manageEmployee {
    private ArrayList<Employee> employees;
    private ArrayList<Experience> experiences;
    private ArrayList<Fresher> freshers;
    private ArrayList<Intern> interns;
    ConnectionDB db = new ConnectionDB();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
//int ID, String fullName, Date birthDay, int phone, String email, String employee_Type, int employee_Count
    public void creatEmployee(Scanner sc){
        Employee e=new Employee();
        System.out.println("Enter employee ID: ");
        e.setID(sc.nextInt());
        System.out.println("Enter employee full name: ");
        e.setFullName(sc.nextLine());
        System.out.println("Enter date birthday(dd/MM/yyyy): ");
        String d;
        d = sc.nextLine();
        SimpleDateFormat birthDay = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date=birthDay.parse(d);
            e.setBirthDay(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Enter phone: ");
        e.setPhone(sc.nextInt());
        System.out.println("Enter email: ");
        e.setEmail(sc.nextLine());
        System.out.println("Enter employee type(Experience/Fresher/Intern): ");
        e.setEmployee_Type(sc.nextLine());
        employees=new ArrayList<>();
        employees.add(e);
        Connection con=db.getConnection();
        String query="insert into employee values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,e.getID());
            ps.setString(2,e.getFullName());
            ps.setString(3,e.getBirthDay().toString());
            ps.setInt(4,e.getPhone());
            ps.setString(5,e.getEmail());
            ps.setString(6,e.getEmployee_Type());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if(e.getEmployee_Type().equals("Experience")){
            experiences=new ArrayList<>();
            Experience ex=new Experience();
            ex.setID(e.getID());
            ex.setFullName(e.getFullName());
            ex.setBirthDay(e.getBirthDay());
            ex.setEmail(e.getEmail());
            ex.setPhone(e.getPhone());
            ex.setEmployee_Type(e.getEmployee_Type());
            System.out.println("Enter experience in year: ");
            ex.setExpInYear(sc.nextInt());
            System.out.println("Enter pro skills: ");
            ex.setProSkill(sc.nextLine());
            experiences.add(ex);
        }
        else if(e.getEmployee_Type().equals("Fresher")){
            freshers=new ArrayList<>();
            Fresher f=new Fresher();
            f.setID(e.getID());
            f.setFullName(e.getFullName());
            f.setBirthDay(e.getBirthDay());
            f.setEmail(e.getEmail());
            f.setPhone(e.getPhone());
            f.setEmployee_Type(e.getEmployee_Type());
            System.out.println("Enter graduation rank: ");
            f.setGraduation_Rank(sc.nextLine());
            System.out.println("Enter graduation date(dd/MM/yyyy): ");
            String gda=sc.nextLine();
            SimpleDateFormat grada=new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date gdate = grada.parse(gda);
                f.setGraduation_Date(gdate);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            f.setEducation(sc.nextLine());
            freshers.add(f);
        }
        else if(e.getEmployee_Type().equals("Intern")){
            interns=new ArrayList<>();
            Intern i=new Intern();
            i.setID(e.getID());
            i.setFullName(e.getFullName());
            i.setBirthDay(e.getBirthDay());
            i.setEmail(e.getEmail());
            i.setPhone(e.getPhone());
            i.setEmployee_Type(e.getEmployee_Type());
            System.out.println("Enter major: ");
            i.setMajors(sc.nextLine());
            System.out.println("Enter semester: ");
            i.setSemester(sc.nextLine());
            i.setUniversity_Name(sc.nextLine());
            interns.add(i);
        }
    }

    public void showInfo(Scanner sc){
        System.out.println("Enter employee ID need see information : ");
        int ID=sc.nextInt();
        for(Experience e:experiences){
            if(e.getID()==ID){
                e.showInfo();
            }
        }
        for(Fresher f: freshers){
            if(f.getID()==ID){
                f.showInfo();
            }
        }
        for(Intern i: interns){
            if(i.getID()==ID){
                i.showInfo();
            }
        }
    }
    public void updateEmployee(Scanner sc){
        System.out.println("Enter employee ID need update: ");
        int id=sc.nextInt();
        for(Employee e:employees){
            if(e.getID()==id){
                System.out.println("Enter new name: ");
                e.setFullName(sc.nextLine());
                System.out.println("Enter new birthday(dd/MM/yyyy): ");
                String date=sc.nextLine();
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                Date birthdate= null;
                try {
                    birthdate = sdf.parse(date);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                e.setBirthDay(birthdate);
                System.out.println("Enter new phone: ");
                e.setPhone(sc.nextInt());
                System.out.println("Enter new email: ");
                e.setEmail(sc.nextLine());
                System.out.println("Enter new employee type(Experience/Fresher/Intern): ");
                e.setEmployee_Type(sc.nextLine());
            }
        }
    }
    public void deleteEmployee(Scanner sc){
        System.out.println("Enter ID employee need delete: ");
        int ID=sc.nextInt();
        for(Employee e:employees){
            if(e.getID()==ID){
                for(Experience ex: experiences){
                    if(ex.getID()==ID){
                        experiences.remove(ex);
                    }
                }
                for(Fresher f: freshers){
                    if(f.getID()==ID){
                        freshers.remove(f);
                    }
                }
                for(Intern i: interns){
                    if(i.getID()==ID){
                        interns.remove(i);
                    }
                }
                employees.remove(e);
            }
        }
    }
}
