package projeto.unipar.educarefrontend.util;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdjustWindowSize {

    // <editor-fold defaultstate="collapsed" desc="Método responsável por receber um JFrame e por pegar o tamanho do monitor e retornar um Dimension">
    public Dimension adjustWindowSize(JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();

        Point windowCenter = new Point(frame.getX() + frame.getWidth() / 2, frame.getY() + frame.getHeight() / 2);

        for (GraphicsDevice device : devices) {
            Rectangle bounds = device.getDefaultConfiguration().getBounds();
            if (bounds.contains(windowCenter)) {
                return new Dimension(bounds.width, bounds.height);
            }
        }

        // Retorna o tamanho da tela principal como padrão
        return ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por receber um JPanel e por pegar o tamanho do monitor e retornar um Dimension">
    public Dimension adjustWindowSize(JPanel panel) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();

        Point windowCenter = new Point(panel.getX() + panel.getWidth() / 2, panel.getY() + panel.getHeight() / 2);

        for (GraphicsDevice device : devices) {
            Rectangle bounds = device.getDefaultConfiguration().getBounds();
            if (bounds.contains(windowCenter)) {
                return new Dimension(bounds.width, bounds.height);
            }
        }

        // Retorna o tamanho da tela principal como padrão
        return ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
    }
    //</editor-fold>
    
}
