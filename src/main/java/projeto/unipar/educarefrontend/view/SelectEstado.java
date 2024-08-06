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
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.educarefrontend.dto.EstadoResponse;
import projeto.unipar.educarefrontend.model.Estado;
import projeto.unipar.educarefrontend.service.EstadoService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.view.panel.CadastrarPai;
import projeto.unipar.educarefrontend.view.panel.EditarPai;
    
public class SelectEstado extends javax.swing.JFrame {

    //ÁREA DE INSTÂNCIAS DE VARIÁVEIS
    private Log log = new Log();
    private EstadoService estadoService = new EstadoService(log);
    private EstadoResponse estadoResponse = new EstadoResponse();
    private Estado estado = new Estado();
    private List<EstadoResponse> estados = new ArrayList<>();
    private DefaultTableModel model;
    private CadastrarPai pai = new CadastrarPai();
    private EditarPai editPai = new EditarPai();
    //FIM ÁREA DE INSTÂNCIAS DE VARIÁVEIS

    //CONSTRUTOR
    public SelectEstado(CadastrarPai pai, EditarPai editPai) {
        this.pai = pai;
        this.editPai = editPai;
        initComponents();
        initManuallyComponents();
    }
    //FIM CONSTRUTOR
    //INICIO MÉTODOS

    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        this.setLocationRelativeTo(null);
        log.escreverLogInfoAvulso("tela de seleção de estados aberta");
        searchTable();
        ajustaTamanhoLinhaTabela();
        adjustColumnTable();
        clickComMouse();
        clickComEnter();
        setupEscapeKey();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método para buscar as informações de estado e setar na tabela">
    private void searchTable() {
        estados = estadoService.getEstados();
        model = (DefaultTableModel) jtbEstados.getModel();
        model.setRowCount(0);
        for (EstadoResponse estado : estados) {
            Object[] row = {
                estado.getId(),
                estado.getSiglaUf()
            };
            model.addRow(row);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de clique com mouse para a tabela">
    private void clickComMouse() {
        jtbEstados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = jtbEstados.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        Long id = (Long) jtbEstados.getValueAt(row, 0);
                        estado = estadoService.searchEstadoId(id);
                        pai.recebeEstadoSelected(estado);
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
        int selectedRow = jtbEstados.getSelectedRow();
        if (selectedRow >= 0) {
            Long id = (Long) jtbEstados.getValueAt(selectedRow, 0);
            estado = estadoService.searchEstadoId(id);
            pai.recebeEstadoSelected(estado);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
            dispose();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de clique enter do teclado">
    private void clickComEnter() {
        jtbEstados.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = jtbEstados.getSelectedRow();
                    if (row >= 0) {
                        Long id = (Long) jtbEstados.getValueAt(row, 0);
                        estado = estadoService.searchEstadoId(id);
                        pai.recebeEstadoSelected(estado);
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
        jtbEstados.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(25));
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar a largura da coluna da tabela">
    private void adjustColumnTable() {
        for (int column = 0; column < jtbEstados.getColumnCount(); column++) {
            TableColumn tableColumn = jtbEstados.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jtbEstados.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jtbEstados.getCellRenderer(row, column);
                Component c = jtbEstados.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jtbEstados.getIntercellSpacing().width;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEstados = new javax.swing.JTable();
        btSelect = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 82, 234));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(null);

        jtbEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Sigla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEstados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbEstados);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 50, 257, 402);

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dê dois cliques! Ou selecione um estado!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 20, 260, 16);

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
    private javax.swing.JTable jtbEstados;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
