package com.zerobase.semiproject.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Component
public class CipherUtils {

    public static final int GCM_IV_LENGTH = 16;
    public static final int GCM_TAG_LENGTH = 128;
    public static SecretKeySpec secretKeySpec;
    public static final String AES_ALGORITHM = "AES/GCM/NoPadding";

    @Value("${cipher.aes256}")
    public void cipherInit(String value) {
        try {
            final String AES256_PRIVATEKEY = value;
            secretKeySpec = new SecretKeySpec(AES256_PRIVATEKEY.getBytes("UTF-8"), "AES");
        } catch (Exception e) {
            log.error("Cipher Init error : {}", e.getMessage());
        }
    }

    public static String encryptAES256(String str) {
        try {
            if (!StringUtils.hasText(str)) {
                return "";
            }
            SecureRandom random = new SecureRandom();
            byte[] iv = new byte[GCM_IV_LENGTH];
            random.nextBytes(iv);

            Cipher c = Cipher.getInstance(AES_ALGORITHM);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            c.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

            byte[] cipherText = c.doFinal(str.getBytes());
            return new String(Base64.getEncoder().encode(concatenate(iv, cipherText)), "utf-8");
        } catch (Exception e) {
            log.error("AES256 Cipher Encrypt Error :: {}", e.getMessage());
            return "";
        }
    }

    private static byte[] concatenate(byte[] firstArray, byte[] secondArray) {
        byte[] result = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
        System.arraycopy(secondArray, 0, result, firstArray.length, secondArray.length);
        return result;
    }

    public static String decryptAES256(String str) {
        try {
            if (!StringUtils.hasText(str)) {
                return "";
            }
            byte[] ciphertext = Base64.getDecoder().decode(str.getBytes());
            byte[] iv = Arrays.copyOfRange(ciphertext, 0, GCM_IV_LENGTH);
            byte[] cipherText = Arrays.copyOfRange(ciphertext, GCM_IV_LENGTH, ciphertext.length);

            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
            return new String(cipher.doFinal(cipherText),"utf-8");
        } catch (Exception e) {
            log.error("AES256 Cipher Decrypt Error :: {}", e.getMessage());
            return "";
        }
    }

    public static String encryptSHA512(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(str.getBytes(StandardCharsets.UTF_8));
            return String.format("%0128x", new BigInteger(1, md.digest()));
        } catch (Exception e) {
            log.error("SHA Cipher Encrypt Error :: {}", e.getMessage());
            return "";
        }
    }
}
