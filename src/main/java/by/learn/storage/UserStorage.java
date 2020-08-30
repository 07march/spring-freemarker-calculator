package by.learn.storage;

import by.learn.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }

    public User getUserByLogin(String login){
        for (User user : users) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
