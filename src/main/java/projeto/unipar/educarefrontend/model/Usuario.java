package projeto.unipar.educarefrontend.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.beans.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.unipar.educarefrontend.util.Log;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    
    public static Usuario jsonToObjeto(String json){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Usuario.class);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
    public static String objectToJson(Usuario usuario){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(usuario);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
}
