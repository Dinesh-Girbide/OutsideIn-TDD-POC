package co.incubyte.users;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class UsersGateway {

  @Inject
  @Client("https://jsonplaceholder.typicode.com")
  HttpClient httpClient;

  public List<User> getUsers() {
    return httpClient.toBlocking()
        .retrieve(HttpRequest.GET("/users"), Argument.listOf(User.class));
  }
}
