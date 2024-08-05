package projeto.unipar.educarefrontend.view.panel;

import projeto.unipar.educarefrontend.util.CepFormatter;
import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.NumeroFormatter;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;

public class EditarPai extends javax.swing.JPanel {

    //VARIAVEIS E INSTANCIAS
    private Log log = new Log();
    //FIM VARIAVEIS E INSTANCIAS
    //CONSTRUTOR
    public EditarPai() {
        initComponents();
    }
    //FIM CONSTRUTOR
    //INICIO MÉTODOS
    
    //FIM MÉTODOS
    //INICIO MÉTODOS AUTOMÁTICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfCpfPai = new CpfFormatter(log).createFormattedTextFieldCpf();
        jLabel1 = new javax.swing.JLabel();
        jtfTelefonePai = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel3 = new javax.swing.JLabel();
        jtfNomeReserva = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jtfEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefoneReserva = new TelefoneFormatter(log).createFormatterTelefone();
        iconBuscar = new javax.swing.JCheckBox();
        jcbWhatsapp = new javax.swing.JCheckBox();
        iconWhatsappReserva = new javax.swing.JCheckBox();
        jcbPodeBuscar = new javax.swing.JCheckBox();
        iconWhatsapp2 = new javax.swing.JCheckBox();
        jcbWhatsappReserva = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jcbSelectPaiMae = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfNomePai = new javax.swing.JTextField();
        btBuscarCep = new javax.swing.JButton();
        jtfCep = new CepFormatter(log).createFormatterCep();
        jtfMomSelected = new javax.swing.JTextField();
        jtfNumero = new NumeroFormatter(log).createFormatterNumero();
        jtfBairro = new javax.swing.JTextField();
        jtfComplemento = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jtfLogradouro = new javax.swing.JTextField();
        btCleanMomAndAdress = new javax.swing.JButton();
        jbLupaMom = new javax.swing.JButton();
        lblQrCode = new javax.swing.JLabel();
        btGeneratedQrCode = new javax.swing.JButton();
        btCleanQrCode = new javax.swing.JButton();
        btDownload = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        btSelectMunicipio = new javax.swing.JButton();
        btSelectEstado = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 160, 238));
        setMaximumSize(new java.awt.Dimension(1366, 678));
        setMinimumSize(new java.awt.Dimension(1366, 678));
        setPreferredSize(new java.awt.Dimension(1366, 678));
        setLayout(null);

        jtfCpfPai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfCpfPai);
        jtfCpfPai.setBounds(130, 90, 150, 24);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome Reserva");
        add(jLabel1);
        jLabel1.setBounds(30, 160, 100, 16);

        jtfTelefonePai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfTelefonePai);
        jtfTelefonePai.setBounds(130, 120, 150, 24);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cpf do Pai");
        add(jLabel3);
        jLabel3.setBounds(30, 90, 100, 16);

        jtfNomeReserva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfNomeReserva);
        jtfNomeReserva.setBounds(130, 160, 150, 24);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator1);
        jSeparator1.setBounds(780, 40, 10, 280);

        jtfEstado.setEditable(false);
        jtfEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfEstado);
        jtfEstado.setBounds(540, 260, 190, 24);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone do Pai");
        add(jLabel4);
        jLabel4.setBounds(30, 120, 100, 16);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefone Reserva");
        add(jLabel5);
        jLabel5.setBounds(30, 190, 100, 16);

        jtfTelefoneReserva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfTelefoneReserva);
        jtfTelefoneReserva.setBounds(130, 190, 150, 24);

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconPodeBuscar.png"))); // NOI18N
        add(iconBuscar);
        iconBuscar.setBounds(300, 90, 20, 20);

        jcbWhatsapp.setSelected(true);
        add(jcbWhatsapp);
        jcbWhatsapp.setBounds(320, 120, 20, 19);

        iconWhatsappReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconWhatsapp.png"))); // NOI18N
        add(iconWhatsappReserva);
        iconWhatsappReserva.setBounds(300, 190, 20, 20);

        jcbPodeBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jcbPodeBuscar.setSelected(true);
        jcbPodeBuscar.setText("Pai pode buscar");
        add(jcbPodeBuscar);
        jcbPodeBuscar.setBounds(320, 90, 120, 20);

        iconWhatsapp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconWhatsapp.png"))); // NOI18N
        add(iconWhatsapp2);
        iconWhatsapp2.setBounds(300, 120, 20, 20);

        jcbWhatsappReserva.setSelected(true);
        add(jcbWhatsappReserva);
        jcbWhatsappReserva.setBounds(320, 190, 20, 19);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator2);
        jSeparator2.setBounds(20, 220, 432, 10);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator3);
        jSeparator3.setBounds(20, 40, 10, 350);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator4);
        jSeparator4.setBounds(20, 390, 430, 10);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator5);
        jSeparator5.setBounds(21, 150, 430, 10);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator6);
        jSeparator6.setBounds(21, 40, 430, 10);

        jcbSelectPaiMae.setForeground(new java.awt.Color(0, 0, 0));
        jcbSelectPaiMae.setText("Mãe mora  no mesmo endereço?");
        add(jcbSelectPaiMae);
        jcbSelectPaiMae.setBounds(460, 50, 270, 20);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator7);
        jSeparator7.setBounds(450, 40, 10, 350);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome do Pai");
        add(jLabel6);
        jLabel6.setBounds(30, 60, 100, 16);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cep");
        add(jLabel7);
        jLabel7.setBounds(460, 110, 80, 16);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Logradouro");
        add(jLabel8);
        jLabel8.setBounds(460, 140, 80, 16);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Número");
        add(jLabel9);
        jLabel9.setBounds(460, 170, 80, 16);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Bairro");
        add(jLabel10);
        jLabel10.setBounds(460, 200, 80, 16);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Complemento");
        add(jLabel11);
        jLabel11.setBounds(460, 230, 80, 16);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cidade");
        add(jLabel12);
        jLabel12.setBounds(460, 290, 80, 16);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("UF - Estado");
        add(jLabel13);
        jLabel13.setBounds(460, 260, 80, 16);

        jtfNomePai.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfNomePai);
        jtfNomePai.setBounds(130, 60, 150, 24);

        btBuscarCep.setBackground(new java.awt.Color(85, 6, 124));
        btBuscarCep.setForeground(new java.awt.Color(255, 255, 255));
        btBuscarCep.setText("Buscar");
        add(btBuscarCep);
        btBuscarCep.setBounds(700, 110, 70, 23);

        jtfCep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfCep);
        jtfCep.setBounds(540, 110, 150, 24);

        jtfMomSelected.setEditable(false);
        jtfMomSelected.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfMomSelected);
        jtfMomSelected.setBounds(460, 80, 190, 24);

        jtfNumero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfNumero);
        jtfNumero.setBounds(540, 170, 230, 24);

        jtfBairro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfBairro);
        jtfBairro.setBounds(540, 200, 230, 24);

        jtfComplemento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfComplemento);
        jtfComplemento.setBounds(540, 230, 230, 24);

        jtfCidade.setEditable(false);
        jtfCidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfCidade);
        jtfCidade.setBounds(540, 290, 190, 24);

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator8);
        jSeparator8.setBounds(450, 40, 330, 10);

        jtfLogradouro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(jtfLogradouro);
        jtfLogradouro.setBounds(540, 140, 230, 24);

        btCleanMomAndAdress.setBackground(new java.awt.Color(85, 6, 124));
        btCleanMomAndAdress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconVassoura24x24.png"))); // NOI18N
        add(btCleanMomAndAdress);
        btCleanMomAndAdress.setBounds(740, 50, 32, 32);

        jbLupaMom.setBackground(new java.awt.Color(85, 6, 124));
        jbLupaMom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIconWhite.png"))); // NOI18N
        add(jbLupaMom);
        jbLupaMom.setBounds(660, 80, 30, 23);
        add(lblQrCode);
        lblQrCode.setBounds(290, 230, 150, 150);

        btGeneratedQrCode.setBackground(new java.awt.Color(85, 6, 124));
        btGeneratedQrCode.setForeground(new java.awt.Color(255, 255, 255));
        btGeneratedQrCode.setText("Gerar QrCode");
        add(btGeneratedQrCode);
        btGeneratedQrCode.setBounds(130, 230, 150, 23);

        btCleanQrCode.setBackground(new java.awt.Color(85, 6, 124));
        btCleanQrCode.setForeground(new java.awt.Color(255, 255, 255));
        btCleanQrCode.setText("Limpar QrCode");
        add(btCleanQrCode);
        btCleanQrCode.setBounds(130, 260, 150, 23);

        btDownload.setBackground(new java.awt.Color(85, 6, 124));
        btDownload.setForeground(new java.awt.Color(255, 255, 255));
        btDownload.setText("Download");
        add(btDownload);
        btDownload.setBounds(130, 290, 150, 23);

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add(jSeparator9);
        jSeparator9.setBounds(450, 320, 330, 10);

        btSelectMunicipio.setBackground(new java.awt.Color(85, 6, 124));
        btSelectMunicipio.setForeground(new java.awt.Color(255, 255, 255));
        btSelectMunicipio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIconWhite.png"))); // NOI18N
        add(btSelectMunicipio);
        btSelectMunicipio.setBounds(740, 290, 30, 23);

        btSelectEstado.setBackground(new java.awt.Color(85, 6, 124));
        btSelectEstado.setForeground(new java.awt.Color(255, 255, 255));
        btSelectEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIconWhite.png"))); // NOI18N
        add(btSelectEstado);
        btSelectEstado.setBounds(740, 260, 30, 23);

        btSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconSave32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        add(btSalvar);
        btSalvar.setBounds(20, 410, 100, 50);
    }// </editor-fold>//GEN-END:initComponents
    //FIM MÉTODOS AUTOMÁTICOS
    //INICIO VARIAVEIS AUTOMATICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCep;
    private javax.swing.JButton btCleanMomAndAdress;
    private javax.swing.JButton btCleanQrCode;
    private javax.swing.JButton btDownload;
    private javax.swing.JButton btGeneratedQrCode;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSelectEstado;
    private javax.swing.JButton btSelectMunicipio;
    private javax.swing.JCheckBox iconBuscar;
    private javax.swing.JCheckBox iconWhatsapp2;
    private javax.swing.JCheckBox iconWhatsappReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbLupaMom;
    private javax.swing.JCheckBox jcbPodeBuscar;
    private javax.swing.JCheckBox jcbSelectPaiMae;
    private javax.swing.JCheckBox jcbWhatsapp;
    private javax.swing.JCheckBox jcbWhatsappReserva;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfCpfPai;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfMomSelected;
    private javax.swing.JTextField jtfNomePai;
    private javax.swing.JTextField jtfNomeReserva;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfTelefonePai;
    private javax.swing.JTextField jtfTelefoneReserva;
    private javax.swing.JLabel lblQrCode;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
