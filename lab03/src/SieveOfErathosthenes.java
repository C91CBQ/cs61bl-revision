import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qibao on 2017/6/24.
 */
public class SieveOfErathosthenes {

    public static void findPrimeNumber(int n) {
        boolean[] list = new boolean[n];
        Arrays.fill(list, 1, n, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (list[i - 1]) {
                for (int j = i * i; j <= n; j += i) {
                    list[j - 1] = false;
                }
            }
        }
        ArrayList<Integer> primeNum = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (list[i]) {
                primeNum.add(i + 1);
                System.out.println((i + 1) + " ");
            }
        }
    }

    public static void main(String args[]) {
        findPrimeNumber(100);
    }
}
