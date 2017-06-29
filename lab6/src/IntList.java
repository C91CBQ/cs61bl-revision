import java.util.List;

/**
 * Created by qibao on 2017/6/29.
 */
public class IntList {

    /** The head of the list is the first node in the list. If the list is empty, head is null **/
    private IntListNode head;
    private int size;

    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    public IntList() {
    }

    /** IntListNode is a nested class. It can be instantiated when associated with an instance of
     *  IntList.
     *  **/
    public static class IntListNode {
        int item;
        IntListNode next;

        public IntListNode(int item) {
            this.item = item;
        }

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public int get(int position) {
        if (position < 0 || position >= this.getSize()) {
            throw new IndexOutOfBoundsException();
        }
        IntListNode temp = head;
        int count = 0;
        while (count < position) {
            count++;
            temp = temp.next;
        }
        return temp.item;
    }

    public int getSize() {
        if (this.head == null) {
            return 0;
        }
        int count = 1;
        IntListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public IntList insert(int x, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (position >= this.getSize()) {
            if (this.getSize() == 0) {
                position = 0;
            } else {
                position = this.getSize();
            }
        }
        if (position == 0) {
            head = new IntListNode(x, head);
            return this;
        }
        IntListNode temp = head;
        int count = 1;
        while (count < position) {
            temp = temp.next;
            count++;
        }
        IntListNode inserted = new IntListNode(x, temp.next);
        temp.next = inserted;
        return this;
    }

    public static IntList merge(IntList l1, IntList l2) {
        if (l1 == null || l2 == null) {
            throw new NullPointerException();
        }
        if (l1.head == null) {
            if (l2.head == null) {
                return new IntList();
            } else {
                return deepCopy(l2);
            }
        }
        if (l2.head == null) {
            return deepCopy(l1);
        }
        IntList merged = new IntList();
        IntListNode temp1 = l1.head;
        IntListNode temp2 = l2.head;
        if (temp1.item <= temp2.item) {
            merged.head = new IntListNode(temp1.item);
            temp1 = temp1.next;
        } else {
            merged.head = new IntListNode(temp2.item);
            temp2 = temp2.next;
        }
        IntListNode temp = merged.head;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                if (temp1.item <= temp2.item) {
                    temp.next = new IntListNode(temp1.item);
                    temp = temp.next;
                    temp1 = temp1.next;
                } else {
                    temp.next = new IntListNode(temp2.item);
                    temp = temp.next;
                    temp2 = temp2.next;
                }
            } else if (temp1 == null) {
                temp.next = new IntListNode(temp2.item);
                temp = temp.next;
                temp2 = temp2.next;
            } else {
                temp.next = new IntListNode(temp1.item);
                temp = temp.next;
                temp1 = temp1.next;
            }
        }
        return merged;
    }

    public static IntList deepCopy(IntList l) {
        if (l == null) {
            throw new NullPointerException();
        }
        if (l.head == null) {
            return new IntList();
        }
        IntListNode temp_ori = l.head;
        IntList copied = new IntList();
        copied.head = new IntListNode(temp_ori.item);
        IntListNode temp_cop = copied.head;
        for (int i = 1; i < l.getSize(); i++) {
            temp_ori = temp_ori.next;
            temp_cop.next = new IntListNode(temp_ori.item);
            temp_cop = temp_cop.next;
        }
        return copied;
    }

    public void remove(int position) {
        if (position < 0 || position >= this.getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            this.head = this.head.next;
        } else {
            int count = 1;
            IntListNode temp = this.head;
            while (count < position) {
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        this.head = reverseHelper(this.head, null);
    }

    private static IntListNode reverseHelper(IntListNode l, IntListNode soFar) {
        if (l == null) {
            return soFar;
        } else {
            IntListNode temp = soFar;
            soFar = l;
            l = l.next;
            soFar.next = temp;
            return reverseHelper(l, soFar);
        }
    }
}
