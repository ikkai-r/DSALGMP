package DSALG_MP;

import java.util.ArrayList;

public class MPQuickSort {

    /**
     * Sorts the string array using the quick sort algorithm.
     * @param arrString     string array to be sorted.
     * @param startIndex    starting index of the array.
     * @param endIndex      last index of the array.
     */
    public void quickSort(String[] arrString, int startIndex, int endIndex){

        if (startIndex < endIndex){

            int partition = partition(arrString, startIndex, endIndex);
            quickSort(arrString, startIndex, partition - 1);
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

        String pivot = arrString[endIndex];
        int returnIndex = startIndex - 1;

        for (int counter = startIndex; counter < endIndex; counter++) {

            if (arrString[counter].compareToIgnoreCase(pivot) < 0) {
                returnIndex++;
                swapValues(arrString, arrString[returnIndex], returnIndex, arrString[counter], counter);
            }

        }

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
        arrString[arrStringTempPosition] = pivotString;
        arrString[setStringIndex] = temp;
    }

    /**
     * Prints the array.
     * @param arrStrings        string array to be printed.
     * @param arrStringsIndex   index of arrStrings.
     */
    public void printArray(String[] arrStrings, int[] arrStringsIndex){

        int arrIndex = 0;
        int space = 0, gap = arrStrings.length;

        System.out.println();

        for (arrIndex = 0; arrIndex < arrStrings.length; arrIndex++) {

            while (gap != 0){
                gap /= 10;
                space++;
            }

            System.out.printf("%" + space + "d: ", arrStringsIndex[arrIndex]);
            System.out.println(arrStrings[arrIndex]);
        }

    }
}
