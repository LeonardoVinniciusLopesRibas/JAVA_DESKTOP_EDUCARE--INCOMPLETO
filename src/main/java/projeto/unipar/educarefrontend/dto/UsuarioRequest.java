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
public class UsuarioRequest {

    private String usuario;
    private String senha;
    
    public static UsuarioRequest jsonToObjeto(String json){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, UsuarioRequest.class);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
    public static String objectToJson(UsuarioRequest usuarioRequest){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(usuarioRequest);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
}
