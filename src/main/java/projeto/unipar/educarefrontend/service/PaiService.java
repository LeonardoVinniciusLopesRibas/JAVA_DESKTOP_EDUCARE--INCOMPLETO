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
import projeto.unipar.educarefrontend.enumerated.Ip;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.JsonUtils;
import projeto.unipar.educarefrontend.util.Log;

public class PaiService {
    
    private static final Ip IP;
    
    static{
        IP = Ip.IP;
    }
    
    private static final String SECURITY = "http://"+IP.getIpAddress()+":4848";
    private static final String BASE_URL = "/educare/pai";
    private static final String CADASTRAR = "/cadastrar";
    
    private final Log log;

    public PaiService(Log log) {
        this.log = log;
    }

    public int postPai(Pai pai) {
        String operacao = "Pai cadastrado com sucesso";
        try{
            URL url = new URL(SECURITY+BASE_URL+CADASTRAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            
            String json = JsonUtils.objectToJson(pai);
            
            try(OutputStream os = connection.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            int responseCode = connection.getResponseCode();
            
            if(responseCode == HttpURLConnection.HTTP_CREATED){
                BalloonNotification b = new BalloonNotification("Pai cadastrado com sucesso");
                b.show("Pai cadastrado com sucesso");
                log.escreverLogHttp(operacao, responseCode);
                return responseCode;
            }else{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> errorResponse = mapper.readValue(response.toString(), Map.class);
                List<String> errorList = (List<String>) errorResponse.get("errorList");
                StringBuilder formattedErrors = new StringBuilder();
                
                for(String error: errorList){
                    formattedErrors.append(error).append("\n");
                }
                
                JTextArea textArea = new JTextArea(formattedErrors.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar Pai", JOptionPane.ERROR_MESSAGE);
                
            }
            connection.disconnect();
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }catch(IOException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return -1;
    }
    
    
    
}
