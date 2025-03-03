package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import hello.exception.ExceptionApplication;
import hello.exception.typeconverter.converter.IntegerToStringConverter;
import hello.exception.typeconverter.converter.IpPortToStringConverter;
import hello.exception.typeconverter.converter.StringToIntegerConveter;
import hello.exception.typeconverter.converter.StringToIpPortConveter;
import hello.exception.typeconverter.type.IpPort;

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

    @Test
    void stringToIpPort() {
        StringToIpPortConveter converter = new StringToIpPortConveter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(ipPort);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
