package projeto.unipar.educarefrontend.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.dto.MaeDtoResponse;
import projeto.unipar.educarefrontend.dto.MaeResponse;
import projeto.unipar.educarefrontend.enumerated.Ip;
import projeto.unipar.educarefrontend.model.Mae;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

public class MaeService {

    private static final Ip IP;

    static {
        IP = Ip.IP;
    }

    private static final String SECURITY = "http://" + IP.getIpAddress() + ":4848";
    private static final String BASE_URL = "/educare/mae";
    private static final String BUSCAR_MAE_POR_PARAMETRO = "/buscaMaePorParametros?query=";
    private static final String BUSCAR_MAE_POR_ID = "/buscaMaeById/";
    private static final String GET_MAE_BY_ID = "/getMaeById/";
    private static final String ENCONTRAR_MAES_POR_PARAMETROS = "/get/mae";

    private final Log log;

    public MaeService(Log log) {
        this.log = log;
    }

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar uma mãe por parâmetros, e retornar uma lista de MaeResponse">
    public List<MaeResponse> buscarMae(String queryBusca) {
        String operacao = "CONSULTANDO MÃE";

        try {
            URL url = new URL(SECURITY + BASE_URL + BUSCAR_MAE_POR_PARAMETRO + queryBusca);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            log.escreverLogHttp(operacao, responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }

                    return JsonUtils.jsonToListUnique(response.toString(), MaeResponse.class);
                }
            } else if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um problema");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar o CEP");
        }

        return null;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar uma mãe pelo id, e retornar uma MaeResponse">
    public MaeResponse buscarMaeById(Long id) {
        String operacao = "BUSCANDO MÃE PELO ID NO BANCO DE DADOS";
        try {
            URL url = new URL(SECURITY + BASE_URL + BUSCAR_MAE_POR_ID + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToObjeto(response.toString(), MaeResponse.class);
            } else {
                log.escreverLogHttp(operacao, responseCode);
                JOptionPane.showMessageDialog(null, "Ocorreu um problema: " + responseCode);
            }
        } catch (IOException ioe) {
            log.escreverLogErroOperacaoException(ioe, ioe.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar mãe pelo ID: " + ioe.getMessage());
        }
        return null;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar uma mãe pelo id, e retornar uma Mae">
    public Mae getMaeById(Long id){
        String operacao = "mae recuperada pelo id";
        try{
            URL url = new URL(SECURITY+BASE_URL+GET_MAE_BY_ID+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            int responseCode = connection.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();
                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToObjeto(response.toString(), Mae.class);
            }else{
                BalloonNotification ballonNotification = new BalloonNotification("Ocorreu um erro");
                ballonNotification.show("Ocorreu um erro");
            }
            
        }catch(IOException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    public List<MaeDtoResponse> getListaMaesResponse(String nome, String cpf, String telefone, String logradouro) {
        String operacao = "maes recuperadas";
        
        try{
            URL url = new URL(SECURITY+BASE_URL+ENCONTRAR_MAES_POR_PARAMETROS+ "?nome=" + nome + "&cpf=" + cpf + "&telefone=" + telefone + "&endereco=" + logradouro);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                
                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToListUnique(response.toString(), MaeDtoResponse.class);
            }else if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                BalloonNotification bn = new BalloonNotification("Não existem mães ativas");
                bn.show("Não existem mães ativas");
            } else {
                BalloonNotification b = new BalloonNotification("Ocorreu algum erro ao recuperar as mães");
                b.show("Ocorreu algum erro ao recuperar as mães");
            }        
        }catch(IOException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
        
    }
}
