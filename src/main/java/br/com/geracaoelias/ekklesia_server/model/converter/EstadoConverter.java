package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.Estado;

@Converter(autoApply = true)
public class EstadoConverter  extends EnumAttributeConverter<Estado, String> {
	@Override
	public Estado convertToEntityAttribute(String valor) {
		return Estado.fromDbValue(valor);
	}

}
