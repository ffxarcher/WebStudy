package com.sq.sever.Controller;

import com.sq.sever.VO.ResultVO;
import com.sq.sever.constant.CookieConstant;
import com.sq.sever.constant.RedisConstant;
import com.sq.sever.dataobject.UserInfo;
import com.sq.sever.enums.ResultEnum;
import com.sq.sever.enums.RoleEnum;
import com.sq.sever.service.UserService;
import com.sq.sever.utils.CookieUtil;
import com.sq.sever.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid")String openid, HttpServletResponse response)
    {
        //1、openid和数据库的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        //2、判断角色
        if(userInfo==null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        if(RoleEnum.BUYER.getCode() != userInfo.getRole())
        {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3、cookie设置
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);
        //4、返回成功code
        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid")String openid, HttpServletResponse response,
                           HttpServletRequest request)
    {
        //从cookie中获取登录者信息，若信息在reids中可以查到则视为已登陆（cookie过期时间与redis相同）
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);

        if(cookie!=null && !StringUtils.isEmpty(redisTemplate.opsForValue()
                .get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()))))
        {
            return ResultVOUtil.success();
        }

        //1、openid和数据库的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        //2、判断角色
        if(userInfo==null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        if(RoleEnum.SELLER.getCode() != userInfo.getRole())
        {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3、redis设置UUID,过期时间。。。
         String token = UUID.randomUUID().toString();
         Integer expire = CookieConstant.expire;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),openid,
                expire,
                TimeUnit.SECONDS);
        //4、设置cookie uuid
        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);

        return ResultVOUtil.success();
    }

}
