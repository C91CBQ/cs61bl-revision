/**
 *  A simple mapping from string names to string values backed by an array.
 *  Supports only A-Z for the first character of the key name. Values can be
 *  any valid string.
 *
 *  @author You
 */
public class SimpleNameMap {

    private int capacity = 0;

    private Entry[] list = new Entry[capacity];

    public int capacity() {
        return capacity;
    }

    public boolean containsKey(String key) {
        if (!isValidName(key))
            return false;
        Entry temp = list[hash(key)];
        while(temp != null) {
            if (temp._key.equals(key))
                return true;
            temp = temp.next();
        }
        return false;
    }

    public String get(String key) {
        if (!isValidName(key))
            return null;
        Entry temp = list[hash(key)];
        while(temp != null) {
            if (temp._key.equals(key))
                return temp._value;
            temp = temp.next();
        }
        return null;
    }

    public void put(String key, String value) {
        if (!isValidName(key))
            return;
        Entry temp = list[hash(key)];
        if (temp == null) {
            list[hash(key)] = new Entry(key, value);
            return;
        }
        while(temp != null) {
            if (temp._key.equals(key)) {
                temp._value = value;
                return;
            }
            temp = temp.next();
        }
    }

    public String remove(String key) {
        if (!containsKey(key))
            return null;
        Entry temp = list[hash(key)];
        if (temp._key.equals(key)) {
            list[hash(key)] = temp.next();
            return temp._value;
        }
        while (temp.next() != null) {
            if (temp.next()._key.equals(key)) {
                String value = temp.next()._value;
                temp._next = temp.next().next();
                return value;
            }
            temp = temp.next();
        }
        return null;
    }

    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry {

        /** The key used for lookup. */
        private String _key;
        /** The associated value. */
        private String _value;

        private Entry _next;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(String key, String value) {
            _key = key;
            _value = value;
            _next = null;
        }

        public void addNext(Entry entry) {
            _next = entry;
        }

        public Entry next() {
            return _next;
        }

        /** Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return _key.equals(other._key);
        }

        /** Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }

    }

    /** Returns true if the given KEY is a valid name that starts with A-Z. */
    private static boolean isValidName(String key) {
        return 'A' <= key.charAt(0) && key.charAt(0) <= 'Z';
    }

    private int hash(String key) {
        return key.hashCode() % 0x7FFFFFFF;
    }

}