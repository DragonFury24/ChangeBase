import java.util.*;

public class NumberInput {

    //Methods will not allow user to advance until a number in the correct format is inputted

    public static int intInput(Scanner keyboard){ //checks if input is a int and return. If not, then will give error and force user to retry
        int iOutput = -1;
        while (true) {
            try {
                iOutput = keyboard.nextInt();
                break;
            } catch (InputMismatchException I) {
                System.out.println("You did not input a whole number. Please try again.");
                keyboard.next();
            }
        }
        return iOutput;
    }

    public static int noNegIntInput(Scanner keyboard){ //checks if input is a int and return. If not or is negative, then will give error and force user to retry
        int iOutput = -1;
        while (iOutput == -1) {
            try {
                iOutput = keyboard.nextInt();
                if (iOutput < 0) {
                    iOutput = -1;
                    System.out.println("You put in a number less than 0. Please try again.");
                }
            } catch (InputMismatchException I) {
                System.out.println("You did not input a whole number. Please try again.");
                keyboard.next();
            }
        }
        return iOutput;
    }

    public static double dInput(Scanner keyboard) { //checks if input is a double and return. If not, then will give error and force user to retry
        double dOutput = 0;
        boolean noInput = true;
        while (noInput) {
            try {
                dOutput = keyboard.nextDouble();
                noInput = false;
            } catch (InputMismatchException I) {
                System.out.println("You did not input a number. Please try again.");
                keyboard.next();
            }
        }
        return dOutput;
    }

    public static double noNegDInput(Scanner keyboard) { //checks if input is a double and return. If not or negative, then will give error and force user to retry
        double dOutput = 0;
        boolean noInput = true;
        while (noInput) {
            try {
                dOutput = keyboard.nextDouble();
                noInput = false;

                if (dOutput < 0) { //checks if number is negative and will reset @noInput to force user to retry
                    System.out.println("You put in a number less than 0. Please try again.");
                    noInput = true;
                }
            } catch (InputMismatchException I) {
                System.out.println("You did not input a number. Please try again.");
                keyboard.next();
            }
        }
        return dOutput;
    }
}