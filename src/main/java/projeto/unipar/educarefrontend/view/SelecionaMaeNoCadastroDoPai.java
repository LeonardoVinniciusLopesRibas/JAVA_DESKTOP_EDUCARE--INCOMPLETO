package projeto.unipar.educarefrontend.view;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.educarefrontend.dto.MaeResponse;
import projeto.unipar.educarefrontend.service.MaeService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.SetIcon;

public class SelecionaMaeNoCadastroDoPai extends javax.swing.JFrame {

    private final SetIcon setIcon = new SetIcon();
    private List<MaeResponse> maeResponse = new ArrayList<>();
    private final Log log = new Log();
    private final MaeService maeService = new MaeService(log);
    private DefaultTableModel model;
    private CadastrarPaiView pai = new CadastrarPaiView(this);
    private int alturaLinha = 20;
    private MaeResponse maeResponseUnit = new MaeResponse();

    public SelecionaMaeNoCadastroDoPai(CadastrarPaiView pai) {
        initComponents();
        this.pai = pai;
        setLocationRelativeTo(pai);
        inicializadorTabela();
        ajustarLarguraDasColunas();
        ajustaTamanhoLinhaTabela();
        clickComEnter();
        clickComMouse();
        setIcon.setIconJFrame(this);
        log.escreverLogInfoAvulso("INFORMATIVO", "Tela de seleção de mãe, no cadastro do pai ABERTA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfQueryBusca = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 576));
        setPreferredSize(new java.awt.Dimension(450, 576));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(75, 0, 130));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 576));

        jtfQueryBusca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfQueryBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQueryBuscaKeyPressed(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(85, 6, 124));
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selecione a Mãe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfQueryBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfQueryBusca)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 576);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfQueryBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQueryBuscaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String queryBusca = jtfQueryBusca.getText();
            if (queryBusca.trim().isBlank() || queryBusca.trim().isEmpty() || queryBusca.trim().length() < 1) {
                System.out.println("");
            }
            maeResponse = maeService.buscarMae(queryBusca);
            preencherTabela(maeResponse);
            ajustarLarguraDasColunas();
        }
    }//GEN-LAST:event_jtfQueryBuscaKeyPressed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        String queryBusca = jtfQueryBusca.getText();
        if (queryBusca.trim().isBlank() || queryBusca.trim().isEmpty() || queryBusca.trim().length() < 1) {
            System.out.println("");
        }
        maeResponse = maeService.buscarMae(queryBusca);
        preencherTabela(maeResponse);
        ajustarLarguraDasColunas();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void preencherTabela(List<MaeResponse> maes) {

        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (MaeResponse mae : maes) {
            Object[] row = {
                mae.getId(),
                mae.getNomeCompletoMae(),
                mae.getCpfMae(),
                mae.getCep()
            };
            model.addRow(row);
        }

    }

    private void inicializadorTabela() {
        maeResponse = maeService.buscarMae("");
        preencherTabela(maeResponse);
    }

    private void ajustarLarguraDasColunas() {
        for (int column = 0; column < jTable1.getColumnCount(); column++) {
            TableColumn tableColumn = jTable1.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jTable1.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jTable1.getCellRenderer(row, column);
                Component c = jTable1.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jTable1.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    private void ajustaTamanhoLinhaTabela() {
        jTable1.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(alturaLinha));
    }

    private void clickComMouse() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = jTable1.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        Long id = (Long) jTable1.getValueAt(row, 0);
                        maeResponseUnit = maeService.buscarMaeById(id);
                        pai.enviaMaeSelecionada(maeResponseUnit);
                        dispose();
                    }
                }
            }
        });
    }

    private void clickComEnter() {
        jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = jTable1.getSelectedRow();
                    if (row >= 0) {
                        Long id = (Long) jTable1.getValueAt(row, 0);
                        maeResponseUnit = maeService.buscarMaeById(id);
                        pai.enviaMaeSelecionada(maeResponseUnit);
                        dispose();
                    }
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextField jtfQueryBusca;
    // End of variables declaration//GEN-END:variables

}
