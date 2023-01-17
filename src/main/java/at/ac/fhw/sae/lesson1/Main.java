package at.ac.fhw.sae.lesson1;

import at.ac.fhw.sae.lesson3.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int number = 42;                //this is a comment

        System.out.println(number);

        final int CONSTANT_VARIABLE = 1;

//        CONSTANT_VARIABLE = 2;

        boolean result = !(number != CONSTANT_VARIABLE);
        System.out.println(result);

        if (number > 42){
            System.out.println("number " + number + " is bigger than 42");
        }else{
            System.out.println("number " + number + " is smaller or equal to 42");
        }

        double value = 56.548784545;
        System.out.println(String.format("value is %.2f",value));


        Scanner in = new Scanner(System.in);
        System.out.print("Enter something: ");
        String input = in.next();

        System.out.println("You entered: " + input);

        double enteredValue = Double.parseDouble(input);

    }
}
