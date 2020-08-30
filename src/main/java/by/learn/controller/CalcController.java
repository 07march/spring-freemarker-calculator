package by.learn.controller;

import by.learn.entity.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/calc")
@Slf4j
public class CalcController {

    //log4j
    //java util logger
    //slf4j

    //info
    //warning
    //error
    //debug
    //trace

//    private Logger log = Logger.getLogger(CalcController.class.getName());

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        log.info("Enter calc path and page");
        modelAndView.setViewName("calc");
        if (httpSession.getAttribute("history") == null) {
            httpSession.setAttribute("history", new ArrayList<Operation>());
        }
        modelAndView.addObject("resultFlag", false);
        modelAndView.addObject("result", 0);
        modelAndView.addObject("message", "Enter numbers");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView calc(@RequestParam("num1") int num1,
                             @RequestParam("num2") int num2,
                             @RequestParam("operation") String operation,
                             HttpSession httpSession,
                             ModelAndView modelAndView) {
        log.info("Enter calc path - " + "Enter numbers " + num1 + " " + num2);
        modelAndView.setViewName("calc");
        modelAndView.addObject("resultFlag", false);
        List<Operation> history = (List<Operation>) httpSession.getAttribute("history");
        switch (operation) {
            case "sum":
                int sum = sum(num1, num2);
                modelAndView.addObject("resultFlag", true);
                modelAndView.addObject("result", sum);
                history.add(new Operation(num1, num2, operation, sum));
                break;
            case "sub":
                int sub = sub(num1, num2);
                modelAndView.addObject("resultFlag", true);
                modelAndView.addObject("result", sub);
                history.add(new Operation(num1, num2, operation, sub));
                break;
            case "mul":
                int mul = mul(num1, num2);
                modelAndView.addObject("resultFlag", true);
                modelAndView.addObject("result", mul);
                history.add(new Operation(num1, num2, operation, mul));
                break;
            case "div":
                int div = div(num1, num2);
                modelAndView.addObject("resultFlag", true);
                modelAndView.addObject("result", div);
                history.add(new Operation(num1, num2, operation, div));
                break;
            default:
                modelAndView.addObject("message", "Operation not found");
        }
        return modelAndView;
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }

    private int mul(int a, int b) {
        return a * b;
    }

    private int div(int a, int b) {
        return a / b;
    }
}
