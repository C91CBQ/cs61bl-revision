import java.util.Iterator;

/**
 * Created by qibao on 2017/8/11.
 */
public class HashMap<K,V> implements Map61BL<K,V> {

    private int capacity;

    private double loadFactor = 0.75;

    private Entry[] list;

    /** Create a new hash map with a default array of size 16 and load factor of 0.75. */
    public HashMap() {
        capacity = 16;
        list = new Entry[capacity];
    }

    /** Create a new hash map with an array of size INITIALCAPACITY and default load factor of 0.75. */
    public HashMap(int initialCapacity) {
        capacity = initialCapacity;
        list = new Entry[capacity];
    }

    /** Create a new hash map with INITIALCAPACITY and LOADFACTOR. */
    public HashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        capacity = initialCapacity;
        list = new Entry[capacity];
    }

    /** Return the capacity of this hash table's internal array. */
    public int capacity() {
        return capacity;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry {

        /** The key used for lookup. */
        private K _key;
        /** The associated value. */
        private V _value;

        private Entry _next;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(K key, V value) {
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

}
