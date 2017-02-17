package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;

public abstract class EnumAttributeConverter<X extends ConvertedEnum<Y>, Y> implements AttributeConverter<X, Y> {
	@Override
	public final Y convertToDatabaseColumn(X x) {
		return x.toDbValue();
	}
}
