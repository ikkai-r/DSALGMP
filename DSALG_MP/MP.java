package DSALG_MP;

import java.util.*;

public class MP {
    private String mainString;
    private final ArrayList<String> arrayLSuffix = new ArrayList<>();
    MPInsertionSort insertionSort = new MPInsertionSort();
    MPQuickSort quickSort = new MPQuickSort();

    /**
     * Sets the string to be sorted, with the help of validateString().
     * @param input     user input string that is to be sorted.
     *                  Input must be a text T of length n, from the alphabet {a,c,g,t}
     */
    public void setString(String input) {
        if (validateString(input)) {
            this.mainString = input;
        } else {
            System.out.println("Error: Invalid character");
            System.exit(0);
        }
    }

    /**
     * Gets the string to make accessible for classes outside.
     * @return      user input string.
     */
    public String getString() {
        return this.mainString;
    }

    /**
     * Checks if the string is a text T of length n, from the alphabet {a,c,g,t}.
     * @param input     user input string to be checked.
     * @return          true if it is from the alphabet {a,c,g,t},
     *                  and false if not.
     */
    public boolean validateString(String input) {

        int index = 0;
        boolean valid = true;
        String checkNew = input.toLowerCase();
        String check = checkNew.strip();

        do {
            switch (check.charAt(index)) {
                case 'a', 'c', 'g', 't' -> index++;
                default -> valid = false;
            }
        } while (valid & index < input.length());

        return valid;
    }

    /**
     *  Creates an array for the array suffixes, and sorts it in lexicographic order.
     */
    public void suffixArray() {

        int[] arrSuffTIni = new int[getString().length()]; // unsorted
        int[] arrSuffixT = new int[getString().length()]; // sorted
        int startIndex = 0;

        String[] arrStrSuffixT = makeArrSuffixT(getString(), getString().length());
        String[] arrInsertT = new String[getString().length()];
        String[] arrQuickT = new String[getString().length()];

        System.arraycopy(arrStrSuffixT, 0, arrInsertT, 0, arrStrSuffixT.length);
        System.arraycopy(arrStrSuffixT, 0, arrQuickT, 0, arrStrSuffixT.length);

        insertionSort.insertionSort(arrInsertT);
        quickSort.quickSort(arrQuickT, startIndex, (arrStrSuffixT.length-1));

        for (int i = 0; i < getString().length(); i++){
            arrSuffTIni[i] = getIndex(getString(), arrStrSuffixT[i]);
            arrSuffixT[i] = getIndex(getString(), arrInsertT[i]);
            arrSuffixT[i] = getIndex(getString(), arrQuickT[i]);
        }

        System.out.println("\n\n============================");
        System.out.println("\nUNSORTED: ");
        printArray(arrStrSuffixT, arrSuffTIni);

        System.out.println("\n\n============================");
        System.out.println("\nINSERTION SORT: ");
        printArray(arrInsertT, arrSuffixT);

        System.out.println("\n\n============================");
        System.out.println("\nQUICK SORT: ");
        printArray(arrQuickT, arrSuffixT);

        System.out.println("============================");
        System.out.println("\nSUFFIX ARRAY: ");

        for (int index = 0; index < arrStrSuffixT.length; index++) {
            System.out.print(arrSuffixT[index] + " ");
        }

    }

    /**
     * Gets the index of the string.
     * @param string        original string.
     * @param compare       string to be compared.
     * @return
     */
    public int getIndex(String string, String compare) {

        int returnValue =  string.length() - compare.length();

        return returnValue;
    }

    /**
     * Gets the array and divides it into a string array with its suffixes.
     * @param T        string to be divided into its array.
     * @param n        string length.
     * @return         T but in its respective array index.
     */
    public String[] makeArrSuffixT(String T, int n) {

        String[] arrSuffix = new String[n];
        StringBuilder substring = new StringBuilder();

        for (int startIndex = 0; startIndex < n; startIndex++) {

            substring.append(T.substring(startIndex));
            this.arrayLSuffix.add(String.valueOf(substring));

            substring.delete(0, n - startIndex);

            arrSuffix[startIndex] = this.arrayLSuffix.get(startIndex);
        }

        return arrSuffix;
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
