package service;

import dto.User;
import repository.UserRepository;

public class UserService implements IUserService{
    public UserRepository userRepository;




    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(String login, String password) {

        if(login.isEmpty() || password.isEmpty()){
            System.out.println("Попытка регистрации с пустым паролем или логином");
            return false;}
        if(login.length()<= 3 || password.length()<= 3){
            System.out.println("Попытка регистрации c паролем или логином не более 3-х символов");
            return false;}
        if (!isValidPassword(password)){
            System.out.println("Попытка регистрации c паролем который содержит только буквы или числа");
            return false;
        }
        if (isLoginAlreadyUsed(login)){
            System.out.println("Попытка регистрации c логином,который уже используется");
            return false;
        }
        userRepository.saveUser(login,password);
        System.out.println("Пользовтель с логином " + login +  " зарегистрирован");
        return true;

    }
    private boolean isLoginAlreadyUsed(String searchLogin){

        User userByLogin = userRepository.getUserByLogin(searchLogin);
        return userByLogin != null;
    }
    private boolean isValidPassword(String password) {

        char[] passwordChars = password.toCharArray();
        boolean hasDigit = false;
        boolean hasLetter = false;
        for (char passwordChar : passwordChars) {
            boolean isDigit = Character.isDigit(passwordChar);
            hasDigit = hasDigit || isDigit;
            hasLetter = hasLetter || !isDigit;


        }


        return hasDigit && hasLetter;
    }


    @Override
    public User login(String login, String password) {
        User userByLogin = userRepository.getUserByLogin(login);
        if(userByLogin == null) {
            System.out.println("Авторизация не пройдена : Пользователь с лоином " +login + " в системе не найден");
            return null;
        }
       boolean passwordCheckPassed =  userByLogin.getPassword().equals(password);
        if(!passwordCheckPassed){
            System.out.println("Авторизация не пройдена : Пароль для пользователя " +login + " указан некорректно");
            return null;
        }


        System.out.println("Авторизация  пройдена : пользователь " +login + " успешно авторизован");
        return userByLogin;
    }

    @Override
    public User updateUserProfile(User user) {

        return userRepository.updateUser(user);
    }
}
