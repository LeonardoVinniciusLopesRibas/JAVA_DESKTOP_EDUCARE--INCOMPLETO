package projeto.unipar.educarefrontend.util;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PasswordViewDontView {

    private boolean isPasswordVisible = false;
    private static final Log log = new Log();

    public void viewPassword(JButton bt, JPasswordField jpfSenha) {
        if (isPasswordVisible) {
            jpfSenha.setEchoChar('*');
            bt.setIcon(new ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png")));
            log.escreverLogInfoAvulso("senha escondida");
        } else {
            jpfSenha.setEchoChar((char) 0);
            bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoVer.png")));
            log.escreverLogInfoAvulso("senha escondida");
        }
        isPasswordVisible = !isPasswordVisible;
    }

}
