package projeto.unipar.educarefrontend.util;

public class RemoveMaskUtil {

    // <editor-fold defaultstate="collapsed" desc="Método responsável por remover máscaras">
    public static String removeMask(String value) {
        if (value == null) {
            return null;
        }
        return value.replaceAll("[^\\d]", "");
    }
    //</editor-fold>
    
}
