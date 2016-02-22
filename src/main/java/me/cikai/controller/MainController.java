package me.cikai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import me.cikai.model.FormModel;
import me.cikai.service.MainService;
import me.cikai.dto.FormDto;

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
	public ModelAndView submit(FormModel formModel) {
		FormDto formDto = modelToDto(formModel);
		service.add(formDto);
		return null;
	}

	public FormDto modelToDto(FormModel formModel) {
		FormDto formDto = new FormDto();
		formDto.setName(formModel.getName());
		formDto.setFood(formModel.getFood());
		formDto.setCount(formModel.getCount());
		formDto.setPayment(formModel.getPayment());
		return formDto;
	}

}
