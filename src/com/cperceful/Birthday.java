package com.cperceful;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Class for parsing and checking birth date
 */
public class Birthday {

    private String input;
    private int age;

    public Birthday(String input){
        this.input = input;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("MMdd")
            .appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 80).toFormatter();

    //method to parse input into usable dob
    public LocalDate parse(){
        LocalDate dob = LocalDate.from(FORMATTER.parse(input));
        return dob;
    }

    public boolean check(){

        //create date from input
        LocalDate dob = LocalDate.from(FORMATTER.parse(input));

        //calculate period
        Period period = Period.between(dob, LocalDate.now());

        //extract age
        age = period.getYears();

        if (age >= 21){
            return true;
        } else{
            return false;
        }

    }
}
