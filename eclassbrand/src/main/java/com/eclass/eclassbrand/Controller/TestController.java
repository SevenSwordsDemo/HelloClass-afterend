package com.eclass.eclassbrand.Controller;


import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Monday;
import com.eclass.eclassbrand.POJO.Thursday;
import com.eclass.eclassbrand.Service.TestService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public CommonResult test()
    {
       return testService.test();
    }

    @RequestMapping("addApply")
    public CommonResult addApply()
    {
        return testService.addAplly();
    }

    @RequestMapping("addClassroom")
    public CommonResult addClassroom()
    {
        return testService.addClassroom();
    }

    @RequestMapping("/getThursday")
    public Monday getThursday()
    {
        return testService.getMonday();
    }
}
