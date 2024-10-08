package projeto.unipar.educarefrontend.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Log log = new Log();

    // <editor-fold defaultstate="collapsed" desc="Método responsável por transformar json para objeto">
    public static <T> T jsonToObjeto(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por transformar objeto para json">
    public static <T> String objectToJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por transformar json para uma lista unica de objeto">
    public static <T> List<T> jsonToListUnique(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por transformar json para Lista">
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por transformar Lista para json">
    public static <T> String listToJson(List<T> list) {
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para ler o arquivo de json">
    private static String lerArquivoJson(String caminhoArquivo) {
        try (InputStream inputStream = JsonUtils.class.getResourceAsStream(caminhoArquivo)) {
            if (inputStream == null) {
                log.escreverLogErroOperacaoException(new IOException("Arquivo não encontrado: " + caminhoArquivo), "Arquivo não encontrado: " + caminhoArquivo);
                return null;
            }
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ler o json de região">
    public static String lerRegioesJson() {
        String caminhoArquivo = "/META-INF/Regioes.json";
        return lerArquivoJson(caminhoArquivo);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ler o json de estado">
    public static String lerEstadosJson() {
        String caminhoArquivo = "/META-INF/Estados.json";
        return lerArquivoJson(caminhoArquivo);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ler o json de municipio">
    public static String lerMunicipiosJson() {
        String caminhoArquivo = "/META-INF/Municipios.json";
        return lerArquivoJson(caminhoArquivo);
    }
    //</editor-fold>
    
}
