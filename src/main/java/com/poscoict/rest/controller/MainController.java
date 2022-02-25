package com.poscoict.rest.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.poscoict.rest.service.MainService;

import lombok.RequiredArgsConstructor;


//@Controller
@RestController
@RequiredArgsConstructor
public class MainController {

	/*
	private MainService mainService;
	
	public MainController(MainService mainService) {
		// TODO Auto-generated constructor stub
		this.mainService = mainService;
	}*/
	
	@Autowired
	MainService mainService;
	
//	@GetMapping("/rest")
	@RequestMapping(value="/rest", method = RequestMethod.GET)
	public ModelAndView home() {
			ModelAndView view = new ModelAndView("index");
			System.out.println("# home");
			view.addObject("String1", mainService.selectSample());
			view.addObject("String2", "euiyoung.hwang2");
//		return "redirect:list";
			return view;
	}
	
	@PostConstruct
	public void postProcess() {
		System.out.println("==============================");
		System.out.println("postProcess");
		System.out.println("==============================");
	}
	
	@PreDestroy
	public void preProcess() {
		System.out.println("preProcess");
		
	}
}
