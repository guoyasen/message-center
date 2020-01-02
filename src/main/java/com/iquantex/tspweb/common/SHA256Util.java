/**
 * @program: tsp-market
 * @description: SHA256 摘要算法工具类
 * @author: dzy
 * @create: 2019-02-20 20:42
 **/

package com.iquantex.tspweb.common;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
@Slf4j
public class SHA256Util {

  public static String getSHA256StrJava(String str){
      MessageDigest messageDigest;
  String encodeStr = "";
  try {
    messageDigest = MessageDigest.getInstance("SHA-256");
    messageDigest.update(str.getBytes("UTF-8"));
    encodeStr = byte2Hex(messageDigest.digest());
  } catch (NoSuchAlgorithmException e) {
      log.error("getSHA256StrJava error <{}>,data <{}>", e.getMessage(),str);
  } catch (UnsupportedEncodingException e) {
      log.error("getSHA256StrJava error <{}>,data <{}>", e.getMessage(),str);
  }
  return encodeStr;
  }
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
            //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void main(String args[]){
      System.out.println(getSHA256StrJava("fullgoal"));
    }


}
