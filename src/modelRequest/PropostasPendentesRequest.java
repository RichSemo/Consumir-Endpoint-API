package modelRequest;

import java.util.List;

import model.InicioFim;

public class PropostasPendentesRequest {
	
	private String midia;
	private String sentido;
	private List<InicioFim> inicio;
	private List<InicioFim> fim;
	private String maxOcorrencia;
	private String agencia;
	private String conta;
	private String tpTitular;
	private String tpBusca;
	private String tpPgto;
	private String tpVisualizacao;
	
	
	public String getMidia() {
		return midia;
	}
	
	public void setMidia(String midia) {
		this.midia = midia;
	}
	
	public String getSentido() {
		return sentido;
	}
	
	public void setSentido(String sentido) {
		this.sentido = sentido;
	}
	
	public List<InicioFim> getInicio() {
		return inicio;
	}
	
	public void setInicio(List<InicioFim> inicio) {
		this.inicio = inicio;
	}
	
	public List<InicioFim> getFim() {
		return fim;
	}
	
	public void setFim(List<InicioFim> fim) {
		this.fim = fim;
	}
	
	public String getMaxOcorrencia() {
		return maxOcorrencia;
	}
	
	public void setMaxOcorrencia(String maxOcorrencia) {
		this.maxOcorrencia = maxOcorrencia;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String getTpTitular() {
		return tpTitular;
	}
	
	public void setTpTitular(String tpTitular) {
		this.tpTitular = tpTitular;
	}
	
	public String getTpBusca() {
		return tpBusca;
	}
	
	public void setTpBusca(String tpBusca) {
		this.tpBusca = tpBusca;
	}
	
	public String getTpPgto() {
		return tpPgto;
	}
	
	public void setTpPgto(String tpPgto) {
		this.tpPgto = tpPgto;
	}
	
	public String getTpVisualizacao() {
		return tpVisualizacao;
	}
	
	public void setTpVisualizacao(String tpVisualizacao) {
		this.tpVisualizacao = tpVisualizacao;
	}
}
