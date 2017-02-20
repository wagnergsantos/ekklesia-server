package br.com.geracaoelias.ekklesia_server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@XmlRootElement(name = "membro")
@Entity
@Table(name = "membro")
@Data
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
    private String estadoSigla;

    @Transient
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
    private Integer estadoCivilId;

    @Transient
    private EstadoCivil estadoCivil;

    @Column(name = "escolaridade_id")
    private Integer escolaridadeId;

    @Transient
    private Escolaridade escolaridade;

    private String nacionalidade;

    private String naturalidade;

    private String conjuge;

    @Column(name = "cargo_id")
    private Integer cargoId;

    @Transient
    private Cargo cargo;

    @Column(name = "situacao_id")
    private Integer situacaoId;

    @Transient
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

    // @Version
    // private Long version;
    
    public void setEstado(Estado estado){
        this.estado = estado;
        if (estado != null){
            estadoSigla = estado.getSigla();
        }
    }    

    public Estado getEstado()
    {
        return Estado.fromValue(estadoSigla);
    }
    
    public void setEscolaridade(Escolaridade escolaridade){
        this.escolaridade = escolaridade;
        if (escolaridade != null){
            escolaridadeId = escolaridade.getId();
        }
    }

    public Escolaridade getEscolaridade()
    {
        return Escolaridade.fromValue(escolaridadeId);
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil){
        this.estadoCivil = estadoCivil;
        if (estadoCivil != null){
            estadoCivilId = estadoCivil.getId();
        }
    }

    public EstadoCivil getEstadoCivil()
    {
        return EstadoCivil.fromValue(estadoCivilId);
    }
    
    public void setSituacaoMembro(SituacaoMembro situacao){
        this.situacao = situacao;
        if (situacao != null){
            situacaoId = situacao.getId();
        }
    }

    public SituacaoMembro getSituacaoMembro()
    {
        return SituacaoMembro.fromValue(situacaoId);
    }
    
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
        if (cargo != null){
            cargoId = cargo.getId();
        }
    }

    public Cargo getCargo()
    {
        return Cargo.fromValue(cargoId);
    }
}
