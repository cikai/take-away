package me.cikai.controller;

import me.cikai.dto.FormDto;
import me.cikai.model.FormModel;
import me.cikai.service.MainService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    MainService service = null;

    @RequestMapping("/main")
    @ResponseBody
    public ModelAndView initPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("main");
        return view;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(FormModel formModel) {
        FormDto formDto = modelToDto(formModel);
        service.add(formDto);
    }

    public FormDto modelToDto(FormModel formModel) {
        FormDto formDto = new FormDto();
        formDto.setName(formModel.getName());
        formDto.setFood(Integer.parseInt(formModel.getFood()));
        formDto.setCount(Integer.parseInt(formModel.getCount()));
        formDto.setPayment(Integer.parseInt(formModel.getPayment()));
        return formDto;
    }

}
