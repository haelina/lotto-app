
package fi.tuni.tamk.tiko.sepanmaahanna;

import fi.tuni.tamk.tiko.sepanmaahanna.util.Math;
import fi.tuni.tamk.tiko.sepanmaahanna.util.Arrays;
import fi.tuni.tamk.tiko.sepanmaahanna.util.Console;

/**
* The class Main is a lotto app.
* 
* All the info is stored in three arrays that hold
* numbers picked by user, randomly generated lotto numbers
* and info about how long it took before user won the lotto.
* User gets to choose if weekly results are shown and the lotto
* continues until user gets 7 right in under 120 years.
*
* @author Hanna Sepänmaa
*/
public class Main {

    static int [] userArray = new int[7];
    static int [] lottoArray = new int[7];
    static int [] bestOfArray = new int[7];

    public static void main(String [] args) {
        
        int number = 0;
        int indexOfUserArray = 0;
        int gotRight = 0;
        int weeks = 0;
        int indexOfBestOfArray = 0;
        
        while(indexOfUserArray < 7) {
            System.out.println("Please give unique number between [1, 40]");
            number = Console.readInt(1, 40, "Please give number.", "Please give unique number between [1, 40]");
            while(Arrays.contains(number, userArray)) {
                System.out.println("Not unique numbers!\nPlease give unique number between [1, 40]");
                number = Console.readInt(1, 40, "Please give number.", "Please give unique number between [1, 40]");
            }
            userArray[indexOfUserArray] = number;
            indexOfUserArray++;
        }
        Arrays.sort(userArray);

        System.out.println("Users lotto:");
        printNumbers(userArray);
        System.out.print("Print weekly lotto results? yes/no: ");
        boolean printInfo = Console.doWePrintInfo();
        boolean tookMoreThanLifetime = true;

        while(tookMoreThanLifetime) {

            for(int k = 0; k < bestOfArray.length; k++) {
                bestOfArray[k] = -1;
            }

            while(gotRight < 7) {
                lottoArray = calculateLotto();
                weeks++;
                gotRight = Arrays.containsSameValues(userArray, lottoArray);
                if(gotRight > 0) {
                    indexOfBestOfArray = gotRight -1;
                    if(bestOfArray[indexOfBestOfArray] < 0) {
                        bestOfArray[indexOfBestOfArray] = weeks/52;
                    }
                }

                if(printInfo) {
                    System.out.println("Week " + weeks + ", Lotto numbers:");
                    printNumbers(lottoArray);
                    System.out.println("You got right: " + gotRight);
                }
            }
        
            for(int h = 1; h <= bestOfArray.length; h++) {
                if(bestOfArray[h-1] != -1) {
                    System.out.println("Got " + h + " right! Took " + bestOfArray[h-1] + " years.");
                } else {
                    System.out.println("Didn't get " + h + " right.");
                }
            }
            System.out.println("You won!");

            if(bestOfArray[bestOfArray.length-1] < 120) {
                tookMoreThanLifetime = false;
            } else {
                System.out.println("This took more than a lifetime, let's try again!");
                weeks = 0;
                gotRight = 0;
            }
        }
    }

    /**
    * Returns int array that holds seven unique values between 1-40
    *
    * Each value is randomly generated and if the value is already
    * included in the array a new random value is generated until each of
    * the seven values is unique. Array values are sorted to ascending order.
    *
    * @return array that has seven unique int values between 1-40
    */
    private static int[] calculateLotto() {
        int indexOfLottoArray = 0;
        int lottoNumber = 0;
        while(indexOfLottoArray < 7) {
            lottoNumber = Math.getRandom(1, 40);
            while(Arrays.contains(lottoNumber, lottoArray)) {
                lottoNumber = Math.getRandom(1, 40);
            }
            lottoArray[indexOfLottoArray] = lottoNumber;
            indexOfLottoArray++;
        }
        Arrays.sort(lottoArray);
        return lottoArray;
    }

    /**
    * Method for printing Array
    * 
    * Prints array values like this: [01, 08, 10, 24, 25, 34, 39]
    * If value is smaller than 10 prefix 0 is added to the print.
    *
    * @param array the array that we want to print
    */
    public static void printNumbers(int [] array) {
        System.out.print("[");
        for(int j = 0; j < array.length -1; j++) {
            if(array[j] < 10) {
                System.out.print("0" + array[j] + ", ");
            } else {
                System.out.print(array[j] + ", ");
            }
        }
        if(array[array.length-1] < 10) {
            System.out.print("0" + array[array.length-1] + "]");
        } else {
            System.out.print(array[array.length-1] + "]");
        }
        System.out.println();
    }
}