package co.incubyte.users;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersServiceShould {

  private UsersService usersService;

  @BeforeEach
  public void init() {
    usersService = mock(UsersService.class);
  }

  @Test
  void get_users_from_httpclient_request() {
    List<User> users = usersService.getUsersByNameSearch("Le");
    verify(usersService).getUsersByNameSearch("Le");
  }
}
