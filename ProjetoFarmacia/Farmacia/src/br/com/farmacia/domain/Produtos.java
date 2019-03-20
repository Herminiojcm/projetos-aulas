package br.com.farmacia.domain;

public class Produtos {
	private Long codigo;
	private String descricao;
	private Long quantidade;
	private Double preco;
	private Fornecedores fornecedores;
	
	//Met�dos de codigo
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	//M�todos de descri��o
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//M�todo de quantidade
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	//M�todo de pre�o
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	//M�todo de fornecedores
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	
	
}
