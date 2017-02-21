package br.com.geracaoelias.ekklesia_server.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.geracaoelias.ekklesia_server.model.converter.EstadoConverter;
import lombok.Data;

@Data
@XmlRootElement
@Entity
public class Igreja
{
    @Id
    @GeneratedValue
    private Long   id;

    @NotEmpty
    @Size(min = 4, max = 70)
    private String nome;
    
    @Email
    private String email;

    @NotEmpty
    @Size(min = 4, max = 70)
    private String dirigente;

    @Column(length = 14)
    private String cnpj;

    @Column(length = 11)
    private String telefone;

    @Column(name = "estado_sigla", length = 2, nullable = false)
    @Convert(converter = EstadoConverter.class)
    private Estado estado;

    private Integer cep;

    @Size(min = 4, max = 60)
    private String bairro;

    @Size(min = 4, max = 60)
    private String cidade;

    private String site;
    
    @OneToMany(mappedBy = "igreja", targetEntity = Membro.class)
    private Set<Membro> membros;
}
