package projeto.unipar.educarefrontend.util;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SetIcon {
    
    Log log = new Log();
    
    public void setIconJFrame(JFrame parent) {
        URL iconUrl = getClass().getResource("/META-INF/EduCareLogo.png");
        if (iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            parent.setIconImage(icon.getImage());
        } else {
            log.escreverLogErroAvulso("ERRO", "ÍCONE ESTÁ NULO - Caminho: /META-INF/EduCareLogo.png");
        }
    }
    
}
