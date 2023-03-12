package ru.protomorphine.cyphers.implementations;

import ru.protomorphine.cyphers.AlphabeticCypher;

import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

/**
 * Implementation of Vigenere Cypher
 */
public class VigenereCypher extends AlphabeticCypher<Byte, Byte, byte[]> {

    /**
     *
     * Creates new instance of VigenereCypher
     *
     * @param alphabetLength Length of used alphabet
     */
    public VigenereCypher(long alphabetLength) {
        super(alphabetLength);
    }

    /**
     *
     * Encrypts given source with given key
     *
     * @param source Source than needs to be encrypted
     * @param key  Key to encrypt source
     */
    @Override
    public ArrayList<Byte> encrypt(ArrayList<Byte> source, byte[] key) {
        return process(source, key, Integer::sum);
    }

    /**
     *
     * Decrypt given source with given key
     *
     * @param source Source that needs to be decrypted
     * @param key  Key to decrypt source
     */
    @Override
    public ArrayList<Byte> decrypt(ArrayList<Byte> source, byte[] key) {
        return process(source, key, (a, b) -> a - b);
    }

    /**
     *
     * Process source with given key
     *
     * @param source Source to encrypt/decrypt
     * @param key Key
     * @param op Operation with source[i] and key[i]
     * @return Encrypted/decrypted source
     */
    private ArrayList<Byte> process(ArrayList<Byte> source, byte[] key, IntBinaryOperator op){

        int sourceSize = source.size();
        ArrayList<Byte> result = new ArrayList<>();

        byte[] extendedKey = extendKey(key, sourceSize);

        for (int i = 0; i < sourceSize; i++) {
            var processedByte = (byte) ((byte)op.applyAsInt(source.get(i), extendedKey[i]) % (byte)this.alphabetLength);
            result.add(processedByte);
        }
        return result;
    }

    /**
     *
     * Extend key to needed length
     * For example: key=DATA keyLength=10 will return DATADATADA
     *
     * @param key Key
     * @param keyLength Length of extended key
     * @return Extended key
     */
    private byte[] extendKey(byte[] key, int keyLength){
        byte[] extendedKey = new byte[keyLength];
        for (int i = 0; i < keyLength; i++) {
            extendedKey[i] = key[i % key.length];
        }
        return extendedKey;
    }
}
