package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> checks;

    protected BaseSchema() {
        this.checks = new HashMap<>();
    }

    protected final void addCheck(String name, Predicate check) {
        checks.put(name, check);
    }

//    public final boolean isValid(T value) {
//        return checks.values().stream().allMatch(check -> check.test(value));
//    }

    public final boolean isValid(T value) {
        for (var ch : checks.entrySet()) {
            if (!ch.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }
}
