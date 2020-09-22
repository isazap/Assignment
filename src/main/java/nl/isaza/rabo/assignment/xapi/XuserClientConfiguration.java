package nl.isaza.rabo.assignment.xapi;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XuserClientConfiguration {
    @Bean
    public OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .cookieJar(CookieJar.NO_COOKIES)
                .cache(null)
                .build();
    }
}
