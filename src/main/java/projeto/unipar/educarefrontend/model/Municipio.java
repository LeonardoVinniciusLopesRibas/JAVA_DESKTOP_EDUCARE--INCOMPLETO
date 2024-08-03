package projeto.unipar.educarefrontend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Municipio {

    private Long id;
    private String ibge;
    private String nome;
    private String uf;
    
}
