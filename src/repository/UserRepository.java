package repository;

import dto.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository implements IUserRepository{




    private List<User> userDatabase = new ArrayList<>();

    @Override
    public User getUserByLogin(String searchLogin) {
        for (User user : userDatabase) {
            if (user.getLogin().equalsIgnoreCase(searchLogin)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User saveUser(String login, String password) {
        User user = new User();
        user.setId(userDatabase.size() + 1);
        user.setLogin(login);
        user.setPassword(password);

        userDatabase.add(user);
        return user;
    }

    @Override
    public User updateUser(User userToUpdate) {
      long userToUpdateId = userToUpdate.getId();
        Iterator<User> iterator = userDatabase.iterator();
        while (iterator.hasNext()){
         User user =   iterator.next();
        if (user.getId() == userToUpdateId) {
            iterator.remove();

            }

        }
        userDatabase.add(userToUpdate);




        return userToUpdate;
    }
}
