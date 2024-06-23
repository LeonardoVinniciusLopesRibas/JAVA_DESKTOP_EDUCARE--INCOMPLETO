package projeto.unipar.educarefrontend.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import org.json.JSONArray;
import org.json.JSONObject;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.Log;

public class UsuarioService {

    private static final String SECURITY = "http://localhost:4848";
    private static final String BASE_URL = "/educare/usuario";
    private static final String LOGIN = "/login";

    private final Log log;

    public UsuarioService(Log log) {
        this.log = log;
    }

    public Usuario logar(UsuarioRequest usuarioRequest) {
        String operacao = "USUARIO LOGADO";
        try {
            URL url = new URL(SECURITY + BASE_URL + LOGIN);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = UsuarioRequest.objectToJson(usuarioRequest);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                br.close();

                if (response.length() > 0) {
                    // Login successful, parse the user data
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    Usuario usuario = new Usuario();
                    usuario.setId(jsonResponse.getLong("id"));
                    usuario.setNome(jsonResponse.getString("nome"));
                    usuario.setEmail(jsonResponse.getString("email"));
                    usuario.setSenha(jsonResponse.getString("senha"));

                    log.escreverLogHttp(operacao, responseCode);
                    return usuario;
                } else {
                    // Login failed (empty response)
                    log.escreverLogErroAvulso("Erro", "LOGIN FALHOU");
                    return null;
                }
            } else if (responseCode == 400) {
                // Validation errors
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                br.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray errorList = jsonResponse.getJSONArray("errorList");
                StringBuilder errorMessage = new StringBuilder();
                for (int i = 0; i < errorList.length(); i++) {
                    errorMessage.append(errorList.getString(i)).append("\n");
                }

                JTextArea textArea = new JTextArea(errorMessage.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollPane, "ERRO AO LOGAR", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                // Other errors
                JOptionPane.showMessageDialog(null, "UM ERRO OCORREU.", "Error", JOptionPane.ERROR_MESSAGE);
                log.escreverLogHttp("ERRO NÃO ESPERADO: ", responseCode);
                return null;
            }
        } catch (Exception e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
            JOptionPane.showMessageDialog(null, "UM ERRO OCORREU DURANTE O LOGIN: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
