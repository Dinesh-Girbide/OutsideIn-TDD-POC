package co.incubyte.users;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;

@Controller("/users")
public class UsersController {

  private UsersService usersService;

  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  @Get("/{searchString}")
  public List<User> getUsersByNameSearch(String searchString) {
    return usersService.getUsersByNameSearch(searchString);
  }
}
