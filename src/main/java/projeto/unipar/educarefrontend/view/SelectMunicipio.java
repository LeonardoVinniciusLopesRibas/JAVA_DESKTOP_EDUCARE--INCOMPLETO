package projeto.unipar.educarefrontend.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.educarefrontend.dto.MunicipioResponse;
import projeto.unipar.educarefrontend.model.Municipio;
import projeto.unipar.educarefrontend.service.MunicipioService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.view.panel.CadastrarPai;
import projeto.unipar.educarefrontend.view.panel.EditarPai;

public class SelectMunicipio extends javax.swing.JFrame {

    //ÁREA DE INSTÂNCIAS DE VARIÁVEIS
    private Log log = new Log();
    private MunicipioService municipioService = new MunicipioService(log);
    private Municipio municipio = new Municipio();
    private CadastrarPai pai = new CadastrarPai();
    private EditarPai editPai = new EditarPai();
    private String ufEstado;
    private List<MunicipioResponse> municipios = new ArrayList<>();
    private DefaultTableModel model;

    //FIM ÁREA DE INSTÂNCIAS DE VARIÁVEIS
    //CONSTRUTOR
    public SelectMunicipio(CadastrarPai pai, String ufEstado, EditarPai editPai) {
        this.ufEstado = ufEstado;
        initComponents();
        initManuallyComponents();
        this.pai = pai;
        this.editPai = editPai;
    }

    //FIM CONSTRUTOR
    //INICIO MÉTODOS
    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        this.setLocationRelativeTo(null);
        log.escreverLogInfoAvulso("tela de seleção de municipios aberta");
        searchTable();
        ajustaTamanhoLinhaTabela();
        adjustColumnTable();
        clickComMouse();
        clickComEnter();
        setupEscapeKey();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para buscar as informações de municipio e setar na tabela">
    private void searchTable() {
        municipios = municipioService.getMunicipio(ufEstado);
        model = (DefaultTableModel) jtbMunicipios.getModel();
        model.setRowCount(0);
        for (MunicipioResponse municipio : municipios) {
            Object[] row = {
                municipio.getId(),
                municipio.getNome(),
                municipio.getUf()
            };
            model.addRow(row);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de clique com mouse para a tabela">
    private void clickComMouse() {
        jtbMunicipios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = jtbMunicipios.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        Long id = (Long) jtbMunicipios.getValueAt(row, 0);
                        municipio = municipioService.searchMunicipioById(id);
                        if (pai != null) {
                            pai.recebeMunicipioSelected(municipio);
                        }
                        if (editPai != null) {
                            editPai.recebeMunicipioSelected(municipio);
                        }
                        ajustaTamanhoLinhaTabela();
                        adjustColumnTable();
                        dispose();
                    }
                }
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de tecla do ESC para fechar JFrame">
    private void setupEscapeKey() {
        jPanel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "closeWindow");
        jPanel1.getActionMap().put("closeWindow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método por pegar a linha selecionada">
    private void selectRow() {
        int selectedRow = jtbMunicipios.getSelectedRow();
        if (selectedRow >= 0) {
            Long id = (Long) jtbMunicipios.getValueAt(selectedRow, 0);
            municipio = municipioService.searchMunicipioById(id);
            if (pai != null) {
                pai.recebeMunicipioSelected(municipio);
            }
            if (editPai != null) {
                editPai.recebeMunicipioSelected(municipio);
            }
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
            dispose();
        } else {

        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de clique enter do teclado">
    private void clickComEnter() {
        jtbMunicipios.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = jtbMunicipios.getSelectedRow();
                    if (row >= 0) {
                        Long id = (Long) jtbMunicipios.getValueAt(row, 0);
                        municipio = municipioService.searchMunicipioById(id);
                        if (pai != null) {
                            pai.recebeMunicipioSelected(municipio);
                        }
                        if (editPai != null) {
                            editPai.recebeMunicipioSelected(municipio);
                        }
                        ajustaTamanhoLinhaTabela();
                        adjustColumnTable();
                        dispose();
                    }
                }
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar o tamanho da altura da linha">
    private void ajustaTamanhoLinhaTabela() {
        jtbMunicipios.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(20));
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar a largura da coluna da tabela">
    private void adjustColumnTable() {
        for (int column = 0; column < jtbMunicipios.getColumnCount(); column++) {
            TableColumn tableColumn = jtbMunicipios.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jtbMunicipios.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jtbMunicipios.getCellRenderer(row, column);
                Component c = jtbMunicipios.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jtbMunicipios.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    //</editor-fold>

    //FIM METODOS
    //METODOS AUTOMATICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMunicipios = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 82, 234));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dê dois cliques! Ou selecione um município!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 20, 260, 16);

        jtbMunicipios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Municipio", "Uf"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMunicipios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbMunicipios);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 370, 402);

        btCancelar.setBackground(new java.awt.Color(85, 6, 124));
        btCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar);
        btCancelar.setBounds(240, 470, 90, 23);

        btSelect.setBackground(new java.awt.Color(85, 6, 124));
        btSelect.setForeground(new java.awt.Color(255, 255, 255));
        btSelect.setText("Selecionar");
        btSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectActionPerformed(evt);
            }
        });
        jPanel1.add(btSelect);
        btSelect.setBounds(70, 470, 90, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectActionPerformed
        // TODO add your handling code here:
        selectRow();
    }//GEN-LAST:event_btSelectActionPerformed
    //FIM METODOS AUTOMATICOS

    //VARIAVEIS AUTOMATICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbMunicipios;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
