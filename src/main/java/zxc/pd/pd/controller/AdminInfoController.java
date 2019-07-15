package zxc.pd.pd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import zxc.pd.pd.constant.CookieConstant;
import zxc.pd.pd.constant.RedisConstant;
import zxc.pd.pd.model.AdminInfo;
import zxc.pd.pd.service.AdminInfoService;
import zxc.pd.pd.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxccong
 * @since 2019-07-11
 */
@Controller
@RequestMapping("/adminInfo")
public class AdminInfoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AdminInfoService adminInfoService;

    /**
     * 用户名密码登陆
     * @param userName
     * @param password
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/loginByAccount")
    public ModelAndView loginByAccount(@RequestParam("userName") String userName,
                                       @RequestParam("password") String password,
                                       HttpServletResponse response,
                                       Map<String, Object> map){
        //1. openid去和数据库里的数据匹配
        AdminInfo adminInfo = adminInfoService.getByUserName(userName);
        //1. openid去和数据库里的数据匹配
        if (adminInfo == null) {
            map.put("msg", "找不到账号错误");
            map.put("url", "/quotationSheet/getByProvince");
            return new ModelAndView("common/error");
        }

        if (!adminInfo.getPassword().equals(password)) {
            map.put("msg", "密码错误");
            map.put("url", "/quotationSheet/getByProvince");
            return new ModelAndView("common/error");
        }

        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), userName, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("redirect:" + "http://106.52.3.108:8080" + "/quotationSheet/getByProvince");

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg","登出成功");
        map.put("url", "/quotationSheet/getByProvince");
        return new ModelAndView("common/success", map);
    }

}
