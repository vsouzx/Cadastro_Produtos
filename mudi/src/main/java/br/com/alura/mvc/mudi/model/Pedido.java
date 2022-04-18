package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private BigDecimal valorNegociado;
	
	private LocalDate dataEntrega = LocalDate.now();
	
	@Column(length=3500)
	
	private String urlProduto;
	@Column(length=3500)
	
	private String urlImagem;
	
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Status status = Status.AGUARDANDO;
	
	//Constructors
	public Pedido() {
		
	}
	
	public Pedido(String nome, BigDecimal valorNegociado, LocalDate dataEntrega, String urlProduto, String urlImagem,
			String descricao, Status status) {
		this.nome = nome;
		this.valorNegociado = valorNegociado;
		this.dataEntrega = dataEntrega;
		this.urlProduto = urlProduto;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
		this.status = status;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [nome=" + nome + ", valorNegociado=" + valorNegociado + ", dataEntrega=" + dataEntrega
				+ ", urlProduto=" + urlProduto + ", urlImagem=" + urlImagem + ", descricao=" + descricao + "]";
	}

	public RequisicaoNovoPedido toRequisicaoNovoPedido() {
		RequisicaoNovoPedido requisicaoNovoPedido = new RequisicaoNovoPedido();
		requisicaoNovoPedido.setId(id);
		requisicaoNovoPedido.setNome(nome);
		requisicaoNovoPedido.setDescricao(descricao);
		requisicaoNovoPedido.setUrlImagem(urlImagem);
		requisicaoNovoPedido.setUrlProduto(urlProduto);
		requisicaoNovoPedido.setValorNegociado(valorNegociado);
		requisicaoNovoPedido.setDataEntrega(dataEntrega);
		requisicaoNovoPedido.setStatus(status);
		return requisicaoNovoPedido;
	}
	
}
