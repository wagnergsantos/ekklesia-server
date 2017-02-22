package br.com.geracaoelias.ekklesia_server.model;

import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.geracaoelias.ekklesia_server.model.converter.CargoConverter;
import br.com.geracaoelias.ekklesia_server.model.converter.EscolaridadeConverter;
import br.com.geracaoelias.ekklesia_server.model.converter.EstadoCivilConverter;
import br.com.geracaoelias.ekklesia_server.model.converter.EstadoConverter;
import br.com.geracaoelias.ekklesia_server.model.converter.SituacaoMembroConverter;
import lombok.Data;

@Data
@XmlRootElement
@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = "Membro.default", attributeNodes = {
        @NamedAttributeNode("igreja")
    })
})
@Entity
public class Membro
{

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 70)
    private String nome;

    @Size(min = 4, max = 70)
    private String endereço;

    private Integer cep;

    @Size(min = 4, max = 60)
    private String bairro;

    @Size(min = 4, max = 60)
    private String cidade;

    @Column(name = "estado_sigla", length = 2, nullable = false)
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    @Size(min = 4, max = 60)
    private String pais;

    @Size(min = 4, max = 70)
    private String nomePai;

    @Size(min = 4, max = 70)
    private String nomeMae;
    
    @Email
    private String email;

    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataBatismo;

    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataCasamento;

    @Column(name = "estadoCivil_id")
    @Convert(converter = EstadoCivilConverter.class)
    private EstadoCivil estadoCivil;

    @Column(name = "escolaridade_id")
    @Convert(converter = EscolaridadeConverter.class)
    private Escolaridade escolaridade;

    private String nacionalidade;

    private String naturalidade;

    private String conjuge;

    @Column(name = "cargo_id")
    @Convert(converter = CargoConverter.class)
    private Cargo cargo;

    @Column(name = "situacao_id")
    @Convert(converter = SituacaoMembroConverter.class)
    private SituacaoMembro situacao;

    @Column(length = 14)
    private String rg;

    @Column(length = 11)
    private String cpf;

    @Column(length = 11)
    private String telefoneResidencial;

    @Column(length = 11)
    private String telefoneComercial;

    @Column(length = 11)
    private String telefoneCelular;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataModificacao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,targetEntity=Igreja.class)
    private Igreja igreja;
    
    @Override
    public int hashCode()
    {
        try {
            final int prime = 31;
            int result = 1;

            Method m = getClass().getDeclaredMethod("getId");
            Object obj = m.invoke(this, (Object[]) null);
            if (obj != null) {
                int tempHashCode = obj.hashCode();
                result = prime * result + tempHashCode;
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Resolve a questão do 'instanceof/isAssignableFrom' devido ao proxy do Hibernate.
     */
    @Override
    public boolean equals(Object obj)
    {
        try {
            if (obj == null) {
                return false;
            }
            if ((this == obj)) {
                return true;
            }

            // resolve comparacao entre entidades transientes e entidades com proxy
            Class<?> c1 = Hibernate.getClass(this);
            Class<?> c2 = Hibernate.getClass(obj);

            if (!c1.equals(c2)) {
                return false;
            }

            Method m = getClass().getDeclaredMethod("getId");

            Object myValue = m.invoke(this, (Object[]) null);
            Object otherValue = m.invoke(obj, (Object[]) null);

            if (myValue != null && otherValue == null)
                return false;

            if (myValue == null && otherValue != null)
                return false;

            if (myValue != null && otherValue != null) {
                if (!myValue.equals(otherValue))
                    return false;
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
