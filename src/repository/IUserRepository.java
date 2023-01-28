package repository;

import dto.User;

public interface IUserRepository {

    User getUserByLogin(String login);

    User saveUser(String login, String password);

    User updateUser(User userToUpdate);
}