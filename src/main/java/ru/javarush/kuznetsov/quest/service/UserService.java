package ru.javarush.kuznetsov.quest.service;

import ru.javarush.kuznetsov.quest.entity.User;
import ru.javarush.kuznetsov.quest.repository.UserRepository;
import java.util.Map;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private static UserService userService;

    private UserService() {
        userRepository = UserRepository.get();
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public Map<Long, User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getById(long userId) {
        return userRepository.getById(userId);
    }

    public void createUser(String login, String password) {
        userRepository.createUser(login, password);
    }

    public Optional<User> findUser(String login, String password) {
        return userRepository.findUser(login, password);
    }

    public Optional<User> verifyLogin(String login) {
        return userRepository.verifyLogin(login);
    }


}
