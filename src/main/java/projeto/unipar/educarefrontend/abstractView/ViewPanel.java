package projeto.unipar.educarefrontend.abstractView;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import projeto.unipar.educarefrontend.util.ReturnSize;
import projeto.unipar.educarefrontend.util.SetIcon;

public abstract class ViewPanel extends javax.swing.JPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //FIM DA ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    public ViewPanel() {
        initComponents();
        initManuallyComponents();
    }
    //FIM DO CONSTRUTOR
    //AREA DE MÉTODOS    

    private void initManuallyComponents() {

        this.setPreferredSize(new Dimension(ReturnSize.getScreenSize()));
        this.setMinimumSize(new Dimension(ReturnSize.getScreenSize()));
        this.setMaximumSize(new Dimension(ReturnSize.getScreenSize()));
        this.setSize(new Dimension(ReturnSize.getScreenSize()));

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustComponentSizes();
            }
        });

    }

    private void adjustComponentSizes() {
        jScrollPane1.setBounds(50, 110, this.getWidth() - 100, 330);
        jButton1.setBounds(this.getWidth() - 55, 60, 35, 35);
    }
    //FIM DA ÁREA DE MÉTODOS
    //CÓDIGO AUTOMÁTICO

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconAdd16x16.png"))); // NOI18N
        add(jButton1);
        jButton1.setBounds(1275, 60, 35, 35);
    }// </editor-fold>//GEN-END:initComponents
    //FIM DOS CÓDIGOS AUTOMÁTICOS
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableModel;
    // End of variables declaration//GEN-END:variables
    //FIM DA DECLARAÇÃO DE VARIÁVEIS AUTOMÁTICAS
}
