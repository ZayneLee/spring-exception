package hello.exception.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import hello.exception.typeconverter.converter.IpPortToStringConverter;
import hello.exception.typeconverter.converter.StringToIpPortConveter;
import hello.exception.typeconverter.type.IpPort;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConveter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String convert = conversionService.convert(1000, String.class);
        assertThat(convert).isEqualTo("1,000");

        Long convert2 = conversionService.convert("1000", Long.class);
        assertThat(convert2).isEqualTo(1000L);
    }
}
