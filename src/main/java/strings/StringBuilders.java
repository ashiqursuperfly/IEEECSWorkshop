package strings;

import java.util.Random;

public class StringBuilders {

    public static void main(String[] args) {

        StringBuilder veryDynamicString = new StringBuilder(); // vs StringBuffer?

        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            veryDynamicString
                    .append((char) (Math.abs(r.nextInt()) % 26 + 65))
                    .append('-');
        }

        System.out.println(veryDynamicString);

        veryDynamicString.deleteCharAt(veryDynamicString.length() - 1);
        System.out.println(veryDynamicString);

        veryDynamicString.insert(4, "GGWP-");
        System.out.println(veryDynamicString);
    }


}
