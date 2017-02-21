package br.com.geracaoelias.ekklesia_server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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

    @NotEmpty
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
}
