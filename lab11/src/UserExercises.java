import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserExercises extends DBTable<User> {
    UserExercises() {
    }

    UserExercises(Collection<User> lst) {
        super(lst);
    }

    /**
     * Get an ordered List of Users, sorted first on age,
     * then on their id if the age is the same.
     */
    public List<User> getOrderedByAgeThenId() {
        return getEntries().stream()
                .sorted(Comparator.comparing(User::getAge))
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    /**
     * Get the average age of all the users.
     * If there are no users, the average is 0.
     */
    public double getAverageAge() {
        return getEntries().stream()
                .mapToInt(user -> user.getAge())
                .average()
                .getAsDouble();
    }

    /**
     * Group usernames by user age, for all users that have an age greater than min_age.
     * Usernames with ages less than or equal to min_age are excluded.
     * Returns a Map from each age present to a list of the usernames that have that age.
     */
    public Map<Integer, List<String>> groupUsernamesByAgeOlderThan(int min_age) {

        return getEntries().stream()
                .filter(user -> user.getAge() > min_age)
//                .map(user -> user.getUsername())
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.mapping(User::getUsername, Collectors.toList())));
    }
}
