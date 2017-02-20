package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.Cargo;

@Converter(autoApply = true)
public class CargoConverter implements AttributeConverter<Cargo, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(Cargo tipoEnum)
    {       
        return tipoEnum != null ? tipoEnum.getId() : null;
    }

    @Override
    public Cargo convertToEntityAttribute(Integer id)
    {
        return Cargo.fromValue(id);
    }

}
