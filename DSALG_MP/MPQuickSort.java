package DSALG_MP;

public class MPQuickSort {

    /**
     * Sorts the string array using the quick sort algorithm.
     * @param arrString     string array to be sorted.
     * @param startIndex    starting index of the array.
     * @param endIndex      last index of the array.
     */
    public void quickSort(String[] arrString, int startIndex, int endIndex){

        // the if statement is created to have a base case for the recursion
        if (startIndex < endIndex){

            // the partition variable serves as the point where the unsorted array is sorted into 2 groups:
            // the left side, where the values less than the pivot are;
            // and the right side, where the values equal to or more than the pivot are.
            int partition = partition(arrString, startIndex, endIndex);

            //the first partitioned side of the array will be sorted first
            quickSort(arrString, startIndex, partition - 1);
            //then the other half will follow.
            quickSort(arrString, partition + 1, endIndex);
        }
    }

    /**
     * Finds the partition for quick sort.
     * @param arrString     string array to be sorted.
     * @param startIndex    starting index of the array.
     * @param endIndex      last index of the array.
     * @return              index of the partition.
     */
    public int partition(String[] arrString, int startIndex, int endIndex){

        //As per the textbook, the pivot is defaulted to the last element of the given array
        String pivot = arrString[endIndex];

        //the returnIndex is initialized to be before the first array because it is only updated when a certain condition is met (see line 48)
        int returnIndex = startIndex - 1;

        //the for loop linearly searches every element of the array to be compared to the pivot
        for (int counter = startIndex; counter < endIndex; counter++) {

            //if the value being compared to is lexicographically lesser than the pivot, returnIndex will increase by 1 and the elements in the array with indexes returnIndex and counter will swap places
            //returnIndex will stay at the index where the value is more than or equal to the pivot when the condition is false.
            if (arrString[counter].compareToIgnoreCase(pivot) < 0) {
                returnIndex++;
                //it will only swap if and only if the 1st element (arrString[returnIndex]) is  more than or equal to the pivot, and the 2nd element is less than the pivot (arrString[counter]);
                swapValues(arrString, arrString[returnIndex], returnIndex, arrString[counter], counter);
            }

        }

        //the pivot, the last element of the array, will swap places to where the last value, which is more than or equal to the pivot, is found.
        swapValues(arrString, arrString[returnIndex + 1], (returnIndex + 1), pivot, endIndex);

        return returnIndex + 1;
    }

    /**
     * Swaps the array values.
     * @param arrString
     * @param temp
     * @param arrStringTempPosition
     * @param pivotString
     * @param setStringIndex
     */
    public void swapValues(String[] arrString, String temp, int arrStringTempPosition, String pivotString, int setStringIndex) {
        //swapping 2 strings in an array
        arrString[arrStringTempPosition] = pivotString;
        arrString[setStringIndex] = temp;
    }

}