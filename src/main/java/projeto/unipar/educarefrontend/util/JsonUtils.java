package projeto.unipar.educarefrontend.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Log log = new Log();

    // Para converter JSON para um objeto único
    public static <T> T jsonToObjeto(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    // Para converter um objeto único para JSON
    public static <T> String objectToJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    // Para converter JSON para uma lista de objetos
    public static <T> List<T> jsonToListUnique(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
    
    // Para converter JSON para uma lista de objetos
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, new TypeReference<List<T>>() {});
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }

    // Para converter uma lista de objetos para JSON
    public static <T> String listToJson(List<T> list) {
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        return null;
    }
}
