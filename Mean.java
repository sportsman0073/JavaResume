/**
 * CS180 - Homework 03
 *
 * This program takes integer inputs from the users and calculates the mean from the summation from the user.
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 06-26-2018
 */

import java.util.*;

public class Mean {
    public static void main(String[] args){
        Boolean keepGoing = true;
        Boolean yesOrNo = true;
        System.out.println("Welcome to the Mean Calculator!");
        String movingOn = "";
        double summation = 0.0;
        int count = 0;
        double mean = 0.0;
        int y = 0;
        Scanner s = new Scanner(System.in);
        do{
            yesOrNo = true;
            //y == Integer.parseInt(x)
            Boolean isNumber = true;
            while(isNumber) {
                System.out.println("Please enter your number:");
                String x = s.nextLine();
                while(x.isEmpty()){
                    System.out.println("Numbers only!");
                    System.out.println("Please enter your number:");
                    x = s.nextLine();
                }
                if (x.matches("-?\\d+")) {
                    y = Integer.valueOf(x);
                    summation += y;
                    isNumber = false;
                } else {
                    System.out.println("Numbers only!");
                }
            }
                System.out.println("Do you wish to enter another number?(y/n):");
                movingOn = s.nextLine();
                count++;
                while(yesOrNo) {
                    while (movingOn.isEmpty()) {
                        System.out.println("Please enter y or n!");
                        System.out.println("Do you wish to enter another number?(y/n):");
                        movingOn = s.nextLine();
                    }

                    if (movingOn.equals("y")) {
                        keepGoing = true;
                        isNumber = true;
                        yesOrNo = false;
                    } else if (movingOn.equals("n")) {
                        mean = summation / count;
                        int sum = (int) summation;
                        System.out.println("Sum: " + sum + " " + "Num: " + count);
                        System.out.println("Mean: " + mean);
                        System.out.println("Thank you for using Mean Calculator!");
                        keepGoing = false;
                        yesOrNo = false;
                    } else {
                        System.out.println("Please enter y or n!");
                        System.out.println("Do you wish to enter another number?(y/n):");
                        movingOn = s.nextLine();


                    }
                }

            }while(keepGoing);
        }
    }
