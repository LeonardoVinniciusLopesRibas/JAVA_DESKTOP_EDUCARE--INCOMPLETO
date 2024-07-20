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
public class CepRequest {
 
    private String cep;
    
    public static String objectToJson(CepRequest cepRequest){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(cepRequest);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    
}
