package projeto.unipar.educarefrontend.util;

public class MaskFormatterUtil {
    
    public static String applyCpfMask(String cpf) {
        String onlyDigits = cpf.replaceAll("[^\\d]", "");
        String mask = "###.###.###-##";
        return applyMask(mask, onlyDigits);
    }
    
    public static String applyTelefoneMask(String telefone) {
        String onlyDigits = telefone.replaceAll("[^\\d]", "");
        String mask = onlyDigits.length() <= 10 ? "(##) ####-####" : "(##) #####-####";
        return applyMask(mask, onlyDigits);
    }
    
    private static String applyMask(String mask, String digits) {
        StringBuilder result = new StringBuilder();
        int maskCharIndex = 0;
        int digitsCharIndex = 0;

        while (maskCharIndex < mask.length() && digitsCharIndex < digits.length()) {
            char maskChar = mask.charAt(maskCharIndex);
            char digitsChar = digits.charAt(digitsCharIndex);

            if (maskChar == '#') {
                result.append(digitsChar);
                digitsCharIndex++;
            } else {
                result.append(maskChar);
            }

            maskCharIndex++;
        }

        return result.toString();
    }
}
