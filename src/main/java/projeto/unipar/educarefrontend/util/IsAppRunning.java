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

    public static boolean isAppRunning() {
        try {
            File lockFile = new File(LOCK_FILE);
            channel = new RandomAccessFile(lockFile, "rw").getChannel();
            lock = channel.tryLock();
            if (lock == null) {
                return true; // Another instance is running
            }

            // Shutdown hook to ensure the lock file is deleted on JVM shutdown
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    if (lock != null) {
                        lock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    // Directly delete the file
                    lockFile.delete();
                } catch (IOException e) {
                    log.escreverLogErroOperacaoException(e, e.getMessage());
                }
            }));

            return false; // Application is not running
        } catch (IOException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
            return true; // Error occurred, assume application is running
        }
    }
}
