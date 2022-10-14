package DSALG_MP;

import java.util.*;

public class MPInsertionSort {

    /**
     * Sorts the string array using the insertion sort algorithm.
     * @param arrString     string array to be sorted.
     */
    public void insertionSort(String[] arrString) {

        int outerIndex = 0, innerIndex = 0;
        String key = "";

        for (outerIndex = 0; outerIndex < arrString.length; outerIndex++) {
            key = arrString[outerIndex];
            innerIndex = outerIndex - 1;

            while (innerIndex >= 0 && arrString[innerIndex].compareToIgnoreCase(key) > 0) {
                arrString[innerIndex + 1] = arrString[innerIndex];
                innerIndex--;
            }

            arrString[innerIndex + 1] = key;
        }
    }

}
