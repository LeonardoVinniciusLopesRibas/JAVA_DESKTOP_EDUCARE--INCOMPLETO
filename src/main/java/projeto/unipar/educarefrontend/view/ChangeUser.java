package projeto.unipar.educarefrontend.view;

import projeto.unipar.educarefrontend.util.BalloonNotification;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.service.UsuarioService;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.PasswordViewDontView;

public class ChangeUser extends javax.swing.JInternalFrame {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private static Log log = new Log();
    private PasswordViewDontView passwordViewDontView = new PasswordViewDontView();
    private Usuario usuario = new Usuario();
    private UsuarioService usuarioService = new UsuarioService(log);
    private JFrame pai;

    //FIM DA ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public ChangeUser(JFrame pai) {
        initComponents();
        initManuallyComponents();
        this.pai = pai;
    }

    //FIM DO CONSTRUTOR
    //AREA DE MÉTODOS
    private void initManuallyComponents() {
        setTitle("Troca de Usuário");
        setPreferredSize(new Dimension(300, 300));
        setMinimumSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(300, 300));
        setSize(new Dimension(300, 300));
        setSize(300, 300);
    }

    private void trocarUsuario() {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setUsuario(jtfUsuario.getText());
        usuarioRequest.setSenha(new String(jPasswordField1.getPassword()));

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
    }

    //FIM DA ÁREA DE MÉTODOS
    //CÓDIGO AUTOMÁTICO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSenha = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(300, 300));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(jtfUsuario);
        jtfUsuario.setBounds(100, 30, 170, 40);

        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 30, 79, 15);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 80, 79, 15);

        jbSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png"))); // NOI18N
        jbSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jbSenha);
        jbSenha.setBounds(235, 80, 35, 40);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(100, 80, 130, 40);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Acessar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 220, 100, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSenhaActionPerformed
        // TODO add your handling code here:
        passwordViewDontView.viewPassword(jbSenha, jPasswordField1);
    }//GEN-LAST:event_jbSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        trocarUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            trocarUsuario();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            trocarUsuario();
        }
    }//GEN-LAST:event_jtfUsuarioKeyPressed
    //FIM DOS CÓDIGOS AUTOMÁTICOS
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton jbSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
    //FIM DA DECLARAÇÃO DE VARIÁVEIS AUTOMÁTICAS
}
