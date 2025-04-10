package hello.exception.typeconverter.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

    @Override
    public String print(Number object, Locale locale) {
        log.info("object = {}, locale = {}", object, locale);
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(object);
    }

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("object = {}, locale = {}", text, locale);
        return NumberFormat.getInstance(locale).parse(text);
    }

}
