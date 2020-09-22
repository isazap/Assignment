package nl.isaza.rabo.assignment.xapi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Service responsible for HTTP communication with the WireMock standalone service for user data.
 */
@Service
public class XuserClient {
    private final ObjectMapper mapper;
    private final OkHttpClient client;
    private final XuserApiConfiguration configuration;

    public XuserClient(ObjectMapper mapper, OkHttpClient client, XuserApiConfiguration configuration) {
        this.mapper = mapper;
        this.client = client;
        this.configuration = configuration;
    }

    /**
     * Executes the given request and parses the result to the given result class.
     *
     * @param requestBuilder the request builder to execute
     * @param result         the result class to parse the body to
     * @param <T>            the type to parse the response to
     * @return and instance of the expected class
     */
    <T> T execute(Request.Builder requestBuilder, Class<T> result) {
        try (var stream = execute(requestBuilder)) {
            return mapper.readValue(stream, result);
        } catch (JsonParseException e) {
            throw new IllegalStateException("The response stream is not JSON parsable", e);
        } catch (JsonMappingException e) {
            throw new IllegalStateException("The response stream is not deserializable to " + result.getSimpleName(), e);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read from the response stream", e);
        }
    }

    /**
     * Returns a {@link Request.Builder} for the configuration baseUrl and path.
     *
     * @param path   the endpoint path
     * @param params the query parameters for the request
     * @return a configured request builder
     */
    Request.Builder request(String path, Map<String, String> params) {
        var url = HttpUrl.get(configuration.getBaseUrl()).resolve(path);
        if (url == null) {
            throw new IllegalStateException(String.format(
                    "Could not combine connection baseUrl %s and the given path %s",
                    configuration.getBaseUrl(),
                    path
            ));
        }

        HttpUrl.Builder httpBuilder = url.newBuilder();
        params.entrySet().forEach(e -> httpBuilder.addQueryParameter(e.getKey(), e.getValue()));

        return new Request.Builder().url(httpBuilder.build());
    }

    /**
     * Executes the given request and returns the response body stream.
     *
     * @param requestBuilder the request builder to execute
     * @return the string representation of the body
     */
    InputStream execute(Request.Builder requestBuilder) {
        var request = requestBuilder.build();
        try {
            var response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new IllegalStateException("Could not execute the request");
            }
            return readBodyStreamResponse(response);

        } catch (IOException e) {
            throw new IllegalStateException("Could not execute the request", e);
        }
    }

    /**
     * Returns the {@link InputStream} representation of the response body, or an
     * empty body if the body is (@code null}.
     *
     * @param response the respoonse to read the body from
     * @return the string representation of the body
     */
    private InputStream readBodyStreamResponse(Response response) {
        var body = response.body();
        return body == null ? StreamUtils.emptyInput() : body.byteStream();
    }
}
