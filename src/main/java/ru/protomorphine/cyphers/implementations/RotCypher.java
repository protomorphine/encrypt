package ru.protomorphine.cyphers.implementations;

import ru.protomorphine.cyphers.Cypher;
import ru.protomorphine.helpers.MathHelper;

import java.util.function.Function;

/**
 * Implementation of ROT Cypher
 */
public class RotCypher implements Cypher<byte[], byte[] , Integer> {

    @Override
    public byte[] encrypt(byte[] source, Integer key) {
        return process(source, encodedValue -> encodedValue + key);
    }

    @Override
    public byte[] decrypt(byte[] source, Integer key) {
        return process(source, encryptedValue -> encryptedValue - key);
    }

    /**
     * Process source with ROT algorithm with given key
     * @param source Encoded source
     * @param processor operation with byte and key (+ for encrypt, - for decrypt)
     * @return Processed (encrypted or decrypted) source
     */
    private byte[] process(byte[] source, Function<Integer, Integer> processor) {
        var result = new byte[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = (byte) MathHelper.mod(processor.apply((int)source[i]), Byte.MAX_VALUE);
        }
        return result;
    }
}
