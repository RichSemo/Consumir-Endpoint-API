package modelRequest;

public class PendenciaRequest {

	private int midia;
	private String solicitacaoUsuario;
	private int agencia;
	private int conta;
	private int tpTitular;
	
	
	
	public int getMidia() {
		return midia;
	}
	
	public void setMidia(int midia) {
		this.midia = midia;
	}
	
	public String getSolicitacaoUsuario() {
		return solicitacaoUsuario;
	}
	
	public void setSolicitacaoUsuario(String solicitacaoUsuario) {
		this.solicitacaoUsuario = solicitacaoUsuario;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getConta() {
		return conta;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public int getTpTitular() {
		return tpTitular;
	}
	
	public void setTpTitular(int tpTitular) {
		this.tpTitular = tpTitular;
	}
}
