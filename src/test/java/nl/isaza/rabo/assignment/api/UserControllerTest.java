package nl.isaza.rabo.assignment.api;

import nl.isaza.rabo.assignment.AssignmentApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = {AssignmentApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureWebTestClient
class UserControllerTest {
    private static final String USER_PATH = "/users";
    private static final String FIRSTNAME = "Jane";
    private static final String SURNAME = "Doe";
    @Autowired
    private WebTestClient api;

    @Test
    public void testGetUser() {
        api.get().uri(USER_PATH)
                .exchange()
                .expectStatus().isOk();

    }
}