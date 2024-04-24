package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        //super();
        addCheck("required", obj -> obj == null || obj instanceof Map<?, ?>);
    }

    public MapSchema required() {
        addCheck("required", value -> !isNull(value));
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> size == ((Map<?, ?>) value).size());
        return this;
    }

//    public <T> MapSchema shape(Map<String, BaseSchema<T>> map) {
//        addCheck("shape", shapeCheck(map));
//    }

    public MapSchema shape(Map<String, BaseSchema<String>> inputSchema) {
        addCheck("shape", map ->
                    inputSchema.entrySet().stream().allMatch(e -> {
                        var data = ((Map<?, ?>) map).get(e.getKey());
                        //var schema = e.getValue();
                        return e.getValue().isValid((String) data);

                    }));

//            for (Map.Entry<String, BaseSchema<T>> entry: inputSchema.entrySet()) {
//                String key = entry.getKey();
//                Map name = (Map) map;
//                var data = name.get(key);
//                var schema = inputSchema.get(key);
//                return schema.isValid((T) data);
//                if (!schema.isValid((String) data)) {
//                    return false;
//                }
//            }
//            return true;
//        };
        return this;
    }
}
