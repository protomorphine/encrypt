package ru.protomorphine.cyphers;

import java.util.ArrayList;

/**
 *
 * Represent cypher which operates with alphabet
 *
 * @param <TEncrypted> Type of encrypted source
 * @param <TDecrypted> Type of decrypted sourse
 * @param <TKey> Type of key
 */
public abstract class AlphabeticCypher<TEncrypted, TDecrypted, TKey>
        implements Cypher<ArrayList<TEncrypted>, ArrayList<TDecrypted>, TKey> {


    /**
     * Length of used alphabet
     */
    protected long alphabetLength;


    /**
     *
     * Creates new instance of AlphabeticCypher class
     *
     * @param alphabetLength Length of used alphabet
     */
    public AlphabeticCypher(long alphabetLength) {
        this.alphabetLength = alphabetLength;
    }
}
