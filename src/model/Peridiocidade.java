package model;

public enum Peridiocidade {
	
	UNICO("UNICO"), 
	MENSAL("MENSAL"), 
	PERIODICO("PERIODICO");
	
	private String descricao;

	Peridiocidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
