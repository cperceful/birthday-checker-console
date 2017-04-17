package com.cperceful;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("Enter DOB: ");
            String input = scanner.nextLine();
            Birthday birthday = new Birthday(input);

            if (birthday.check()){
                System.out.println("Valid Sale(" + birthday.getAge() + ")");
            } else{
                System.out.println("OMG DENY SALE(" + birthday.getAge() + ")");
            }


        }
    }
}
