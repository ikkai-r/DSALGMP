package DSALG_MP;

import java.util.Scanner;

public class MPDriver {
    public static void main(String[] args) {

        MP mp = new MP();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = input.nextLine();

        mp.setString(text);
        mp.suffixArray();

    }
}