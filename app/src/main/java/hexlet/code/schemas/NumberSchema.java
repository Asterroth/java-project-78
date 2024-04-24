package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", value -> {
            if (value == null) {
                return true;
            } else {
                return min <= (Integer) value && (Integer) value <= max;
            }
        });
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> {
            if (value == null) {
                return true;
            } else {
                return (Integer) value > 0;
            }
        });
        return this;
    }
}
