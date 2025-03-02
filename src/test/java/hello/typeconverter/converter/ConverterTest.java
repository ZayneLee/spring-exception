package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import hello.exception.ExceptionApplication;
import hello.exception.typeconverter.converter.IntegerToStringConverter;
import hello.exception.typeconverter.converter.StringToIntegerConveter;

@SpringBootTest(classes = ExceptionApplication.class)
class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConveter converter = new StringToIntegerConveter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }
}
