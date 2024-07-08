package projeto.unipar.educarefrontend.view;

import javax.swing.JFrame;
import projeto.unipar.educarefrontend.util.RoundedBorder;

import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.SetIcon;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;

public class CadastrarPaiView extends javax.swing.JFrame {

    private final SetIcon setIcon = new SetIcon();
    private final Log log = new Log();
    private final JFrame pai;

    public CadastrarPaiView(JFrame pai) {
        initComponents();
        this.pai = pai;
        setLocationRelativeTo(pai);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);
        log.escreverLogInfoAvulso("INFO", "Tela de Cadastro de Pai Aberta");
        validaCamposMostrarMae();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfCpfPai = new CpfFormatter().createFormattedTextFieldCpf();
        jcbPaiMae = new javax.swing.JCheckBox();
        jbLupa = new javax.swing.JButton();
        jlSelecioneAMae = new javax.swing.JLabel();
        jtfMaeSelecionada = new javax.swing.JTextField();
        jtfTelefonePai = new TelefoneFormatter().createFormatterTelefone();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(229, 218, 235));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastrar Pai");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cpf");

        jtfEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfEmail.setBorder(new RoundedBorder(15));

        jtfCpfPai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfCpfPai.setBorder(new RoundedBorder(15));

        jcbPaiMae.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbPaiMae.setText("Pai e Mãe moram no mesmo endereço?");
        jcbPaiMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaiMaeActionPerformed(evt);
            }
        });

        jbLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIcon.png"))); // NOI18N

        jlSelecioneAMae.setText("Selecione a Mãe");

        jtfMaeSelecionada.setEditable(false);
        jtfMaeSelecionada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfMaeSelecionada.setBorder(new RoundedBorder(15));

        jtfTelefonePai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfTelefonePai.setBorder(new RoundedBorder(15));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(658, 658, 658)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtfTelefonePai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbPaiMae, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbLupa)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfMaeSelecionada))
                                    .addComponent(jlSelecioneAMae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPaiMae, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jlSelecioneAMae)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMaeSelecionada)
                            .addComponent(jbLupa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(858, 858, 858))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(jtfTelefonePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

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

    private void jcbPaiMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaiMaeActionPerformed
        // TODO add your handling code here:
        validaCamposMostrarMae();
    }//GEN-LAST:event_jcbPaiMaeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbLupa;
    private javax.swing.JCheckBox jcbPaiMae;
    private javax.swing.JLabel jlSelecioneAMae;
    private javax.swing.JTextField jtfCpfPai;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfMaeSelecionada;
    private javax.swing.JTextField jtfTelefonePai;
    // End of variables declaration//GEN-END:variables

    
    
    private void validaCamposMostrarMae(){
        boolean selected = jcbPaiMae.isSelected();
        jlSelecioneAMae.setEnabled(selected);
        jbLupa.setEnabled(selected);
        jtfMaeSelecionada.setEnabled(selected);
        jlSelecioneAMae.setVisible(selected);
        jbLupa.setVisible(selected);
        jtfMaeSelecionada.setVisible(selected);
        
    }
}
