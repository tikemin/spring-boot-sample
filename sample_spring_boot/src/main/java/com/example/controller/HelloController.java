package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.service.DetailService;
import com.example.domain.service.HelloService;

/**
 * @author tikemin
 * Hello Controller
 * /helloでリンクに来た場合のコントローラー
 */
@Controller
public class HelloController {

	@Autowired
	HelloService hello;
	
	@Autowired
	DetailService detail;

	/**
	 * Topページ
	 */
	@RequestMapping("/")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "hoge") String name, Model model) {
		hello.execute(model);	
		return "index";
	}

	/**
	 * 詳細ページ
	 */	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") String id, Model model){
	    detail.execute(model, id);	
		return "detail";
	}
}