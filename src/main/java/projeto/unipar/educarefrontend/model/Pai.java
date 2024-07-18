package projeto.unipar.educarefrontend.model;

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
public class Pai {
    
    private Long id;
    private String nomeCompletoPai;
    private String cpfPai;
    private String telefonePai;
    private boolean telefonePaiWhatsapp;
    private String contatoReserva;
    private boolean podeBuscar;
    private String telefoneReserva;
    private boolean telefoneReservaWhatsapp;
    
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
    
    //private Mae mae

    
    public static String objectToJson(Pai pai){
        Log log = new Log();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(pai);
        }catch(JsonProcessingException e){
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
}
