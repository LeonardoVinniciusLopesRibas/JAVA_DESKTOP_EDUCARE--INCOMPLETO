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
import projeto.unipar.educarefrontend.model.ValidacaoPreferencia;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

public class ValidacaoPreferenciaService {

    private static final String SECURITY = "http://localhost:4848";
    private static final String BASE_URL = "/educare/validacao";
    private static final String SET_TRUE = "/setTrue";
    private static final String CHECK_SET_TRUE = "/checkSetTrue";

    private final Log log;

    public ValidacaoPreferenciaService(Log log) {
        this.log = log;
    }

    public ValidacaoPreferencia setTrue(ValidacaoPreferencia validacaoPreferencia) {
        String operacao = "SQL REALIZADA";
        try {
            URL url = new URL(SECURITY + BASE_URL + SET_TRUE);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = JsonUtils.objectToJson(validacaoPreferencia);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                log.escreverLogHttp(operacao, responseCode);
                validacaoPreferencia.setSqlTrue(true);
                return validacaoPreferencia;
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
                JOptionPane.showMessageDialog(null, scrollPane, "Algum erro ocorreu na importação!!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (Exception e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    public Boolean checkSetTrue() {
        try {
            URL url = new URL(SECURITY + BASE_URL + CHECK_SET_TRUE);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.toString(), Boolean.class);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                log.escreverLogErroAvulso(response.toString());
            }
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        } catch (Exception e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return false;
    }

}
