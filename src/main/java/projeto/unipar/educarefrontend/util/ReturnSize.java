package projeto.unipar.educarefrontend.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class ReturnSize {

    // <editor-fold defaultstate="collapsed" desc="Método responsável por pegar o tamanho da tela e retornar um Dimension">
    public static Dimension getScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        return screenSize;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por pegar a altura da tela e retornar um Dimension">
    public static double getScreenSizeHeight() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Double altura = toolkit.getScreenSize().getHeight();
        return altura;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por pegar a largura da tela e retornar um Dimension">
    public static double getScreenSizeWidth() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Double largura = toolkit.getScreenSize().getWidth();
        return largura;
    }
    //</editor-fold>
    
}
