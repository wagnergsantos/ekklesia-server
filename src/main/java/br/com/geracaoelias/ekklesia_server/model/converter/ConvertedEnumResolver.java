package br.com.geracaoelias.ekklesia_server.model.converter;

import java.util.HashMap;
import java.util.Map;

public class ConvertedEnumResolver<T extends ConvertedEnum<Y>, Y> {

	private final String classCanonicalName;
	private final Map<Y, T> dbValues = new HashMap<>();

	public ConvertedEnumResolver(Class<T> enumClass) {
		classCanonicalName = enumClass.getCanonicalName();
		for (T t : enumClass.getEnumConstants()) {
			dbValues.put(t.toDbValue(), t);
		}
	}

	public T get(Y dbValue) {
		T enumValue = dbValues.get(dbValue);
		if (enumValue == null) {
			throw new IllegalArgumentException("Nenhum enum com o valor" + dbValue + " em " + classCanonicalName);
		}
		return enumValue;
	}
}