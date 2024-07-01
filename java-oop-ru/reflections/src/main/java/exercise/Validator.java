package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> validate(Address address) {
        List<String> listFieldName = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(address);
                    if (value == null) {
                        listFieldName.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return listFieldName;
    }
    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        List<String> listFieldName = validate(address);
        for (String s : listFieldName) {
            notValidFields.put(s, List.of("can not be null"));
        }
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLength = field.getAnnotation(MinLength.class);
                if (minLength != null) {
                    try {
                        Object value = field.get(address);
                        int min = minLength.minLength();
                        if (String.valueOf(value).length() < min) {
                            notValidFields.put(field.getName(), List.of("length less than " + min));
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return notValidFields;
    }
}
// END
