package projeto.unipar.educarefrontend.util;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetIcon {
    
    Log log = new Log();
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por setar a logo no topo do JFrame">
    public void setIconJFrame(JFrame parent) {
        URL iconUrl = getClass().getResource("/META-INF/EduCareLogo32px.png");
        if (iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            parent.setIconImage(icon.getImage());
        } else {
            log.escreverLogErroAvulso("ÍCONE ESTÁ NULO - Caminho: /META-INF/EduCareLogo32px.png");
        }
    }
    //</editor-fold>
    
}
