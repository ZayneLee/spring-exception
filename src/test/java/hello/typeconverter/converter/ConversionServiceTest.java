package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.support.DefaultConversionService;

import hello.exception.ExceptionApplication;
import hello.exception.typeconverter.converter.IntegerToStringConverter;
import hello.exception.typeconverter.converter.IpPortToStringConverter;
import hello.exception.typeconverter.converter.StringToIntegerConveter;
import hello.exception.typeconverter.converter.StringToIpPortConveter;
import hello.exception.typeconverter.type.IpPort;

@SpringBootTest(classes = ExceptionApplication.class)
public class ConversionServiceTest {

    @Test
    void conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConveter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConveter());
        conversionService.addConverter(new IpPortToStringConverter());

        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        assertThat(conversionService.convert(ipPort, String.class)).isEqualTo("127.0.0.1:8080");

        String ipPortString = "127.0.0.1:8080";
        assertThat(conversionService.convert(ipPortString, IpPort.class)).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
