public class Misc {

    static void varArgsDemo(int ... x) {
        for (int i :
                x) {
            System.out.println(i);
        }
    }

    static void varArgsDemo(boolean b, int ... x) {
        System.out.println(b);
        for (int i :
                x) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        varArgsDemo(0, 1, 2);
        varArgsDemo(true, 1, 2, 3);
    }

}
