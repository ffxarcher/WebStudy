package com.sq.sever.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    /**
     * 添加cookie
     * @param response
     * @param name
     * @param value
     * @param MaxAge
     */
    public static void set(HttpServletResponse response,
                           String name,String value,int MaxAge)
    {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(MaxAge);
        response.addCookie(cookie);
    }


    public static Cookie get(HttpServletRequest request,
                           String name)
    {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            for(Cookie cookie : cookies)
            {
                if(name.equals(cookie.getName()))
                {
                    return cookie;
                }
            }
        }
        return  null;
    }
}
