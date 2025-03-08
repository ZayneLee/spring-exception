package hello.exception.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Locale;

import org.junit.jupiter.api.Test;

public class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void testParse() throws ParseException {
        Number number = formatter.parse("1,000", Locale.KOREA);
        assertThat(number).isEqualTo(1000L);
    }

    @Test
    void testPrint() {
        String print = formatter.print(1000, Locale.KOREA);
        assertThat(print).isEqualTo("1,000");
    }
}
