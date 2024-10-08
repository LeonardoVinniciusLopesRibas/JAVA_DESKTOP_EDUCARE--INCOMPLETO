package projeto.unipar.educarefrontend.util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AjustaTamanhoLinhaTabela  extends DefaultTableCellRenderer{
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por ajustar o tamanho da linha da tabela">
    private int alturaLinha;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setRowHeight(row, alturaLinha); 
        return c;
    }
    //</editor-fold>
    
}
