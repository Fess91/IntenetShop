package service;

import dto.User;

public interface IUserService {

    boolean register (String login, String password);


    User login(String login, String password);

    User updateUserProfile(User user);



}
