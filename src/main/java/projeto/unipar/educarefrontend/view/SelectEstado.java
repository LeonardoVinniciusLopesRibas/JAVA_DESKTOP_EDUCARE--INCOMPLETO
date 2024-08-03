package projeto.unipar.educarefrontend.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import projeto.unipar.educarefrontend.dto.EstadoResponse;
import projeto.unipar.educarefrontend.model.Estado;
import projeto.unipar.educarefrontend.service.EstadoService;
import projeto.unipar.educarefrontend.util.AjustaTamanhoLinhaTabela;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.util.OpenOrganizeInternalFrame;
import projeto.unipar.educarefrontend.view.panel.CadastrarPai;

public class SelectEstado extends javax.swing.JInternalFrame {

    //INSTANCIANDOS VARIAVEIS
    private Log log = new Log();
    private OpenOrganizeInternalFrame organizeInternalFrame = new OpenOrganizeInternalFrame();
    private List<EstadoResponse> estados = new ArrayList<>();
    private DefaultTableModel model;
    private int alturaLinha = 20;
    private EstadoService estadoService = new EstadoService(log);
    private Estado estado = new Estado();
    private JFrame pai;

    //FIM INSTANCIANDO VARIAVEIS
    //CONSTRUTOR
    public SelectEstado(JFrame pai) {
        initComponents();
        initManuallyComponents(pai);
        this.pai = pai;
    }
    //FIM CONSTRUTOR

    //MÉTODOS
    private void initManuallyComponents(JFrame pai) {
        organizeInternalFrame.openOrganizeInternalFrame(this, pai);
        setTitle("Selecione o Estado");
        setTableEstados();
        organizeHeight();
    }
    
    private void setTableEstados() {
        estados = searchEstados();
        model = (DefaultTableModel) jtbEstados.getModel();
        model.setRowCount(0);
        for (EstadoResponse estado : estados) {
            Object[] row = {
                estado.getId(),
                estado.getSiglaUf()
            };
            model.addRow(row);
        }
    }
    
    private List<EstadoResponse> searchEstados() {
        return estados = estadoService.getEstados();
    }
    
    private void organizeHeight(){
        jtbEstados.setDefaultRenderer(Object.class, new AjustaTamanhoLinhaTabela(alturaLinha));
    }
    
    private void clickComMouse() {
        jtbEstados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = jtbEstados.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        Long id = (Long) jtbEstados.getValueAt(row, 0);
                        //estado = estadoService.searchEstadoId(id);
                        //pai.redirectedEstado(estado);
                        dispose();
                    }
                }
            }
        });
    }

    private void clickComEnter() {
        jtbEstados.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    int row = jtbEstados.getSelectedRow();
                    if (row >= 0) {
                        Long id = (Long) jtbEstados.getValueAt(row, 0);
                        //estado = estadoService.searchEstadoId(id);
                        //pai.redirectedEstado(estado);
                        dispose();
                    }
                }
            }
        });
    }
    

    //FIM MÉTODOS
    //MÉTODOS AUTOMÁTICOS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEstados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btSelecionar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(85, 6, 124));
        setMaximumSize(new java.awt.Dimension(395, 700));
        setMinimumSize(new java.awt.Dimension(395, 700));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(395, 700));
        getContentPane().setLayout(null);

        jtbEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbEstados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbEstados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 50, 300, 402);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dê dois cliques! Ou clique em Selecionar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 300, 16);

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });
        getContentPane().add(btSelecionar);
        btSelecionar.setBounds(40, 590, 90, 23);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar);
        btCancelar.setBounds(250, 590, 84, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    //FIM METODOS AUTOMATICOS
    //VARIAVEIS AUTOMATICAS
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbEstados;
    // End of variables declaration//GEN-END:variables
    //FIM VARIAVEIS AUTOMATICAS
}
