package vip.xjdai.toolencryption;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 加签  验签    签名验证：验证数据的合法来源   即验证数据来源的合法性
 * 加签：私钥
 * 验签：公钥
 */
public class Test2
{
    private static String privateKeyPath = "储存私钥信息的文件路径";
    private static String publicKeyPath  = "储存公钥信息的文件路径";

    public static void main(
            String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException
    {
        String data = "验证该数据是否为合法的服务器发送";
        /**
         * 加签过程
         */
        PrivateKey privateKey = RSAUtil.getPrivateKey();
        Signature  signature  = Signature.getInstance("Sha1WithRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] signed = signature.sign();
        /**
         * 验签过程
         */
        PublicKey publicKey  = RSAUtil.getPublicKey();
        Signature signature2 = Signature.getInstance("Sha1WithRSA");
        signature2.initVerify(publicKey);
        signature2.update(data.getBytes(StandardCharsets.UTF_8));
        boolean verify = signature2.verify(signed);
        System.out.println("验签结果:" + verify);
    }


}