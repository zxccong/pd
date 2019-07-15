package zxc.pd.pd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @GetMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("redirect:"
                .concat("http://106.52.3.108:8080")
                .concat("/index.html"));

    }

}

