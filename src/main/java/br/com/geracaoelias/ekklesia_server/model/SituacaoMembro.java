package br.com.geracaoelias.ekklesia_server.model;

import java.util.Map;

import br.com.geracaoelias.ekklesia_server.util.EnumUtils;

public enum SituacaoMembro
{
    AFASTADO(1, "Afastado"),
    ATIVO(2, "Ativo"),
    TRANSFERIDO(3, "Transferido");

    private static final EnumUtils.EnumProperty<SituacaoMembro, Integer> ENUM_PROP;

    private static final Map<Integer, SituacaoMembro> LOOKUP_MAP;

    static {
        ENUM_PROP = new EnumUtils.EnumProperty<SituacaoMembro, Integer>()
        {

            @Override
            public Integer getValue(SituacaoMembro type)
            {
                return type.getId();
            }

        };

        LOOKUP_MAP = EnumUtils.createLookup(SituacaoMembro.class, ENUM_PROP);
    }

    public static SituacaoMembro fromValue(Integer id)
    {
        return LOOKUP_MAP.get(id);
    }

    private Integer id;

    private String descricao;

    SituacaoMembro(Integer id, String descricao)
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
