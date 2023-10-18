package com.example.zuki.Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encriptar {
    public static String Encriptar(String mensaje, String clave) throws Exception {
        Key aesKey = new SecretKeySpec(clave.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        byte[] encrypted = cipher.doFinal(mensaje.getBytes());
        String base64String = Base64.getEncoder().encodeToString(encrypted);

        return base64String;
    }

    public static String Desencriptar(String mensajeEncriptado, String clave) throws Exception {
        byte[] encryptedBytes=Base64.getDecoder().decode( mensajeEncriptado.replace("\n", "") );

        Key aesKey = new SecretKeySpec(clave.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        String decrypted = new String(cipher.doFinal(encryptedBytes));

        return decrypted;
    }
    public static SecretKey generarClaveSecreta(String clave) throws Exception {
        byte[] claveBytes = clave.getBytes("UTF-8");
        KeySpec spec = new PBEKeySpec(clave.toCharArray(), claveBytes, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] claveSecretaBytes = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(claveSecretaBytes, "AES");
    }

    public static String GenerarClave() {
        // Aquí puedes implementar la lógica para generar una clave aleatoria
        // Por ejemplo, puedes utilizar la clase SecureRandom para generar una clave segura
        // y devolverla como una cadena en formato hexadecimal o en Base64
        // Aquí tienes un ejemplo simple:

        SecureRandom secureRandom = new SecureRandom();
        byte[] claveAleatoria = new byte[16]; // 16 bytes para una clave AES de 128 bits
        secureRandom.nextBytes(claveAleatoria);
        return Base64.getEncoder().encodeToString(claveAleatoria);

    }
}
