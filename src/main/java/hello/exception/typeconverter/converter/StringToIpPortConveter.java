package hello.exception.typeconverter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import hello.exception.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToIpPortConveter implements Converter<String, IpPort> {

    @Override
    @Nullable
    public IpPort convert(String source) {
        log.info("convert source={}", source);
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);
    }

}
