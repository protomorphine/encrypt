package ru.protomorphine.cyphers.implementations;

import ru.protomorphine.cyphers.AlphabeticCypher;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Implementation of ROT Cypher
 */
public class RotCypher extends AlphabeticCypher<Byte, Byte, Integer> {

    /**
     *
     * Creates new instance of RotCypher
     *
     * @param alphabetLength Length of used alphabet
     */
    public RotCypher(long alphabetLength) {
        super(alphabetLength);
    }

    /**
     *
     * Encrypts given source with given key
     *
     * @param source Source than needs to be encrypted
     * @param key Key to encrypt source
     */
    @Override
    public ArrayList<Byte> encrypt(ArrayList<Byte> source, Integer key) {
        return process(source, encodedValue -> encodedValue + key);
    }

    /**
     *
     * Decrypt given source with given key
     *
     * @param source Source that needs to be decrypted
     * @param key Key to decrypt source
     */
    @Override
    public ArrayList<Byte> decrypt(ArrayList<Byte> source, Integer key) {
        return encrypt(source, -key);
    }

    /**
     * Process source with ROT algorithm with given key
     *
     * @param source Encoded source
     * @param processor operation with byte and key (+ for encrypt, - for decrypt)
     * @return Processed (encrypted or decrypted) source
     */
    private ArrayList<Byte> process(ArrayList<Byte> source, Function<Integer, Integer> processor) {

        ArrayList<Byte> result = new ArrayList<>();

        for (Byte elem : source) {
            result.add((byte) (processor.apply((int) elem) % this.alphabetLength));
        }

        return result;
    }
}
