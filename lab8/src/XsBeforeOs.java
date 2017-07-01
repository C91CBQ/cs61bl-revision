public class XsBeforeOs {

    // Rearrange the elements of values so that all the Xs precede all
    // the Os.
    public static void rearrange(char[] values) {
        int lastXpos = values.length - 1;
        for (int k = 0; k < values.length; k++) {
            if (values[k] == 'O') {
                if (k >= lastXpos) {
                    break;
                }
                for (int i = lastXpos; i > k; i--) {
                    if (values[i] == 'X') {
                        values[i] = 'O';
                        values[k] = 'X';
                        lastXpos = i - 1;
                    }
                }
                // YOUR CODE HERE
            }
            try {
                isOK(values, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
    }

    // Check for consistency. All the Xs in elements 0 to k of values should
    // precede all the Os. Throw an IllegalStateException if this is not
    // consistent.
    public static void isOK (char[] values, int k) {
        boolean isOrdered = false;
        for (int i = 0; i < k; i++) {
            if (values[i] == 'O') {
                isOrdered = true;
            } else if (values[i] == 'X' && isOrdered) {
                throw new IllegalStateException();
            }
        }
        // YOUR CODE HERE

    }
}
