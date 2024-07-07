package projeto.unipar.educarefrontend.util;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReiniciarSystem {
    
    
    public static void reiniciar(JFrame pai, Log log) {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String currentDir = new File(".").getCanonicalPath();
            String jarFilePath = currentDir + File.separator + "EduCareFrontEnd-1.0-SNAPSHOT.jar";
            File jarFile = new File(jarFilePath);

            if (!jarFile.exists() || !jarFile.isFile()) {
                JOptionPane.showMessageDialog(pai, "Não foi possível reiniciar a aplicação.", "Erro", JOptionPane.ERROR_MESSAGE);
                log.escreverLogErroAvulso("Reiniciar", "Arquivo JAR especificado não encontrado ou inválido: " + jarFilePath);
                return;
            }

            ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", jarFilePath);
            builder.start();
            pai.dispose();
        } catch (IOException ex) {
            String errorMessage = "Erro ao reiniciar a aplicação: " + ex.getMessage();
            JOptionPane.showMessageDialog(pai, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            log.escreverLogErroOperacaoException(ex, errorMessage);
        } catch (Exception ex) {
            String errorMessage = "Erro desconhecido ao reiniciar a aplicação: " + ex.getMessage();
            JOptionPane.showMessageDialog(pai, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            log.escreverLogErroOperacaoException(ex, errorMessage);
        }
    }
}
