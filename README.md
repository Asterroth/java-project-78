### Hexlet tests and linter status:
[![Actions Status](https://github.com/Asterroth/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Asterroth/java-project-78/actions)
[![Java CI](https://github.com/Asterroth/java-project-78/actions/workflows/java_ci.yml/badge.svg)](https://github.com/Asterroth/java-project-78/actions/workflows/java_ci.yml)

### Валидатор данных

## Краткое описание
Проект библиотеки для проверки корректности (валидации) данных, в зависимости от их типа: строки, числа и объектов типа `Map`.

### Валидация строк
Реализация проверки строки по валидаторам:
- `required` – любая непустая строка
- `minLength` – строка равна или длиннее заданного
- `contains` – строка содержит определённую подстроку
### Валидация чисел
Реализация проверки числа по валидаторам:
- `required` – любое число включая ноль
- `positive` – положительное число
- `range` – диапазон (включая границы)
### Валидация объектов типа Map
Реализация проверки объектов типа `Map` по валидаторам:
- `required` – требуется тип данных Map
- `sizeof` – количество пар ключ-значений в объекте Map должно быть равно заданному

### Валидация вложенных типов
Проверка данных внутри объекта типа `Map` по валидатору `shape`

### Примеры использования
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// Strings
StringSchema schema = v.string().required().minLength(5).contains("hex");
schema.isValid("hexlet"); // true
schema.isValid(""); // false

// Numbers
NumberSchema schema = v.number().required().positive().range(5, 10);
schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with structure checking support
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
