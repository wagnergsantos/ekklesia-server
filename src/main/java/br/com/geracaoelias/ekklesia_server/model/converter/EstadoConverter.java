package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.Estado;

@Converter(autoApply = true)
public class EstadoConverter implements AttributeConverter<Estado, String>
{

    @Override
    public String convertToDatabaseColumn(Estado estado)
    {       
        return estado != null ? estado.getSigla() : null;
    }

    @Override
    public Estado convertToEntityAttribute(String sigla)
    {
        return Estado.fromValue(sigla);
    }

}
