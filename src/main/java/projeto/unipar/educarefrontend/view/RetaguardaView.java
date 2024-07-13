package projeto.unipar.educarefrontend.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.ReiniciarSystem;
import projeto.unipar.educarefrontend.util.RoundedBorder;
import projeto.unipar.educarefrontend.util.SetIcon;

public class RetaguardaView extends javax.swing.JFrame {

    private final Log log = new Log();
    private final SetIcon setIcon = new SetIcon();

    private boolean isCadastrarUsuarioOpen;
    private CadastrarUsuarioView cadastrarUsuarioInstancia;

    private boolean isTrocarUsuarioOpen;
    private TrocarUsuarioView trocarUsuarioInstancia;
    
    private boolean isCadastrarPaiOpen;
    private CadastrarPaiView cadastrarPaiInstancia;

    public RetaguardaView() {
        initComponents();
        log.escreverLogInfoAvulso("INFORMATIVO", "ABRINDO RETAGUARDA");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
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
        jmiCadastrarPai = new javax.swing.JMenuItem();
        jmiVisualizarPai = new javax.swing.JMenuItem();
        jmiReativarPai = new javax.swing.JMenuItem();
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

        jMenu6.setText("File");
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar1.add(jMenu7);

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
                .addContainerGap(561, Short.MAX_VALUE))
        );

        jmbItens.setBackground(new java.awt.Color(85, 6, 124));
        jmbItens.setBorderPainted(false);
        jmbItens.setOpaque(true);

        jmArquivo.setBackground(new java.awt.Color(85, 6, 124));
        jmArquivo.setBorder(new RoundedBorder(15));
        jmArquivo.setForeground(new java.awt.Color(255, 255, 255));
        jmArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmArquivo32px.png"))); // NOI18N
        jmArquivo.setText("Arquivo");
        jmArquivo.setOpaque(true);

        jmiTrocarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiTrocarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiTrocarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiTrocarUsuario.png"))); // NOI18N
        jmiTrocarUsuario.setText("Trocar de Usuário");
        jmiTrocarUsuario.setBorder(new RoundedBorder(15));
        jmiTrocarUsuario.setOpaque(true);
        jmiTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTrocarUsuarioActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiTrocarUsuario);

        jmiReiniciar.setBackground(new java.awt.Color(85, 6, 124));
        jmiReiniciar.setForeground(new java.awt.Color(255, 255, 255));
        jmiReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReiniciar.png"))); // NOI18N
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
        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiSair.png"))); // NOI18N
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
        jmFerramentas.setBorder(new RoundedBorder(15));
        jmFerramentas.setForeground(new java.awt.Color(255, 255, 255));
        jmFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmFerramenta32px.png"))); // NOI18N
        jmFerramentas.setText("Ferramentas");
        jmFerramentas.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(85, 6, 124));
        jMenu1.setBorder(new RoundedBorder(15));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmCrianca.png"))); // NOI18N
        jMenu1.setText("Criança");
        jMenu1.setOpaque(true);

        jMenuItem1.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jMenuItem1.setText("Cadastrar");
        jMenuItem1.setBorder(new RoundedBorder(15));
        jMenuItem1.setOpaque(true);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jMenuItem2.setText("Visualizar");
        jMenuItem2.setBorder(new RoundedBorder(15));
        jMenuItem2.setOpaque(true);
        jMenu1.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jMenuItem3.setText("Reativar");
        jMenuItem3.setBorder(new RoundedBorder(15));
        jMenuItem3.setOpaque(true);
        jMenu1.add(jMenuItem3);

        jmFerramentas.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(85, 6, 124));
        jMenu2.setBorder(new RoundedBorder(15));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmMae.png"))); // NOI18N
        jMenu2.setText("Mãe");
        jMenu2.setOpaque(true);

        jMenuItem4.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jMenuItem4.setText("Cadastrar");
        jMenuItem4.setBorder(new RoundedBorder(15));
        jMenuItem4.setOpaque(true);
        jMenu2.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jMenuItem5.setText("Visualizar");
        jMenuItem5.setBorder(new RoundedBorder(15));
        jMenuItem5.setOpaque(true);
        jMenu2.add(jMenuItem5);

        jMenuItem6.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem6.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jMenuItem6.setText("Reativar");
        jMenuItem6.setBorder(new RoundedBorder(15));
        jMenuItem6.setOpaque(true);
        jMenu2.add(jMenuItem6);

        jmFerramentas.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(85, 6, 124));
        jMenu3.setBorder(new RoundedBorder(15));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmPai.png"))); // NOI18N
        jMenu3.setText("Pai");
        jMenu3.setOpaque(true);

        jmiCadastrarPai.setBackground(new java.awt.Color(85, 6, 124));
        jmiCadastrarPai.setForeground(new java.awt.Color(255, 255, 255));
        jmiCadastrarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jmiCadastrarPai.setText("Cadastrar");
        jmiCadastrarPai.setBorder(new RoundedBorder(15));
        jmiCadastrarPai.setOpaque(true);
        jmiCadastrarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarPaiActionPerformed(evt);
            }
        });
        jMenu3.add(jmiCadastrarPai);

        jmiVisualizarPai.setBackground(new java.awt.Color(85, 6, 124));
        jmiVisualizarPai.setForeground(new java.awt.Color(255, 255, 255));
        jmiVisualizarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jmiVisualizarPai.setText("Visualizar");
        jmiVisualizarPai.setBorder(new RoundedBorder(15));
        jmiVisualizarPai.setOpaque(true);
        jMenu3.add(jmiVisualizarPai);

        jmiReativarPai.setBackground(new java.awt.Color(85, 6, 124));
        jmiReativarPai.setForeground(new java.awt.Color(255, 255, 255));
        jmiReativarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jmiReativarPai.setText("Reativar");
        jmiReativarPai.setBorder(new RoundedBorder(15));
        jmiReativarPai.setOpaque(true);
        jMenu3.add(jmiReativarPai);

        jmFerramentas.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(85, 6, 124));
        jMenu4.setBorder(new RoundedBorder(15));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmResponsavel.png"))); // NOI18N
        jMenu4.setText("Responsável");
        jMenu4.setOpaque(true);

        jMenuItem10.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem10.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jMenuItem10.setText("Cadastrar");
        jMenuItem10.setBorder(new RoundedBorder(15));
        jMenuItem10.setOpaque(true);
        jMenu4.add(jMenuItem10);

        jMenuItem11.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem11.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jMenuItem11.setText("Visualizar");
        jMenuItem11.setBorder(new RoundedBorder(15));
        jMenuItem11.setOpaque(true);
        jMenu4.add(jMenuItem11);

        jMenuItem12.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem12.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jMenuItem12.setText("Reativar");
        jMenuItem12.setBorder(new RoundedBorder(15));
        jMenuItem12.setOpaque(true);
        jMenu4.add(jMenuItem12);

        jmFerramentas.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(85, 6, 124));
        jMenu5.setBorder(new RoundedBorder(15));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmProduto.png"))); // NOI18N
        jMenu5.setText("Produto");
        jMenu5.setOpaque(true);

        jMenuItem13.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem13.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jMenuItem13.setText("Cadastrar");
        jMenuItem13.setBorder(new RoundedBorder(15));
        jMenuItem13.setOpaque(true);
        jMenu5.add(jMenuItem13);

        jMenuItem14.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem14.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jMenuItem14.setText("Visualizar");
        jMenuItem14.setBorder(new RoundedBorder(15));
        jMenuItem14.setOpaque(true);
        jMenu5.add(jMenuItem14);

        jMenuItem15.setBackground(new java.awt.Color(85, 6, 124));
        jMenuItem15.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jMenuItem15.setText("Reativar");
        jMenuItem15.setBorder(new RoundedBorder(15));
        jMenuItem15.setOpaque(true);
        jMenu5.add(jMenuItem15);

        jmFerramentas.add(jMenu5);

        jmUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmUsuario.setBorder(new RoundedBorder(15));
        jmUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmUsuario.png"))); // NOI18N
        jmUsuario.setText("Usuário");
        jmUsuario.setOpaque(true);

        jmiCadastrarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiCadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiCadastrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiCadastrar.png"))); // NOI18N
        jmiCadastrarUsuario.setText("Cadastrar");
        jmiCadastrarUsuario.setBorder(new RoundedBorder(15));
        jmiCadastrarUsuario.setOpaque(true);
        jmiCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarUsuarioActionPerformed(evt);
            }
        });
        jmUsuario.add(jmiCadastrarUsuario);

        jmiVisualizarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiVisualizarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiVisualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiVisualizar.png"))); // NOI18N
        jmiVisualizarUsuario.setText("Visualizar");
        jmiVisualizarUsuario.setBorder(new RoundedBorder(15));
        jmiVisualizarUsuario.setOpaque(true);
        jmUsuario.add(jmiVisualizarUsuario);

        jmiReativarUsuario.setBackground(new java.awt.Color(85, 6, 124));
        jmiReativarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jmiReativarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmiReativar.png"))); // NOI18N
        jmiReativarUsuario.setText("Reativar");
        jmiReativarUsuario.setBorder(new RoundedBorder(15));
        jmiReativarUsuario.setOpaque(true);
        jmUsuario.add(jmiReativarUsuario);

        jmFerramentas.add(jmUsuario);

        jmbItens.add(jmFerramentas);

        jmEstoque.setBackground(new java.awt.Color(85, 6, 124));
        jmEstoque.setBorder(new RoundedBorder(15));
        jmEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jmEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/jmEstoque.png"))); // NOI18N
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
        Object[] options = {"Sim", "Não"};

        int option = JOptionPane.showOptionDialog(
                this,
                "Tem certeza que deseja sair?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (option == JOptionPane.YES_OPTION) {
            dispose();
            if(cadastrarUsuarioInstancia != null){
                cadastrarUsuarioInstancia.dispose();
            }
            if(cadastrarPaiInstancia != null){
                cadastrarPaiInstancia.dispose();
            }
        }
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReiniciarActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};

        int option = JOptionPane.showOptionDialog(
                this,
                "Tem certeza que deseja reiniciar?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (option == JOptionPane.YES_OPTION) {
            ReiniciarSystem.reiniciar(this, log);
            if(cadastrarUsuarioInstancia != null){
                cadastrarUsuarioInstancia.dispose();
            }
            if(cadastrarPaiInstancia != null){
                cadastrarPaiInstancia.dispose();
            }
        }
    }//GEN-LAST:event_jmiReiniciarActionPerformed

    private void jmiCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        if (isCadastrarUsuarioOpen) {
            cadastrarUsuarioInstancia.toFront();
            cadastrarUsuarioInstancia.repaint();
        } else {
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

    private void jmiTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTrocarUsuarioActionPerformed
        // TODO add your handling code here:
        if (isTrocarUsuarioOpen) {
            trocarUsuarioInstancia.toFront();
            trocarUsuarioInstancia.repaint();
        } else {
            isTrocarUsuarioOpen = true;
            trocarUsuarioInstancia = new TrocarUsuarioView(this, cadastrarUsuarioInstancia, cadastrarPaiInstancia);
            trocarUsuarioInstancia.setVisible(true);
            log.escreverLogInfoAvulso("INFORMATIVO", "Tela de troca de usuário aberta");
            trocarUsuarioInstancia.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isTrocarUsuarioOpen = false;
                    trocarUsuarioInstancia = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isTrocarUsuarioOpen = false;
                    trocarUsuarioInstancia = null;
                }
            });

        }
    }//GEN-LAST:event_jmiTrocarUsuarioActionPerformed

    private void jmiCadastrarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarPaiActionPerformed
        // TODO add your handling code here:
        if(isCadastrarPaiOpen){
            cadastrarPaiInstancia.toFront();
            cadastrarPaiInstancia.repaint();
        }else{
            isCadastrarPaiOpen = true;
            cadastrarPaiInstancia = new CadastrarPaiView(this);
            cadastrarPaiInstancia.setVisible(true);
            log.escreverLogInfoAvulso("INFORMATIVO", "Tela de cadastro de pai aberta");
            cadastrarPaiInstancia.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    isCadastrarPaiOpen = false;
                    cadastrarPaiInstancia = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isCadastrarPaiOpen = false;
                    cadastrarPaiInstancia = null;
                }
            });
        }
        
        
    }//GEN-LAST:event_jmiCadastrarPaiActionPerformed

    public void userSession(Usuario usuario) {

        Long id = usuario.getId();
        String nome = usuario.getNome();
        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        escreverBemVindo(nome);
    }

    private void escreverBemVindo(String nome) {
        jlBemVindo.setText("Bem vindo " + nome);
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlBemVindo;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmEstoque;
    private javax.swing.JMenu jmFerramentas;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JMenuBar jmbItens;
    private javax.swing.JMenuItem jmiCadastrarPai;
    private javax.swing.JMenuItem jmiCadastrarUsuario;
    private javax.swing.JMenuItem jmiReativarPai;
    private javax.swing.JMenuItem jmiReativarUsuario;
    private javax.swing.JMenuItem jmiReiniciar;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiTrocarUsuario;
    private javax.swing.JMenuItem jmiVisualizarPai;
    private javax.swing.JMenuItem jmiVisualizarUsuario;
    // End of variables declaration//GEN-END:variables

}
