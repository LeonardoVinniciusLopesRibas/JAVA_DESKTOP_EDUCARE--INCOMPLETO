package projeto.unipar.educarefrontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projeto.unipar.educarefrontend.dto.MunicipioResponse;
import projeto.unipar.educarefrontend.enumerated.Ip;
import projeto.unipar.educarefrontend.model.Municipio;
import projeto.unipar.educarefrontend.util.BalloonNotification;

public class MunicipioService {

    private static final Ip IP;

    static {
        IP = Ip.IP;
    }

    private static final String SECURITY = "http://" + IP.getIpAddress() + ":4848";
    private static final String BASE_URL = "/educare/municipio";
    private static final String CADASTRAR = "/cadastrar";
    private static final String GET_BY_UF = "/get/uf/";
    private static final String GET_ID = "/get/";

    private final Log log;

    public MunicipioService(Log log) {
        this.log = log;
    }

    // <editor-fold defaultstate="collapsed" desc="Método para cadastrar municipio ao abrir o sistema, e retornar um boolean ">
    public boolean cadastrarMunicipio() {
        String operacao = "MUNICIPIO CADASTRADO";
        try {
            String json = JsonUtils.lerMunicipiosJson();
            URL url = new URL(SECURITY + BASE_URL + CADASTRAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                log.escreverLogHttp(operacao, responseCode);
                return true;
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> errorResponse = mapper.readValue(response.toString(), Map.class);
                List<String> errorList = (List<String>) errorResponse.get("errorList");
                StringBuilder formattedErrors = new StringBuilder();
                for (String error : errorList) {
                    formattedErrors.append(error).append("\n");
                }

                JTextArea textArea = new JTextArea(formattedErrors.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollPane, "Algum erro ocorreu no cadastro do município!!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (Exception e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return false;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método para resgatar os municipios, e retornar uma lista de MunicipioResponse">
    public List<MunicipioResponse> getMunicipio(String uf) {
        String operacao = "municipios buscados";
        List<MunicipioResponse> municipios = null;
        try {
            URL url = new URL(SECURITY + BASE_URL + GET_BY_UF + uf);
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
                municipios = JsonUtils.jsonToListUnique(response.toString(), MunicipioResponse.class);
                return municipios;
            } else {
                BalloonNotification balloonNotification = new BalloonNotification("Municipios não encontrados");
                balloonNotification.show("Municipios não encontrados");
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return municipios;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método para resgatar um municipio, recebendo um id, e retornando um Municipio">
    public Municipio searchMunicipioById(Long id) {
        String operacao = "Municipio encontrado pelo id";
        try {
            URL url = new URL(SECURITY + BASE_URL + GET_ID + id);
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
                return JsonUtils.jsonToObjeto(response.toString(), Municipio.class);
            } else {
                BalloonNotification balloonNotification = new BalloonNotification("Ocorreu algum erro ao selecionar!");
                balloonNotification.show("Ocorreu algum erro ao selecionar!");
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>
    
}
