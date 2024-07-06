package projeto.unipar.educarefrontend.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.RoundedBorder;
import projeto.unipar.educarefrontend.util.SetIcon;

public class RetaguardaView extends javax.swing.JFrame {

    private final Log log = new Log();
    private final SetIcon setIcon = new SetIcon();
    
    private boolean isCadastrarUsuarioOpen;
    private CadastrarUsuarioView cadastrarUsuarioInstancia;

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
        jmArquivo = new javax.swing.JMenu();
        jmiTrocarUsuario = new javax.swing.JMenuItem();
        jmiReiniciar = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmFerramentas = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jmUsuario = new javax.swing.JMenu();
        jmiCadastrarUsuario = new javax.swing.JMenuItem();
        jmiVisualizarUsuario = new javax.swing.JMenuItem();
        jmiReativarUsuario = new javax.swing.JMenuItem();
        jmEstoque = new javax.swing.JMenu();

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

        jmArquivo.setBackground(new java.awt.Color(85, 6, 124));
        jmArquivo.setForeground(new java.awt.Color(255, 255, 255));
        jmArquivo.setText("Arquivo");
        jmArquivo.setOpaque(true);

        jmiTrocarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiTrocarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiTrocarUsuario.setText("Trocar de Usuário");
        jmiTrocarUsuario.setBorder(new RoundedBorder(15));
        jmiTrocarUsuario.setOpaque(true);
        jmArquivo.add(jmiTrocarUsuario);

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
        jmArquivo.add(jmiReiniciar);

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
        jmArquivo.add(jmiSair);

        jmbItens.add(jmArquivo);

        jmFerramentas.setBackground(new java.awt.Color(85, 6, 124));
        jmFerramentas.setForeground(new java.awt.Color(255, 255, 255));
        jmFerramentas.setText("Ferramentas");
        jmFerramentas.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(85, 6, 124));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Criança");
        jMenu1.setOpaque(true);

        jMenuItem1.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Cadastrar");
        jMenuItem1.setOpaque(true);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Visualizar");
        jMenuItem2.setOpaque(true);
        jMenu1.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Reativar");
        jMenuItem3.setOpaque(true);
        jMenu1.add(jMenuItem3);

        jmFerramentas.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(85, 6, 124));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Mãe");
        jMenu2.setOpaque(true);

        jMenuItem4.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setText("Cadastrar");
        jMenuItem4.setOpaque(true);
        jMenu2.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setText("Visualizar");
        jMenuItem5.setOpaque(true);
        jMenu2.add(jMenuItem5);

        jMenuItem6.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem6.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setText("Reativar");
        jMenuItem6.setOpaque(true);
        jMenu2.add(jMenuItem6);

        jmFerramentas.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(85, 6, 124));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Pai");
        jMenu3.setOpaque(true);

        jMenuItem7.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem7.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setText("Cadastrar");
        jMenuItem7.setOpaque(true);
        jMenu3.add(jMenuItem7);

        jMenuItem8.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem8.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setText("Visualizar");
        jMenuItem8.setOpaque(true);
        jMenu3.add(jMenuItem8);

        jMenuItem9.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setText("Reativar");
        jMenuItem9.setOpaque(true);
        jMenu3.add(jMenuItem9);

        jmFerramentas.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(85, 6, 124));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Responsável");
        jMenu4.setOpaque(true);

        jMenuItem10.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem10.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setText("Cadastrar");
        jMenuItem10.setOpaque(true);
        jMenu4.add(jMenuItem10);

        jMenuItem11.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem11.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem11.setText("Visualizar");
        jMenuItem11.setOpaque(true);
        jMenu4.add(jMenuItem11);

        jMenuItem12.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem12.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem12.setText("Reativar");
        jMenuItem12.setOpaque(true);
        jMenu4.add(jMenuItem12);

        jmFerramentas.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(85, 6, 124));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Produto");
        jMenu5.setOpaque(true);

        jMenuItem13.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem13.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem13.setText("Cadastrar");
        jMenuItem13.setOpaque(true);
        jMenu5.add(jMenuItem13);

        jMenuItem14.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem14.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem14.setText("Visualizar");
        jMenuItem14.setOpaque(true);
        jMenu5.add(jMenuItem14);

        jMenuItem15.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem15.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem15.setText("Reativar");
        jMenuItem15.setOpaque(true);
        jMenu5.add(jMenuItem15);

        jmFerramentas.add(jMenu5);

        jmUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmUsuario.setText("Usuário");
        jmUsuario.setOpaque(true);

        jmiCadastrarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiCadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiCadastrarUsuario.setText("Cadastrar");
        jmiCadastrarUsuario.setOpaque(true);
        jmiCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarUsuarioActionPerformed(evt);
            }
        });
        jmUsuario.add(jmiCadastrarUsuario);

        jmiVisualizarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiVisualizarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiVisualizarUsuario.setText("Visualizar");
        jmiVisualizarUsuario.setOpaque(true);
        jmUsuario.add(jmiVisualizarUsuario);

        jmiReativarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiReativarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiReativarUsuario.setText("Reativar");
        jmiReativarUsuario.setOpaque(true);
        jmUsuario.add(jmiReativarUsuario);

        jmFerramentas.add(jmUsuario);

        jmbItens.add(jmFerramentas);

        jmEstoque.setBackground(new java.awt.Color(85, 6, 124));
        jmEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jmEstoque.setText("Estoque");
        jmEstoque.setOpaque(true);
        jmbItens.add(jmEstoque);

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

    private void jmiCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        if(isCadastrarUsuarioOpen){
            cadastrarUsuarioInstancia.toFront();
            cadastrarUsuarioInstancia.repaint();
        }else{
            isCadastrarUsuarioOpen = true;
            cadastrarUsuarioInstancia = new CadastrarUsuarioView(this);
            cadastrarUsuarioInstancia.setVisible(true);
            log.escreverLogInfoAvulso("INFORMATIVO", "Tela de cadastrar usuário aberta");
            cadastrarUsuarioInstancia.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isCadastrarUsuarioOpen = false;
                    cadastrarUsuarioInstancia = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isCadastrarUsuarioOpen = false;
                    cadastrarUsuarioInstancia = null;
                }
            });
        }
        
    }//GEN-LAST:event_jmiCadastrarUsuarioActionPerformed

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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlBemVindo;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmEstoque;
    private javax.swing.JMenu jmFerramentas;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JMenuBar jmbItens;
    private javax.swing.JMenuItem jmiCadastrarUsuario;
    private javax.swing.JMenuItem jmiReativarUsuario;
    private javax.swing.JMenuItem jmiReiniciar;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiTrocarUsuario;
    private javax.swing.JMenuItem jmiVisualizarUsuario;
    // End of variables declaration//GEN-END:variables

}
