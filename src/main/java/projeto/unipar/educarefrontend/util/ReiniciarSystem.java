package projeto.unipar.educarefrontend.util;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReiniciarSystem {

    public static void reiniciar(JFrame pai, Log log) {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String jarFilePath = new File(ReiniciarSystem.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath();

            File jarFile = new File(jarFilePath);

            if (!jarFile.exists() || !jarFile.isFile()) {
                JOptionPane.showMessageDialog(pai, "Não foi possível reiniciar a aplicação.", "Erro", JOptionPane.ERROR_MESSAGE);
                log.escreverLogErroAvulso("Arquivo JAR especificado não encontrado ou inválido: " + jarFilePath);
                return;
            }

            ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", jarFilePath);
            log.escreverLogInfoAvulso("Comando para reiniciar: " + String.join(" ", javaBin, "-jar", jarFilePath));
            Process process = builder.start();
            pai.dispose();
            log.escreverLogInfoAvulso("Sistema sendo fechado");
            System.exit(0);
            Thread.sleep(5000);
            process.waitFor();

        } catch (IOException | InterruptedException ex) {
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
