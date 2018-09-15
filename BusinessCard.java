/**
 * CS180 - Homework 01
 *
 * This program makes a business card from inputs from the user.
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 06-17-2018
 */

import java.util.*;

class BusinessCard {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your Name");
        String name = s.nextLine(); // person's name

        System.out.println("Enter your age");
        int age = s.nextInt(); // the age of the person
        s.nextLine();

        System.out.println("Enter your GPA");
        double gPA = s.nextDouble(); // gpa of a person
        s.nextLine();

        System.out.println("Enter your Major");
        String major = s.nextLine(); // person's major

        System.out.println("Enter your Email");
        String email = s.nextLine(); // person's email address

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.printf("GPA: " +"%.2f\n",gPA);
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }
}