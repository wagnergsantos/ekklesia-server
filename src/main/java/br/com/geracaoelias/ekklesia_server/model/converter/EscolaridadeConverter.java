package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.Escolaridade;

@Converter(autoApply = true)
public class EscolaridadeConverter implements AttributeConverter<Escolaridade, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(Escolaridade tipoEnum)
    {       
        return tipoEnum != null ? tipoEnum.getId() : null;
    }

    @Override
    public Escolaridade convertToEntityAttribute(Integer id)
    {
        return Escolaridade.fromValue(id);
    }

}
