package service;

import java.util.ArrayList;
import java.util.List;

import model.InicioFim;
import model.Proposta;
import modelRequest.PendenciaRequest;
import modelRequest.PropostasPendentesRequest;
import modelResponse.PendenciaResponse;
import modelResponse.PropostasPendentesResponse;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		AssinatDigitalAPI assinatAPI = new AssinatDigitalAPI();
		
		PendenciaRequest pen = new PendenciaRequest();
		
		pen.setAgencia(1);
		pen.setConta(2);
		pen.setMidia(3);
		pen.setSolicitacaoUsuario("teste");
		pen.setTpTitular(0);
		
		System.out.println("Primeiro Teste - Enviando Http POST request");
		
		System.out.println(" ");
		System.out.println("Dados Fake criados para requisição de Verificar Pendencias");
		System.out.println(" ");
		
		PendenciaResponse res = assinatAPI.verificarPendencias(pen);
		
		System.out.println(" ");
		System.out.println("Resposta do Verificar Pendencias");
		System.out.println(" ");
		System.out.println("Midia: "+ res.getMidia());
		System.out.println("Prestacao: "+ res.getQtdPrestacao());
		System.out.println("AceiteDigital: "+ res.getAceiteDigital());		
		
		
		PropostasPendentesRequest ppr = new PropostasPendentesRequest();
		List<InicioFim> inicio = new ArrayList<InicioFim>();
		List<InicioFim> fim = new ArrayList<InicioFim>();
		
		InicioFim ini = new InicioFim();
		ini.setNumAquisicao("1");
		ini.setNumAtendimento("1");
		ini.setNumPlano("1");
		
		InicioFim fi = new InicioFim();
		fi.setNumAquisicao("1");
		fi.setNumAtendimento("1");
		fi.setNumPlano("1");
		
		inicio.add(ini);
		fim.add(fi);
		
		ppr.setMidia("1");
		ppr.setSentido("1");
		ppr.setInicio(inicio);
		ppr.setFim(fim);
		ppr.setAgencia("1");
		ppr.setConta("1");
		ppr.setMaxOcorrencia("1");		
		ppr.setTpBusca("1");
		ppr.setTpPgto("1");
		ppr.setTpTitular("1");
		ppr.setTpVisualizacao("1");
		
		System.out.println(" ");
		System.out.println("Dados Fake criados para requisição de Listar Propostas");
		System.out.println(" ");
		
		PropostasPendentesResponse ppresp = assinatAPI.listarPropostas(ppr);
		
		System.out.println(" ");
		System.out.println("Resposta do Listar Propostas");
		System.out.println(" ");
		System.out.println("Midia: "+ ppresp.getMidia());
		
		System.out.println(" ");
		System.out.println("Objeto Inicio");
		System.out.println("     NumAquisicao: "+ ppresp.getInicio().getNumAquisicao());
		System.out.println("     NumAtendimento: "+ ppresp.getInicio().getNumAtendimento());
		System.out.println("     NumPlano: "+ ppresp.getInicio().getNumPlano());
		
		System.out.println(" ");
		System.out.println("Objeto Fim");
		System.out.println("     NumAquisicao: "+ ppresp.getFim().getNumAquisicao());
		System.out.println("     NumAtendimento: "+ ppresp.getFim().getNumAtendimento());
		System.out.println("     NumPlano: "+ ppresp.getFim().getNumPlano());
		System.out.println(" ");
		
		System.out.println("IndicadorFunc: "+ ppresp.getIndicadorFunc());
		System.out.println("tpConta "+ ppresp.getTpConta());
		
		System.out.println(" ");		
		System.out.println("Lista de Propostas");
		
		for(Proposta prop: ppresp.getPropostas()) {
			System.out.println("     NumPlano: "+ prop.getNumPlano());
			System.out.println("     Peridiocidade: "+ prop.getPeridiocidade());
		}
		
		System.out.println(" ");
		
		System.out.println("Chamando Erro");
		assinatAPI.chamaErro();
		
	}

}
