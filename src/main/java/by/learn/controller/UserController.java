package by.learn.controller;

import by.learn.entity.User;
import by.learn.storage.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
@Slf4j
public class UserController {

    private final UserStorage userStorage;

    public UserController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @GetMapping(path = "/reg")
    public ModelAndView reg(ModelAndView modelAndView) {
        modelAndView.setViewName("reg");
        log.warn("Enter user reg page");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView regPost(User user, ModelAndView modelAndView) {
        userStorage.add(user);
        modelAndView.setViewName("redirect:/?message=registration successfully!");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView auth(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView authPost(String login, String password, HttpSession httpSession, ModelAndView modelAndView) {
        User userByLogin = userStorage.getUserByLogin(login);
        if (userByLogin == null) {
            modelAndView.setViewName("auth");
            log.warn("User " + login + " not found!");
            log.debug(httpSession.toString());
            modelAndView.addObject("message", "user not found!");

        } else {
            if (userByLogin.getPassword().equals(password)) {
                httpSession.setAttribute("user", userByLogin);
                log.warn("Auth successfully!!");
                modelAndView.setViewName("redirect:/?message=auth successfully!");
            } else {
                modelAndView.setViewName("auth");
                log.warn("Incorrect password!");
                modelAndView.addObject("message", "incorrect password!");
            }
        }
        return modelAndView;
    }
}

