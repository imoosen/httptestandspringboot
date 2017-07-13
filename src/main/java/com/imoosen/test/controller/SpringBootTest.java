package com.imoosen.test.controller;



import com.imoosen.test.model.User;
import com.imoosen.test.server.UserServer;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/20.
 */
@RestController
@RequestMapping("springboot")

public class SpringBootTest {

    @Resource(name="userServer")
    private UserServer userServer;


    @RequestMapping("test")
    public String test(){
        return "success";
    }

    @RequestMapping("testList")
    public List<String> getList(){

        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        return list;
    }

    @RequestMapping(value = "getid",method = RequestMethod.GET)
    public Integer getException(HttpServletRequest req){
        String id = req.getParameter("id");
        return Integer.parseInt(id);
    }

    @RequestMapping(value = "byid",method = RequestMethod.GET)
    public String getUserById(HttpServletRequest req){

        String id = req.getParameter("id");

        User user= userServer.selectByPrimaryKey(Integer.parseInt(id));

        return  user.getName();

    }
 @RequestMapping(value = "getall",method = RequestMethod.GET)
    public Map<String,Object> getAll(HttpServletRequest req){



        List<User> user= userServer.selectAll();
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("user",user);

        return  returnMap;

    }


}
