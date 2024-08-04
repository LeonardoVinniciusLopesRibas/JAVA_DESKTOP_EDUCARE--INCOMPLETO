/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.unipar.educarefrontend.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author leonardo
 */
public class CepFormatter extends PlainDocument{
    
    private final Log log;

    public CepFormatter(Log log) {
        this.log = log;
    }

    // <editor-fold defaultstate="collapsed" desc="Classe responsável por formatar o Cep no padrão ##.###-###">
    public JFormattedTextField createFormatterCep() {
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setColumns(9);
        formattedTextField.setDocument(this);
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

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        String original = getText(0, getLength());
        StringBuilder buffer = new StringBuilder(original);
        buffer.insert(offs, str);

        String onlyDigits = buffer.toString().replaceAll("[^\\d]", "");
        String mask = "##.###-###";

        super.remove(0, getLength());
        super.insertString(0, applyMask(mask, onlyDigits), a);
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);

        String original = getText(0, getLength());
        String onlyDigits = original.replaceAll("[^\\d]", "");
        String mask = "##.###-###";

        super.remove(0, getLength());
        super.insertString(0, applyMask(mask, onlyDigits), null);
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
    //</editor-fold>
    
}
