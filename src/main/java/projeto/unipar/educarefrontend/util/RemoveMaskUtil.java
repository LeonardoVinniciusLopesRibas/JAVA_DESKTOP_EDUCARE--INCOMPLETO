package projeto.unipar.educarefrontend.util;

public class RemoveMaskUtil {

    public static String removeMask(String value) {
        if (value == null) {
            return null;
        }
        return value.replaceAll("[^\\d]", "");
    }
    
}
