package projeto.unipar.educarefrontend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    private Long id;
    private String codigoUf;
    private String nomeUf;
    private String siglaUf;
    private Regiao regiao;
    
    
    
    
}
