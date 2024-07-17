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
    
    public static boolean isAppRunning() {
        try {
            File lockFile = new File(LOCK_FILE);
            channel = new RandomAccessFile(lockFile, "rw").getChannel();
            lock = channel.tryLock();
            if (lock == null) {
                channel.close();
                return true;
            }
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    lock.release();
                    channel.close();
                    lockFile.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return true; 
        }
    }
    
}
