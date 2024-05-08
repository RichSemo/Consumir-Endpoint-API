package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.HttpStatus;

import com.google.gson.Gson;

import modelRequest.AceitarRecusarRequest;
import modelRequest.PendenciaRequest;
import modelRequest.PropostasPendentesRequest;
import modelResponse.AceitarRecusarResponse;
import modelResponse.ErroResponse;
import modelResponse.Error;
import modelResponse.PendenciaResponse;
import modelResponse.PropostasPendentesResponse;

public class AssinatDigitalAPI {
	
	private final String propostasURL = "http://5ee50d3bddcea00016a37256.mockapi.io/TCAP-Proposta/listarPropostas";
	private final String pendenciasURL = "http://5ee50d3bddcea00016a37256.mockapi.io/TCAP-Proposta/verificarPendenciaAceiteDigital";
	private final String aceiteRecusaURL = "http://5ee50d3bddcea00016a37256.mockapi.io/TCAP-Proposta/aceitarRecusarPropostas";
	private final String error = "http://5ee50d3bddcea00016a37256.mockapi.io/TCAP-Proposta/simulaErro";
	private Gson gson = new Gson();
	
	
	/** Lista todas as propostas com falta de assinatura digital
	 * @throws Exception*/
	
	public PropostasPendentesResponse listarPropostas(PropostasPendentesRequest propPendentes) throws Exception {
		
		String jsonObjRequest = gson.toJson(propPendentes); //Converte Objeto Java para JSON		
		String response = requestResponse(propostasURL, jsonObjRequest, 0);		
		PropostasPendentesResponse obj = gson.fromJson(response.toString(), PropostasPendentesResponse.class); //Converte String JSON para objeto Java
    	
    	return obj;
	}
	
	/** Realiza o aceite ou a recusa da proposta
	 * @throws Exception*/
	
	public AceitarRecusarResponse aceitarRecusarPropostas(AceitarRecusarRequest aceitRecuse) throws Exception {
		
		String jsonObjRequest = gson.toJson(aceitRecuse); //Converte Objeto Java para JSON		
		String response = requestResponse(aceiteRecusaURL, jsonObjRequest, 0);				
		AceitarRecusarResponse obj = gson.fromJson(response.toString(), AceitarRecusarResponse.class); //Converte String JSON para objeto Java
    	
    	return obj;
	}
	
	/** Verifica pendencias do aceite digital	 
	 * @throws Exception */
	
	public PendenciaResponse verificarPendencias(PendenciaRequest pendencia) throws Exception {
    	
		String jsonObjRequest = gson.toJson(pendencia); //Converte Objeto Java para JSON		
		String response = requestResponse(pendenciasURL, jsonObjRequest, 0);		
		PendenciaResponse obj = gson.fromJson(response.toString(), PendenciaResponse.class); //Converte JSON para objeto Java
		
		return obj;
	}
	
	public void chamaErro() throws Exception {		
		requestResponse(error, "", 500);		
	}
	
	/** Realiza o processo de requisicao, e retorna o response em json
	 * @param stringUrl
	 * @param jsonObjRequest
	 * @return
	 * @throws Exception */
	
	private String requestResponse(String stringUrl, String jsonObjRequest, int simulaErro) throws Exception {
		
		URL url = new URL(stringUrl);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		//Estruturas para requisicao
    	connection.setRequestMethod("POST");
    	connection.setRequestProperty("Content-Type", "application/json; utf-8");
    	connection.setRequestProperty("Accept", "application/json");
    	connection.setConnectTimeout(3000);
		connection.setReadTimeout(5000);
    	connection.setDoOutput(true);
    	
    	//Gravar dados JSON no Request Body
    	try(OutputStream os = connection.getOutputStream()) {
    	    byte[] input = jsonObjRequest.getBytes("utf-8");
    	    os.write(input, 0, input.length);           
    	}
    	
    	//Codigo de Resposta da Requisicao
    	int responseCode = connection.getResponseCode();
    	int codigoResposta = connection.getResponseCode();
		String msgResposta = connection.getResponseMessage();
		
		if(simulaErro > 0) codigoResposta = simulaErro;
		
    	System.out.println("\nEnviando 'POST' request para URL: " + stringUrl);
    	System.out.println("Codigo de resposta: " + responseCode);
    	
    	if(HttpStatus.OK.value() == codigoResposta || HttpStatus.CREATED.value() == codigoResposta){
			
			String resposta = this.obterRespostaHttpDoImputStream(connection.getInputStream());
			connection.disconnect();
			return resposta;

		} else {
			
			try{
				String resposta = this.obterRespostaHttpDoImputStream(connection.getInputStream());
				ErroResponse erroResp = gson.fromJson(resposta.toString(), ErroResponse.class);
				Error erro = erroResp.getError();
				String codErro = "";
				int tamanho = erro.getMessage().length();
				
				if(erro.getMessage().length() == 8){
					codErro = erro.getMessage();
					msgResposta = erro.getMessage();
					
				} else {
					codErro = erro.getCode();
					msgResposta = erro.getMessage();					
				}

				System.out.println("Erro: " + codErro + " -  Mensagem: " + msgResposta);
				throw new Exception();
				
			} catch(Exception e){
				System.out.println("Erro: " + codigoResposta +  " -  Mensagem: " + msgResposta);
				throw new Exception();
			}			
		}
	
	}
	
	/**Metodo Auxiliar que obtem InputStream da resposta de conexao e retornar String JSON
	 * @param connectionInputStream
	 * @return String JSON
	 * @throws IOException*/
	
	private String obterRespostaHttpDoImputStream(InputStream connectionInputStream) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader((connectionInputStream)));

		String inputline;
		StringBuffer response = new StringBuffer();

		while((inputline = in.readLine()) != null) {
			response.append(inputline);
		}
		
		in.close();
		
		return response.toString();
	}

}
