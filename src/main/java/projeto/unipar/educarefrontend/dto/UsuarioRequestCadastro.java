package projeto.unipar.educarefrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestCadastro {
    
    private String nome;
    private String usuario;
    private String senha;
    
    
}
