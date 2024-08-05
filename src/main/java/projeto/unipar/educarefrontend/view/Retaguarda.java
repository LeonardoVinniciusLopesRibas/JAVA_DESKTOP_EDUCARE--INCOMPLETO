package projeto.unipar.educarefrontend.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import projeto.unipar.educarefrontend.model.Usuario;
import projeto.unipar.educarefrontend.util.AdjustWindowSize;
import projeto.unipar.educarefrontend.util.BalloonNotification;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.OpenOrganizeInternalFrame;
import projeto.unipar.educarefrontend.util.ReiniciarSystem;
import projeto.unipar.educarefrontend.util.ReturnSize;
import projeto.unipar.educarefrontend.util.SetIcon;
import projeto.unipar.educarefrontend.util.WindowsCloseHandler;
import projeto.unipar.educarefrontend.view.panel.CadastrarPai;
import projeto.unipar.educarefrontend.view.panel.ReativarPai;
import projeto.unipar.educarefrontend.view.panel.VisualizarPai;

public class Retaguarda extends javax.swing.JFrame {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private static final Log log = new Log();
    private static final WindowsCloseHandler windowsCloseHandler = new WindowsCloseHandler();
    private static final SetIcon setIcon = new SetIcon();
    private static final OpenOrganizeInternalFrame openOrganizeInternalFrame = new OpenOrganizeInternalFrame();
    private AdjustWindowSize adjustWindowSize = new AdjustWindowSize();

    private boolean isChangeUser;
    private ChangeUserForm changeUserInstance;

    private JButton btSair = new JButton("Sair");
    private JButton menuPai = new JButton("Pai");
    private JPopupMenu paiPopup = new JPopupMenu();
    private JMenuItem cadastrarPai = new JMenuItem("Cadastrar pai");
    private JMenuItem visualizarPai = new JMenuItem("Visualizar pai");
    private JButton menuMae = new JButton("Mãe");
    private JPopupMenu maePopup = new JPopupMenu();
    private JMenuItem cadastrarMae = new JMenuItem("Cadastrar mãe");
    private JMenuItem visualizarMae = new JMenuItem("Visualizar mãe");

    //FIM DA ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public Retaguarda() {
        initComponents();
        initManuallyComponents();
    }

    //FIM DO CONSTRUTOR
    //AREA DE MÉTODOS
    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        this.setPreferredSize(new Dimension(ReturnSize.getScreenSize()));
        this.setMinimumSize(new Dimension(ReturnSize.getScreenSize()));
        this.setMaximumSize(new Dimension(ReturnSize.getScreenSize()));
        this.setSize(new Dimension(ReturnSize.getScreenSize()));
        abas.setPreferredSize(new Dimension(ReturnSize.getScreenSize()));
        abas.setMinimumSize(new Dimension(ReturnSize.getScreenSize()));
        abas.setMaximumSize(new Dimension(ReturnSize.getScreenSize()));
        abas.setSize(new Dimension(ReturnSize.getScreenSize()));
        int largura = (int) ReturnSize.getScreenSizeWidth();
        jToolBar.setPreferredSize(new Dimension(largura, 60));
        jToolBar.setMinimumSize(new Dimension(largura, 60));
        jToolBar.setMaximumSize(new Dimension(largura, 60));
        jToolBar.setSize(new Dimension(largura, 60));
        jPanel1.setPreferredSize(new Dimension(ReturnSize.getScreenSize()));
        jPanel1.setMinimumSize(new Dimension(ReturnSize.getScreenSize()));
        jPanel1.setMaximumSize(new Dimension(ReturnSize.getScreenSize()));
        jPanel1.setSize(new Dimension(ReturnSize.getScreenSize()));
        moveAndCheckSizeJPanel();
        organizeJPanel();
        this.setTitle("Retaguarda");
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);
        windowsCloseHandler.addCloseHandler(this, log);
        addInfToolBar();
        actionBtSair();
        actionBtVisualizarPai();
        actionBtCadastrarPai();
        BalloonNotification balloonNotification = new BalloonNotification("sistema iniciado");
        balloonNotification.show("sistema iniciado");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por assegurar a sessão do usuário">
    public void userSession(Usuario usuario) {
        Long id = usuario.getId();
        String nome = usuario.getNome();
        String email = usuario.getUsuario();
        String senha = usuario.getSenha();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por reiniciar o sistema">
    private void reiniciar() {
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
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por matar o sistema">
    private void close() {

        Object[] options = {"Sim", "Não"};

        int option = JOptionPane.showOptionDialog(
                this,
                "Tem certeza que deseja fechar o sistema?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (option == JOptionPane.YES_OPTION) {
            //System.exit(0) -> Mata completamento o processo do sistema
            System.exit(0);
            this.dispose();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por abrir a interface de troca de usuário">
    public void trocarUsuario() {

        if (isChangeUser) {
            changeUserInstance.toFront();
            changeUserInstance.repaint();
        } else {
            isChangeUser = true;
            changeUserInstance = new ChangeUserForm(this);
            changeUserInstance.setVisible(true);
            changeUserInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isChangeUser = false;
                    changeUserInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isChangeUser = false;
                    changeUserInstance = null;
                }
            });
        }

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos para adicionar os botões e os botões suspensos no ToolBar"> 
    private void addInfToolBar() {

        jToolBar.setBackground(Color.getHSBColor(204, 160, 238));

        //SAIR
        btSair.setPreferredSize(new java.awt.Dimension(100, 60));
        btSair.setFont(new Font("Arial", Font.BOLD, 16));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemSair32x32.png")));
        jToolBar.add(btSair);
        //FIM SAIR

        //PAI
        menuPai.setPreferredSize(new java.awt.Dimension(100, 60));
        menuPai.setFont(new Font("Arial", Font.BOLD, 16));
        menuPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemPai32x32.png")));

        cadastrarPai.setPreferredSize(new java.awt.Dimension(180, 60));
        cadastrarPai.setFont(new Font("Arial", Font.BOLD, 16));
        visualizarPai.setPreferredSize(new java.awt.Dimension(180, 60));
        visualizarPai.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconCadastrar32x32.png")));
        visualizarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconVisualizar32x32.png")));
        paiPopup.add(cadastrarPai);
        paiPopup.add(visualizarPai);

        menuPai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paiPopup.show(menuPai, menuPai.getWidth() / 2, menuPai.getHeight());
            }
        });

        jToolBar.add(menuPai);
        //FIM PAI

        //MAE
        menuMae.setPreferredSize(new java.awt.Dimension(100, 60));
        menuMae.setFont(new Font("Arial", Font.BOLD, 16));
        menuMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemMae32x32.png")));

        cadastrarMae.setPreferredSize(new java.awt.Dimension(180, 60));
        cadastrarMae.setFont(new Font("Arial", Font.BOLD, 16));
        visualizarMae.setPreferredSize(new java.awt.Dimension(180, 60));
        visualizarMae.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconCadastrar32x32.png")));
        visualizarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconVisualizar32x32.png")));
        maePopup.add(cadastrarMae);
        maePopup.add(visualizarMae);

        menuMae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maePopup.show(menuMae, menuMae.getWidth() / 2, menuMae.getHeight());
            }
        });

        jToolBar.add(menuMae);
        //FIM MAE
        //
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento do botão do JToolBar para sair"> 
    private void actionBtSair() {
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
    }

    private void btSairActionPerformed(ActionEvent evt) {
        close();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Evento do botão do JToolBar para VisualizarPai"> 
    private void actionBtVisualizarPai() {
        visualizarPai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                visualizarPaiPerformed(evt);
            }
        });
    }

    private void visualizarPaiPerformed(ActionEvent evt) {
        addSawPai();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento do botão do JToolBar para CadastrarPai">     
    private void actionBtCadastrarPai() {
        cadastrarPai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cadastrarPaiPerformed(evt);
            }
        });
    }

    private void cadastrarPaiPerformed(ActionEvent evt) {
        addAddPai();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para abrir a aba de visualizar pai"> 
    public void addSawPai() {
        boolean abaExistente = false;
        String title = "Visualizar pai";
        for (int i = 0; i < abas.getTabCount(); i++) {
            if (abas.getTitleAt(i).equals(title)) {
                abaExistente = true;
                abas.setSelectedIndex(i);
                break;
            }
        }
        if (!abaExistente) {
            VisualizarPai tabSawPai = new VisualizarPai(this);
            abas.addTab(title, tabSawPai);
            int index = abas.indexOfComponent(tabSawPai);
            abas.setTabComponentAt(index, createTabTitle(title, tabSawPai));
            abas.setSelectedComponent(tabSawPai);

        }
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método para abrir a aba de reativar pai">
    public void addReativePai(){
        boolean abaExistente = false;
        String title = "Reativar pai";
        for(int i = 0; i < abas.getTabCount(); i++){
            if(abas.getTitleAt(i).equals(title)){
                abaExistente = true;
                abas.setSelectedIndex(i);
                break;
            }
        }
        if(!abaExistente){
            ReativarPai tabReativePai = new ReativarPai(this);
            abas.addTab(title, tabReativePai);
            int index = abas.indexOfComponent(tabReativePai);
            abas.setTabComponentAt(index, createTabTitle(title, tabReativePai));
            abas.setSelectedComponent(tabReativePai);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para abrir a aba de cadastrar pai"> 
    public void addAddPai() {
        boolean abaExistente = false;
        String title = "Cadastrar pai";
        for (int i = 0; i < abas.getTabCount(); i++) {
            if (abas.getTitleAt(i).equals(title)) {
                abaExistente = true;
                abas.setSelectedIndex(i);
                break;
            }
        }
        if (!abaExistente) {
            CadastrarPai tabAddPai = new CadastrarPai();
            abas.addTab(title, tabAddPai);
            int index = abas.indexOfComponent(tabAddPai);
            abas.setTabComponentAt(index, createTabTitle(title, tabAddPai));
            abas.setSelectedComponent(tabAddPai);
        }
    }
    //</editor-fold>

    //MÉTODO ABAIXO SEMPRE PRECISA SER O ÚLTIMO, OS ACIMA APENAS INFORMAÇÃO DA ABA, E ABAIXO CRIAÇÃO DELA
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por criar o título da aba, e o botão de x para fechar">
    private JPanel createTabTitle(String title, final JPanel panel) {
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel(title);
        JButton closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abas.remove(panel);
            }
        });
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(closeButton, BorderLayout.EAST);
        return titlePanel;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Evento para organizar o JPanel">
    private void moveAndCheckSizeJPanel() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                organizeJPanel();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                organizeJPanel();
            }
        });

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método que organiza a localização do JPanel">
    private void organizeJPanel() {
        Dimension dimension = adjustWindowSize.adjustWindowSize(this);

        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        int panelWidth = screenWidth;
        int panelHeight = screenHeight;

        int panelX = 0;
        int panelY = 0;

        int toolBarWidth = panelWidth;
        int toolBarHeight = 61;
        int toolBarX = 0;
        int toolBary = 0;

        int tabbedPaneWidth = panelWidth;
        int tabbedPaneHeight = panelHeight;
        int tabbedPaneX = 0;
        int tabbedPaney = 62;

        jPanel1.setPreferredSize(new Dimension(panelWidth, panelHeight));
        jPanel1.setSize(new Dimension(panelWidth, panelHeight));
        jPanel1.setLocation(panelX, panelY);
        jPanel1.setBounds(panelX, panelY, panelWidth, panelHeight);

        abas.setPreferredSize(new Dimension(tabbedPaneWidth, tabbedPaneHeight));
        abas.setSize(new Dimension(tabbedPaneWidth, tabbedPaneHeight));
        abas.setLocation(tabbedPaneX, tabbedPaney);
        abas.setBounds(tabbedPaneX, tabbedPaney, tabbedPaneWidth, tabbedPaneHeight);

        jToolBar.setPreferredSize(new Dimension(toolBarWidth, toolBarHeight));
        jToolBar.setSize(new Dimension(toolBarWidth, toolBarHeight));
        jToolBar.setLocation(toolBarX, toolBary);
        jToolBar.setBounds(toolBarX, toolBary, toolBarWidth, toolBarHeight);

        jPanel1.revalidate();
        jPanel1.repaint();
        this.setLayout(new BorderLayout());
        jPanel1.setLayout(new BorderLayout());

        jPanel1.add(jToolBar, BorderLayout.NORTH);
        jPanel1.add(abas, BorderLayout.CENTER);

        abas.revalidate();
        abas.repaint();
        abas.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        UIManager.put("TabbedPane.contentOpaque", false);
        UIManager.put("TabbedPane.tabsOverlapBorder", true);

        jToolBar.revalidate();
        jToolBar.repaint();
    }
    //</editor-fold>
    
    //FIM DA ÁREA DE MÉTODOS
    //CÓDIGO AUTOMÁTICO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar = new javax.swing.JToolBar();
        abas = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemTrocarUsuario = new javax.swing.JMenuItem();
        jMenuItemReiniciar = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuFerramentas = new javax.swing.JMenu();
        jMenuCadastrarEditar = new javax.swing.JMenu();
        jMenuItemCadastrarEditarCrianca = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarMae = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarPai = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarResponsavel = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarEditarProduto = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarEditarNaturezaContas = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarGrupoContas = new javax.swing.JMenuItem();
        jMenuItemCadastrarEditarContaBancaria = new javax.swing.JMenuItem();
        jMenuReativar = new javax.swing.JMenu();
        jMenuItemReativarCrianca = new javax.swing.JMenuItem();
        jMenuItemReativarMae = new javax.swing.JMenuItem();
        jMenuItemReativarPai = new javax.swing.JMenuItem();
        jMenuItemReativarResponsavel = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemReativarProduto = new javax.swing.JMenuItem();
        jMenuItemReativarUsuario = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemReativarNaturezaContas = new javax.swing.JMenuItem();
        jMenuItemReativarGrupoContas = new javax.swing.JMenuItem();
        jMenuItemReativarContaBancaria = new javax.swing.JMenuItem();
        jMenuFinanceiro = new javax.swing.JMenu();
        jMenuItemNovaPendenciaPagar = new javax.swing.JMenuItem();
        jMenuItemNovaPendenciaReceber = new javax.swing.JMenuItem();
        jMenuItemConsultarDebitos = new javax.swing.JMenuItem();
        jMenuItemConsultarPendencias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 160, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jToolBar.setRollover(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(abas, javax.swing.GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 684, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 63, Short.MAX_VALUE)
                    .addComponent(abas, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMenuArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuArquivo16x16.png"))); // NOI18N
        jMenuArquivo.setText("Arquivo");

        jMenuItemTrocarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemTrocarUsuario16x16.png"))); // NOI18N
        jMenuItemTrocarUsuario.setText("Trocar Usuário");
        jMenuItemTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTrocarUsuarioActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemTrocarUsuario);

        jMenuItemReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemReiniciar16x16.png"))); // NOI18N
        jMenuItemReiniciar.setText("Reiniciar");
        jMenuItemReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReiniciarActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemReiniciar);

        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemSair16x16.png"))); // NOI18N
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar1.add(jMenuArquivo);

        jMenuFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuFerramentas16x16.png"))); // NOI18N
        jMenuFerramentas.setText("Ferramentas");

        jMenuCadastrarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuCadastrarEditar16x16.png"))); // NOI18N
        jMenuCadastrarEditar.setText("Cadastrar/Editar");

        jMenuItemCadastrarEditarCrianca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemCrianca16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarCrianca.setText("Criança");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarCrianca);

        jMenuItemCadastrarEditarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemMae16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarMae.setText("Mãe");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarMae);

        jMenuItemCadastrarEditarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemPai16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarPai.setText("Pai");
        jMenuItemCadastrarEditarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarEditarPaiActionPerformed(evt);
            }
        });
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarPai);

        jMenuItemCadastrarEditarResponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemResponsavel16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarResponsavel.setText("Responsável");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarResponsavel);
        jMenuCadastrarEditar.add(jSeparator2);

        jMenuItemCadastrarEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemProduto16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarProduto.setText("Produto");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarProduto);

        jMenuItemCadastrarEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemUsuario16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarUsuario.setText("Usuário");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarUsuario);
        jMenuCadastrarEditar.add(jSeparator1);

        jMenuItemCadastrarEditarNaturezaContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemNaturezaContas16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarNaturezaContas.setText("Natureza de Contas");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarNaturezaContas);

        jMenuItemCadastrarEditarGrupoContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemGrupoContas16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarGrupoContas.setText("Grupo de Contas");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarGrupoContas);

        jMenuItemCadastrarEditarContaBancaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemContaBancaria16x16.png"))); // NOI18N
        jMenuItemCadastrarEditarContaBancaria.setText("Conta Bancária");
        jMenuCadastrarEditar.add(jMenuItemCadastrarEditarContaBancaria);

        jMenuFerramentas.add(jMenuCadastrarEditar);

        jMenuReativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuReativar16x16.png"))); // NOI18N
        jMenuReativar.setText("Reativar");

        jMenuItemReativarCrianca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemCrianca16x16.png"))); // NOI18N
        jMenuItemReativarCrianca.setText("Criança");
        jMenuReativar.add(jMenuItemReativarCrianca);

        jMenuItemReativarMae.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemMae16x16.png"))); // NOI18N
        jMenuItemReativarMae.setText("Mãe");
        jMenuReativar.add(jMenuItemReativarMae);

        jMenuItemReativarPai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemPai16x16.png"))); // NOI18N
        jMenuItemReativarPai.setText("Pai");
        jMenuItemReativarPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReativarPaiActionPerformed(evt);
            }
        });
        jMenuReativar.add(jMenuItemReativarPai);

        jMenuItemReativarResponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemResponsavel16x16.png"))); // NOI18N
        jMenuItemReativarResponsavel.setText("Responsável");
        jMenuReativar.add(jMenuItemReativarResponsavel);
        jMenuReativar.add(jSeparator4);

        jMenuItemReativarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemProduto16x16.png"))); // NOI18N
        jMenuItemReativarProduto.setText("Produto");
        jMenuReativar.add(jMenuItemReativarProduto);

        jMenuItemReativarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemUsuario16x16.png"))); // NOI18N
        jMenuItemReativarUsuario.setText("Usuário");
        jMenuReativar.add(jMenuItemReativarUsuario);
        jMenuReativar.add(jSeparator3);

        jMenuItemReativarNaturezaContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemNaturezaContas16x16.png"))); // NOI18N
        jMenuItemReativarNaturezaContas.setText("Natureza de Contas");
        jMenuReativar.add(jMenuItemReativarNaturezaContas);

        jMenuItemReativarGrupoContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemGrupoContas16x16.png"))); // NOI18N
        jMenuItemReativarGrupoContas.setText("Grupo de Contas");
        jMenuReativar.add(jMenuItemReativarGrupoContas);

        jMenuItemReativarContaBancaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemContaBancaria16x16.png"))); // NOI18N
        jMenuItemReativarContaBancaria.setText("Conta Bancária");
        jMenuReativar.add(jMenuItemReativarContaBancaria);

        jMenuFerramentas.add(jMenuReativar);

        jMenuBar1.add(jMenuFerramentas);

        jMenuFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuFinanceiro16x16.png"))); // NOI18N
        jMenuFinanceiro.setText("Financeiro");

        jMenuItemNovaPendenciaPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemContaPagar16x16.png"))); // NOI18N
        jMenuItemNovaPendenciaPagar.setText("Nova Pendência a Pagar");
        jMenuFinanceiro.add(jMenuItemNovaPendenciaPagar);

        jMenuItemNovaPendenciaReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemContaReceber16x16.png"))); // NOI18N
        jMenuItemNovaPendenciaReceber.setText("Nova Pendência a Receber");
        jMenuFinanceiro.add(jMenuItemNovaPendenciaReceber);

        jMenuItemConsultarDebitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemConsultarDebitos16x16.png"))); // NOI18N
        jMenuItemConsultarDebitos.setText("Consultar Débitos");
        jMenuFinanceiro.add(jMenuItemConsultarDebitos);

        jMenuItemConsultarPendencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/JMenuItemConsultarPendencias16x16.png"))); // NOI18N
        jMenuItemConsultarPendencias.setText("Consultar Pendências");
        jMenuFinanceiro.add(jMenuItemConsultarPendencias);

        jMenuBar1.add(jMenuFinanceiro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTrocarUsuarioActionPerformed
        // TODO add your handling code here:
        trocarUsuario();
    }//GEN-LAST:event_jMenuItemTrocarUsuarioActionPerformed

    private void jMenuItemReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReiniciarActionPerformed
        // TODO add your handling code here:
        reiniciar();
    }//GEN-LAST:event_jMenuItemReiniciarActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemCadastrarEditarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarEditarPaiActionPerformed
        // TODO add your handling code here:
        addSawPai();
    }//GEN-LAST:event_jMenuItemCadastrarEditarPaiActionPerformed

    private void jMenuItemReativarPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReativarPaiActionPerformed
        // TODO add your handling code here:
        addReativePai();
    }//GEN-LAST:event_jMenuItemReativarPaiActionPerformed
    //FIM DOS CÓDIGOS AUTOMÁTICOS
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastrarEditar;
    private javax.swing.JMenu jMenuFerramentas;
    private javax.swing.JMenu jMenuFinanceiro;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarContaBancaria;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarCrianca;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarGrupoContas;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarMae;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarNaturezaContas;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarPai;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarProduto;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarResponsavel;
    private javax.swing.JMenuItem jMenuItemCadastrarEditarUsuario;
    private javax.swing.JMenuItem jMenuItemConsultarDebitos;
    private javax.swing.JMenuItem jMenuItemConsultarPendencias;
    private javax.swing.JMenuItem jMenuItemNovaPendenciaPagar;
    private javax.swing.JMenuItem jMenuItemNovaPendenciaReceber;
    private javax.swing.JMenuItem jMenuItemReativarContaBancaria;
    private javax.swing.JMenuItem jMenuItemReativarCrianca;
    private javax.swing.JMenuItem jMenuItemReativarGrupoContas;
    private javax.swing.JMenuItem jMenuItemReativarMae;
    private javax.swing.JMenuItem jMenuItemReativarNaturezaContas;
    private javax.swing.JMenuItem jMenuItemReativarPai;
    private javax.swing.JMenuItem jMenuItemReativarProduto;
    private javax.swing.JMenuItem jMenuItemReativarResponsavel;
    private javax.swing.JMenuItem jMenuItemReativarUsuario;
    private javax.swing.JMenuItem jMenuItemReiniciar;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemTrocarUsuario;
    private javax.swing.JMenu jMenuReativar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
    //FIM DA DECLARAÇÃO DE VARIÁVEIS AUTOMÁTICAS
}
