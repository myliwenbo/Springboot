package vip.xjdai.toolencryption;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import sun.misc.BASE64Encoder;
import sun.rmi.runtime.Log;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * RSA加密解密操作步骤
 */
public class Test1
{
    public static void main(String[] args)
    {
        try {
            //先给出一个待加密的字符串
            String data = "青青子衿，悠悠我心。但为君故，沉吟至今。";
            //1.构建公私钥匙对
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair          keyPair          = keyPairGenerator.generateKeyPair();
            //2.获取钥匙对中的公钥
            PublicKey publicKey = keyPair.getPublic();
            System.out.println( new BASE64Encoder().encode(publicKey.getEncoded()));
            System.out.println();
            //3.获取钥匙对中的私钥
            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println( new BASE64Encoder().encode(privateKey.getEncoded()));
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test()
    {

    }

}