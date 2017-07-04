/**
 * Created by qibao on 2017/6/23.
 */
public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            }
            return false;
        } else {
            if (year % 4 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        if (args.length == 1) {
            int year = Integer.valueOf(args[0]);
            System.out.println(isLeapYear(year));
        } else {
            System.out.println("Please input one argument for year.");
        }
    }
}
