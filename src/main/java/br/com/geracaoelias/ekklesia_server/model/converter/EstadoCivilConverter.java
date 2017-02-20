package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.EstadoCivil;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(EstadoCivil tipoEnum)
    {       
        return tipoEnum != null ? tipoEnum.getId() : null;
    }

    @Override
    public EstadoCivil convertToEntityAttribute(Integer id)
    {
        return EstadoCivil.fromValue(id);
    }

}
