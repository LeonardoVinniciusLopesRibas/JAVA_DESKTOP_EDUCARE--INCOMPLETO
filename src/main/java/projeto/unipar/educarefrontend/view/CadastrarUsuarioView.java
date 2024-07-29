package projeto.unipar.educarefrontend.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private final JFrame pai;
    
    public CadastrarUsuarioView(JFrame pai) {
        initComponents();
        this.pai = pai;
        setLocationRelativeTo(pai);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);
        log.escreverLogInfoAvulso("Tela de Cadastro de Usuário Aberta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        btVisualizarSenha = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        jbCadastrarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRAR USUÁRIO");

        jPanel1.setBackground(new java.awt.Color(204, 160, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 100));
        jPanel1.setLayout(null);

        jtfNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfNome);
        jtfNome.setBounds(130, 100, 539, 40);

        jtfEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfEmail);
        jtfEmail.setBounds(130, 150, 539, 40);

        btVisualizarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/olhoNaoVer.png"))); // NOI18N
        btVisualizarSenha.setBorder(new RoundedBorder(15));
        btVisualizarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btVisualizarSenhaMousePressed(evt);
            }
        });
        jPanel1.add(btVisualizarSenha);
        btVisualizarSenha.setBounds(640, 200, 33, 40);

        jpfSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jpfSenha);
        jpfSenha.setBounds(130, 200, 500, 40);

        jbCadastrarUsuario.setBackground(new java.awt.Color(51, 153, 0));
        jbCadastrarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbCadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrarUsuario.setText("Cadastrar");
        jbCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jbCadastrarUsuario);
        jbCadastrarUsuario.setBounds(20, 630, 140, 45);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastrar Usuário");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(640, 30, 160, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Senha");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 200, 110, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 100, 110, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Usuário");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 150, 110, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
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
        urc.setUsuario(email);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCadastrarUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
