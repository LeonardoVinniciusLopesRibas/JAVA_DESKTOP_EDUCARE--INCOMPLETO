package projeto.unipar.educarefrontend.view.panel;

import javax.swing.JPanel;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.service.PaiService;
import projeto.unipar.educarefrontend.util.Log;
import projeto.unipar.educarefrontend.view.Retaguarda;

public class VisualizarPai extends JPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    private Log log = new Log();
    private Pai pai = new Pai();
    private PaiService paiService = new PaiService(log);
    private Retaguarda retaguarda;
    //FIM DA ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR

    public VisualizarPai(Retaguarda pai) {
        initComponents();
        this.retaguarda = pai;
        initManuallyComponents();
    }

    //FIM DO CONSTRUTOR
    //AREA DE MÉTODOS
    // <editor-fold defaultstate="collapsed" desc="Assistente do construtor manual">
    private void initManuallyComponents() {

    }
    //</editor-fold>

    //FIM DA ÁREA DE MÉTODOS
    //CÓDIGO AUTOMÁTICO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModel = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 160, 238));
        setLayout(null);

        jTableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableModel.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableModel);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 1260, 330);

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconAdd16x16.png"))); // NOI18N
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        add(btCadastrar);
        btCadastrar.setBounds(1275, 60, 35, 35);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO add your handling code here:
        retaguarda.addAddPai();
    }//GEN-LAST:event_btCadastrarActionPerformed
    //FIM DOS CÓDIGOS AUTOMÁTICOS
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btCadastrar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableModel;
    // End of variables declaration//GEN-END:variables
    //FIM DA DECLARAÇÃO DE VARIÁVEIS AUTOMÁTICAS
}
