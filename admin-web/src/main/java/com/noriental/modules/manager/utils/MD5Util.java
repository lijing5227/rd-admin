package com.noriental.modules.manager.utils;

import com.noriental.modules.manager.exception.OkayException;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：md5工具类
 * *
 * *   @DATE    2019-12-23
 * *   @AUTHOR  JT.L
 ***/
public final class MD5Util {

    static MessageDigest md5Digest;

    static {
        try {
            md5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new OkayException("md5Digest初始化失败", e);
        }
    }

    /**
     * 自定义MD5获取字符串MD5值
     *
     * @param s
     * @return
     */
    public static String MD5(String s) {
        try {
            md5Digest.reset();
            byte[] bytes = md5Digest.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new OkayException("自定义MD5获取字符串MD5值异常", e);
        }
    }

    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    /**
     * 获取字符串MD5值默认编码为UTF-8
     *
     * @param key
     * @return
     */
    public static String strMD5(String key) {
        try {
            return computeDigest(loadBytes(key, null));
        } catch (Exception e) {
            throw new OkayException("获取UTF-8字符串MD5值异常", e);
        }
    }

    /**
     * 获取字符串MD5值需指定编码，默认使用MD5
     *
     * @param key
     * @param encoding
     * @return
     */
    public static String strMD5(String key, String encoding) {
        try {
            return computeDigest(loadBytes(key, encoding));
        } catch (Exception e) {
            throw new OkayException("获取字符串MD5值异常", e);
        }
    }

    /**
     * 以指定编码获取二进制编码
     *
     * @param name
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] loadBytes(String name, String encoding) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(encoding)) {
            encoding = "utf8";
        }
        byte[] buffer = name.getBytes(encoding);
        return (buffer);
    }

    /**
     * MD5值生成实现
     * <p>
     * byte-wise AND converts signed byte to unsigned.
     * pad on left if single hex digit.
     *
     * @param b
     * @return
     */
    private static String computeDigest(byte[] b) {
        md5Digest.reset();
        md5Digest.update(b);
        byte[] hash = md5Digest.digest();
        StringBuilder d = new StringBuilder();
        int usbyte;
        for (int i = 0; i < hash.length; i += 2) {
            usbyte = hash[i] & 0xFF;
            if (usbyte < 16) {
                d.append("0").append(Integer.toHexString(usbyte));
            } else {
                d.append(Integer.toHexString(usbyte));
            }
            usbyte = hash[i + 1] & 0xFF;
            if (usbyte < 16) {
                d.append("0").append(Integer.toHexString(usbyte));
            } else {
                d.append(Integer.toHexString(usbyte));
            }
        }
        return d.toString().trim().toLowerCase();
    }

    public static void main(String[] args) {
        String project = "/xdfapp/user-svr";
        String s = MD5Util.MD5(project);
        System.out.println(s);
    }
}
