package hexlet.code.schemas;

import static java.util.Objects.isNull;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        super();
    }

    public StringSchema required() {
        addCheck("required", value -> !isNull(value) && !value.equals(""));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", value -> length <= value.toString().length());
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", value -> value.toString().contains(substring));
        return this;
    }
}
