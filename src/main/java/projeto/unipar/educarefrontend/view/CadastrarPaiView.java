package projeto.unipar.educarefrontend.view;

import com.google.zxing.WriterException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import projeto.unipar.educarefrontend.dto.CepResponse;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.service.CepService;
import projeto.unipar.educarefrontend.util.CepFormatter;

import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.NumeroFormatter;
import projeto.unipar.educarefrontend.util.QRCodeGenerator;
import projeto.unipar.educarefrontend.util.SetIcon;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;
import projeto.unipar.educarefrontend.util.ValidaCpf;

public class CadastrarPaiView extends javax.swing.JFrame {

    private final SetIcon setIcon = new SetIcon();
    private final Log log = new Log();
    private final JFrame pai;
    private ValidaCpf validaCpf = new ValidaCpf();

    public CadastrarPaiView(JFrame pai) {
        initComponents();
        this.pai = pai;
        setLocationRelativeTo(pai);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);
        log.escreverLogInfoAvulso("INFO", "Tela de Cadastro de Pai Aberta");
        validaCamposMostrarMae();
        validaQrCodeTrue();
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
        jtfMaeSelecionada = new javax.swing.JTextField();
        jtfTelefoneReserva = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel4 = new javax.swing.JLabel();
        jcbWhastapp = new javax.swing.JCheckBox();
        jtfNomeContatoReserva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefoneContatoReserva = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel6 = new javax.swing.JLabel();
        jcbPodeBuscar = new javax.swing.JCheckBox();
        jcbWhastappReserva = new javax.swing.JCheckBox();
        jtfNumero = new NumeroFormatter(log).createFormatterNumero();
        jtfBairro = new javax.swing.JTextField();
        jbCadastrarPai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfLogradouro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfComplemento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfUf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btDownload = new javax.swing.JButton();
        btGerarQrCode = new javax.swing.JButton();
        jlQrCode = new javax.swing.JLabel();
        jbBuscarCep1 = new javax.swing.JButton();
        jftfCep = new CepFormatter(log).createFormatterCep();
        jbLimparQrCode = new javax.swing.JButton();
        jtfCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

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
        jLabel2.setBounds(60, 100, 140, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("N°");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(980, 200, 100, 20);

        jtfNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfNome);
        jtfNome.setBounds(200, 100, 410, 40);

        jtfCpfPai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfCpfPai);
        jtfCpfPai.setBounds(200, 150, 410, 40);

        jcbPaiMae.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbPaiMae.setText("Pai e Mãe moram no mesmo endereço?");
        jcbPaiMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaiMaeActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPaiMae);
        jcbPaiMae.setBounds(620, 100, 340, 30);

        jbLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIcon.png"))); // NOI18N
        jbLupa.setToolTipText("Selecione a Mãe");
        jPanel1.add(jbLupa);
        jbLupa.setBounds(620, 150, 60, 40);

        jtfMaeSelecionada.setEditable(false);
        jtfMaeSelecionada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfMaeSelecionada.setToolTipText("Selecione a Mãe");
        jPanel1.add(jtfMaeSelecionada);
        jtfMaeSelecionada.setBounds(690, 150, 270, 40);

        jtfTelefoneReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfTelefoneReserva);
        jtfTelefoneReserva.setBounds(200, 300, 411, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 200, 140, 20);

        jcbWhastapp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbWhastapp.setText("WhatsApp");
        jcbWhastapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWhastappActionPerformed(evt);
            }
        });
        jPanel1.add(jcbWhastapp);
        jcbWhastapp.setBounds(620, 250, 160, 30);

        jtfNomeContatoReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfNomeContatoReserva);
        jtfNomeContatoReserva.setBounds(200, 250, 411, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contato Reserva");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 250, 140, 20);

        jtfTelefoneContatoReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfTelefoneContatoReserva);
        jtfTelefoneContatoReserva.setBounds(200, 200, 410, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefone Reserva");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 300, 140, 20);

        jcbPodeBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbPodeBuscar.setText("Pode buscar");
        jcbPodeBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPodeBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPodeBuscar);
        jcbPodeBuscar.setBounds(620, 200, 160, 30);

        jcbWhastappReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbWhastappReserva.setText("Pode buscar");
        jcbWhastappReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWhastappReservaActionPerformed(evt);
            }
        });
        jPanel1.add(jcbWhastappReserva);
        jcbWhastappReserva.setBounds(620, 300, 98, 30);

        jtfNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfNumero);
        jtfNumero.setBounds(1080, 200, 260, 40);

        jtfBairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfBairro);
        jtfBairro.setBounds(1080, 250, 260, 40);

        jbCadastrarPai.setBackground(new java.awt.Color(51, 153, 0));
        jbCadastrarPai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbCadastrarPai.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrarPai.setText("Salvar Cadastro");
        jbCadastrarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarPaiActionPerformed(evt);
            }
        });
        jPanel1.add(jbCadastrarPai);
        jbCadastrarPai.setBounds(60, 700, 140, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cpf");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 150, 140, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Cep");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(980, 100, 100, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Bairro");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(980, 250, 100, 20);

        jtfLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfLogradouro);
        jtfLogradouro.setBounds(1080, 150, 260, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Logradouro");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(980, 150, 100, 20);

        jtfComplemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfComplemento);
        jtfComplemento.setBounds(1080, 300, 260, 40);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Complemento");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(980, 300, 100, 20);

        jtfUf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfUf);
        jtfUf.setBounds(1080, 400, 260, 40);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("UF - Estado");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(980, 400, 100, 20);

        btDownload.setBackground(new java.awt.Color(85, 6, 124));
        btDownload.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDownload.setForeground(new java.awt.Color(255, 255, 255));
        btDownload.setText("Download");
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });
        jPanel1.add(btDownload);
        btDownload.setBounds(60, 640, 140, 40);

        btGerarQrCode.setBackground(new java.awt.Color(85, 6, 124));
        btGerarQrCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btGerarQrCode.setForeground(new java.awt.Color(255, 255, 255));
        btGerarQrCode.setText("Gerar Qrcode");
        btGerarQrCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarQrCodeActionPerformed(evt);
            }
        });
        jPanel1.add(btGerarQrCode);
        btGerarQrCode.setBounds(60, 580, 140, 40);
        jPanel1.add(jlQrCode);
        jlQrCode.setBounds(240, 540, 230, 200);

        jbBuscarCep1.setBackground(new java.awt.Color(85, 6, 124));
        jbBuscarCep1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbBuscarCep1.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscarCep1.setText("Buscar Cep");
        jbBuscarCep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCep1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscarCep1);
        jbBuscarCep1.setBounds(1240, 100, 100, 40);

        jftfCep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jftfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftfCepKeyPressed(evt);
            }
        });
        jPanel1.add(jftfCep);
        jftfCep.setBounds(1080, 100, 150, 40);

        jbLimparQrCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconVassoura.png"))); // NOI18N
        jbLimparQrCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparQrCodeActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimparQrCode);
        jbLimparQrCode.setBounds(480, 540, 40, 40);

        jtfCidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtfCidade);
        jtfCidade.setBounds(1080, 350, 260, 40);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Cidade");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(980, 350, 100, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
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

    private void jbBuscarCep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCep1ActionPerformed
        // TODO add your handling code here:
        String cepComMascara = jftfCep.getText();
        String cepSemMascara = cepComMascara.replaceAll("[^\\d]", "");
        CepService cepService = new CepService();
        limparCamposEnderecoAoBuscar();
        CepResponse cepResponse = cepService.buscarCep(cepSemMascara);

        if (cepResponse != null) {
            jtfLogradouro.setText(cepResponse.getLogradouro());
            jtfBairro.setText(cepResponse.getBairro());
            jtfComplemento.setText(cepResponse.getComplemento());
            jtfCidade.setText(cepResponse.getLocalidade());
            jtfUf.setText(cepResponse.getUf());
        } else {
            JOptionPane.showMessageDialog(null, "CEP não encontrado.");
        }
    }//GEN-LAST:event_jbBuscarCep1ActionPerformed

    private void btGerarQrCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarQrCodeActionPerformed
        // TODO add your handling code here:
        if (jtfCpfPai == null || jtfCpfPai.getText().trim().isBlank() || jtfCpfPai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o CPF primeiro", "Cpf Inválido", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String cpfPai = jtfCpfPai.getText().replaceAll("[^\\d]", "");

        if (cpfPai.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF deve conter 11 dígitos", "Cpf Inválido", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!validaCpf.isValidCPF(cpfPai)) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Cpf Inválido", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(cpfPai, log);
        ImageIcon icon = new ImageIcon(qrCodeImage);
        jlQrCode.setIcon(icon);
        validaQrCodeTrue();
    }//GEN-LAST:event_btGerarQrCodeActionPerformed

    public void validaQrCodeTrue() {
        jbLimparQrCode.setVisible(jlQrCode.getIcon() != null);
    }

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
        // TODO add your handling code here:
        if (jlQrCode.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Nenhum QR code para salvar", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar QR code");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagem PNG", "png"));

        fileChooser.setSelectedFile(new File("qrCode-EduCare-" + jtfCpfPai.getText() + ".png"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".png")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
            }

            try {
                ImageIcon icon = (ImageIcon) jlQrCode.getIcon();
                BufferedImage qrCodeImage = new BufferedImage(
                        icon.getIconWidth(),
                        icon.getIconHeight(),
                        BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = qrCodeImage.createGraphics();
                icon.paintIcon(null, g2d, 0, 0);
                g2d.dispose();

                ImageIO.write(qrCodeImage, "png", fileToSave);
                JOptionPane.showMessageDialog(null, "QR code salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar QR code: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                log.escreverLogErroOperacaoException(e, e.getMessage());
            }
        }
    }//GEN-LAST:event_btDownloadActionPerformed

    private void jbLimparQrCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparQrCodeActionPerformed
        // TODO add your handling code here:
        jlQrCode.setIcon(null);
        validaQrCodeTrue();

    }//GEN-LAST:event_jbLimparQrCodeActionPerformed

    private void jbCadastrarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarPaiActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jbCadastrarPaiActionPerformed

    private void jftfCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftfCepKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String cepComMascara = jftfCep.getText();
            String cepSemMascara = cepComMascara.replaceAll("[^\\d]", "");
            CepService cepService = new CepService();
            limparCamposEnderecoAoBuscar();
            CepResponse cepResponse = cepService.buscarCep(cepSemMascara);

            if (cepResponse != null) {
                jtfLogradouro.setText(cepResponse.getLogradouro());
                jtfBairro.setText(cepResponse.getBairro());
                jtfComplemento.setText(cepResponse.getComplemento());
                jtfCidade.setText(cepResponse.getLocalidade());
                jtfUf.setText(cepResponse.getUf());
            } else {
                JOptionPane.showMessageDialog(null, "CEP não encontrado.");
            }
        }
    }//GEN-LAST:event_jftfCepKeyPressed

    private void validaCamposMostrarMae() {
        boolean selected = jcbPaiMae.isSelected();
        //jlSelecioneAMae.setEnabled(selected);
        jbLupa.setEnabled(selected);
        jtfMaeSelecionada.setEnabled(selected);
        //jlSelecioneAMae.setVisible(selected);
        jbLupa.setVisible(selected);
        jtfMaeSelecionada.setVisible(selected);
    }

    public void limparCamposEnderecoAoBuscar() {
        jtfLogradouro.setText("");
        jtfNumero.setText("");
        jtfBairro.setText("");
        jtfComplemento.setText("");
        jtfCidade.setText("");
        jtfUf.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDownload;
    private javax.swing.JButton btGerarQrCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscarCep1;
    private javax.swing.JButton jbCadastrarPai;
    private javax.swing.JButton jbLimparQrCode;
    private javax.swing.JButton jbLupa;
    private javax.swing.JCheckBox jcbPaiMae;
    private javax.swing.JCheckBox jcbPodeBuscar;
    private javax.swing.JCheckBox jcbWhastapp;
    private javax.swing.JCheckBox jcbWhastappReserva;
    private javax.swing.JFormattedTextField jftfCep;
    private javax.swing.JLabel jlQrCode;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfCpfPai;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfMaeSelecionada;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNomeContatoReserva;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfTelefoneContatoReserva;
    private javax.swing.JTextField jtfTelefoneReserva;
    private javax.swing.JTextField jtfUf;
    // End of variables declaration//GEN-END:variables

}
