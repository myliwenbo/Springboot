package com.example.demo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator
{

    /**
     *
     * @throws WriterException
     * @throws IOException
     */
    private static void generateQRCodeImage() throws WriterException, IOException
    {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        File         file         = new File("");
        //获取当前项目路径
        String filePath = file.getCanonicalPath();
        // 生成二维码对象，传入参数：内容、码的类型、宽高、配置
        BitMatrix bitMatrix = qrCodeWriter.encode("410426199204106011", BarcodeFormat.QR_CODE, 350, 350);
        Path      path      = FileSystems.getDefault().getPath(filePath + "\\MyQRCode.png");
        //生成二维码
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args)
    {
        try {
            generateQRCodeImage();
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }

}