package ru.protomorphine.encoders;

/**
 * Base encoder interface
 * @param <TEncoded> Type of encoded source
 * @param <TDecoded> Type of decoded source
 */
public interface BaseEncoder<TEncoded, TDecoded> {
    /**
     * Encode source
     * @param source Source that needs to be encoded
     * @return Encoded source
     */
    TEncoded encode(TDecoded source);

    /**
     * Decode source
     * @param source Source that needs to be decoded
     * @return Decoded source
     */
    TDecoded decode(TEncoded source);
}
