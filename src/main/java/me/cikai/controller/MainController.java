package me.cikai.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import me.cikai.dto.FormDto;
import me.cikai.dto.ListDto;
import me.cikai.model.FormModel;
import me.cikai.model.ListModel;
import me.cikai.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    MainService service = null;

    @RequestMapping("/main")
    @ResponseBody
    public ModelAndView initPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("main");
        return view;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list() {
        List<ListDto> listDto = service.getList();
        List<ListModel> listModel = listDto.stream().map(this::dtoToModel).collect(Collectors.toList());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list", listModel);
        return resultMap;
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

    public ListModel dtoToModel(ListDto listDto) {
        ListModel listModel = new ListModel();
        listModel.setName(listDto.getName());
        listModel.setFood(String.valueOf(listDto.getFood()));
        listModel.setCount(String.valueOf(listDto.getCount()));
        listModel.setPayment(String.valueOf(listDto.getPayment()));
        return listModel;
    }

}
