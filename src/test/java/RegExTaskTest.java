import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RegExTaskTest {
    RegExTask regExTask;
    public RegExTaskTest(){
        regExTask = new RegExTask();
    }
    static Stream<Arguments> isItPhoneNumberTest() {
        return Stream.of(
                arguments("+380 (95) 666-88-99",true),
                arguments("0",false),
                arguments("+7 (896) 666-88-99",true),
                arguments("aasdadsa asd asd daaw",false),
                arguments("+0404 (998) 123-83-49",true)

        );
    }

    @ParameterizedTest(name = "is It Phone Number. Input data is {0}, {1} ")
    @MethodSource("isItPhoneNumberTest")
    void isItPhoneNumberTest_0(String phoneNumber, boolean expected) {
        boolean actual = regExTask.isItPhoneNumber(phoneNumber);
        assertEquals(expected, actual);
    }
}
