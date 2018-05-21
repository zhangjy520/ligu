package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by conn on 2016/8/1.
 * root
 */
@Controller
@RequestMapping(value = "/root")
public class RootController extends BasicController{

    @RequestMapping(value = "/index")
    public String index(){
        return "root/index";
    }

}
