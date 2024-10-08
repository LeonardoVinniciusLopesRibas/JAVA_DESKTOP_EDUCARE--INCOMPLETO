package projeto.unipar.educarefrontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.dto.UsuarioRequestCadastro;
import projeto.unipar.educarefrontend.enumerated.Ip;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

public class UsuarioService {

    private static final Ip IP;
    
    static {
        IP = Ip.IP;
    }
    
    private static final String SECURITY = "http://"+IP.getIpAddress()+":4848";
    private static final String BASE_URL = "/educare/usuario";
    private static final String LOGIN = "/login";
    private static final String CADASTRAR = "/cadastrar";

    private final Log log;

    public UsuarioService(Log log) {
        this.log = log;
    }

    // <editor-fold defaultstate="collapsed" desc="Método responsável por validar o Login de um usuário">
    public Usuario logar(UsuarioRequest usuarioRequest) {
        String operacao = "USUARIO LOGADO";
        try {
            URL url = new URL(SECURITY + BASE_URL + LOGIN);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = JsonUtils.objectToJson(usuarioRequest);

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
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    Usuario usuario = new Usuario();
                    usuario.setId(jsonResponse.getLong("id"));
                    usuario.setNome(jsonResponse.getString("nome"));
                    usuario.setUsuario(jsonResponse.getString("usuario"));
                    usuario.setSenha(jsonResponse.getString("senha"));

                    log.escreverLogHttp(operacao, responseCode);
                    return usuario;
                } else {
                    log.escreverLogErroAvulso("LOGIN FALHOU");
                    return null;
                }
            } else if (responseCode == 400) {
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

                
                
                return null;
            } else {
                log.escreverLogHttp("ERRO NÃO ESPERADO: ", responseCode);
                return null;
            }
        } catch (Exception e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
            return null;
        }
    }
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por cadastrar usuário no banco de dados">
    /*public void save(UsuarioRequestCadastro urc, CadastrarUsuarioView cadastrarUsuario) {
        String operacao = "USUÁRIO CADASTRADO";
        try{
            URL url = new URL(SECURITY + BASE_URL + CADASTRAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            
            String json = JsonUtils.objectToJson(urc);
            
            try(OutputStream os = connection.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_CREATED){
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
                cadastrarUsuario.limparCampos();
                log.escreverLogHttp(operacao, responseCode);
            }else{
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar Usuário", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();            
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }catch(IOException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }catch(Exception e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        
    }*/
    //</editor-fold>

    
}
