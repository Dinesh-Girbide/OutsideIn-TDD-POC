package co.incubyte.users;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.Test;

@MicronautTest
public class UsersIntegrationTest {

  @Inject
  @Client("/users")
  HttpClient httpClient;

  @Test
  void httpClient_returns_list_of_users() {
    List<User> users = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("Le"), Argument.listOf(User.class));
    assertThat(users.isEmpty()).isFalse();
    for (User user : users) {
      assertThat(user.getName().contains("Le")).isTrue();
    }
  }
}
