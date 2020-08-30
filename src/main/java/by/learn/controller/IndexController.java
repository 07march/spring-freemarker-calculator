package by.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
@Slf4j
public class IndexController {

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "Hello!") String message, ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
