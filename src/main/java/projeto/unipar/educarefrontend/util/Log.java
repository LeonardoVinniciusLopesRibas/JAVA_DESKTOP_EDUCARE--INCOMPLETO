package projeto.unipar.educarefrontend.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private static final String DIRETORIO = System.getProperty("user.home") + "/.educare";
    private static final String ARQUIVO = DIRETORIO + "/log.txt";

    public Log() {
        criarArquivo();
    }

    // <editor-fold defaultstate="collapsed" desc="Método responsável por criar o diretorio e o arquivo">
    public void criarArquivo() {
        try {
            File logDir = new File(DIRETORIO);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }
            File logFile = new File(ARQUIVO);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por pegar a hora e formatar">
    private String getHoraLog() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por setar um erro avulso recebido por parâmetro">
    public void escreverLogErroAvulso(String erro) {
        try {
            String tipo = "ERRO AVULSO!";
            String horaLog = getHoraLog();
            String logEntry = String.format("%s - %s - %s%n", horaLog, tipo, erro.toUpperCase());
            Files.write(Paths.get(ARQUIVO), logEntry.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            escreverLogErroOperacaoException(e, e.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por setar uma informação avulsa recebida por parâmetro">
    public void escreverLogInfoAvulso(String info) {
        try {
            String tipo = "INFORMAÇÃO AVULSO!";
            String horaLog = getHoraLog();
            String logEntry = String.format("%s - %s - %s%n", horaLog, tipo, info.toUpperCase());
            Files.write(Paths.get(ARQUIVO), logEntry.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            escreverLogErroOperacaoException(e, e.getMessage());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por setar um erro de Exception, recebida por parâmetros">
    public void escreverLogErroOperacaoException(Exception e, String errorMessage) {
        try {
            criarArquivo();
            String horaLog = getHoraLog();
            String logEntry = String.format("%s - ERRO - %s - %s%n", horaLog, e.getClass().getName(), errorMessage);
            Files.write(Paths.get(ARQUIVO), logEntry.getBytes(), StandardOpenOption.APPEND);

            // Adiciona o stack trace ao log
            for (StackTraceElement element : e.getStackTrace()) {
                String stackTraceEntry = String.format("%s\tat %s%n", horaLog, element.toString());
                Files.write(Paths.get(ARQUIVO), stackTraceEntry.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resgatar o código de http">
    public void escreverLogHttp(String operacao, int code) {
        try {
            criarArquivo();
            String horaLog = getHoraLog();
            String logEntry = String.format("%s - %s - %d%n", horaLog, operacao.toUpperCase(), code);
            Files.write(Paths.get(ARQUIVO), logEntry.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            escreverLogErroOperacaoException(e, e.getMessage());
        }
    }
    //</editor-fold>
    
}
