package com.spring.web.content.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *                       
 * @Filename GreetController.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: chenchuan</li>
 *<li>Date: 2017年3月6日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class GreetController {

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(name="name" ,required=false,defaultValue="world") String name,Model model){
		model.addAttribute("name", name);
		return "greet";
	}
}
