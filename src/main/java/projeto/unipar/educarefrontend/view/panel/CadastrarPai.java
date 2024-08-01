package projeto.unipar.educarefrontend.view.panel;

import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;

public class CadastrarPai extends javax.swing.JPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private Log log = new Log();
    //FIM ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public CadastrarPai() {
        initComponents();
    }    
    //FIM CONSTRUTOR
    //INÍCIO MÉTODOS
    
    //FIM MÉTODOS
    //INÍCIO MÉTODOS AUTOMÁTICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfCpfPai = new CpfFormatter(log).createFormattedTextFieldCpf();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTelefonePai = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel3 = new javax.swing.JLabel();
        jtfNomeReserva = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jtfNomePai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroReserva = new javax.swing.JTextField();
        iconBuscar = new javax.swing.JCheckBox();
        jcbWhatsapp = new javax.swing.JCheckBox();
        iconWhatsappReserva = new javax.swing.JCheckBox();
        jcbPodeBuscar = new javax.swing.JCheckBox();
        iconWhatsapp2 = new javax.swing.JCheckBox();
        jcbWhatsappReserva = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 160, 238));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setLayout(null);
        add(jtfCpfPai);
        jtfCpfPai.setBounds(130, 90, 150, 22);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome Reserva");
        add(jLabel1);
        jLabel1.setBounds(30, 160, 110, 16);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do Pai");
        add(jLabel2);
        jLabel2.setBounds(30, 60, 110, 16);
        add(jtfTelefonePai);
        jtfTelefonePai.setBounds(130, 120, 150, 22);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cpf do Pai");
        add(jLabel3);
        jLabel3.setBounds(30, 90, 110, 16);
        add(jtfNomeReserva);
        jtfNomeReserva.setBounds(130, 160, 150, 22);
        add(jSeparator1);
        jSeparator1.setBounds(30, 150, 250, 10);
        add(jtfNomePai);
        jtfNomePai.setBounds(130, 60, 150, 22);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone do Pai");
        add(jLabel4);
        jLabel4.setBounds(30, 120, 110, 16);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone Reserva");
        add(jLabel5);
        jLabel5.setBounds(30, 190, 110, 16);
        add(jtfNumeroReserva);
        jtfNumeroReserva.setBounds(130, 190, 150, 22);

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconPodeBuscar.png"))); // NOI18N
        add(iconBuscar);
        iconBuscar.setBounds(300, 90, 20, 20);
        add(jcbWhatsapp);
        jcbWhatsapp.setBounds(320, 120, 20, 19);

        iconWhatsappReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconWhatsapp.png"))); // NOI18N
        add(iconWhatsappReserva);
        iconWhatsappReserva.setBounds(300, 190, 20, 20);

        jcbPodeBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jcbPodeBuscar.setText("Pai pode buscar");
        add(jcbPodeBuscar);
        jcbPodeBuscar.setBounds(320, 90, 120, 20);

        iconWhatsapp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconWhatsapp.png"))); // NOI18N
        add(iconWhatsapp2);
        iconWhatsapp2.setBounds(300, 120, 20, 20);
        add(jcbWhatsappReserva);
        jcbWhatsappReserva.setBounds(320, 190, 20, 19);
    }// </editor-fold>//GEN-END:initComponents
    //FIM MÉTODOS AUTOMÁTICOS
    //INICIO VARIÁVEIS AUTOMÁTICAS
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox iconBuscar;
    private javax.swing.JCheckBox iconWhatsapp2;
    private javax.swing.JCheckBox iconWhatsappReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbPodeBuscar;
    private javax.swing.JCheckBox jcbWhatsapp;
    private javax.swing.JCheckBox jcbWhatsappReserva;
    private javax.swing.JTextField jtfCpfPai;
    private javax.swing.JTextField jtfNomePai;
    private javax.swing.JTextField jtfNomeReserva;
    private javax.swing.JTextField jtfNumeroReserva;
    private javax.swing.JTextField jtfTelefonePai;
    // End of variables declaration//GEN-END:variables
    //FIM VARIÁVEIS AUTOMÁTICAS
}
