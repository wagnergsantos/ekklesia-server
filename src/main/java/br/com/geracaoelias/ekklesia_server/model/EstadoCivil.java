package br.com.geracaoelias.ekklesia_server.model;

import java.util.Map;

import br.com.geracaoelias.ekklesia_server.util.EnumUtils;

public enum EstadoCivil
{
    CASADO(1, "Casado"),
    DIVORCIADO(2, "Divorciado"),
    SOLTERO(3, "Solteiro"),
    VIUVO(4, "Viúvo");
    
    private static final EnumUtils.EnumProperty<EstadoCivil, Integer> ENUM_PROP;
    private static final Map<Integer, EstadoCivil> LOOKUP_MAP;
    
    static {
        ENUM_PROP = new EnumUtils.EnumProperty<EstadoCivil, Integer>()
        {

            @Override
            public Integer getValue(EstadoCivil type)
            {
                return type.getId();
            }
            
        };
        
        LOOKUP_MAP = EnumUtils.createLookup(EstadoCivil.class, ENUM_PROP);
    }
    
    public static EstadoCivil fromValue(Integer id){
        return LOOKUP_MAP.get(id);
    }

    private Integer id;

    private String descricao;

    EstadoCivil(Integer id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId()
    {
        return id;
    }

    public String getDescricao()
    {
        return descricao;
    }

}
