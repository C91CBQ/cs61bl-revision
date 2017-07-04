public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     * @param o Object to insert
     */
    public void insertBack(Object o) {
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public Object get(int position) {
        DLNode curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /* Fill these in! */

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the getSize of the list, insert into
     *            the end of the list.
     */
    public void insert(Object o, int position) {
        // fill me in
        if (position < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == 0) {
            sentinel.next = new DLNode(o, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            if (position > this.size) {
                position = this.size;
            }
            DLNode temp = sentinel;
            while (position > 0) {
                temp = temp.next;
                position--;
            }
            temp.next = new DLNode(o, temp, temp.next);
            temp.next.next.prev = temp.next;
        }
        size++;
    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(Object o) {
        // fill me in
        this.insert(o, 0);
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(Object o) {
        // fill me in
        DLNode temp = sentinel;
        while (temp.next != sentinel) {
            if (temp.next.item.equals(o)) {
                remove(temp.next);
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        // fill me in
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        // fill me in
        DLNode temp = sentinel;
        while (temp.next != sentinel) {
            temp = temp.next;
            temp.next = new DLNode(temp.item, temp, temp.next);
            temp.next.next.prev = temp.next;
            temp = temp.next;
        }
        size = 2 * size;
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        DLNode temp = sentinel;
        do {
            DLNode storage = temp.next;
            temp.next = temp.prev;
            temp.prev = storage;
            temp = temp.prev;
        } while (temp != sentinel);
    }

    public static void main(String[] args) {
        // you can add some quick tests here if you would like
    }
}
