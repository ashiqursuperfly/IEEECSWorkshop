package exceptions;

import java.util.Random;

public class CommonExceptions {

    public static void main(String[] args) {

        int [] arr = new int[10];
        // System.out.println(arr[10]);

        /*
            int x = 2/0;
        */


        int stoi;
        try {
            String qty = "";
            stoi = Integer.parseInt(qty);
        } catch (NumberFormatException numberFormatException) {
            // this block only runs when an exception is thrown in the try block
            stoi = 0;
        }


        // normal execution

//        float stof = Float.parseFloat("123.21a");
//        double stod = Double.parseDouble("123.21a");

//        String s = null;
//        System.out.println(s.length());


    }

}
