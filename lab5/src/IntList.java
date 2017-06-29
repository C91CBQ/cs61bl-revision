/**
 * Created by qibao on 2017/6/29.
 */
public class IntList {

    private int item;
    private IntList next;

    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    public IntList(int item) {
        this(item, null);
    }

    public int item() {
        return item;
    }

    public IntList next() {
        return next;
    }

    public int get(int position) {
        if (position < 0 || position >= this.size()) {
            throw new IllegalArgumentException();
        } else {
            int count = 0;
            IntList temp = this;
            while (count < position) {
                temp = temp.next();
                count++;
            }
            return temp.item();
        }
    }

    public int size() {
        int count = 1;
        IntList temp = this;
        while (temp.next != null) {
            count++;
            temp = temp.next();
        }
        return count;
    }

    @Override
    public String toString() {
        String result = new String("( ");
        for (int i = 0; i < this.size(); i++) {
            result = result.concat(String.valueOf(this.get(i))).concat(" ");
        }
        result = result.concat(")");
        return result;
    }

    public boolean equals(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (o instanceof IntList) {
            isEqual:
            if (this.size() == ((IntList) o).size()) {
                for (int i = 0; i < this.size(); i++) {
                    if (this.get(i) != ((IntList) o).get(i)) {
                        break isEqual;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void add(int item) {
        IntList temp = this;
        for (int i = 1; i < this.size(); i++) {
            temp = temp.next();
        }
        temp.next = new IntList(item);
    }

    public int smallest() {
        int min = this.item;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) < min) {
                min = this.get(i);
            }
        }
        return min;
    }

    public static IntList append(IntList l1, IntList l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            IntList result = new IntList(l2.item());
            IntList temp = result;
            for (int i = 1; i < l2.size(); i++) {
                temp.next = new IntList(l2.get(i));
                temp = temp.next();
            }
            return result;
        } else if (l2 == null) {
            IntList result = new IntList(l1.item());
            IntList temp = result;
            for (int i = 1; i < l1.size(); i++) {
                temp.next = new IntList(l1.get(i));
                temp = temp.next();
            }
            return result;
        }
        IntList result = new IntList(l1.item());
        IntList temp = result;
        for (int i = 1; i < l1.size(); i++) {
            temp.next = new IntList(l1.get(i));
            temp = temp.next();
        }
        for (int i = 0; i < l2.size(); i++) {
            temp.next = new IntList(l2.get(i));
            temp = temp.next();
        }
        return result;
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

}
