package DSALG_MP;

import java.util.ArrayList;

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

        //calls validate string to check if the input only contains the
        //given alphabet set
        if (validateString(input)) {
            this.mainString = input;
        } else {
            //if not valid, it will end the program
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
        String checkNew = input.toLowerCase(); //to make the comparison easier
        String check = checkNew.strip(); //removes the white spaces in the string

        do {
            switch (check.charAt(index)) {
                case 'a', 'c', 'g', 't' -> index++;
                default -> valid = false;
            }
        } while (valid && index < input.length());
        //checks from beginning to end
        //if it is invalid, it will end the loop and return false
        //else, it will return true

        return valid;
    }

    /**
     *  Creates an array for the array suffixes, and sorts it in lexicographic order.
     */
    public void suffixArray() {

        int[] arrSuffTIni = new int[getString().length()]; // unsorted
        int[] arrSuffixTQuick = new int[getString().length()]; // sorted by quick sort
        int[] arrSuffixTInsertion = new int[getString().length()]; // sorted by insertion sort
        int startIndex = 0;

        //creates a string array for the insertion sort, sorted string suffix, and quick sort
        String[] arrStrSuffixT = makeArrSuffixT(getString(), getString().length());
        String[] arrInsertT = new String[getString().length()];
        String[] arrQuickT = new String[getString().length()];

        //copies the string array with divided suffixes to their
        //respective arrays to individually sort them through the
        //insertion and quick sort algorithm
        System.arraycopy(arrStrSuffixT, 0, arrInsertT, 0, arrStrSuffixT.length);
        System.arraycopy(arrStrSuffixT, 0, arrQuickT, 0, arrStrSuffixT.length);

        //pass the specified arrays to the following algorithms accordingly
        insertionSort.insertionSort(arrInsertT);
        quickSort.quickSort(arrQuickT, startIndex, (arrStrSuffixT.length-1));

        //inserts the sorted suffix index for the
        //array based on the original string and the suffix
        for (int i = 0; i < getString().length(); i++){
            arrSuffTIni[i] = getIndex(getString(), arrStrSuffixT[i]);
            arrSuffixTInsertion[i] = getIndex(getString(), arrInsertT[i]);
            arrSuffixTQuick[i] = getIndex(getString(), arrQuickT[i]);
        }

        //display the unsorted and sorted suffixes
        //from the arrays with proper labels
        System.out.println("\n\n============================");
        System.out.println("\nUNSORTED: ");
        printArray(arrStrSuffixT, arrSuffTIni);

        System.out.println("\n\n============================");
        System.out.println("\nINSERTION SORT: ");
        printArray(arrInsertT, arrSuffixTInsertion);

        System.out.println("\n\n============================");
        System.out.println("\nQUICK SORT: ");
        printArray(arrQuickT, arrSuffixTQuick);

        System.out.println("\n\n============================");
        System.out.println("\nSUFFIX ARRAY: ");

        System.out.println("\nFrom Insertion Sort: ");
        for (int index = 0; index < arrStrSuffixT.length; index++) {
            System.out.print(arrSuffixTInsertion[index] + " ");
        }

        System.out.println();

        System.out.println("\nFrom Quick Sort: ");
        for (int index = 0; index < arrStrSuffixT.length; index++) {
            System.out.print(arrSuffixTQuick[index] + " ");
        }

    }

    /**
     * Gets the index of the string.
     * @param string        original string.
     * @param compare       string to be compared.
     * @return
     */
    public int getIndex(String string, String compare) {

        //returns the original index of the suffix array
        //by subtracting the original length of the string
        //to its suffix
        int returnValue =  string.length() - compare.length();

        return returnValue;
    }

    /**
     * Gets the array and divides it into a string array with its suffixes.
     * @param T        string to be divided into its array.
     * @param n        string length.
     * @return         array with the suffixes of string T.
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
     * Utility function that prints the array.
     * @param arrStrings        string array to be printed.
     * @param arrStringsIndex   index of arrStrings.
     */
    public void printArray(String[] arrStrings, int[] arrStringsIndex){

        int arrIndex = 0;
        int space = 0, gap = arrStrings.length;

        System.out.println();

        for (arrIndex = 0; arrIndex < arrStrings.length; arrIndex++) {

            //formatting purposes
            while (gap != 0){
                gap /= 10;
                space++;
            }

            System.out.printf("%" + space + "d: ", arrStringsIndex[arrIndex]);
            System.out.println(arrStrings[arrIndex]);
        }

    }
}
