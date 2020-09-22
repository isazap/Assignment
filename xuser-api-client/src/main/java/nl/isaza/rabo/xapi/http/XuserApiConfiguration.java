package nl.isaza.rabo.xapi.http;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "xuser")
public class XuserApiConfiguration {
    private String baseUrl;
}
