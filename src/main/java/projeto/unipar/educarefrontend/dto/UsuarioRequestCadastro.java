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
public class UsuarioRequestCadastro {
    
    private String nome;
    private String email;
    private String senha;
    
    public static UsuarioRequestCadastro jsonToObjeto(String json){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, UsuarioRequestCadastro.class);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
    public static String objectToJson(UsuarioRequestCadastro usuarioRequestCadastro){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(usuarioRequestCadastro);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
}
