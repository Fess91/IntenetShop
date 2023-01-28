import dto.User;
import repository.UserRepository;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);







        userService.register("best_ever_user","123ва4");
        userService.login("best_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");
        userService.login("best_ever_ever_user", "123ва4");


        User bestEverUser = userService.login("best_ever_user", "123ва4");
        bestEverUser.setLogin("best_ever_ever_user");
        bestEverUser.setAge(28);
        userService.updateUserProfile(bestEverUser);


    }
}