package ru.protomorphine.cyphers;

/**
 *
 * Base interface of cypher
 *
 * @param <TEncrypted> Type of encrypted source
 * @param <TDecrypted> Type of decrypted source
 * @param <TKey> Type of key
 */
public interface Cypher<TEncrypted, TDecrypted, TKey> {

    /**
     *
     * Encrypts given source with given key
     *
     * @param source Source than needs to be encrypted
     * @param key Key to encrypt source
     */
    TEncrypted encrypt(TDecrypted source, TKey key);

    /**
     *
     * Decrypt given source with given key
     *
     * @param source Source that needs to be decrypted
     * @param key Key to decrypt source
     */
    TEncrypted decrypt(TEncrypted source, TKey key);
}
