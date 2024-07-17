package projeto.unipar.educarefrontend.view;

import javax.swing.JFrame;
import projeto.unipar.educarefrontend.util.BorderBlack;
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
        setSize(1366, 768); // Define o tamanho fixo
        setResizable(false);
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
        jtfNome = new javax.swing.JTextField();
        jtfCpfPai = new CpfFormatter(log).createFormattedTextFieldCpf();
        jcbPaiMae = new javax.swing.JCheckBox();
        jbLupa = new javax.swing.JButton();
        jlSelecioneAMae = new javax.swing.JLabel();
        jtfMaeSelecionada = new javax.swing.JTextField();
        jtfTelefonePai = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel4 = new javax.swing.JLabel();
        jcbWhastapp = new javax.swing.JCheckBox();
        jtfNomeContatoReserva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefoneContatoReserva = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel6 = new javax.swing.JLabel();
        jcbPodeBuscar = new javax.swing.JCheckBox();
        jcbWhastappReserva = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jtfCep = new javax.swing.JTextField();
        jbBuscarCep = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 160, 238));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastrar Pai");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(652, 30, 117, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 80, 37, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("N°");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1120, 350, 15, 20);

        jtfNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfNome.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfNome);
        jtfNome.setBounds(60, 100, 410, 60);

        jtfCpfPai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfCpfPai.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfCpfPai);
        jtfCpfPai.setBounds(540, 100, 304, 60);

        jcbPaiMae.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbPaiMae.setText("Pai e Mãe moram no mesmo endereço?");
        jcbPaiMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaiMaeActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPaiMae);
        jcbPaiMae.setBounds(880, 110, 340, 31);

        jbLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIcon.png"))); // NOI18N
        jPanel1.add(jbLupa);
        jbLupa.setBounds(880, 170, 60, 60);

        jlSelecioneAMae.setText("Selecione a Mãe");
        jPanel1.add(jlSelecioneAMae);
        jlSelecioneAMae.setBounds(880, 150, 351, 16);

        jtfMaeSelecionada.setEditable(false);
        jtfMaeSelecionada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfMaeSelecionada.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfMaeSelecionada);
        jtfMaeSelecionada.setBounds(950, 170, 270, 60);

        jtfTelefonePai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfTelefonePai.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfTelefonePai);
        jtfTelefonePai.setBounds(60, 280, 411, 60);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 170, 51, 20);

        jcbWhastapp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbWhastapp.setText("WhatsApp");
        jcbWhastapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWhastappActionPerformed(evt);
            }
        });
        jPanel1.add(jcbWhastapp);
        jcbWhastapp.setBounds(490, 200, 145, 40);

        jtfNomeContatoReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfNomeContatoReserva.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfNomeContatoReserva);
        jtfNomeContatoReserva.setBounds(60, 370, 411, 60);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nome do Contato Reserva");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 260, 162, 20);

        jtfTelefoneContatoReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfTelefoneContatoReserva.setBorder(new RoundedBorder(15));
        jPanel1.add(jtfTelefoneContatoReserva);
        jtfTelefoneContatoReserva.setBounds(60, 190, 410, 60);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefone Reserva");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 350, 102, 20);

        jcbPodeBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbPodeBuscar.setText("Pode buscar");
        jcbPodeBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPodeBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPodeBuscar);
        jcbPodeBuscar.setBounds(490, 290, 145, 40);

        jcbWhastappReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbWhastappReserva.setText("Pode buscar");
        jcbWhastappReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWhastappReservaActionPerformed(evt);
            }
        });
        jPanel1.add(jcbWhastappReserva);
        jcbWhastappReserva.setBounds(490, 380, 145, 40);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(1120, 370, 100, 60);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(880, 460, 340, 60);
        jPanel1.add(jtfCep);
        jtfCep.setBounds(880, 280, 220, 60);

        jbBuscarCep.setText("Buscar Cep");
        jPanel1.add(jbBuscarCep);
        jbBuscarCep.setBounds(1120, 280, 100, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Endereço");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1020, 240, 62, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cpf");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(540, 80, 21, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Cep");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(880, 260, 24, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Bairro");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(880, 440, 36, 20);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(880, 370, 220, 60);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Logradouro");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(880, 350, 72, 20);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(880, 540, 340, 60);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Logradouro");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(880, 520, 72, 20);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(880, 630, 340, 60);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cidade");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(880, 610, 42, 20);

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

    private void jcbWhastappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbWhastappActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbWhastappActionPerformed

    private void jcbPodeBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPodeBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPodeBuscarActionPerformed

    private void jcbWhastappReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbWhastappReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbWhastappReservaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jbBuscarCep;
    private javax.swing.JButton jbLupa;
    private javax.swing.JCheckBox jcbPaiMae;
    private javax.swing.JCheckBox jcbPodeBuscar;
    private javax.swing.JCheckBox jcbWhastapp;
    private javax.swing.JCheckBox jcbWhastappReserva;
    private javax.swing.JLabel jlSelecioneAMae;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfCpfPai;
    private javax.swing.JTextField jtfMaeSelecionada;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNomeContatoReserva;
    private javax.swing.JTextField jtfTelefoneContatoReserva;
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
