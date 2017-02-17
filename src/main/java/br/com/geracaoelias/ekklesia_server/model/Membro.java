package br.com.geracaoelias.ekklesia_server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
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

import br.com.geracaoelias.ekklesia_server.model.converter.EstadoConverter;
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
	@Size(min=4, max=70)
	private String nome;
	
	@NotEmpty
	@Size(min=4, max=70)
	private String endereço;
	
	@NotEmpty
	@Size(max=8)
	private Integer cep;
	
	@NotEmpty
	@Size(min=4, max=60)
	private String bairro;
	
	@NotEmpty
	@Size(min=4, max=60)
	private String cidade;
	
	@Column(length = 2, nullable = false)
	@Convert(converter = EstadoConverter.class)
	private Estado estado;
	
	@NotEmpty
	@Size(min=4, max=60)
	private String pais;
	
	@Size(min=4, max=70)
	private String nomePai;
	
	@NotEmpty
	@Size(min=4, max=70)
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
	
	@Column(length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@Column(length = 14, nullable = false)
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
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
	
	
}
