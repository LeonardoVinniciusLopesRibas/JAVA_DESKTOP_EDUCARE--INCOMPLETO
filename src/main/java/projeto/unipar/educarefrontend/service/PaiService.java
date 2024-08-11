package projeto.unipar.educarefrontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import projeto.unipar.educarefrontend.dto.PaiDtoResponse;
import projeto.unipar.educarefrontend.enumerated.Ip;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

public class PaiService {

    private static final Ip IP;

    static {
        IP = Ip.IP;
    }

    private static final String SECURITY = "http://" + IP.getIpAddress() + ":4848";
    private static final String BASE_URL = "/educare/pai";
    private static final String CADASTRAR = "/cadastrar";
    private static final String GET_PAI_COM_PARAMETROS = "/get/pai";
    private static final String DESATIVAR_PAI = "/put/desativar/";
    private static final String GET_PAI_DESATIVADOS_COM_PARAMETROS = "/get/pai/desativados";
    private static final String REATIVAR_PAI = "/put/reativar/";
    private static final String GET_PAI = "/get/";
    private static final String PUT_PAI = "/put/pai";

    private final Log log;

    public PaiService(Log log) {
        this.log = log;
    }

    // <editor-fold defaultstate="collapsed" desc="Método para buscar um pai por id">
    public Pai getId(Long id) {
        String operacao = "pai buscado pelo id";
        try {
            URL url = new URL(SECURITY + BASE_URL + GET_PAI + id);
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

                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToObjeto(response.toString(), Pai.class);
            } else {
                BalloonNotification b = new BalloonNotification("Erro ao buscar por ID");
                b.show("Erro ao buscar por ID");
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por cadastrar um pai no banco de dados">
    public int postPai(Pai pai) {
        String operacao = "Pai cadastrado com sucesso";
        try {
            URL url = new URL(SECURITY + BASE_URL + CADASTRAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = JsonUtils.objectToJson(pai);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                BalloonNotification b = new BalloonNotification("Pai cadastrado com sucesso");
                b.show("Pai cadastrado com sucesso");
                log.escreverLogHttp(operacao, responseCode);
                return responseCode;
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar Pai", JOptionPane.ERROR_MESSAGE);

            }
            connection.disconnect();
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return -1;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar uma lista de pais, por parâmetros">
    public List<PaiDtoResponse> getListaDePaisResponse(String nome, String cpf, String telefone, String logradouro) {
        String operacao = "pais recuperados do banco de dados";
        try {
            URL url = new URL(SECURITY + BASE_URL + GET_PAI_COM_PARAMETROS + "?nome=" + nome + "&cpf=" + cpf + "&telefone=" + telefone + "&endereco=" + logradouro);
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

                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToListUnique(response.toString(), PaiDtoResponse.class);
            } else if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                BalloonNotification bn = new BalloonNotification("Não existem pais ativos");
                bn.show("Não existem pais ativos");
            } else {
                BalloonNotification b = new BalloonNotification("Ocorreu algum erro ao recuperar os pais");
                b.show("Ocorreu algum erro ao recuperar os pais");
            }

        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Método responsável por desativar um pai">
    public void desativarPai(Long id) {
        String operacao = "pai desativado com sucesso";
        try {
            URL url = new URL(SECURITY + BASE_URL + DESATIVAR_PAI + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                log.escreverLogHttp(operacao, responseCode);
                BalloonNotification bn = new BalloonNotification("Pai desativado com sucesso");
                bn.show("Pai desativado com sucesso");
            } else {
                BalloonNotification bn = new BalloonNotification("Ocorreu algum problema para desativar");
                bn.show("Ocorreu algum problema para desativar");
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar uma lista de pais desativados, por parâmetros">
    public List<PaiDtoResponse> getListaDePaisResponseDesativados(String nome, String cpf, String telefone, String logradouro) {
        String operacao = "pais desativados recuperados";
        try {
            URL url = new URL(SECURITY + BASE_URL + GET_PAI_DESATIVADOS_COM_PARAMETROS + "?nome=" + nome + "&cpf=" + cpf + "&telefone=" + telefone + "&endereco=" + logradouro);
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

                log.escreverLogHttp(operacao, responseCode);
                return JsonUtils.jsonToListUnique(response.toString(), PaiDtoResponse.class);
            } else if (responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                BalloonNotification bn = new BalloonNotification("Não existem pais desativados");
                bn.show("Não existem pais desativados");
            } else {
                BalloonNotification b = new BalloonNotification("Ocorreu algum erro ao recuperar os pais");
                b.show("Ocorreu algum erro ao recuperar os pais");
            }

        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por reativar um pai">
    public void reativarPai(Long id) {
        String operacao = "pai reativado com sucesso";
        try {
            URL url = new URL(SECURITY + BASE_URL + REATIVAR_PAI + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                log.escreverLogHttp(operacao, responseCode);
                BalloonNotification bn = new BalloonNotification("Pai reativado com sucesso");
                bn.show("Pai reativado com sucesso");
            } else {
                BalloonNotification bn = new BalloonNotification("Ocorreu algum problema para reativar");
                bn.show("Ocorreu algum problema para reativar");
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
    }
    //</editor-fold>

    public int putPai(Pai pai) {
        String operacao = "PAI ATUALIZADO";

        try {
            URL url = new URL(SECURITY + BASE_URL + PUT_PAI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = JsonUtils.objectToJson(pai);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BalloonNotification b = new BalloonNotification("Pai atualizado com sucesso");
                b.show("Pai atualizado com sucesso");
                log.escreverLogHttp(operacao, responseCode);
                return responseCode;
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao atualizar Pai", JOptionPane.ERROR_MESSAGE);

            }
            connection.disconnect();

        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return -1;

    }

}
