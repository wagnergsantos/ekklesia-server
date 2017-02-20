package br.com.geracaoelias.ekklesia_server.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EnumUtils
{
    
    public static interface EnumProperty<T extends Enum<T>,U> {
        U getValue(T type);
    }
    
    public static <T extends Enum<T>, U> Map<U,T> createLookup (Class<T> enumTypeClass, EnumProperty<T, U> prop){
        Map<U,T> lookup = new HashMap<>();
        for (T type : enumTypeClass.getEnumConstants()){
            lookup.put(prop.getValue(type), type);
        }
        return Collections.unmodifiableMap(lookup);
    }
}