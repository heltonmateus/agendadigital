package br.com.iftm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

import br.com.iftm.entity.enums.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADORSERVICO", schema = "GAC")
@SequenceGenerator(name = "SQ_PRESTADORSERVICO", sequenceName = "SQ_PRESTADORSERVICO", initialValue = 1, allocationSize = 1, schema = "GAC")
public class PrestadorServico {

	@Id()
	@GeneratedValue(generator = "SQ_PRESTADORSERVICO", strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO_PRESTADORSERVICO")
	private Integer codigo;

	@Column(name = "NOME_PRESTADORSERVICO", nullable = false, length = 100)
	private String nome;

	// CIDADE
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "CODIGO_CIDADE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_PRESTADOR_SERV_TB_CIDADE"))
	private Cidade cidade;

	@Column(name = "BAIRRO_PRESTADORSERVICO", nullable = false, length = 100)
	private String bairro;

	@Column(name = "CEP_PRESTADORSERVICO", nullable = true, length = 10)
	private String cep;

	@Column(name = "TIPOLOGRA_PRESTADORSERVICO", nullable = false, length = 10)
	private TipoLogradouro tipoLogradouro;

	@Column(name = "LOGRAD_PRESTADORSERVICO", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "COMPEND_PRESTADORSERVICO", nullable = true, length = 100)
	private String complemento;

	@Column(name = "NUMEROCASA_PRESTADORSERVICO", nullable = false)
	private Integer numero;

	@Column(name = "EMAIL_PRESTADORSERVICO", nullable = true, length = 100)
	private String email;

	// pegando telefone cadastrando e alterando
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

	// relacao de prestacao de servico com servico prestado INTERMEDIARIA
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	// relacao de prestacao de servico com servico prestado INTERMEDIARIA
	@JoinTable(name = "RL_SERVICO_CREDENCIADO", joinColumns = {
			@JoinColumn(name = "CODIGO_PRESTADORSERVICO") }, inverseJoinColumns = {
					@JoinColumn(name = "CODIGO_TIPOSERVICO") }, schema = "GAC")
	private Set<TipoServico> tipoServicos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<TipoServico> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(Set<TipoServico> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

}
