package me.cikai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    MainService service;

    @RequestMapping("/main")
    public ModelAndView initPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("main");
        return view;
    }

}
