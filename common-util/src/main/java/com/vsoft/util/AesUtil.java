package com.v.soft.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author liuWei
 * @desc 描述
 * @date 2020/8/17 17:11
 */
public class AesUtil {

    private static final String IV = "5075428636499153";

    //密钥
    private static final String secretkey = "74a720e82bc24559b78c3777d5c910ac";

    /**
     * 指定key加密
     * @param strKey
     * @param strIn
     * @return
     * @throws Exception
     */
    public static String encrypt(String strKey, String strIn) throws Exception {
        return getEncrypt(strKey, strIn);
    }

    /**
     * 加密
     * @param strIn
     * @return
     * @throws Exception
     */
    public static String encrypt(String strIn) throws Exception {
        return getEncrypt(secretkey, strIn);
    }


    public static String encrypts(String strKey, String strIn) throws Exception {
        return getEncrypt(strKey, strIn);
    }

    private static String getEncrypt(String strKey, String strIn) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(strIn.getBytes("UTF-8"));
        return org.apache.commons.codec.binary.Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String strIn) throws Exception {
        strIn = strIn.trim();
        SecretKeySpec skeySpec = getKey(secretkey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = org.apache.commons.codec.binary.Base64.decodeBase64(strIn);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original,"UTF-8");
        return originalString;
    }

    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes("UTF-8");
        byte[] arrB = new byte[16];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        return new SecretKeySpec(arrB, "AES");
    }
}
