package ru.javarush.kuznetsov.quest.repository;

import ru.javarush.kuznetsov.quest.entity.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private static final UserRepository userRepository = new UserRepository();

    private final Map<Long, User> users;
    private Long id=0L;

    private UserRepository() {
        users = new HashMap<>();
        users.put(id, new User("admin", "admin"));
        users.put(++id, new User("user", "user"));
    }

    public static UserRepository get() {
        return userRepository;
    }

    public Map<Long, User> getAll() {
        return users;
    }

    public Optional<User> getById(long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public void createUser(String login, String password) {
        users.put(++id, new User(login, password));
    }

    public Optional<User> findUser(String login, String password) {
        Collection<User> values = users.values();
        return values.stream()
                .filter(user -> user.getLogin().equals(login))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }

    public Optional<User> verifyLogin(String login) {
        Collection<User> values = users.values();
        return values.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }


}
