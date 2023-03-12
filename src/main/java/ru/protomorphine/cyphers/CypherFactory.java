package ru.protomorphine.cyphers;

import ru.protomorphine.cyphers.implementations.RotCypher;
import ru.protomorphine.cyphers.implementations.VigenereCypher;

/**
 * Represent factory to create new Cypher instances
 */
public class CypherFactory {

    /**
     *
     * Creates new RotCypher instance
     *
     * @return RotCypher instance
     */
    public static RotCypher createRotCypher(){ return new RotCypher(Byte.MAX_VALUE); }

    /**
     *
     * Creates new VigenereCypher instance
     *
     * @return VigenereCypher instance
     */
    public static VigenereCypher createVigenereCypher(){ return new VigenereCypher(Byte.MAX_VALUE); }
}
