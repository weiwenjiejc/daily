package org.wwj.demo.mybatis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wwj.demo.mybatis.dao.TestDao;

@Controller
public class TestController {

    @Autowired
    private TestDao testDao;


    @RequestMapping("/test")
    @ResponseBody
    String test(){
        String version = null;
        try {
            
            version = testDao.getVersion();
        }catch (Exception e){
            System.out.println("出现异常");
        }
        
        return version;
    }
}
