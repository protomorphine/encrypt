package ru.protomorphine;

import ru.protomorphine.cyphers.implementations.RotCypher;
import ru.protomorphine.encoders.implementations.StringEncoder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's Encrypt Data");

        StringEncoder encoder = new StringEncoder();
        RotCypher cypher = new RotCypher();

        String beforeEncoded = "TEST DATA";
        byte[] encoded = encoder.encode(beforeEncoded);
        byte[] encrypted = cypher.encrypt(encoded, 13);

        byte[] decrypted = cypher.decrypt(encrypted, 13);
        String decoded = encoder.decode(decrypted);

        System.out.println("Encoded string = " + Arrays.toString(encoded));
        System.out.println("Encrypted string = " + encoder.decode(encrypted));
        System.out.println("Decrypted = " + decoded);
    }
}