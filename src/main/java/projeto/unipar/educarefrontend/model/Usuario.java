package projeto.unipar.educarefrontend.model;
        
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    
    
}
