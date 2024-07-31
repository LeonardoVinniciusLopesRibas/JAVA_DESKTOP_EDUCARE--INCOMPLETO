package projeto.unipar.educarefrontend.view;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.model.ValidacaoPreferencia;
import projeto.unipar.educarefrontend.service.EstadoService;
import projeto.unipar.educarefrontend.service.MunicipioService;
import projeto.unipar.educarefrontend.service.RegiaoService;
import projeto.unipar.educarefrontend.service.UsuarioService;
import projeto.unipar.educarefrontend.service.ValidacaoPreferenciaService;
import projeto.unipar.educarefrontend.util.AdjustWindowSize;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.IsAppRunning;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.PasswordViewDontView;
import projeto.unipar.educarefrontend.util.ReturnSize;
import projeto.unipar.educarefrontend.util.SetIcon;
import projeto.unipar.educarefrontend.util.RoundedBorder;
import projeto.unipar.educarefrontend.util.WindowsCloseHandler;

public class LoginView extends javax.swing.JFrame {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private final Log log = new Log();
    private final SetIcon setIcon = new SetIcon();
    private UsuarioService usuarioService = new UsuarioService(log);
    private Usuario usuario = new Usuario();
    private PasswordViewDontView passwordViewDontView = new PasswordViewDontView();
    private boolean isDragging = false;
    private AdjustWindowSize adjustWindowSize = new AdjustWindowSize();
    //FIM ÁREA DE INSTÂNCIAS E VARIÁVEIS

    //CONSTRUTOR
    public LoginView() {
        initComponents();
        initiallyManuallyComponents();
    }
    //FIM CONSTRUTOR

    //INÍCIO MÉTODOS
    private void initiallyManuallyComponents() {
        log.escreverLogInfoAvulso("INICIANDO APLICAÇÃO");
        this.setPreferredSize(new Dimension(1366, 768));
        this.setMinimumSize(new Dimension(1024, 768));
        this.setSize(new Dimension(1366, 768));
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);
        WindowsCloseHandler.addCloseHandler(this, log);
        organizeJLayeredPanel();
        moveAndCheckSizeJLayeredPaneRight();
    }

    private void organizeJLayeredPanel() {
        Dimension dimension = adjustWindowSize.adjustWindowSize(this);
        System.out.println("Window location: " + this.getLocation());
        System.out.println("Screen dimension: " + dimension);

        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        int panelWidth = (int) (screenWidth * 0.4);
        int panelHeight = screenHeight;
        int panelX = screenWidth - panelWidth;
        int panelY = 0;

        jLayeredPaneRight.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jLayeredPaneRight.setSize(new Dimension(panelWidth, panelHeight));
        jLayeredPaneRight.setLocation(panelX, panelY);
        jLayeredPaneRight.setBounds(panelX, panelY, panelWidth, panelHeight);
    }

    private void moveAndCheckSizeJLayeredPaneRight() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                organizeJLayeredPanel();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                organizeJLayeredPanel();
            }

        });
    }

    public void logar() {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setUsuario(jtfEmail.getText());
        usuarioRequest.setSenha(new String(jpfSenha.getPassword()));

        usuario = usuarioService.logar(usuarioRequest);

        if (usuario != null) {
            Retaguarda retaguarda = new Retaguarda();
            retaguarda.setVisible(true);
            retaguarda.userSession(usuario);
            this.dispose();
            BalloonNotification balloon = new BalloonNotification("Usuário acessando! - Bem Vindo: " + usuario.getNome());
            balloon.show("Usuário acessando! - Bem Vindo: " + usuario.getNome());
        } else {
            BalloonNotification balloon = new BalloonNotification("Usuário ou Senha Inválidos!");
            balloon.show("Usuário ou Senha Inválidos!");
        }
    }

    //FIM MÉTODOS
    //INÍCIO MÉTODOS AUTOMÁTICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPaneRight = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        btAcessarSistema = new javax.swing.JButton();
        btVisualizarSenha = new javax.swing.JButton();
        jLayeredPaneLeft = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDUCARE");
        setBackground(new java.awt.Color(148, 98, 171));
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        jLayeredPaneRight.setBackground(new java.awt.Color(148, 100, 172));
        jLayeredPaneRight.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USUÁRIO");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SENHA");

        jtfEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfEmail.setToolTipText("INFORME O SEU E-MAIL DE LOGIN");
        jtfEmail.setBorder(new RoundedBorder(15));
        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfEmailKeyPressed(evt);
            }
        });

        jpfSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpfSenha.setToolTipText("INFORME SUA SENHA");
        jpfSenha.setBorder(new RoundedBorder(15));
        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyPressed(evt);
            }
        });

        btAcessarSistema.setBackground(new java.awt.Color(85, 6, 124));
        btAcessarSistema.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btAcessarSistema.setForeground(new java.awt.Color(255, 255, 255));
        btAcessarSistema.setText("ACESSAR");
        btAcessarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcessarSistemaActionPerformed(evt);
            }
        });

        btVisualizarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png"))); // NOI18N
        btVisualizarSenha.setBorder(new RoundedBorder(15));
        btVisualizarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btVisualizarSenhaMousePressed(evt);
            }
        });

        jLayeredPaneRight.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(jtfEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(jpfSenha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(btAcessarSistema, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneRight.setLayer(btVisualizarSenha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneRightLayout = new javax.swing.GroupLayout(jLayeredPaneRight);
        jLayeredPaneRight.setLayout(jLayeredPaneRightLayout);
        jLayeredPaneRightLayout.setHorizontalGroup(
            jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneRightLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPaneRightLayout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addGroup(jLayeredPaneRightLayout.createSequentialGroup()
                                    .addGap(103, 103, 103)
                                    .addComponent(btAcessarSistema))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneRightLayout.createSequentialGroup()
                                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btVisualizarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        jLayeredPaneRightLayout.setVerticalGroup(
            jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPaneRightLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(72, 72, 72)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addGroup(jLayeredPaneRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btVisualizarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(57, 57, 57)
                    .addComponent(btAcessarSistema)
                    .addContainerGap(359, Short.MAX_VALUE)))
        );

        getContentPane().add(jLayeredPaneRight);
        jLayeredPaneRight.setBounds(880, 0, 484, 769);

        jLayeredPaneLeft.setBackground(new java.awt.Color(229, 218, 235));
        jLayeredPaneLeft.setOpaque(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/EduCareLogo.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(887, 768));
        jLabel1.setMinimumSize(new java.awt.Dimension(887, 768));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(887, 768));

        jLayeredPaneLeft.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneLeftLayout = new javax.swing.GroupLayout(jLayeredPaneLeft);
        jLayeredPaneLeft.setLayout(jLayeredPaneLeftLayout);
        jLayeredPaneLeftLayout.setHorizontalGroup(
            jLayeredPaneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneLeftLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPaneLeftLayout.setVerticalGroup(
            jLayeredPaneLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jLayeredPaneLeft);
        jLayeredPaneLeft.setBounds(0, -10, 910, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVisualizarSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVisualizarSenhaMousePressed
        // TODO add your handling code here:
        passwordViewDontView.viewPassword(btVisualizarSenha, jpfSenha);
    }//GEN-LAST:event_btVisualizarSenhaMousePressed

    private void btAcessarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessarSistemaActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_btAcessarSistemaActionPerformed

    private void jtfEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_jtfEmailKeyPressed

    private void jpfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_jpfSenhaKeyPressed
    //FIM MÉTODOS AUTOMÁTICOS
    //MAIN
    public static void main(String args[]) {
        Splash splash = new Splash();
        Log log = new Log();
        ValidacaoPreferenciaService validacaoPreferenciaService = new ValidacaoPreferenciaService(log);
        ValidacaoPreferencia validacaoPreferencia = new ValidacaoPreferencia();
        RegiaoService regiaoService = new RegiaoService(log);
        EstadoService estadoService = new EstadoService(log);
        MunicipioService municipioService = new MunicipioService(log);
        splash.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (IsAppRunning.isAppRunning()) {
            JOptionPane.showMessageDialog(null, "O sistema já está em execução.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                boolean sqlAtivo = validacaoPreferenciaService.checkSetTrue();
                if (!sqlAtivo) {
                    regiaoService.cadastrarRegiao();
                    estadoService.cadastrarEstado();
                    municipioService.cadastrarMunicipio();
                    validacaoPreferencia.setSqlTrue(true);
                    validacaoPreferenciaService.setTrue(validacaoPreferencia);
                    log.escreverLogInfoAvulso("CADASTRADOS PARAMETROS INICIAIS DE REGIÃO, ESTADO E MUNICIPIO");
                }

                if (sqlAtivo) {
                    log.escreverLogInfoAvulso("REGIÕES, ESTADOS E MUNICÍPIOS JÁ INSERIDOS");
                }
                splash.disposeSplash();
                new LoginView().setVisible(true);
            }
        });
    }
    //FIM MAIN
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcessarSistema;
    private javax.swing.JButton btVisualizarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPaneLeft;
    private javax.swing.JLayeredPane jLayeredPaneRight;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfEmail;
    // End of variables declaration//GEN-END:variables
    //FIM ÁREA DE VARIÁVEIS AUTOMÁTICAS
}
