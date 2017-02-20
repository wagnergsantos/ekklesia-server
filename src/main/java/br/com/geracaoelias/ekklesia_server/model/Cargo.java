package br.com.geracaoelias.ekklesia_server.model;

import java.util.Map;

import br.com.geracaoelias.ekklesia_server.util.EnumUtils;

public enum Cargo
{
    DIACONO(1, "Diácono"),
    EVANGELISTA(2, "Evangelista"),
    MISSIONARIO(3, "Missionário"),
    PASTOR(4, "Pastor");

    private static final EnumUtils.EnumProperty<Cargo, Integer> ENUM_PROP;

    private static final Map<Integer, Cargo> LOOKUP_MAP;

    static {
        ENUM_PROP = new EnumUtils.EnumProperty<Cargo, Integer>()
        {

            @Override
            public Integer getValue(Cargo type)
            {
                return type.getId();
            }

        };

        LOOKUP_MAP = EnumUtils.createLookup(Cargo.class, ENUM_PROP);
    }

    public static Cargo fromValue(Integer id)
    {
        return LOOKUP_MAP.get(id);
    }

    private Integer id;

    private String descricao;

    Cargo(Integer id, String descricao)
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
