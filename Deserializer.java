package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Deserializer {
    public static <T> T deserialize(String data, Object obj) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<T> cls = (Class<T>) obj.getClass();
        T newClass = (T) cls.newInstance();
        String[] arrValues = data.split(";");

        for (String value : arrValues) {
            String[] nameValue = value.split("=");
            Field field = newClass.getClass().getDeclaredField(nameValue[0]);

            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                if (field.getType().equals(int.class)) {
                    field.setInt(newClass, Integer.parseInt(nameValue[1]));
                } else if (field.getType().equals(String.class)) {
                    field.set(newClass, nameValue[1]);
                }

            }
        }
        return newClass;
    }
}