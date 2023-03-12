package ru.protomorphine.helpers;

import ru.protomorphine.cyphers.CypherFactory;
import ru.protomorphine.cyphers.implementations.RotCypher;
import ru.protomorphine.cyphers.implementations.VigenereCypher;
import ru.protomorphine.encoders.implementations.ByteArrayListStringEncoder;
import ru.protomorphine.encoders.implementations.ByteArrayStringEncoder;

import java.util.ArrayList;

/**
 * Helpers methods to encrypt/decrypt data
 */
public class EncryptionHelper {

    /**
     * @param source String to encrypt with Vigenere Cypher
     * @param key Key
     * @return Decoded encrypted source string
     */
    public static String encryptWithVigenereCypher(String source, String key) {

        ByteArrayListStringEncoder encoder = new ByteArrayListStringEncoder();
        ByteArrayStringEncoder keyEncoder = new ByteArrayStringEncoder();

        VigenereCypher cypher = CypherFactory.createVigenereCypher();

        ArrayList<Byte> encoded = encoder.encode(source);
        ArrayList<Byte> encrypted = cypher.encrypt(encoded, keyEncoder.encode(key.toUpperCase()));

        return encoder.decode(encrypted);
    }

    /**
     * @param source String to encrypt with Rot Cypher
     * @param key Key
     * @return Decoded encrypted source string
     */
    public static String encryptWithRotCypher(String source, Integer key) {
        ByteArrayListStringEncoder encoder = new ByteArrayListStringEncoder();

        RotCypher cypher = CypherFactory.createRotCypher();
        ArrayList<Byte> encoded = encoder.encode(source);
        ArrayList<Byte> encrypted = cypher.encrypt(encoded, key);

        return encoder.decode(encrypted);
    }
}
