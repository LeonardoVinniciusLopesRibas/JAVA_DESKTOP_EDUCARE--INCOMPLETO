package projeto.unipar.educarefrontend.view.panel;

import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import projeto.unipar.educarefrontend.dto.CepRequest;
import projeto.unipar.educarefrontend.dto.CepResponse;
import projeto.unipar.educarefrontend.dto.MaeResponse;
import projeto.unipar.educarefrontend.model.Estado;
import projeto.unipar.educarefrontend.model.Mae;
import projeto.unipar.educarefrontend.model.Municipio;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.service.CepService;
import projeto.unipar.educarefrontend.service.EstadoService;
import projeto.unipar.educarefrontend.service.MaeService;
import projeto.unipar.educarefrontend.service.PaiService;
import projeto.unipar.educarefrontend.util.AdjustWindowSize;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.CepFormatter;
import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.NumeroFormatter;
import projeto.unipar.educarefrontend.util.QRCodeGenerator;
import projeto.unipar.educarefrontend.util.RemoveMaskUtil;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;
import projeto.unipar.educarefrontend.util.ValidaCpf;
import projeto.unipar.educarefrontend.view.SelectEstado;
import projeto.unipar.educarefrontend.view.SelectMunicipio;
import projeto.unipar.educarefrontend.view.SelectedMomOnDad;

public class CadastrarPai extends javax.swing.JPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private Log log = new Log();
    private String ibge;
    private ValidaCpf validaCpf = new ValidaCpf();
    private EstadoService estadoService = new EstadoService(log);
    private MaeService maeService = new MaeService(log);
    private PaiService paiService = new PaiService(log);
    private AdjustWindowSize adjustWindowSize = new AdjustWindowSize();
    private Mae mae = new Mae();
    private Pai pai = new Pai();

    private boolean isSelectEstado;
    private SelectEstado selectEstadoInstance;
    private boolean isSelectMunicipio;
    private SelectMunicipio selectMunicipioInstance;
    private boolean isSelectMom;
    private SelectedMomOnDad selectMomInstance;

    private Long idEstado;
    private String siglaUfEstado;
    private String nomeEstado;

    private Long idMunicipio;
    private String ibgeMunicipio;
    private String nomeMunicipio;
    private String ufToMunicipio;

    private Long idMom;
    private String nomeMom;
    private String cpfMom;
    private String cepMom;
    private String logradouroMom;
    private String numeroMom;
    private String bairroMom;
    private String complementoMom;
    private String localidadeMom;
    private String ufMom;
    private String ibgeMom;

    //FIM ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public CadastrarPai() {
        initComponents();
        initManuallyComponents();

    }
    //FIM CONSTRUTOR
    //INÍCIO MÉTODOS

    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        showAdressMom();
        cleanDataForNewRegister();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por buscar o CEP">
    private void searchCep() {
        String cepComMascara = jtfCep.getText();
        String cepSemMascara = cepComMascara.replaceAll("[^\\d]", "");
        if (cepSemMascara == null || cepSemMascara.trim().isBlank() || cepSemMascara.trim().isEmpty()) {
            BalloonNotification balloonNotification = new BalloonNotification("O CEP está inválido");
            balloonNotification.show("O CEP está inválido");
            return;
        }

        if (cepSemMascara.length() != 8) {
            BalloonNotification balloonNotification = new BalloonNotification("O CEP deve conter 8 dígitos");
            balloonNotification.show("O CEP deve conter 8 dígitos");
            return;
        }
        CepService cepService = new CepService(log);

        CepRequest cepRequest = new CepRequest();
        cepRequest.setCep(cepSemMascara);
        CepResponse cepResponse = cepService.buscarCep(cepRequest);

        if (cepResponse != null) {
            jtfLogradouro.setText(cepResponse.getLogradouro());
            jtfBairro.setText(cepResponse.getBairro());
            jtfComplemento.setText(cepResponse.getComplemento());
            jtfCidade.setText(cepResponse.getLocalidade());
            jtfEstado.setText(cepResponse.getUf());
            ibge = cepResponse.getIbge();
            ibgeMom = "";
            ibgeMunicipio = "";
        } else {
            System.out.println("Cep não encontrado");
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por validar se a checkbox de mãe está marcada ou não">
    private void showAdressMom() {
        boolean selected = jcbSelectPaiMae.isSelected();
        jbLupaMom.setEnabled(selected);
        jtfMomSelected.setEnabled(selected);
        jbLupaMom.setVisible(selected);
        jtfMomSelected.setVisible(selected);
        btCleanMomAndAdress.setVisible(selected);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método por limpar todos os campos, chamado depois de clicar em salvar">
    private void cleanDataForNewRegister() {
        ibge = "";
        ibgeMom = "";
        ibgeMunicipio = "";

        jtfNomePai.setText("");
        jtfCpfPai.setText("");
        jtfTelefonePai.setText("");
        jtfNomeReserva.setText("");
        jtfTelefoneReserva.setText("");
        jcbSelectPaiMae.setSelected(false);
        jcbPodeBuscar.setSelected(true);
        jcbWhatsapp.setSelected(true);
        jcbWhatsappReserva.setSelected(true);
        jtfMomSelected.setText("");
        jtfCep.setText("");
        jtfLogradouro.setText("");
        jtfNumero.setText("");
        jtfBairro.setText("");
        jtfComplemento.setText("");
        jtfEstado.setText("");
        jtfCidade.setText("");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para limpar o endereço e a mãe">
    private void cleanAdressAndMomSelected() {
        Object[] options = {"Sim", "Não"};
        int option = JOptionPane.showOptionDialog(
                null,
                "Deseja realmente remover a mãe",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (jtfMomSelected != null && jtfMomSelected.getText().length() != 0) {
            if (option == JOptionPane.YES_OPTION) {
                jtfMomSelected.setText("");
                jtfCep.setText("");
                jtfLogradouro.setText("");
                jtfNumero.setText("");
                jtfBairro.setText("");
                jtfComplemento.setText("");
                jtfCidade.setText("");
                jtfEstado.setText("");
                ibge = "";
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por gerar o QrCode">
    private void generatedQrCode() {
        if (jtfCpfPai == null || jtfCpfPai.getText().trim().isBlank() || jtfCpfPai.getText().trim().isEmpty()) {
            BalloonNotification balloonNotification = new BalloonNotification("Informe o CPF primeiro");
            balloonNotification.show("Informe o CPF primeiro");

            return;
        }
        String cpfPai = jtfCpfPai.getText().replaceAll("[^\\d]", "");

        if (cpfPai.length() != 11) {
            BalloonNotification balloonNotification = new BalloonNotification("CPF deve conter 11 dígitos");
            balloonNotification.show("CPF deve conter 11 dígitos");
            return;
        }

        if (!validaCpf.isValidCPF(cpfPai)) {
            BalloonNotification balloonNotification = new BalloonNotification("CPF inválido");
            balloonNotification.show("CPF inválido");
            return;
        }

        BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(cpfPai, log);
        ImageIcon icon = new ImageIcon(qrCodeImage);
        lblQrCode.setIcon(icon);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por limpar o QrCode e remove-lo">
    private void cleanQrCode() {
        lblQrCode.setIcon(null);
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método para download do QrCode">
    private void downloadQrCode() {
        if (lblQrCode.getIcon() == null) {
            BalloonNotification balloonNotification = new BalloonNotification("Nenhum QrCode para salvar");
            balloonNotification.show("Nenhum QrCode para salvar");
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
                ImageIcon icon = (ImageIcon) lblQrCode.getIcon();
                BufferedImage qrCodeImage = new BufferedImage(
                        icon.getIconWidth(),
                        icon.getIconHeight(),
                        BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = qrCodeImage.createGraphics();
                icon.paintIcon(null, g2d, 0, 0);
                g2d.dispose();

                ImageIO.write(qrCodeImage, "png", fileToSave);
                BalloonNotification balloonNotification = new BalloonNotification("QrCode salvo com sucesso");
                balloonNotification.show("QrCode salvo com sucesso");
            } catch (IOException e) {
                BalloonNotification balloonNotification = new BalloonNotification("Erro ao salvar QrCode");
                balloonNotification.show("Erro ao salvar QrCode");
                log.escreverLogErroOperacaoException(e, e.getMessage());
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por carregar o JFrame de select estado">
    private void loadSelectEstado() {
        if (isSelectEstado) {
            selectEstadoInstance.toFront();
            selectEstadoInstance.repaint();
        } else {
            isSelectEstado = true;
            selectEstadoInstance = new SelectEstado(this, null);
            selectEstadoInstance.setVisible(true);
            selectEstadoInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isSelectEstado = false;
                    selectEstadoInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isSelectEstado = false;
                    selectEstadoInstance = null;
                }
            });
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por receber o estado selecionado">
    public void recebeEstadoSelected(Estado estado) {
        idEstado = estado.getId();
        siglaUfEstado = estado.getSiglaUf();
        nomeEstado = estado.getNomeUf();

        jtfEstado.setText(siglaUfEstado);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por receber o municipio selecionado">
    public void recebeMunicipioSelected(Municipio municipio) {
        idMunicipio = municipio.getId();
        ibgeMunicipio = municipio.getIbge();
        nomeMunicipio = municipio.getNome();
        ufToMunicipio = municipio.getUf();
        ibge = "";
        ibgeMom = "";
        jtfCidade.setText(nomeMunicipio);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por receber a mãe selecionada">
    public void recebeMomSelected(MaeResponse maeResponse) {
        idMom = maeResponse.getId();
        nomeMom = maeResponse.getNomeCompletoMae();
        cepMom = maeResponse.getCep();
        cpfMom = maeResponse.getCpfMae();
        logradouroMom = maeResponse.getLogradouro();
        numeroMom = maeResponse.getNumero();
        bairroMom = maeResponse.getBairro();
        complementoMom = maeResponse.getComplemento();
        localidadeMom = maeResponse.getLocalidade();
        ufMom = maeResponse.getUf();
        ibgeMom = maeResponse.getIbge();
        ibge = "";
        ibgeMunicipio = "";

        jtfMomSelected.setText(idMom + " - " + nomeMom);
        jtfCep.setText(cepMom);
        jtfLogradouro.setText(logradouroMom);
        jtfNumero.setText(numeroMom);
        jtfBairro.setText(bairroMom);
        jtfComplemento.setText(complementoMom);
        jtfEstado.setText(ufMom);
        jtfCidade.setText(localidadeMom);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por carregar o JFrame de select municipio">
    public void loadSelectMunicipio() {
        if (jtfEstado.getText().length() >= 1) {
            if (isSelectMunicipio) {
                selectMunicipioInstance.toFront();
                selectMunicipioInstance.repaint();
            } else {
                isSelectMunicipio = true;
                selectMunicipioInstance = new SelectMunicipio(this, siglaUfEstado, null);
                selectMunicipioInstance.setVisible(true);
                selectMunicipioInstance.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        isSelectMunicipio = false;
                        selectMunicipioInstance = null;
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        isSelectMunicipio = false;
                        selectMunicipioInstance = null;
                    }
                });
            }
        } else {
            BalloonNotification b = new BalloonNotification("Informe um estado primeiro");
            b.show("Informe um estado primeiro");
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por carregar o JFrame de select mae">
    public void loadSelectMom() {
        if (isSelectMom) {
            selectMomInstance.toFront();
            selectMomInstance.repaint();
        } else {
            isSelectMom = true;
            selectMomInstance = new SelectedMomOnDad(this, null);
            selectMomInstance.setVisible(true);
            selectMomInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isSelectMom = false;
                    selectMomInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isSelectMom = false;
                    selectMomInstance = null;
                }
            });
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por pegar todas as informações e enviar a api, para salvar o pai">
    public void salvarRequestDad() {
        Boolean ativo = true;
        String bairro = jtfBairro.getText();
        String cep = RemoveMaskUtil.removeMask(jtfCep.getText());
        String complemento = jtfComplemento.getText();
        String contatoReserva = jtfNomeReserva.getText();
        String cpfPai = RemoveMaskUtil.removeMask(jtfCpfPai.getText());
        String ibgeRequest;
        if (ibge != null && ibge.length() >= 1) {
            ibgeRequest = ibge;
        } else if (ibgeMunicipio != null && ibgeMunicipio.length() >= 1) {
            ibgeRequest = ibgeMunicipio;
        } else if (ibgeMom != null) {
            ibgeRequest = ibgeMom;
        } else {
            ibgeRequest = "";
        }
        String localidade = jtfCidade.getText();
        String logradouro = jtfLogradouro.getText();
        String nomeCompletoPai = jtfNomePai.getText();
        String numero = jtfNumero.getText();
        Boolean podeBuscar;
        if (jcbPodeBuscar.isSelected() == true) {
            podeBuscar = true;
        } else {
            podeBuscar = false;
        }
        String telefonePai = RemoveMaskUtil.removeMask(jtfTelefonePai.getText());
        Boolean paiWhatsapp;
        if (jcbWhatsapp.isSelected() == true) {
            paiWhatsapp = true;
        } else {
            paiWhatsapp = false;
        }
        String telefoneReserva = RemoveMaskUtil.removeMask(jtfTelefoneReserva.getText());
        Boolean reservaWhatsapp;
        if (jcbWhatsappReserva.isSelected() == true) {
            reservaWhatsapp = true;
        } else {
            reservaWhatsapp = true;
        }

        String estado = jtfEstado.getText();

        if (idMom != null) {
            mae = maeService.getMaeById(idMom);
        }

        pai.setAtivo(ativo);
        pai.setBairro(bairro);
        pai.setCep(cep);
        pai.setComplemento(complemento);
        pai.setContatoReserva(contatoReserva);
        pai.setCpfPai(cpfPai);
        pai.setIbge(ibgeRequest);
        pai.setLocalidade(localidade);
        pai.setLogradouro(logradouro);
        pai.setNomeCompletoPai(nomeCompletoPai);
        pai.setNumero(numero);
        pai.setPodeBuscar(podeBuscar);
        pai.setTelefonePai(telefonePai);
        pai.setTelefonePaiWhatsapp(paiWhatsapp);
        pai.setTelefoneReserva(telefoneReserva);
        pai.setTelefoneReservaWhatsapp(reservaWhatsapp);
        pai.setUf(estado);
        if (mae != null) {
            pai.setMae(mae);
        }
        int responseCode = paiService.postPai(pai);

        if (responseCode == 201) {
            cleanDataForNewRegister();
        }
    }
    //</editor-fold>

    //FIM MÉTODOS
    //INÍCIO MÉTODOS AUTOMÁTICOS
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
        setMinimumSize(new java.awt.Dimension(1366, 678));
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
        jcbSelectPaiMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSelectPaiMaeActionPerformed(evt);
            }
        });
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
        btBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCepActionPerformed(evt);
            }
        });
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
        btCleanMomAndAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCleanMomAndAdressActionPerformed(evt);
            }
        });
        add(btCleanMomAndAdress);
        btCleanMomAndAdress.setBounds(740, 50, 32, 32);

        jbLupaMom.setBackground(new java.awt.Color(85, 6, 124));
        jbLupaMom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIconWhite.png"))); // NOI18N
        jbLupaMom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupaMomActionPerformed(evt);
            }
        });
        add(jbLupaMom);
        jbLupaMom.setBounds(660, 80, 30, 23);
        add(lblQrCode);
        lblQrCode.setBounds(290, 230, 150, 150);

        btGeneratedQrCode.setBackground(new java.awt.Color(85, 6, 124));
        btGeneratedQrCode.setForeground(new java.awt.Color(255, 255, 255));
        btGeneratedQrCode.setText("Gerar QrCode");
        btGeneratedQrCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGeneratedQrCodeActionPerformed(evt);
            }
        });
        add(btGeneratedQrCode);
        btGeneratedQrCode.setBounds(130, 230, 150, 23);

        btCleanQrCode.setBackground(new java.awt.Color(85, 6, 124));
        btCleanQrCode.setForeground(new java.awt.Color(255, 255, 255));
        btCleanQrCode.setText("Limpar QrCode");
        btCleanQrCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCleanQrCodeActionPerformed(evt);
            }
        });
        add(btCleanQrCode);
        btCleanQrCode.setBounds(130, 260, 150, 23);

        btDownload.setBackground(new java.awt.Color(85, 6, 124));
        btDownload.setForeground(new java.awt.Color(255, 255, 255));
        btDownload.setText("Download");
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });
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
        btSelectMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectMunicipioActionPerformed(evt);
            }
        });
        add(btSelectMunicipio);
        btSelectMunicipio.setBounds(740, 290, 30, 23);

        btSelectEstado.setBackground(new java.awt.Color(85, 6, 124));
        btSelectEstado.setForeground(new java.awt.Color(255, 255, 255));
        btSelectEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lupaIconWhite.png"))); // NOI18N
        btSelectEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectEstadoActionPerformed(evt);
            }
        });
        add(btSelectEstado);
        btSelectEstado.setBounds(740, 260, 30, 23);

        btSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconSave32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        add(btSalvar);
        btSalvar.setBounds(20, 410, 100, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        // TODO add your handling code here:
        searchCep();
    }//GEN-LAST:event_btBuscarCepActionPerformed

    private void btCleanMomAndAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCleanMomAndAdressActionPerformed
        // TODO add your handling code here:
        cleanAdressAndMomSelected();
    }//GEN-LAST:event_btCleanMomAndAdressActionPerformed

    private void jcbSelectPaiMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSelectPaiMaeActionPerformed
        // TODO add your handling code here:
        showAdressMom();
    }//GEN-LAST:event_jcbSelectPaiMaeActionPerformed

    private void btGeneratedQrCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGeneratedQrCodeActionPerformed
        // TODO add your handling code here:
        generatedQrCode();
    }//GEN-LAST:event_btGeneratedQrCodeActionPerformed

    private void btCleanQrCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCleanQrCodeActionPerformed
        // TODO add your handling code here:
        cleanQrCode();
    }//GEN-LAST:event_btCleanQrCodeActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
        // TODO add your handling code here:
        downloadQrCode();
    }//GEN-LAST:event_btDownloadActionPerformed

    private void btSelectMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectMunicipioActionPerformed
        // TODO add your handling code here:
        loadSelectMunicipio();
    }//GEN-LAST:event_btSelectMunicipioActionPerformed

    private void btSelectEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectEstadoActionPerformed
        // TODO add your handling code here:
        loadSelectEstado();
    }//GEN-LAST:event_btSelectEstadoActionPerformed

    private void jbLupaMomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupaMomActionPerformed
        // TODO add your handling code here:
        loadSelectMom();
    }//GEN-LAST:event_jbLupaMomActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        salvarRequestDad();
    }//GEN-LAST:event_btSalvarActionPerformed
    //FIM MÉTODOS AUTOMÁTICOS
    //INICIO VARIÁVEIS AUTOMÁTICAS

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
    //FIM VARIÁVEIS AUTOMÁTICAS
}
