package com.company.pjname.util;


import android.util.Base64;
import org.json.JSONObject;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author : xubo
 * @description : AES加解密工具
 * @date : 2019-08-20 21:27
 */
public class AesEncryptUtils {

    private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";
    private static final String CHARSET_NAME = "utf-8";

    /**
     * 加密
     * @param contentStr 需要加密的字符串
     * @param key key
     * @return
     * @throws Exception
     */
    public static String encrypt(String contentStr, String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] b = cipher.doFinal(contentStr.getBytes(CHARSET_NAME));
        return Base64.encodeToString(b,Base64.DEFAULT);
    }

    /**
     * 解密
     * @param encryptStr 需要解密的字符串
     * @param key key
     * @return
     * @throws Exception
     */
    public static String decode(String encryptStr, String key) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encryptBytes = Base64.decode(encryptStr,Base64.DEFAULT);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    public static void main(String[] args) throws Exception {
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("phone", "18963786896");
//        jsonObject.put("smsCode", "514756");
//        jsonObject.put("newPassword", "xubo234");



//        jsonObject.put("userName", "xubo");
//        jsonObject.put("password", "xubo234");


//        jsonObject.put("id", "46");
//        jsonObject.put("userId", 41);
//        jsonObject.put("pageNum", 1);
//        jsonObject.put("pageSize", 10);
        jsonObject.put("token", "41_29ac6871fdf0408dbd6914296b5758b4");
        System.out.println(encrypt(jsonObject.toString(), "#wms.app&?xpo*+!"));
    }

}
