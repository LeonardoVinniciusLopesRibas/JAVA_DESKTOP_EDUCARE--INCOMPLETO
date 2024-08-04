package projeto.unipar.educarefrontend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CepResponse {
    
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String localidade;
    private String ibge;
    private String uf;
    private boolean erro;   
    
   
    
    
}
