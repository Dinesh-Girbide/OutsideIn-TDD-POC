package co.incubyte.users;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersControllerShould {

  private UsersService usersService;

  @BeforeEach
  void init() {
    usersService = mock(UsersService.class);
  }

  @Test
  void invoke_service_with_name_starting_characters() {
    UsersController usersController = new UsersController(usersService);
    usersController.getUsersByNameSearch("Le");
    verify(usersService).getUsersByNameSearch("Le");
  }
}
