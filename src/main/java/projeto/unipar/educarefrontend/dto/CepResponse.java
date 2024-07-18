package projeto.unipar.educarefrontend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.unipar.educarefrontend.util.Log;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CepResponse {
    
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    
    
    public static CepResponse jsonToObjeto(String json){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, CepResponse.class);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
}
