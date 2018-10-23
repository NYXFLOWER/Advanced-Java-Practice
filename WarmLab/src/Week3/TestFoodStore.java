package Week3;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.image.ImagingOpException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestFoodStore {
    public static void main(String[] args) throws InputMismatchException {
//----------------------------Task 1-------------------------------//
        // Task 1.1
        FoodStore myFoodStore = new FoodStore(10);
        System.out.println("Contains " + myFoodStore.getAmountStored());

        // Task 1.2
        // test the depositFood method
        myFoodStore.depositFood(2);
        System.out.println("Contains " + myFoodStore.getAmountStored());
        // test the withdrawFood method
        myFoodStore.withdrawFood(4);
        System.out.println("Contains " + myFoodStore.getAmountStored());


        // Task 1.3
        int input;
        boolean flag = true;
        System.out.println("Enter the amount of food you want to deposite with '+' or withdraw with '-' before the number.");
        System.out.println("Enter 'NO' when you finish it.");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        {
            System.out.println("sign + number: ");
            input = Integer.parseInt(scanner.nextLine());
            if (input > 0){myFoodStore.depositFood(input);}
            else {myFoodStore.depositFood(input);}
            System.out.println("Do you want to continue? YES or NO");
            if (scanner1.nextLine().equals("NO")) {flag = false;}

        } while (flag);

        System.out.println("The amount of food is " + myFoodStore.getAmountStored() + " now.");

    }
}
