package com.didispace.web;

import com.didispace.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 在application.properties中使用spring.profiles.active可以配置环境端口号，来区分使用的环境
 * @author v-yangxu
 *
 */
@Controller
@RequestMapping(value="")
public class HelloController {

	//读取properties文件的参数，并注入到到指定字段中
//	@Autowired
//	private ConfigService c;

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index2() {
        return "index";
    }

    @RequestMapping("/hello")

    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }





    @RequestMapping("/html")
    public String html() throws Exception {
        throw new Exception("请求错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("JSON错误");
    }

}