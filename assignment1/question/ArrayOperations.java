import java.lang.Math;
/*
 * ArrayOperations
 *
 * A class with basic array methods to
 *  - print the values in an array
 *  - calculate the sum of the values in an array
 *  - calculate the minimum of the values in an array
 *  - calculate the maximum of the values in an array
 *  - calculate the average of the values in an array
 *
 */
public class ArrayOperations {
    /*
     * printArray
     *
     * Purpose: prints all the values in the array to the console
     *  example format:  {1,2,3,4}
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: void
     *
     */
    public static void printArray ( int[] array ) {
        System.out.print("{");
        for(int i=0; i<array.length-1; i++)
            System.out.print(array[i] + ",");
        
        System.out.println(array[array.length-1] + "}");
    }
    
    /*
     * arraySum
     *
     * Purpose: totals all the values in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: total of all values in the array
     *
     */
    public static int arraySum ( int[] array ) {
        int sum = 0;
        
        // TODO ...
        
        return sum;
    }
    
    /*
     * arrayMax
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: maximum value in the array
     *
     */
    // TODO
    
    /*
     * arrayMin
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns:  minimum value in the array
     *
     */
    // TODO
    
    /*
     * arrayAvg
     *
     * Purpose: finds the average of all the values in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: average of values in the array as a double
     *
     */
    // TODO
    
    /*
     * arraysEqual
     *
     * Purpose: determines whether the two arrays are equal
     *      where equal means array1 and array2 are the same length
     *      and the contain the same values in the same order
     *
     * Parameters: two arrays of integers
     *
     * Returns: true if the are equal, false otherwise
     *
     */
    // TODO
    
}
