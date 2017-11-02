package com.qinchy.imoocdemo.controller;

import com.qinchy.imoocdemo.config.WechatConfig;
import com.qinchy.imoocdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private WechatConfig wechatConfig;

    @RequestMapping(path = "/getCfg1", method = RequestMethod.GET)
    public String getCfg1(){
        return this.wechatConfig.getAccessTokenServerClass();
    }

    @RequestMapping(path = "/getCfg2", method = RequestMethod.GET)
    public String getCfg2(){
        return "test";
    }

    @RequestMapping(path = "/getStu", method = RequestMethod.GET)
    public Student getStu(){
        return new Student("abc",11);
    }

    // 请求url:/say[?id=],不传id时默认为0
    @RequestMapping(path = "/say1", method = RequestMethod.GET)
    public String say1(@RequestParam(value = "id", required = false, defaultValue = "0") int id){
        return "id = "+id;
    }

    //GetMapping等同于get方式的RequestMapping
    @GetMapping(path = "/say2")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") int id){
        return "id = "+id;
    }

    // 请求url:/1/say
    @RequestMapping(path = "/{id}/hi", method = RequestMethod.GET)
    public String hi(@PathVariable(name="id", required = true) int id){
        return "id = "+id;
    }

}
