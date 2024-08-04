package projeto.unipar.educarefrontend.util;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class OpenOrganizeInternalFrame {
    
    private static final Log log = new Log();
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por organizar o JInternalFrame no meio da tela">
    public void openOrganizeInternalFrame(JInternalFrame janela, JFrame frame){
        log.escreverLogInfoAvulso("jinternalframe sendo aberto");
        int lDesk = frame.getWidth();
        int aDesk = frame.getHeight();
        int lIframe = janela.getWidth();
        int aIframe = janela.getHeight();
        
        janela.setLocation(lDesk / 2 - lIframe / 2, aDesk / 2 - aIframe / 2);
        frame.add(janela);
        janela.setVisible(true);
    }
    //</editor-fold>

}
