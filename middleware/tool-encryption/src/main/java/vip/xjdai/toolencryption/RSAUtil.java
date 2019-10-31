package vip.xjdai.toolencryption;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 工具类
 */
@Slf4j
public class RSAUtil
{

    public static void main(String[] args)
    {

    }

    /*
        读取秘钥数据
     */
    public static byte[] readKeyDatas(String keyFilePath)
    {
        BufferedReader bufferedReader = null;
        try {
            //读取数据
            bufferedReader = new BufferedReader(new FileReader(keyFilePath));
            String        str           = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("---")) {
                    continue;
                }
                stringBuilder.append(str);
            }
            return stringBuilder.toString().getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取私钥数据，通过私钥生成公钥
     * @param
     * @return
     */
    public static PublicKey getPublicKey()
    {
        //1.读取公钥文件,获取公钥数据
        byte[] bytesPublicBase64 = readKeyDatas("rsa_public.pem");
        //2.对读取回来的数据进行Base64解码
        byte[] bytesPublic = Base64.getDecoder().decode(bytesPublicBase64);
        //3.把解码后的数据,重新封装成一个PublicKey对象
        X509EncodedKeySpec keySpec    = new X509EncodedKeySpec(bytesPublic);
        KeyFactory         keyFactory = null;
        try {

            keyFactory = KeyFactory.getInstance("RSA");
            //生成公钥
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成私钥和公钥
     * @return
     */
    public static PrivateKey getPrivateKey()
    {
        //1.读取私钥文件,获取私钥数据
        //1.构建公私钥匙对
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            //2.获取钥匙对中的私钥
            PrivateKey       aPrivate    = keyPair.getPrivate();
            PublicKey        aPublic     = keyPair.getPublic();
            File             aPrivatePem = new File("rsa_private.pem");//
            File             rsaPublic   = new File("rsa_public.pem");//
            FileOutputStream out         = new FileOutputStream(aPrivatePem);
            FileOutputStream outPublic   = new FileOutputStream(rsaPublic);
            out.write(  Base64.getDecoder().decode(aPrivate.getEncoded()));
            outPublic.write(  Base64.getDecoder().decode(aPublic.getEncoded()));
            out.close();
            outPublic.close();
            return aPrivate;
        } catch (NoSuchAlgorithmException | IOException e) {
            log.error("生成私钥错误");
        }
        return null;
    }

    /*
        加密数据
     */
    public static String encodeData(PublicKey publicKey, String originData)
    {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytesEncrypt = cipher.doFinal(originData.getBytes());
            //Base64编码
            byte[] bytesEncryptBase64 = Base64.getEncoder().encode(bytesEncrypt);
            return new String(bytesEncryptBase64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        解密数据
     */
    public static String decodeData(PrivateKey privateKey, String encodeData)
    {
        try {
            //Base64解码
            byte[] bytesEncrypt = Base64.getDecoder().decode(encodeData);
            //加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytesDecrypt = cipher.doFinal(bytesEncrypt);
            return new String(bytesDecrypt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
}