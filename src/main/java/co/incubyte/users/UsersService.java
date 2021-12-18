package co.incubyte.users;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;


@Singleton
public class UsersService {
  private final UsersGateway usersGateway;

  public UsersService(UsersGateway usersGateway) {
    this.usersGateway = usersGateway;
  }

  public List<User> getUsersByNameSearch(String searchString) {
    List<User> allUsers=usersGateway.getUsers();
    List<User> searchedUsers = new ArrayList<>();
    for (User user : allUsers) {
      if (user.getName().contains(searchString)) {
        searchedUsers.add(user);
      }
    }
    return searchedUsers;
  }
}
