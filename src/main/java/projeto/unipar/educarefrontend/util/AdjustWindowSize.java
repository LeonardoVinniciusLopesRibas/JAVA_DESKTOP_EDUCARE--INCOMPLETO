package projeto.unipar.educarefrontend.util;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdjustWindowSize {

    public Dimension adjustWindowSize(JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();

        Point windowCenter = new Point(frame.getX() + frame.getWidth() / 2, frame.getY() + frame.getHeight() / 2);

        for (GraphicsDevice device : devices) {
            Rectangle bounds = device.getDefaultConfiguration().getBounds();
            System.out.println("Device bounds: " + bounds);
            if (bounds.contains(windowCenter)) {
                return new Dimension(bounds.width, bounds.height);
            }
        }

        // Retorna o tamanho da tela principal como padrão
        return ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
    }

}
