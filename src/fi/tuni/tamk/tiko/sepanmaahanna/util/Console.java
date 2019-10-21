
package fi.tuni.tamk.tiko.sepanmaahanna.util;

import java.util.Scanner;
/**
* Class Console
*
* @author Hanna Sepänmaa
*/
public class Console {
    /**
    * Returns an int value selected by user
    *
    * If value is invalid, it shows errormessage that is entered as parameter
    * and asks user again until a valid number is given
    *
    * @param errorMessage this message is shown if given number is invalid
    * @return int value that user has selected
    */
    public static int readInt(String errorMessage) {
        Scanner s = new Scanner(System.in);
        boolean askAgain = true;
        int input = 0;
        while(askAgain) {
            askAgain = false;
            try {
                input = Integer.parseInt(s.nextLine());
            } catch(NumberFormatException e) {
                askAgain = true;
                System.out.println(errorMessage);
            }
        }
        return input;
    }

    /**
    * Returns an int value between min and max.
    *
    * If value is not in this range or value is invalid,
    * it gives errorMessage and asks user again.
    * Previous method readInt(String errorMessage) is reused here.
    *
    * @param min minimum int value that is accepted
    * @param max maximum int value that is accepted
    * @param errorMessageNonNumeric shows up if given number is invalid
    * @param errorMessageNonMinAndMax shows up if number is not between min and max
    * @return int value that is between min and max
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Scanner s = new Scanner(System.in);
        int number = readInt(errorMessageNonNumeric);
        while(number < min || number > max) {
            System.out.println(errorMessageNonMinAndMax);
            number = readInt(errorMessageNonNumeric);
        }
        return number;
    }

    /**
    * Asks info from user and returns boolean value.
    *
    * If user answers "yes" printInfo is marked to be true.
    * Otherwise method returns boolean value false.
    *
    * @return boolean value which tells if user wants to
    * print weekly info regarding lotto
    */
    public static boolean doWePrintInfo() {
        Scanner s = new Scanner(System.in);
        boolean printInfo = false;
        String userSays = s.nextLine();
        if(userSays.equals("yes")) {
            printInfo = true;
        }
        return printInfo;
    }
}