package projeto.unipar.educarefrontend.util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowsCloseHandler {

    public static void addCloseHandler(JFrame frameSendoFechado, Log log) {

        frameSendoFechado.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
                Object[] options = {"Sim", "Não"};
                int option = JOptionPane.showOptionDialog(
                        frameSendoFechado,
                        "Você tem certeza que deseja fechar o sistema?",
                        "Confirmar saída",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );
                if (option == JOptionPane.YES_OPTION) {
                    
                    //SE ESSE MÉTODO FOR USADO EM ALGUM LUGAR QUE NÃO PODERÁ FECHAR TODA A APLICAÇÃO, NÃO VAI FUNCIONAR
                    System.exit(0);

                    log.escreverLogInfoAvulso("Aplicação fechada com sucesso");
                } else {
                    frameSendoFechado.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}
