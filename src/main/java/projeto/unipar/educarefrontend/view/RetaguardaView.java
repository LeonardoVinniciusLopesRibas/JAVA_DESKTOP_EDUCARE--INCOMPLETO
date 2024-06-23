package projeto.unipar.educarefrontend.view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.RoundedBorder;
import projeto.unipar.educarefrontend.util.SetIcon;

public class RetaguardaView extends javax.swing.JFrame {

    private final Log log = new Log();
    private final SetIcon setIcon = new SetIcon();

    public RetaguardaView() {
        initComponents();
        log.escreverLogInfoAvulso("INFORMATIVO", "ABRINDO RETAGUARDA");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlBemVindo = new javax.swing.JLabel();
        jmbItens = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiTrocarUser = new javax.swing.JMenuItem();
        jmiReiniciar = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDUCARE");

        jPanel1.setBackground(new java.awt.Color(229, 218, 235));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/EduCareLogo.png"))); // NOI18N

        jlBemVindo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jlBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
            .addComponent(jlBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );

        jmbItens.setBackground(new java.awt.Color(85, 6, 124));
        jmbItens.setBorderPainted(false);
        jmbItens.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(85, 6, 124));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Arquivo");
        jMenu1.setOpaque(true);

        jmiTrocarUser.setBackground(new java.awt.Color(85, 6, 124));
        jmiTrocarUser.setForeground(new java.awt.Color(255, 255, 255));
        jmiTrocarUser.setText("Trocar de Usuário");
        jmiTrocarUser.setBorder(new RoundedBorder(15));
        jmiTrocarUser.setOpaque(true);
        jMenu1.add(jmiTrocarUser);

        jmiReiniciar.setBackground(new java.awt.Color(85, 6, 124));
        jmiReiniciar.setForeground(new java.awt.Color(255, 255, 255));
        jmiReiniciar.setText("Reiniciar");
        jmiReiniciar.setBorder(new RoundedBorder(15));
        jmiReiniciar.setOpaque(true);
        jmiReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReiniciarActionPerformed(evt);
            }
        });
        jMenu1.add(jmiReiniciar);

        jmiSair.setBackground(new java.awt.Color(85, 6, 124));
        jmiSair.setForeground(new java.awt.Color(255, 255, 255));
        jmiSair.setText("Sair");
        jmiSair.setBorder(new RoundedBorder(15));
        jmiSair.setOpaque(true);
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSair);

        jmbItens.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(85, 6, 124));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Ferramentas");
        jMenu2.setOpaque(true);
        jmbItens.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(85, 6, 124));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Estoque");
        jMenu3.setOpaque(true);
        jmbItens.add(jMenu3);

        setJMenuBar(jmbItens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            dispose(); // Fecha a janela
        }
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReiniciarActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja reiniciar?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            reiniciar(); // Chama o método para reiniciar
        }
    }//GEN-LAST:event_jmiReiniciarActionPerformed

    public void userSession(Usuario usuario) {

        Long id = usuario.getId();
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        escreverBemVindo(nome);
    }

    private void escreverBemVindo(String nome) {
        jlBemVindo.setText("Bom Trabalho: " + nome);
    }

    private void reiniciar() {
        try {
            String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String currentDir = new File(".").getCanonicalPath();  // Obtém o diretório atual de onde o JAR está sendo executado
            String jarFilePath = currentDir + File.separator + "EduCareFrontEnd-1.0-SNAPSHOT.jar";
            File jarFile = new File(jarFilePath);

            if (!jarFile.exists() || !jarFile.isFile()) {
                JOptionPane.showMessageDialog(this, "Não foi possível reiniciar a aplicação.", "Erro", JOptionPane.ERROR_MESSAGE);
                log.escreverLogErroAvulso("Reiniciar", "Arquivo JAR especificado não encontrado ou inválido: " + jarFilePath);
                return;
            }

            // Cria um processo para reiniciar a aplicação
            ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", jarFilePath);
            builder.start();
            dispose(); // Fecha a janela atual
        } catch (IOException ex) {
            // Loga o erro
            String errorMessage = "Erro ao reiniciar a aplicação: " + ex.getMessage();
            JOptionPane.showMessageDialog(this, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            log.escreverLogErroOperacaoException(ex, errorMessage);
        } catch (Exception ex) {
            // Outras exceções não previstas
            String errorMessage = "Erro desconhecido ao reiniciar a aplicação: " + ex.getMessage();
            JOptionPane.showMessageDialog(this, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            log.escreverLogErroOperacaoException(ex, errorMessage);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlBemVindo;
    private javax.swing.JMenuBar jmbItens;
    private javax.swing.JMenuItem jmiReiniciar;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiTrocarUser;
    // End of variables declaration//GEN-END:variables

}
