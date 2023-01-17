package at.ac.fhw.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args){
        System.out.println("This is a BMI-Calculator");

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your weight in kg: ");
        String inputWeight = in.next();

        System.out.print("Enter your height in centimetres: ");
        String inputHeight = in.next();

        double enteredWeight = Double.parseDouble(inputWeight);
        double enteredHeight = Double.parseDouble(inputHeight);

        double bmi = enteredWeight/(Math.pow(enteredHeight/100,2));

        System.out.println(String.format("Your BMI is %.2f",bmi));

        if (bmi <= 18.4){
            System.out.println("You are underweight");
        }else if (bmi >= 18.5 && bmi <= 24.9){
            System.out.println("You are normal weight");
        }else if (bmi >= 25.0 && bmi <= 29.9){
            System.out.println("You are slightly overweight");
        }else if (bmi >= 30.0 && bmi <= 34.9){
            System.out.println("You are overweight");
        }else if (bmi >= 35.0 && bmi <= 39.9){
            System.out.println("You are strongly overweight");
        }else if (bmi >= 40.0){
            System.out.println("You are very strongly overweight");
        }

    }
}
