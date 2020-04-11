package cn.lwb.加签;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA加密解密操作步骤
 */
public class Test1 {

    public static void main(String[] args) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        //先给出一个待加密的字符串
        String data = "青青子衿，悠悠我心。但为君故，沉吟至今。";
        //1.构建公私钥匙对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //2.获取钥匙对中的公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("公钥数据：");
        //3.获取钥匙对中的私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("公钥数据：" + privateKey.toString());
        //4.对待加密的数据进行加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytesEncrypt = cipher.doFinal(data.getBytes());//产生的是乱码,需要用Base64进行转码
        //5.Base64编码
        byte[] encodeBase64 = Base64.getEncoder().encode(bytesEncrypt);
        System.out.println("加密后的数据:" + new String(encodeBase64));
        //6.在解密时,先对用Base64编码的信息进行解码
        byte[] bytesDecode = Base64.getDecoder().decode(encodeBase64);
        //7.解密
        Cipher cipher2 = Cipher.getInstance("RSA");
        cipher2.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytesDecrypt = cipher2.doFinal(bytesDecode);
        System.out.println("解密后的数据:" + new String(bytesDecrypt));
    }
}