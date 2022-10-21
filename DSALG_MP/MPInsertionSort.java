package DSALG_MP;

public class MPInsertionSort {

    /**
     * Sorts the string array using the insertion sort algorithm.
     * @param arrString     string array to be sorted.
     */
    public void insertionSort(String[] arrString) {

        //initialize necessary variables for the insertion sort
        int outerIndex = 0, innerIndex = 0;
        String key = "";

        //starts at 1 to access the first element in index 0 for comparison
        //loop up till the last elementt
        for (outerIndex = 1; outerIndex < arrString.length; outerIndex++) {
            key = arrString[outerIndex]; //set a key for comparison
            innerIndex = outerIndex - 1; //set the innerIndex to the outerIndex-1 to access the element on the left of the key

            //while loop to check if the innerIndex will not go out of bounds
            //and check if the String in the innerIndex position is lexicographically higher than the String key
            while (innerIndex >= 0 && arrString[innerIndex].compareToIgnoreCase(key) > 0) {
                arrString[innerIndex + 1] = arrString[innerIndex]; //move the element's value to the right, shifting the array
                innerIndex--;
            }

            arrString[innerIndex + 1] = key; //set the element at the right of the element's current innerIndex position to the value of String key
        }
    }

}