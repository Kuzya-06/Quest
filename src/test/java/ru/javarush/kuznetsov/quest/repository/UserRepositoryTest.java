package ru.javarush.kuznetsov.quest.repository;

import org.junit.jupiter.api.Test;
import ru.javarush.kuznetsov.quest.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository = UserRepository.get();

    @Test
    void createUserTest() {
        Map<Long, User> all = userRepository.getAll();
        long count = all.values().stream().count();

        userRepository.createUser("root", "root1");
        userRepository.createUser("root2", "root2");
        assertEquals(count + 2, all.values().stream().count());
    }

    @Test
    void findUserByLoginAndByPasswordTest() {
        Map<Long, User> all = userRepository.getAll();
        userRepository.createUser("root", "root123");
        long count = all.values().stream().count();
        userRepository.createUser("root2", "root1232");

        Optional<User> user = userRepository.findUser("root", "root123");
        User user1 = user.get();
        assertEquals(userRepository.getById(count-1).get(), user1);

    }
}