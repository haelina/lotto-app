
package fi.tuni.tamk.tiko.sepanmaahanna.util;
/**
* The class Arrays contains methods for using arrays
*
* @author Hanna Sepänmaa
*/
public class Arrays {
    /**
    * Returns an array of values that have been
    * changed from String to int values
    * 
    * @param array an array with String values
    * @return an array with int values
    */
    public static int [] toIntArray(String [] array) {
        int [] intArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    /**
    * Returns a boolean value which indicates
    * if given int value is found from array
    *
    * @param value int value 
    * @param array int type array 
    * @return boolean value which indicates if array contains value
    */
    public static boolean contains(int value, int [] array) {
        boolean doesItContain = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                doesItContain = true;
            }
        }
        return doesItContain;
    }

    /**
    * Compares values from two int arrays and returns an int value
    * which tells how many values in these arrays were the same
    *
    * @param array1 int array
    * @param array2 int array
    * @return int value of how many numbers are the same in these two arrays
    */
    public static int containsSameValues(int [] array1, int [] array2) { 
        int sameNumbers = 0;
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) {
                    sameNumbers++;
                }
            }
        }
        return sameNumbers;
    }

    /**
    * Returns an array with int values. Values are in ascending order.
    *
    * @param array the array that needs to be sorted
    * @return int array where values are sorted to ascending order
    */
    public static int [] sort(int [] array) {
        int [] sortedArray = array;
        for(int i = 0; i < array.length-1; i++) {
            int minimumIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int minimum = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = minimum;
        }
        return sortedArray;
    }
}