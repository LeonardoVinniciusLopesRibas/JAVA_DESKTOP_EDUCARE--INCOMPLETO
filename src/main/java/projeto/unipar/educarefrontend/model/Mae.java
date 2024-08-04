package projeto.unipar.educarefrontend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mae {

    private Long id;
    private String nomeCompletoMae;
    private String cpfMae;
    private String telefoneMae;
    private boolean telefoneMaeWhatsapp;
    private String contatoReserva;
    private boolean podeBuscar;
    private String telefoneReserva;
    private boolean telefoneReservaWhatsapp;
    private Pai pai;
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String numero;
    private String siafi;
    private boolean ativo;
    
}
