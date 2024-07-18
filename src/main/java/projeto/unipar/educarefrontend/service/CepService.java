package projeto.unipar.educarefrontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import projeto.unipar.educarefrontend.dto.CepResponse;
import projeto.unipar.educarefrontend.util.Log;

public class CepService {

    public CepResponse buscarCep(String cepSemMascara) {

        Log log = new Log();
        try {
            // Montar a URL do ViaCEP
            String url = "https://viacep.com.br/ws/" + cepSemMascara + "/json/";

            // Criar o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            
            // Criar a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url).create(url))
                    .GET()
                    .build();

            // Enviar a requisição e obter a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar se a resposta foi bem-sucedida
            if (response.statusCode() == 200) {
                // Converter o JSON da resposta em um objeto CepResponse
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.body(), CepResponse.class);
            } else {
                log.escreverLogErroOperacaoException(null, "Falha na consulta do CEP: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
        
    }
    
}
