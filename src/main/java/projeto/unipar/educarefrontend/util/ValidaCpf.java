package projeto.unipar.educarefrontend.util;

public class ValidaCpf {

    // <editor-fold defaultstate="collapsed" desc="Método responsável por validar se o CPF é válido">
    public boolean isValidCPF(String cpf) {
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int[] weights = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * weights[i];
            }
            int firstVerifierDigit = 11 - (sum % 11);
            if (firstVerifierDigit > 9) {
                firstVerifierDigit = 0;
            }

            weights = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * weights[i];
            }
            int secondVerifierDigit = 11 - (sum % 11);
            if (secondVerifierDigit > 9) {
                secondVerifierDigit = 0;
            }

            return cpf.charAt(9) == Character.forDigit(firstVerifierDigit, 10)
                    && cpf.charAt(10) == Character.forDigit(secondVerifierDigit, 10);
        } catch (Exception e) {
            return false;
        }

    }
    //</editor-fold>

}
