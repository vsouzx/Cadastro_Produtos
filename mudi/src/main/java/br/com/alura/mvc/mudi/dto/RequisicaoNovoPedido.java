package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.Status;


public class RequisicaoNovoPedido {

	private Integer id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	
	@NotNull
	private BigDecimal valorNegociado;
	
	private LocalDate dataEntrega;
	
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	private Status status = Status.AGUARDANDO;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNome(nome);
		pedido.setDescricao(descricao);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setValorNegociado(valorNegociado);
		pedido.setStatus(status);
		return pedido;
	}

}
