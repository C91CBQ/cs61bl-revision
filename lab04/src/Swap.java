/**
 * Created by qibao on 2017/6/25.
 */
public class Swap {
    int counter = 0;            // instance variable
    int counter2 = 0;           // instance variable
    static int counter3 = 0;    // static, is a class variable

    /* swap() iterates through the array from the start_index and
       swaps elements forward if they are in descending order with respect
       to the next element, and then prints out the number of swaps. */
    public int swap(int[] arr, int start_index) {   // beginning of method block
        int counter = 0;
        while (start_index < arr.length - 1) {          // beginning of while block
            if (arr[start_index] > arr[start_index+1]) {
                int temporary = arr[start_index];   // available inside if statement
                arr[start_index] = arr[start_index+1];
                arr[start_index+1] = temporary;
                counter = counter + 1;              // references local variable counter
                counter2 = counter2 + 2;            // references instance variable
                counter3 = counter3 + 1;            // references class variable
            }
            start_index = start_index + 1;          // references local variable start_index
        }                                           // end of while block
        System.out.println("Swapped " + counter + " times.");
        return counter;
    }                                               // end of method block

    public static void main(String[] args) {
        Swap s = new Swap();
        int[] arr = {3, 2, 6, 1, 4};
        s.swap(arr, 0);     // expect to swap 3 times, (3, 2), (6, 1) and (6, 4)
        // -> arr is {2, 3, 1, 4, 6}
        s.swap(arr, 0);     // expect to swap 1 time -> arr is {2, 1, 3, 4, 6}
    }
}
