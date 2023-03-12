package ru.protomorphine.encoders.implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

class ByteArrayStringEncoderTest {

    private final ByteArrayStringEncoder stringEncoder = new ByteArrayStringEncoder();

    @ParameterizedTest
    @ValueSource(strings ={"Test String to encode", "TEST DATA", "TEST StRiNg"})
    void encode(String stringToEncode) {
        var encoded = stringEncoder.encode(stringToEncode);

        Assertions.assertArrayEquals(stringToEncode.getBytes(StandardCharsets.UTF_8), encoded);
    }

    @ParameterizedTest
    @MethodSource("byteArrayParametersProvider")
    void decode(byte[] encodedString) {
        var decoded = stringEncoder.decode(encodedString);

        Assertions.assertEquals(decoded, "hello my name is Daniil");
    }


    static Stream<byte[]> byteArrayParametersProvider() {
        return Stream.of(
                new byte[]{104, 101, 108, 108, 111, 32, 109, 121, 32, 110, 97, 109, 101, 32, 105, 115, 32, 68, 97, 110, 105, 105, 108}
        );
    }
}