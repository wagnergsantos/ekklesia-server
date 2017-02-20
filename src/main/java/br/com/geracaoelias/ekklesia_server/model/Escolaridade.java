package br.com.geracaoelias.ekklesia_server.model;

import java.util.Map;

import br.com.geracaoelias.ekklesia_server.util.EnumUtils;

public enum Escolaridade
{
    FUNDAMENTAL(1, "Ensino Fundamental"),
    MEDIO(2, "Ensino Médio"),
    SUPERIOR(3, "Ensino Superior"),
    ESPECIALIZACAO(4, "Especialização"),
    MESTRADO(5, "Mestrado"),
    DOUTORADO(6, "Doutorado");

    private static final EnumUtils.EnumProperty<Escolaridade, Integer> ENUM_PROP;

    private static final Map<Integer, Escolaridade> LOOKUP_MAP;

    static {
        ENUM_PROP = new EnumUtils.EnumProperty<Escolaridade, Integer>()
        {

            @Override
            public Integer getValue(Escolaridade type)
            {
                return type.getId();
            }

        };

        LOOKUP_MAP = EnumUtils.createLookup(Escolaridade.class, ENUM_PROP);
    }

    public static Escolaridade fromValue(Integer id)
    {
        return LOOKUP_MAP.get(id);
    }

    private Integer id;

    private String descricao;

    Escolaridade(Integer id, String descricao)
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
