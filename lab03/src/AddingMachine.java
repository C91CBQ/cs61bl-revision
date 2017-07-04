import java.util.Scanner;

/**
 * Created by qibao on 2017/6/24.
 */
public class AddingMachine {

    public static int MAXIMUM_NUMBER_OF_INPUTS = 20;

    public static int[] storage = new int[MAXIMUM_NUMBER_OF_INPUTS];

    public static void running() {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int subtotal = 0;
        int input = -1;
        int index = 0;
        while (true) {
            int pre = input;
            input = scanner.nextInt();
            if (input == 0) {
                if (pre == 0) {
                    System.out.println("total " + total);
                    for (int i = 0; i < index; i++) {
                        System.out.println(storage[i]);
                    }
                } else {
                    System.out.println("subtotal " + subtotal);
                    subtotal = 0;
                }
            } else {
                storage[index++] = input;
                subtotal += input;
                total += input;
            }
        }
    }

    public static void main(String args[]) {
        running();
    }
}
