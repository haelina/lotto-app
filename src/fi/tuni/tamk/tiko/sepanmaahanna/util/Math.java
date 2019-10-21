
package fi.tuni.tamk.tiko.sepanmaahanna.util;
/**
* The class Math contains methods for several Math related functions
*
* @author Hanna Sepänmaa
*/
public class Math {
    /**
    * Returns a random int value from specified number range. 
    *
    * Int value min must be smaller than max.
    * 
    * @param min the minimum value of a randomly selected number 
    * @param max the maximum value of a randomly selected number
    * @return a random int value from number range min-max.
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}