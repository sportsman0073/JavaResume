/**
 * CS180 - Project 01
 *
 * This project will replace words with "X" or with a different word. It will also get rid of some personal information.
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 06-24-2018
 */

import java.util.Arrays;
import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +
                    "2. Find-And-Replace\n" +
                    "3. Censor Information");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                // PART 1 - Censoring Words


                // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");
                String passage = scanner.nextLine();

                // TODO: PART 1 - Ask the user for a passage to censor


                // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");
                String word = scanner.nextLine();

                // TODO: PART 1 - Ask the user for a word to censor


                System.out.println("Uncensored: ");
                System.out.println(passage);

                // TODO: PART 1 - Implement your parsing here

                String censored = "";
                char[] x = new char[word.length()];
                Arrays.fill(x,'X');

                int wordLength = word.length();
                int passageLength = passage.length();
                int i = 0;

                //int wordIndex = passage.indexOf(word);
                for(i=0; i < passageLength-wordLength+1;) {
                    /*if (passage.substring(i, i + wordLength + 1).equals(word + " ")) {
                        censored += passage.substring(i, i + wordLength).replace(word, new String(x));
                        i += wordLength;
                        } else if ((passage.substring(i, i + wordLength + 1).equals(word + ".")) || (passage.substring(i, i + wordLength + 1).equals(word + "!")) || (passage.substring(i, i + wordLength + 1).equals(word + ",")) || (passage.substring(i, i + wordLength + 1).equals(word + "?")) || i + wordLength + 1 == passage.length() || (passage.substring(i, i + wordLength + 1).equals(word + "\n"))) {
                            censored += passage.substring(i, i + wordLength).replace(word, new String(x));
                            i += wordLength;
                        }
                    else {
                        censored += passage.charAt(i);
                        i++;
                    }*/
                    int after = i + wordLength;
                    if(passage.substring(i, i+wordLength).equals(word) &&
                            (after==passageLength
                            ||passage.charAt(after)==' '
                            ||passage.charAt(after)=='.'
                            ||passage.charAt(after)=='?'
                            ||passage.charAt(after)=='!'
                            ||passage.charAt(after)==',')
                            &&(i==0||passage.charAt(i-1)==' '
                            ))
                    {
                        censored += passage.substring(i, i + wordLength).replace(word, new String(x));
                        i += wordLength;
                    }else {
                        censored += passage.charAt(i);
                        i++;
                    }

                }
                censored += passage.substring(i,passageLength);


                /*String[] s = passage.split(" ");
                for(int i = 0; i < s.length;i++) {
                        if (s[i].equals(word) || s[i].equals(word + ".") || s[i].equals(word + "!") || s[i].equals(word + ",") || s[i].equals(word + "?")) {
                            censored += s[i].replace(word, new String(x)) + " ";
                        }
                        else{
                            censored += s[i] + " ";
                        }
                    }
                */
                System.out.println("Censored: ");
                System.out.println(censored);


            }else if (choice == 2) {

                // PART 2 - Replacing Words


                // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");
                String passage = scanner.nextLine();


                // TODO: PART 2 - Ask the user for a passage to filter


                // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");
                String replace = scanner.nextLine();

                //TODO: PART 2 - Ask the user for a word to replace


                // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");
                String insert = scanner.nextLine();

                //TODO: PART 2 - Ask the user for a word to insert


                System.out.println("Uncensored: ");
                System.out.println(passage);


                // TODO: PART 2 - Implement your parsing here
                String replaceWords = passage.replaceAll(replace, insert);


                System.out.println("Censored: ");
                System.out.println(replaceWords);



            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);

                // TODO: PART 3 - Implement your parsing here
                String moto = "";
                String censoredName = "";
                String censoredEmail = "";
                String censoredPhone = "";
                String censordedInfo = "";
                String[] info = passage.split("\n");
                for(int i = 0;i<info.length;i++){
                    if(info[i].contains("Name:")){
                        String firstName = "";
                        String lastName ="";
                        String[] name = info[i].split(" ");
                        char[] nameFirst = new char[name[1].length()-1];
                        Arrays.fill(nameFirst,'*');
                        char [] nameLast = new char[name[2].length()-1];
                        Arrays.fill(nameLast,'*');
                        for(int k=0;k<name[1].length();++k) {
                            firstName = name[1].replaceAll(name[1], new String(nameFirst));
                        }
                        for(int k=0;k<name[2].length()-1;k++) {
                            lastName = name[2].replaceAll(name[2], new String(nameLast));
                        }
                        censoredName = name[0]+" "+name[1].charAt(0)+firstName + " " + lastName+name[2].charAt(name[2].length()-1);
                        censordedInfo += censoredName + "\n";
                    }
                    else if(info[i].contains("Email:")) {
                        String[] email = info[i].split("@");
                        int location = email[1].indexOf(".");
                        String webAddress = "";
                        String[] labelEmail = info[i].split(" ");
                        String emailName = "";
                        String emailAddress = "";
                        char[] nameEmail = new char[email[0].length() - 8];
                        Arrays.fill(nameEmail, '*');
                        char[] addressEmail = new char[location-1];
                        Arrays.fill(addressEmail, '*');
                        for (int k = 8; k < email[0].length(); k++) {
                            emailName = email[0].replaceAll(email[0], new String(nameEmail));
                        }
                            for(int k = 0; k < email[1].length()-location; k++) {
                                emailAddress = email[1].replaceAll(email[1], new String(addressEmail));
                            }
                            for(int j = location; j<email[1].length();j++){
                            webAddress += email[1].charAt(j);
                            }
                            censoredEmail = labelEmail[0]+ " "+email[0].charAt(7)+emailName + "@" + email[1].charAt(0) +emailAddress + webAddress;
                        censordedInfo += censoredEmail + "\n";

                    }
                    else if(info[i].contains("Phone:")){
                        String[] phone = info[i].split("-");
                        String[] labelPhone = info[i].split(" ");
                        String firstThreeNumbers = "";
                        String nextThreeNumbers = "";
                        char[] phoneThreeNumber = new char[phone[0].length()-7];
                        Arrays.fill(phoneThreeNumber,'*');
                        char [] phoneNextNumber = new char[phone[1].length()];
                        Arrays.fill(phoneNextNumber,'*');
                        for(int k = 6; k<phone[0].length();k++){
                            firstThreeNumbers = phone[0].replaceAll(phone[0],new String(phoneThreeNumber));
                        }
                        for(int k = 0; k<phone[1].length();k++){
                            nextThreeNumbers = phone[1].replaceAll(phone[1],new String(phoneNextNumber));
                        }
                        censoredPhone = labelPhone[0]+ " " +firstThreeNumbers +"-"+nextThreeNumbers+"-"+phone[2];
                        censordedInfo += censoredPhone + "\n";
                    }
                    else{
                        moto = info[i];
                        censordedInfo += moto + "\n";

                    }

                }
                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(censordedInfo);


            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }


            System.out.println("Would you like to keep filtering? Yes/No");
            String input = scanner.nextLine();

            // TODO: PART 4 - Update the value of keepGoing accordingly
            // TODO: PART 4 - Replace the line below with your code
            while(input.isEmpty()) {
                input = scanner.nextLine();
            }
                if (input.equals("Yes")) {
                    keepFiltering = true;
                } else {

                    keepFiltering = false;
                }


        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }

}

