package com.ljishopping.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljishopping.common.pojo.LJIResult;

@Controller
public class SearchController {

	@Autowired

	@RequestMapping(value = "/query")
	@ResponseBody
	public LJIResult search(@RequestParam("q") String query, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "50") Integer rows) {
		
		return null;
	}
}
