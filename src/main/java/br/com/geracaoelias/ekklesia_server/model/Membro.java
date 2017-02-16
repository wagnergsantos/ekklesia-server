package br.com.geracaoelias.ekklesia_server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@XmlRootElement(name="student")
@Entity
@Table(name="membro")
@Data
public class Membro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=60)
	private String nome;
	
	private String endereço;
	
	private Integer cep;
	
	private String bairro;
	
	private String cidade;
	
	@Column(length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private Estados estado;
	
	private String pais;
	
	@Size(min=4, max=60)
	private String nomePai;
	
	@NotEmpty
	@Size(min=4, max=60)
	private String nomemae;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataBatismo;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataCasamento;
	
	private EstadoCivil estadoCivil;
	
	private Escolaridade escolaridade;
	
	private String rg;
	
	private String cpf;
	
	private String telefoneResidencial;
	
	private String telefoneComercial;
	
	private String telefoneCelular;
	
	
	
	
	
}
