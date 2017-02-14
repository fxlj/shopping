package com.ljishopping.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljishopping.common.pojo.LJIResult;
import com.ljishopping.search.service.ExtItemService;

@Controller
public class ExtImController {

	@Autowired
	private ExtItemService extItemService;

	@RequestMapping("/test")
	public String Test(){
		return "test";
	}
	
	@RequestMapping("/import")
	@ResponseBody
	public LJIResult importAllItems() {
		LJIResult result = extItemService.importAllItems();
		return result;
	}
}
