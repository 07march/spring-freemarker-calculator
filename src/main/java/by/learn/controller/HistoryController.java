package by.learn.controller;

import by.learn.entity.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class HistoryController {

    @GetMapping("/all")
    public ModelAndView findAll(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("history");
        modelAndView.addObject("all", HistoryUtil.getAll(httpSession));
        return modelAndView;
    }

    @GetMapping(path = "/byResult")
    public ModelAndView byresult(ModelAndView modelAndView) {
        modelAndView.setViewName("historybyresult");
        modelAndView.addObject("result", new String[]{"Enter result"});
        return modelAndView;
    }

    @PostMapping(path = "/byResult")
    public ModelAndView byresultpost(HttpSession httpSession, int result, ModelAndView modelAndView) {
        modelAndView.addObject("result", HistoryUtil.getAllByResult(httpSession, result));
        modelAndView.setViewName("historybyresult");
        return modelAndView;
    }

    private static class HistoryUtil {
        public static List<Integer> getAllByResult(HttpSession httpSession, int result) {
            List<Operation> historyByResult = (List<Operation>) httpSession.getAttribute("history");
            List<Integer> integers = new ArrayList<>();
            for (Operation s : historyByResult) {
                if (s.getResult() == result) {
                    integers.add(s.getResult());
                }
            }
            return integers;
        }

        public static List<Operation> getAll(HttpSession httpSession) {
            return ((List<Operation>) httpSession.getAttribute("history"));
        }
    }
}
