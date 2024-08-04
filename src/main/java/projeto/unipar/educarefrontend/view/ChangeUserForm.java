package projeto.unipar.educarefrontend.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.service.UsuarioService;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.PasswordViewDontView;

public class ChangeUserForm extends javax.swing.JFrame {

    //AREA DE VARIAVEIS E INSTANCIAS
    private static Log log = new Log();
    private PasswordViewDontView passwordViewDontView = new PasswordViewDontView();
    private Usuario usuario = new Usuario();
    private UsuarioService usuarioService = new UsuarioService(log);
    private Retaguarda pai;

    //FIM AREA DE VARIAVEIS E INSTANCIAS
    //CONSTRUTOR
    public ChangeUserForm(Retaguarda pai) {
        initComponents();
        initManuallyComponents();
        this.pai = pai;
        
    }

    //FIM CONSTRUTOR
    //INICIO MÉTODOS
    private void initManuallyComponents() {
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(400, 300));
        setMinimumSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(400, 300));
        setSize(new Dimension(400, 300));
    }
    
    private Boolean trocarUsuario() {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setUsuario(jtfUsuario.getText());
        usuarioRequest.setSenha(new String(jpfSenha.getPassword()));

        Object[] options = {"Sim", "Não"};

        int option = JOptionPane.showOptionDialog(
                this,
                "Todas suas telas serão fechadas. Deseja mesmo trocar de usuário?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (option == JOptionPane.YES_OPTION) {
            usuario = usuarioService.logar(usuarioRequest);

            if (usuario != null) {
                //ReiniciarSystem.reiniciar(this, log);
                this.dispose();
                if (pai != null) {
                    pai.dispose();
                }

                if (LoginView.class != null) {
                    Retaguarda retaguarda = new Retaguarda();
                    retaguarda.setVisible(true);
                    retaguarda.userSession(usuario);

                    BalloonNotification balloon = new BalloonNotification("Usuário: " + usuario.getNome() + " acessado!");
                    balloon.show("Usuário: " + usuario.getNome() + " acessado!");
                }
            } else {
                BalloonNotification balloon = new BalloonNotification("Usuário ou Senha Inválidos!");
                balloon.show("Usuário ou Senha Inválidos!");
            }

        }
        return true;
    }
    //FIM METODOS
    //INICIO MÉTODOS AUTOMATICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btSawPassword = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 82, 234));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(null);

        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyPressed(evt);
            }
        });
        jPanel1.add(jpfSenha);
        jpfSenha.setBounds(130, 150, 140, 24);

        jLabel1.setText("Senha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 150, 80, 24);

        btSawPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoVer.png"))); // NOI18N
        btSawPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSawPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btSawPassword);
        btSawPassword.setBounds(280, 150, 30, 24);

        jLabel2.setText("Usuário");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 110, 80, 24);

        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(jtfUsuario);
        jtfUsuario.setBounds(130, 110, 180, 24);

        btLogin.setText("Acessar");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btLogin);
        btLogin.setBounds(150, 210, 90, 23);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Trocar de Usuário");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 40, 130, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        trocarUsuario();
    }//GEN-LAST:event_btLoginActionPerformed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            trocarUsuario();

        }
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    private void jpfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            trocarUsuario();
        }
    }//GEN-LAST:event_jpfSenhaKeyPressed

    private void btSawPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSawPasswordActionPerformed
        // TODO add your handling code here:
        passwordViewDontView.viewPassword(btSawPassword, jpfSenha);
    }//GEN-LAST:event_btSawPasswordActionPerformed
    //FIM METODOS AUTOMATICOS
    //VARIAVEIS AUTOMATICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSawPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
