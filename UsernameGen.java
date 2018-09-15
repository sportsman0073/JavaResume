/**
 *  CS180 - Homework 02
 *
 * This program makes a new username from their age and their first letter of thier first name and thier entire last name.
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 06-17-2018
 */

import java.util.*;

public class UsernameGen {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("What is your full name?");
        String name = s.nextLine(); // person's name

        System.out.println("What is your birth year?");
        int year = s.nextInt(); // person's birth year
        s.nextLine();
        String n = name.toLowerCase(); //temporary variable
        String[] m = n.split(" "); // temporary variable to make it into a few lists
        Character firstLetter = m[0].charAt(0); //first letter of their first name
        String username = firstLetter + m[1]; // the first letter of the first name and the last name
        System.out.printf("Your username is "+ username + (2017-year)); // output with a new username

    }
}
