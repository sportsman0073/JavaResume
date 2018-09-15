import java.util.*;
import java.lang.Object;

/**
 * CS180 - Homework 05
 *
 *
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 07-03-2018
 */

public final class Employee extends Object{
    private int idNumber;
    private String name;
    private String position;
    private double salary;
    public Employee(String name, String position){
        if(name == null){
            this.name = "";
        } else  {
            this.name = name;
        }
        if(position == null){
            this.position = "";
        } else {
            this.position = position;
        }
        if(this.position.equals("Manager")){
            this.salary = 50000.0;
        }
        else{
            this.salary = 25000.0;
        }
        generateIdNumber();
    }
    private int generateIdNumber(){
        Random rand = new Random();
        this.idNumber = (int)(rand.nextInt(900000)+100000);
        return this.idNumber;
    }
    public int getIdNumber(){
        return idNumber;

    }
    public String getName(){
        return this.name;

    }
    public String getPosition(){
        return this.position;

    }
    public double getSalary(){

        return this.salary;

    }
    public void setName(String name){
        String realEmployeeName = name;
        if(realEmployeeName == null){
            this.name = "";
        }
        else{
            this.name = realEmployeeName;
        }

    }
    public void setPosition(String position){
        String realEmployeePosition = position;
        this.position = position;
        if(realEmployeePosition == null){
            this.position = "";
        }

        if(position.equals("Manager")){
            this.salary = 50000.0;
        }
        else{
            this.salary = 25000.0;
        }

    }
    public void setSalary(double salary){
        double realEmployeeSalary = salary;
        if(realEmployeeSalary<=0.0){
            this.salary = 0.0;
        }
        else{
            this.salary = realEmployeeSalary;
        }
    }
    public String toString(){
        String employee = "ID number: " + idNumber +"\n"
                + "Name: " + name+"\n"
                + "Position: " + position+"\n"
                + "Salary: $"+ String.format("%.2f",salary);
        return employee;
    }
    public static void main(String[] args){

    }

}
