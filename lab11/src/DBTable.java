import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBTable<T> {
    protected List<T> entries;

    public DBTable() {
        this.entries = new ArrayList<>();
    }

    public DBTable(Collection<T> lst) {
        entries = new ArrayList<>(lst);
    }

    public void add(T t) {
        entries.add(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DBTable<?> dbTable = (DBTable<?>) o;
        return entries != null ? entries.equals(dbTable.entries) : dbTable.entries == null;

    }

    /**
     * Add all items from a collection to the table
     */
    public void add(Collection<T> col) {
        col.forEach(this::add);
    }

    /**
     * Returns a copy of the entries in this table
     */
    List<T> getEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * getOrderedBy should create a new list ordered on the results of the getter,
     * without modifying the entries.
     * @param getter Gets a field from or processes an object of type T, and returns
     *               a Comparable.
     * @param <R> The type returned by the getter method, and the type ordered on.
     * @return A List of the contents of this table, ordered by the result of the getter.
     */
    public <R extends Comparable<R>> List<T> getOrderedBy(Function<T, R> getter) {
        return getEntries().stream()
                .sorted((u1, u2) -> getter.apply(u1).compareTo(getter.apply(u2)))
                .collect(Collectors.toList());
    }

    /**
     * groupByWhitelist() takes in a getter and a whitelist, and groups entries by the key given by
     * the getter as long as the key is present in the whitelist.
     * @param getter Gets a field from or process an object of type T.
     * @param whitelist A Collection of keys.
     * @param <R> The key type and return type of the getter.
     * @return A map from each key allowed to a list of the matching entries.
     * All keys present in this DB as obtained by the getter and in the whitelist are allowed.
     */
    public <R> Map<R, List<T>> groupByWhitelist(Function<T, R> getter, Collection<R> whitelist) {
        return getEntries().stream()
                .filter(u -> whitelist.contains(getter.apply(u)))
                .collect(Collectors.groupingBy(getter));
    }

    /**
     * Creates a DBTable that contains the elements as obtained by the getter.
     * For example, getting a DBTable of usernames would look like this:
     * DBTable<String> names = table.getSubtableOf(User::getUsername);
     */
    public <R> DBTable<R> getSubtableOf(Function<T, R> getter) {
        return new DBTable<>(getEntries().stream()
                .map(u -> getter.apply(u))
                .collect(Collectors.toList())
        ); 
    }

    /**
     * Create a list where each entry is duplicated a number of times according to the integer value
     * given by the getter. For example:
     *         DBTable<User> t = new DBTable<>(Arrays.asList(
     *             new User(2, "daniel", "dando@gmail.com"),
     *             new User(3, "matt", "italy@gmail.com"),
     *             new User(1, "sarahjkim", "potato@potato.com"),
     *             new User(1, "alanyao", "potato@cs61bl.org")
     *         ));
     *         System.out.println("t = " + t.duplicateOn(User::getId));
     * should print out the daniel object twice, matt 3 times, and the remaining two once.
     */
    public <R extends Number> List<T> duplicateOn(Function<T, R> getter) {
        return getEntries().stream()
                .flatMap(t ->
                    Stream.iterate(t, UnaryOperator.identity()).limit(getter.apply(t).intValue())
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        /* Basic test DB */
        DBTable<User> t = new DBTable<>(Arrays.asList(
                new User(2, "daniel", "dando@gmail.com"),
                new User(3, "matt", "italy@gmail.com"),
                new User(1, "sarahjkim", "potato@potato.com"),
                new User(1, "alanyao", "potato@cs61bl.org")
        ));
        List<User> l = t.getOrderedBy(User::getUsername);
        System.out.println(l);

        System.out.println("t = " + t.groupByWhitelist(User::getId, Arrays.asList(1, 2)));
        System.out.println(t.duplicateOn(User::getId));
    }
}
