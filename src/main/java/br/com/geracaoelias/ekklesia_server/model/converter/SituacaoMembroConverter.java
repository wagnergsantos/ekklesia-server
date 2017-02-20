package br.com.geracaoelias.ekklesia_server.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.geracaoelias.ekklesia_server.model.SituacaoMembro;

@Converter(autoApply = true)
public class SituacaoMembroConverter implements AttributeConverter<SituacaoMembro, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(SituacaoMembro tipoEnum)
    {       
        return tipoEnum != null ? tipoEnum.getId() : null;
    }

    @Override
    public SituacaoMembro convertToEntityAttribute(Integer id)
    {
        return SituacaoMembro.fromValue(id);
    }

}
