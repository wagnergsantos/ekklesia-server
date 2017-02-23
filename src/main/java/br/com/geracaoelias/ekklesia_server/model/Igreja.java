package br.com.geracaoelias.ekklesia_server.model;

import java.lang.reflect.Method;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.geracaoelias.ekklesia_server.model.converter.EstadoConverter;
import lombok.Data;

@Data
@XmlRootElement
@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = "Igreja.default", attributeNodes = {@NamedAttributeNode("membros")})})
@Entity
@XmlAccessorType(XmlAccessType.NONE)
public class Igreja
{
    
    @Id
    @GeneratedValue
    @XmlElement
    private Long        id;

    @NotEmpty
    @Size(min = 4, max = 70)
    @XmlElement
    private String      nome;

    @Email
    @XmlElement
    private String      email;

    @NotEmpty
    @Size(min = 4, max = 70)
    @XmlElement
    private String      dirigente;

    @Column(length = 14)
    @XmlElement
    private String      cnpj;

    @Column(length = 11)
    @XmlElement
    private String      telefone;

    @Column(name = "estado_sigla", length = 2, nullable = false)
    @Convert(converter = EstadoConverter.class)
    @XmlElement
    private Estado      estado;

    @XmlElement
    private Integer     cep;

    
    @Size(min = 4, max = 60)
    @XmlElement
    private String      bairro;

    @Size(min = 4, max = 60)
    @XmlElement
    private String      cidade;

    @XmlElement
    private String      site;

    @XmlTransient
    @JsonIgnoreProperties("membros")
    @JsonIgnore
    @OneToMany(mappedBy = "igreja", targetEntity = Membro.class)
    private Set<Membro> membros;

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
