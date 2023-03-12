package ru.protomorphine.encoders.implementations;

import ru.protomorphine.encoders.BaseEncoder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * String to ArrayList{Byte} encoder
 */
public class ByteArrayListStringEncoder implements BaseEncoder<ArrayList<Byte>, String> {

    /**
     * Encode source
     *
     * @param source Source that needs to be encoded
     * @return Encoded source
     */
    @Override
    public ArrayList<Byte> encode(String source) {

        byte[] sourceBytes = source.getBytes(StandardCharsets.UTF_8);
        Byte[] sourceByteObjects = new Byte[source.length()];

        int i = 0;
        for(byte b: sourceBytes)
            sourceByteObjects[i++] = b;

        return new ArrayList<>(Arrays.asList(sourceByteObjects));
    }

    /**
     * Decode source
     *
     * @param source Source that needs to be decoded
     * @return Decoded source
     */
    @Override
    public String decode(ArrayList<Byte> source) {
        byte[] sourceBytes = new byte[source.size()];

        int i = 0;
        for(Byte b: source)
            sourceBytes[i++] = b;

        return new String(sourceBytes, StandardCharsets.UTF_8);
    }
}
