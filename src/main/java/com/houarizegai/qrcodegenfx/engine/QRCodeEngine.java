package com.houarizegai.qrcodegenfx.engine;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.houarizegai.qrcodegenfx.global.Utils;

import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeEngine {

    public static BitMatrix bitMatrix;

    public static void qrCodeGen(String data, int size, String outputPath) {
        // encode
        bitMatrix = generateMatrix(data, size);


    }

    public static BitMatrix generateMatrix(String data, int size) {
        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
            return bitMatrix;
        } catch(WriterException we) {
            we.printStackTrace();
            return null;
        }
    }
}
