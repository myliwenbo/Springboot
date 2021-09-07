package vip.xjdai.common.utils;

import java.io.IOException;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.io.File;

public class MD5 {
    private static final String[] hexDigits;

    public static String getMD5(final File file) {
        FileInputStream fis = null;
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            final byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            final byte[] b = md.digest();
            final StringBuilder resultSb = new StringBuilder();
            for (final byte aB : b) {
                resultSb.append(byteToHexString(aB));
            }
            return resultSb.toString();
        } catch (Exception ex) {

            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
    }

    public static String byteArrayToHexString(final byte[] b) {
        final StringBuilder resultSb = new StringBuilder();
        for (final byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    public static String MD5Encode(final String origin) {
        String resultString = null;
        try {
            resultString = origin;
            final MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(resultString.getBytes("UTF-8"));
            resultString = byteArrayToHexString(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private static String byteToHexString(final byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        final int d1 = n / 16;
        final int d2 = n % 16;
        return MD5.hexDigits[d1] + MD5.hexDigits[d2];
    }

    static {
        hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }
}