package br.com.alura.mvc.mudi.model;

public enum Status {

	AGUARDANDO ("AGUARDANDO"),
	APROVADO ("APROVADO"),
	ENTREGUE ("ENTREGUE");
	
	public String getNome() {
		return nome;
	}

	private final String nome;
	
	Status(String nome){
		this.nome = nome;
	}
}
