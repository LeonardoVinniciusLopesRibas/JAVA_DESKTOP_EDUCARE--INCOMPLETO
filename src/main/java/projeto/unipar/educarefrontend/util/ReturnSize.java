package projeto.unipar.educarefrontend.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class ReturnSize {

    public static Dimension getScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        return screenSize;
    }
    
    public static double getScreenSizeHeight() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Double altura = toolkit.getScreenSize().getHeight();
        return altura;
    }
    
    public static double getScreenSizeWidth() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Double largura = toolkit.getScreenSize().getWidth();
        return largura;
    }
}
