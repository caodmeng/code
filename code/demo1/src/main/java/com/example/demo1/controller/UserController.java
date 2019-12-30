package com.example.demo1.controller;

import com.example.demo1.bean.ConfigBean;
import com.example.demo1.bean.ConfigTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 *
 * 用户入口
 *
 * @author caodm3
 * @date: 2019年05月03日  0:34
 */
@RestController
public class UserController {

	@Value("${com.caodm.name}")
	private String name;
	@Value("${com.caodm.want}")
	private String want;
	@Autowired
	ConfigBean configBean;
	@Autowired
	ConfigTestBean configTestBean;
	@RequestMapping(value = "/usr",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String hexo(){
		return "<div>"+name+","+want+"</div>";
	}
	@RequestMapping(value = "/usrConfig",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String hexo1(){
		return configBean.getName()+",6666"+configBean.getWant();
	}
	@RequestMapping(value = "/usrYerHope",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String hexo2(){
		return configBean.getYerHope();
	}
	@RequestMapping(value = "/usrTestMd",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String hexo3(){
		return configTestBean.getCc()+",MD"+configTestBean.getDd();
	}
}
