package projeto.unipar.educarefrontend.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class BalloonNotification {

    private Timer timer;
    private final JWindow window;
    private final JLabel label;
    private final JButton closeButton;
    private static BalloonNotification currentNotification = null;
    private String currentMessage = "";

    // <editor-fold defaultstate="collapsed" desc="Construtor de BalloonNotification">
    public BalloonNotification(String message) {
        window = new JWindow();
        window.setLayout(new BorderLayout());

        label = new JLabel(message.toUpperCase(), SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        closeButton = new JButton("X");
        closeButton.setPreferredSize(new Dimension(30, 30));
        closeButton.setFocusable(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                resetNotification();
            }
        });

        window.add(label, BorderLayout.CENTER);
        window.add(closeButton, BorderLayout.NORTH);

        window.pack();
        window.setSize(new Dimension(300, 100));
        ReturnSize returnSize = new ReturnSize();
        Dimension dimension = returnSize.getScreenSize();
        int x = dimension.width - 350;
        int y = dimension.height - 150;

        window.setLocation(x, y);

        setupTimer();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Método responsável por mostrar o balloon no JFrame">
    public void show(String newMessage) {
        if (currentNotification != null && currentNotification.window.isVisible()) {
            if (newMessage.equals(currentNotification.currentMessage)) {
                return;
            }
            currentNotification.window.setVisible(false);
        }

        if (currentNotification == null || !newMessage.equals(currentNotification.currentMessage)) {
            currentNotification = new BalloonNotification(newMessage);
        }

        currentNotification.currentMessage = newMessage;
        currentNotification.window.setVisible(true);
        currentNotification.timer.setRepeats(false);
        currentNotification.timer.start();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por resetar a notificação atual">
    private void resetNotification() {
        currentNotification = null;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método responsável por setar um tempo padrão na notificação">
    private void setupTimer() {
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                resetNotification();
            }
        });
    }
    //</editor-fold>
}
