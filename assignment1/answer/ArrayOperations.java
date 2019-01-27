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
        for(int i=0;i<array.length;i++)
        {
        	sum+=array[i];
        }
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
    public static int arrayMax(int[] array) {
    	int maximum=0;
    	if (array.length >0)
    	{
    		maximum = array[0];
    		for (int i =0;i<array.length;i++)
    		{
    			if (array[i]>maximum)
    			{
    				maximum = array[i];
    			}
    		}
    		return maximum;
    		
    	}
    	else {
    		System.out.println("The array is empty!\n");
    		return 0;
    	}
    }
    
    
    
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
    public static int arrayMin(int[] array) {
    	int minimum=0;
    	if (array.length >0)
    	{
    		minimum = array[0];
    		for (int i =0;i<array.length;i++)
    		{
    			if (array[i]<minimum)
    			{
    				minimum = array[i];
    			}
    		}
    		return minimum;
    		
    	}
    	else {
    		System.out.println("The array is empty!\n");
    		return 0;
    	}
    }
    
    
    
    
    
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
    
    public static double arrayAvg(int[] array) {
    	
    	int sum = arraySum(array);
    	return sum*1.0/array.length;
    	
    	
    }
    
    
    
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
    
    public static boolean arraysEqual(int[] array1, int[] array2) {
    	if (array1.length == array2.length)
    	{
    		for(int i =0;i<array1.length;i++)
    		{
    			if (array1[i]!=array2[i])
    			{
    				return false;
    			}
    		}
    		return true;
    		
    	}
    	else {
    		return false;
    	}
    }
    
}
