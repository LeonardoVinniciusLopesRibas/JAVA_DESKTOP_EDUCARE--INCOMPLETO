package projeto.unipar.educarefrontend.view.panel;

import projeto.unipar.educarefrontend.abstractView.ViewPanel;
import projeto.unipar.educarefrontend.model.Pai;
import projeto.unipar.educarefrontend.service.PaiService;

public class VisualizarPai extends ViewPanel {

    //ÁREA DE INSTÂNCIAS E VARIÁVEIS
        private Pai pai = new Pai();
        private PaiService paiService = new PaiService();
    //FIM DA ÁREA DE INSTÂNCIAS E VARIÁVEIS
    //CONSTRUTOR
    
    public VisualizarPai() {
        initComponents();
    }
    //FIM DO CONSTRUTOR
    //AREA DE MÉTODOS
    
        private void searchAllPai(){
            //pai = paiService.
        }
    
    //FIM DA ÁREA DE MÉTODOS
    //CÓDIGO AUTOMÁTICO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    //FIM DOS CÓDIGOS AUTOMÁTICOS
    //ÁREA DE VARIÁVEIS AUTOMÁTICAS

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    //FIM DA DECLARAÇÃO DE VARIÁVEIS AUTOMÁTICAS
}
