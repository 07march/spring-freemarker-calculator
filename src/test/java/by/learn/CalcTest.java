package by.learn;

import by.learn.entity.User;
import by.learn.storage.UserStorage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class CalcTest {

    static UserStorage userStorage;

    @BeforeAll
    static void init(){
        userStorage = new UserStorage();
    }

    @AfterAll
    static void destr(){
        System.out.println("destr");
    }

    @Test
    void check(){
        User user = new User("Test", "test", "qwerty");
        userStorage.add(user);
        assertEquals(user,  userStorage.getUserByLogin("test"));
    }

    //TDD
    @Test
    void sum(){
        Calc calc = new Calc();
        int sum = calc.sum(2, 6);
        assertEquals(8, sum);
    }

    @Test
    void div(){
        Calc calc = new Calc();
        int sum = calc.sum(2, 3);
        assertEquals(5, sum);
    }
}
