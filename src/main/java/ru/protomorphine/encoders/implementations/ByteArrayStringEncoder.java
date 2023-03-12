package ru.protomorphine.encoders.implementations;

import ru.protomorphine.encoders.BaseEncoder;
import java.nio.charset.StandardCharsets;

/**
 * String to byte array encoder
 */
public class ByteArrayStringEncoder implements BaseEncoder<byte[], String> {

    /**
     * Encode source
     *
     * @param source Source that needs to be encoded
     * @return Encoded source
     */
    @Override
    public byte[] encode(String source) {
        return source.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Decode source
     *
     * @param source Source that needs to be decoded
     * @return Decoded source
     */
    @Override
    public String decode(byte[] source) {
        return new String(source);
    }
}
