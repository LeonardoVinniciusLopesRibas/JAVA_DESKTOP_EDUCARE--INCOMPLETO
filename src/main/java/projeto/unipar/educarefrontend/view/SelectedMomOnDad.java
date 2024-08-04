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
import projeto.unipar.educarefrontend.dto.MaeResponse;
import projeto.unipar.educarefrontend.service.MaeService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.view.panel.CadastrarPai;

public class SelectedMomOnDad extends javax.swing.JFrame {

    //VARIAVEIS E INSTANCIAS
    private Log log = new Log();
    private List<MaeResponse> maes = new ArrayList<>();
    private MaeService maeService = new MaeService(log);
    private DefaultTableModel model;
    private MaeResponse maeResponse = new MaeResponse();
    private CadastrarPai pai = new CadastrarPai();
    //FIM VARIAVEIS E INSTANCIAS
    //CONSTRUTOR
    public SelectedMomOnDad(CadastrarPai pai) {
        initComponents();
        initManuallyComponents();
        this.pai = pai;
    }
    //FIM CONSTRUTOR
    //INICIO METODOS
    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        this.setLocationRelativeTo(null);
        searchMom();
        setupEscapeKey();
        clickComEnter();
        clickComMouse();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método por buscar as mães pela query">
    private void searchMom(){
        String queryBusca = jtfQuery.getText();
        if (queryBusca.trim().isBlank() || queryBusca.trim().isEmpty() || queryBusca.trim().length() < 1) {
            System.out.println("");
        }
        maes = maeService.buscarMae(queryBusca);
        searchTable(maes);
        
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método por setar a lista de mães na tabela">
    private void searchTable(List<MaeResponse> maes) {

        model = (DefaultTableModel) jtbMae.getModel();
        model.setRowCount(0);
        for (MaeResponse mae : maes) {
            Object[] row = {
                mae.getId(),
                mae.getNomeCompletoMae(),
                mae.getCpfMae(),
                mae.getCep()
            };
            model.addRow(row);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
        }

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
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar o tamanho da altura da linha">    
    private void ajustaTamanhoLinhaTabela() {
        jtbMae.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(25));
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar a largura da coluna da tabela">
    private void adjustColumnTable() {
        for (int column = 0; column < jtbMae.getColumnCount(); column++) {
            TableColumn tableColumn = jtbMae.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jtbMae.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jtbMae.getCellRenderer(row, column);
                Component c = jtbMae.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jtbMae.getIntercellSpacing().width;
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
    
    // <editor-fold defaultstate="collapsed" desc="Evento de clique com mouse para a tabela">
    private void clickComMouse() {
        jtbMae.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = jtbMae.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        Long id = (Long) jtbMae.getValueAt(row, 0);
                        maeResponse = maeService.buscarMaeById(id);
                        pai.recebeMomSelected(maeResponse);
                        dispose();
                    }
                }
            }
        });
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Evento de clique enter do teclado">
    private void clickComEnter() {
        jtbMae.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = jtbMae.getSelectedRow();
                    if (row >= 0) {
                        Long id = (Long) jtbMae.getValueAt(row, 0);
                        maeResponse = maeService.buscarMaeById(id);
                        pai.recebeMomSelected(maeResponse);
                        dispose();
                    }
                }
            }
        });
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método por pegar a linha selecionada">
    private void selectRow() {
        int selectedRow = jtbMae.getSelectedRow();
        if (selectedRow >= 0) {
            Long id = (Long) jtbMae.getValueAt(selectedRow, 0);
            maeResponse = maeService.buscarMaeById(id);
            pai.recebeMomSelected(maeResponse);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
            dispose();
        } else {

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
        jtfQuery = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMae = new javax.swing.JTable();
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
        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dê dois cliques! Ou selecione a mãe!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 20, 260, 16);

        jtfQuery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQueryKeyPressed(evt);
            }
        });
        jPanel1.add(jtfQuery);
        jtfQuery.setBounds(27, 40, 259, 22);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar);
        btBuscar.setBounds(292, 40, 72, 23);

        jtbMae.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Cpf", "Cep"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbMae.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbMae);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 375, 380);

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

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        searchMom();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jtfQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQueryKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            searchMom();
        }
    }//GEN-LAST:event_jtfQueryKeyPressed

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
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbMae;
    private javax.swing.JTextField jtfQuery;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
