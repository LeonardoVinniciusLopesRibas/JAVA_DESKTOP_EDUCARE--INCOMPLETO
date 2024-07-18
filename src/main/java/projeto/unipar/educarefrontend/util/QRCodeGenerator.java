package projeto.unipar.educarefrontend.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class QRCodeGenerator {

    public static BufferedImage generateQRCodeImage(String barcodeText, Log log) {
        try {
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
            System.out.println(bitMatrix);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
            
        } catch (WriterException e) {
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        log.escreverLogInfoAvulso("ERRO", "NÃO FOI POSSÍVEL GERAR O QRCODE");
        return null;
    }

}
