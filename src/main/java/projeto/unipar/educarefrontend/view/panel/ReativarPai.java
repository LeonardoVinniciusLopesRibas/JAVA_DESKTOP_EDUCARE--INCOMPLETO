package projeto.unipar.educarefrontend.view.panel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import projeto.unipar.educarefrontend.dto.PaiDtoResponse;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.service.PaiService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.CpfFormatter;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.MaskFormatterUtil;
import projeto.unipar.educarefrontend.util.RemoveMaskUtil;
import projeto.unipar.educarefrontend.util.TelefoneFormatter;
import projeto.unipar.educarefrontend.view.Retaguarda;

public class ReativarPai extends javax.swing.JPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private Log log = new Log();
    private Pai pai = new Pai();
    private PaiService paiService = new PaiService(log);
    private Retaguarda retaguarda;
    private List<PaiDtoResponse> paisResponse = new ArrayList<>();
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;

    //FIM ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public ReativarPai(Retaguarda pai) {
        initComponents();
        initManuallyComponents();
    }

    //FIM CONSTRUTOR
    //INÍCIO MÉTODOS
    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {
        setDataTable();
        sorter = new TableRowSorter<>(model);
        jtbPaiResponse.setRowSorter(sorter);
        clickLeftEvent();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por inicializar a tabela">
    private void setDataTable() {
        String nome = jtfNome.getText();
        String cpf = RemoveMaskUtil.removeMask(jtfCpf.getText());
        String telefone = RemoveMaskUtil.removeMask(jtfTelefone.getText());
        String logradouro = jtfEndereço.getText();

        paisResponse = paiService.getListaDePaisResponseDesativados(nome, cpf, telefone, logradouro);
        if (paisResponse == null) {
            paisResponse = new ArrayList<>();
        }
        model = (DefaultTableModel) jtbPaiResponse.getModel();
        model.setRowCount(0);
        
        for (PaiDtoResponse pai : paisResponse) {
            Object[] row = {
                pai.getId(),
                pai.getNome(),
                MaskFormatterUtil.applyCpfMask(pai.getCpf()),
                MaskFormatterUtil.applyTelefoneMask(pai.getTelefone()),
                pai.getLogradouro(),
                pai.getNomeCidade(),
                pai.getNomeEstado()
            };
            model.addRow(row);
            ajustaTamanhoLinhaTabela();
            adjustColumnTable();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por arrumar a altura da linha">
    private void ajustaTamanhoLinhaTabela() {
        jtbPaiResponse.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(20));
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por arrumar a largura da coluna">
    private void adjustColumnTable() {
        for (int column = 0; column < jtbPaiResponse.getColumnCount(); column++) {
            TableColumn tableColumn = jtbPaiResponse.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jtbPaiResponse.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jtbPaiResponse.getCellRenderer(row, column);
                Component c = jtbPaiResponse.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jtbPaiResponse.getIntercellSpacing().width;
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

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resetar o ascendente, decrescente da tabela">
    private void resetTableSorter() {
        if (sorter != null) {
            sorter.setSortKeys(null);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Evento de clique com botão direito para reativar">
    private void clickLeftEvent() {
        jtbPaiResponse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int row = jtbPaiResponse.rowAtPoint(e.getPoint());
                if (row >= 0 && row < jtbPaiResponse.getRowCount()) {
                    jtbPaiResponse.setRowSelectionInterval(row, row);
                } else {
                    jtbPaiResponse.clearSelection();
                }
                int rowIndex = jtbPaiResponse.getSelectedRow();
                if (rowIndex < 0) {
                    return;
                }
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem removeItem = new JMenuItem("Reativar Pai");
                    removeItem.addActionListener(e1 -> {
                        Object[] options = {"Sim", "Não"};
                        int option = JOptionPane.showOptionDialog(
                                null,
                                "Deseja mesmo reativar?",
                                "Confirmação",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if (option == JOptionPane.YES_OPTION) {
                            Long id = (Long) jtbPaiResponse.getValueAt(row, 0);
                            paiService.reativarPai(id);
                            resetTableSorter();
                            setDataTable();
                        }
                    });
                    popup.add(removeItem);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }

        });
    }
    //</editor-fold>

    //FIM MÉTODOS
    //INÍCIO MÉTODOS AUTOMÁTICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPaiResponse = new javax.swing.JTable();
        btBuscar = new javax.swing.JButton();
        jtfEndereço = new javax.swing.JTextField();
        jtfTelefone = new TelefoneFormatter(log).createFormatterTelefone();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfCpf = new CpfFormatter(log).createFormattedTextFieldCpf();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 160, 238));
        setMaximumSize(new java.awt.Dimension(1366, 678));
        setMinimumSize(new java.awt.Dimension(1366, 678));
        setLayout(null);

        jtbPaiResponse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cpf", "Telefone", "Logradouro", "Estado", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbPaiResponse.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbPaiResponse);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 130, 1260, 330);

        btBuscar.setBackground(new java.awt.Color(85, 6, 124));
        btBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        add(btBuscar);
        btBuscar.setBounds(650, 70, 72, 24);
        add(jtfEndereço);
        jtfEndereço.setBounds(440, 70, 190, 24);
        add(jtfTelefone);
        jtfTelefone.setBounds(440, 30, 190, 24);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Telefone");
        add(jLabel3);
        jLabel3.setBounds(350, 30, 90, 24);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Endereço");
        add(jLabel4);
        jLabel4.setBounds(350, 70, 90, 24);
        add(jtfNome);
        jtfNome.setBounds(140, 30, 190, 24);
        add(jtfCpf);
        jtfCpf.setBounds(140, 70, 190, 24);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cpf");
        add(jLabel2);
        jLabel2.setBounds(50, 70, 90, 24);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome");
        add(jLabel1);
        jLabel1.setBounds(50, 30, 90, 24);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/IconReload.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1275, 20, 35, 35);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        resetTableSorter();
        setDataTable();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetTableSorter();
        setDataTable();
    }//GEN-LAST:event_jButton1ActionPerformed
    //FIM MÉTODOS AUTOMÁTICOS
    //INICIO VARIÁVEIS AUTOMÁTICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbPaiResponse;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfEndereço;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
    //FIM VARIÁVEIS AUTOMÁTICAS
}
