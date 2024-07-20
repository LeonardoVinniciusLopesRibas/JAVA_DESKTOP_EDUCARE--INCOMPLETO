package projeto.unipar.educarefrontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import projeto.unipar.educarefrontend.dto.CepResponse;
import projeto.unipar.educarefrontend.util.Log;

public class CepService {

    public CepResponse buscarCep(String cepSemMascara) {
        Log log = new Log();
        try {
            String url = "https://viacep.com.br/ws/" + cepSemMascara + "/json/";

            HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
            
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(5)).GET()
                                             .build();

            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        System.out.println(response);
            
            if (response.statusCode() == 200) {
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
