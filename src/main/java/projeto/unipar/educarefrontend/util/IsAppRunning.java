package projeto.unipar.educarefrontend.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class IsAppRunning {

    private static FileLock lock;
    private static FileChannel channel;
    private static final String LOCK_FILE = "app.lock";
    private static Log log = new Log();
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por validar se o sistema está rodando ou não">
    public static boolean isAppRunning() {
        try {
            File lockFile = new File(LOCK_FILE);
            channel = new RandomAccessFile(lockFile, "rw").getChannel();
            lock = channel.tryLock();
            if (lock == null) {
                return true; 
            }

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    if (lock != null) {
                        lock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    lockFile.delete();
                } catch (IOException e) {
                    log.escreverLogErroOperacaoException(e, e.getMessage());
                }
            }));

            return false;
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
            return true;
        }
    }
    //</editor-fold>
    
}
