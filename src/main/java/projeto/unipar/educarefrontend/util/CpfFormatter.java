/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.unipar.educarefrontend.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author leona
 */
public class CpfFormatter extends DocumentFilter {

    private Log log;

    public CpfFormatter(Log log) {
        this.log = log;
    }

    public JTextField createFormattedTextFieldCpf() {

        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setColumns(14);
        formattedTextField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) {
                try {
                    if (str == null) {
                        return;
                    }

                    String original = getText(0, getLength());
                    StringBuilder buffer = new StringBuilder(original);
                    buffer.insert(offs, str);

                    String onlyDigits = buffer.toString().replaceAll("[^\\d]", "");
                    String mask = "###.###.###-##";

                    super.remove(0, getLength());
                    super.insertString(0, applyMask(mask, onlyDigits), a);
                } catch (BadLocationException e) {
                    log.escreverLogErroOperacaoException(e, e.getMessage());
                }
            }

            @Override
            public void remove(int offs, int len) {
                try {
                    super.remove(offs, len);

                    String original = getText(0, getLength());
                    String onlyDigits = original.replaceAll("[^\\d]", "");
                    String mask = "###.###.###-##";

                    super.remove(0, getLength());
                    super.insertString(0, applyMask(mask, onlyDigits), null);
                } catch (BadLocationException e) {
                    log.escreverLogErroOperacaoException(e, e.getMessage());
                }
            }

            private String applyMask(String mask, String digits) {
                StringBuilder result = new StringBuilder();
                int maskCharIndex = 0;
                int digitsCharIndex = 0;

                while (maskCharIndex < mask.length() && digitsCharIndex < digits.length()) {
                    char maskChar = mask.charAt(maskCharIndex);
                    char digitsChar = digits.charAt(digitsCharIndex);

                    if (maskChar == '#') {
                        result.append(digitsChar);
                        digitsCharIndex++;
                    } else {
                        result.append(maskChar);
                    }

                    maskCharIndex++;
                }

                return result.toString();
            }
        });

        formattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                    e.consume();
                }
            }
        });

        return formattedTextField;

    }

}
