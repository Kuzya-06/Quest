package ru.javarush.kuznetsov.quest.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javarush.kuznetsov.quest.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository = UserRepository.get();

    @ParameterizedTest
    @ValueSource(longs = {0l})
    void getById0DefaultTest(long id){
        Map<Long, User> all = userRepository.getAll();
        User user = all.get(id);
        assertEquals("admin", user.getLogin());
    }

    @ParameterizedTest
    @ValueSource(longs = {1l})
    void getById1DefaultTest(long id){
        Map<Long, User> all = userRepository.getAll();
        User user = all.get(id);
        assertEquals("user", user.getLogin());
    }

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
        assertEquals(userRepository.getById(count - 1).get(), user1);

    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "user"})
    void verifyLoginByLoginDefaultTest(String login) {
        Collection<User> values = userRepository.getAll().values();
        boolean b = values.stream()
                .map(e -> e.getLogin())
                .anyMatch(e -> e.equals(login));
        assertTrue(b);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "user", "qwertyuiop"})
    void verifyLoginByLoginAddLoginTest(String login) {
        Collection<User> values = userRepository.getAll().values();
        userRepository.createUser(login, "111");
        boolean b = values.stream()
                .map(e -> e.getLogin())
                .anyMatch(e -> e.equals(login));
        assertTrue(b);

    }
}