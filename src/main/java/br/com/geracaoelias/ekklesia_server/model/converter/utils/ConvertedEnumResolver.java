package br.com.geracaoelias.ekklesia_server.model.converter.utils;

import java.util.HashMap;
import java.util.Map;

public class ConvertedEnumResolver<T extends ConvertedEnum<Y>, Y> {

	private final Map<Y, T> dbValues = new HashMap<>();

	public ConvertedEnumResolver(Class<T> enumClass) {
		for (T t : enumClass.getEnumConstants()) {
			dbValues.put(t.toDbValue(), t);
		}
	}

	public T get(Y dbValue) {	    
		return dbValue == null ? null : find(dbValue);
	}
	
	private T find(Y dbValue) {
        T enumValue = dbValues.get(dbValue);
       
        return enumValue;
    }
}