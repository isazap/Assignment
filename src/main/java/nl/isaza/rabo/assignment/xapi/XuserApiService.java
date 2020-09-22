package nl.isaza.rabo.assignment.xapi;

import nl.isaza.rabo.assignment.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service responsible for exposing the WireMock user service api
 */
@Service
public class XuserApiService {
    private static final String USERS_PATH = "/users";
    private static final String USERNAMES_PATH = "/users/names";
    private final XuserClient client;

    public XuserApiService(XuserClient client) {
        this.client = client;
    }

    public User getUser(String first, String surname) {
        var queryParams = Map.of("first", first, "surname", surname);
        var request = client.request(USERS_PATH, queryParams);

        return client.execute(request, User.class);
    }
}
