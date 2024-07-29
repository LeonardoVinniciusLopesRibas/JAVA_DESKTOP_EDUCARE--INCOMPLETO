package projeto.unipar.educarefrontend.util;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdjustWindowSize {

    public Dimension adjustWindowSize(JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();

        for (GraphicsDevice device : devices) {
            Rectangle bounds = device.getDefaultConfiguration().getBounds();
            if (bounds.contains(frame.getLocation())) {
                return new Dimension(bounds.width, bounds.height);
            }
        }

        // Retorna o tamanho da tela principal como padrão
        return ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
    }

    
    
}
