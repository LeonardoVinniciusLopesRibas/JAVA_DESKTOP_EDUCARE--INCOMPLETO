package projeto.unipar.educarefrontend.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.dto.UsuarioRequest;
import projeto.unipar.educarefrontend.dto.UsuarioRequestCadastro;
import projeto.unipar.educarefrontend.service.UsuarioService;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.RoundedBorder;
import projeto.unipar.educarefrontend.util.SetIcon;

public class CadastrarUsuarioView extends javax.swing.JFrame {

    private boolean isPasswordVisible = false;
    private final SetIcon setIcon = new SetIcon();
    private final Log log = new Log();
    private final UsuarioService usuarioService = new UsuarioService(log);
    
    public CadastrarUsuarioView(JFrame pai) {
        initComponents();
        setLocationRelativeTo(pai);
        setIcon.setIconJFrame(this);
        log.escreverLogInfoAvulso("INFO", "Tela de Cadastro de Usuário Aberta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btVisualizarSenha = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        jbCadastrarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR USUÁRIO");

        jPanel1.setBackground(new java.awt.Color(229, 218, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Usuário");

        jtfNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfNome.setBorder(new RoundedBorder(15));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email");

        jtfEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfEmail.setBorder(new RoundedBorder(15));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Senha");

        btVisualizarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png"))); // NOI18N
        btVisualizarSenha.setBorder(new RoundedBorder(15));
        btVisualizarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btVisualizarSenhaMousePressed(evt);
            }
        });

        jpfSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpfSenha.setBorder(new RoundedBorder(15));

        jbCadastrarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jbCadastrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbCadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrarUsuario.setText("Cadastrar");
        jbCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbCadastrarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jpfSenha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btVisualizarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtfNome)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVisualizarSenha)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jbCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVisualizarSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVisualizarSenhaMousePressed
        // TODO add your handling code here:
        if (isPasswordVisible) {
            jpfSenha.setEchoChar('*');
            btVisualizarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png")));
        } else {
            jpfSenha.setEchoChar((char) 0);
            btVisualizarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoVer.png")));
        }
        isPasswordVisible = !isPasswordVisible;
    }//GEN-LAST:event_btVisualizarSenhaMousePressed

    private void jbCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        String nome = jtfNome.getText();
        String email = jtfEmail.getText();
        String senha = jpfSenha.getText();
        
        UsuarioRequestCadastro urc = new UsuarioRequestCadastro();
        urc.setNome(nome);
        urc.setEmail(email);
        urc.setSenha(senha);
        
        usuarioService.save(urc, this);
    }//GEN-LAST:event_jbCadastrarUsuarioActionPerformed

    public void limparCampos(){
        jtfNome.setText("");
        jtfEmail.setText("");
        jpfSenha.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVisualizarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCadastrarUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
