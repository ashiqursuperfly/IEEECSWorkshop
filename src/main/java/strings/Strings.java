package strings;

import java.util.Arrays;
import java.util.Random;

public class Strings {
    public static void main(String[] args) {

        String s1 = "IEEE";
        String s2 = "CS";

        System.out.println(s1 + s2);
        System.out.println(s1.substring(1, 4));

        String s3 = "Name, Price, Qty";
        String [] parts = s3.split(",");
        System.out.println(Arrays.toString(parts));

        s3 = "WELCOME123TO456IEEE456CS789";
        parts = s3.split("[0-9]+");
        System.out.println(Arrays.toString(parts));

        /* Why is this inefficient ? */
        String veryDynamicString = "";
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            veryDynamicString += (char)(Math.abs(r.nextInt()) % 26 + 65);
            veryDynamicString += "-";
        }
        /* creates 5 new strings -_- */

        System.out.println(veryDynamicString.substring(0, veryDynamicString.length()-1));


    }
}
