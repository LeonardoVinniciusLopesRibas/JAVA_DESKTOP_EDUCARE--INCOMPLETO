package projeto.unipar.educarefrontend.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import projeto.unipar.educarefrontend.util.Log;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaeResponse {
    
    private Long id;
    private String nomeCompletoMae;
    private String cpfMae;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String ibge;
       
}
