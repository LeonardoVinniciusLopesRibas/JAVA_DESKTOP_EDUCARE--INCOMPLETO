package projeto.unipar.educarefrontend.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.dto.CepRequest;
import projeto.unipar.educarefrontend.dto.CepResponse;
import projeto.unipar.educarefrontend.util.Log;

public class CepService {
    
    private static final String CONSULTA_CEP = "https://viacep.com.br/ws/";
    private static final String JSON = "/json/";

    private final Log log;

    public CepService(Log log) {
        this.log = log;
    }
    
    public CepResponse buscarCep(CepRequest cepRequest) {
        String operacao = "CEP CONSULTADO";
        try {
            URL url = new URL(CONSULTA_CEP + cepRequest.getCep() + JSON);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    
                    CepResponse cepResponse = CepResponse.jsonToObjeto(response.toString());
                    
                    if (cepResponse.isErro()) {
                        JOptionPane.showMessageDialog(null, "CEP não encontrado ou inválido");
                    } else {
                        return cepResponse;
                    }
                }
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                JOptionPane.showMessageDialog(null, "Ocorreu um problema, entre em contato com o fabricante");
            } else {
                JOptionPane.showMessageDialog(null, "Erro desconhecido: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar o CEP");
        }

        return null;
    }
    
}
