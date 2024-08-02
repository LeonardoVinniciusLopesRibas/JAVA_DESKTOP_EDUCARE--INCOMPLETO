package projeto.unipar.educarefrontend.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

public class QRCodeGenerator {

    public static BufferedImage generateQRCodeImage(String barcodeText, Log log) {
        try {
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 150, 150);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
            
        } catch (WriterException e) {
            log.escreverLogInfoAvulso("NÃO FOI POSSÍVEL GERAR O QRCODE");
            log.escreverLogErroOperacaoException(e, e.getMessage());
        }
        log.escreverLogInfoAvulso("NÃO FOI POSSÍVEL GERAR O QRCODE");
        return null;
    }

}
