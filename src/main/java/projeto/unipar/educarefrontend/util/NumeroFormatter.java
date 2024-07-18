package projeto.unipar.educarefrontend.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class NumeroFormatter extends DocumentFilter {
    
    private final Log log;

    public NumeroFormatter(Log log) {
        this.log = log;
    }

    public JTextField createFormatterNumero() {
        JTextField textField = new JTextField();
        ((PlainDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= 5) {
                    super.insertString(fb, offset, string.replaceAll("[^\\d]", ""), attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= 5) {
                    super.replace(fb, offset, length, text.replaceAll("[^\\d]", ""), attrs);
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                    e.consume();
                }
            }
        });

        return textField;
    }
    
}
