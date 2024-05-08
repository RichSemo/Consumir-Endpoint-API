package modelResponse;

import java.util.List;

import model.InicioFim;
import model.Proposta;

public class PropostasPendentesResponse {

	private int midia;
	private InicioFim inicio;
	private InicioFim fim;
	private String indicadorFunc;
	private int tpConta;
	private List<Proposta> propostas;
	
	
	public int getMidia() {
		return midia;
	}
	
	public void setMidia(int midia) {
		this.midia = midia;
	}
	
	public InicioFim getInicio() {
		return inicio;
	}
	
	public void setInicio(InicioFim inicio) {
		this.inicio = inicio;
	}
	
	public InicioFim getFim() {
		return fim;
	}
	
	public void setFim(InicioFim fim) {
		this.fim = fim;
	}
	
	public String getIndicadorFunc() {
		return indicadorFunc;
	}
	
	public void setIndicadorFunc(String indicadorFunc) {
		this.indicadorFunc = indicadorFunc;
	}
	
	public int getTpConta() {
		return tpConta;
	}
	
	public void setTpConta(int tpConta) {
		this.tpConta = tpConta;
	}
	
	public List<Proposta> getPropostas() {
		return propostas;
	}
	
	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}
}
