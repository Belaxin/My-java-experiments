package bank;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

public class Hashing {

    static String hash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
            String sha256hex = new String(HexFormat.of().formatHex(hash));
            return sha256hex;
        } catch(Exception ex) {
            System.err.println(ex);
        }

        return "";
    }
}
