package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer {
    public static String serialize(Object obj) throws IllegalAccessException {
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        String data = "";

        for(Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                data += field.getName() + "=";
                if (field.getType().equals(int.class)) {
                    data += field.getInt(obj);
                } else if (field.getType().equals(String.class)) {
                    data += (String) field.get(obj);
                }
                data += ";";

            }
        }
        return data;
    }
}
