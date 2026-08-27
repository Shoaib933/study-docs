package exceptions;

import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static void main() {


        //compile check kar pa rha hai.
//        FileReader fileReader=new FileReader("abc.txt");


        System.out.println("Hello, Lets began...");
        System.out.println("starting calculator");


        try (Scanner sc = new Scanner(System.in);
             FileReader fileReader = new FileReader("AgeNotFoundException.java");
        ) {
            System.out.println("Enter the first number");
            int a = sc.nextInt();
            System.out.println("Enter the second number");
            int b = sc.nextInt();

            //nhi check kar pa rha hai.
            int c = a / b;
            System.out.println("The result is : " + c);

            if (c == 5) {
                throw new AgeNotFoundException();
            }
        } catch (ArithmeticException e) {
            System.out.println("You 2nd number can not be zero");
        } catch (InputMismatchException e) {
            System.out.println("Your input is not a number");
        } catch (AgeNotFoundException e) {
            System.out.println("Age is not found");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Something went wrong "+e.getMessage());
        }


        System.out.println("Thank you for using our calculator");
        System.out.println("lets go to next step");
        System.out.println("Enter you name:");
//        Scanner sc1 = new Scanner(System.in);
//        String name = sc1.nextLine();
//        System.out.println("Welcome " + name);
        System.out.println("Thankyou for using our calculator");
        System.out.println("bye");


    }
}
