package com.sq.apigateway.Filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sq.apigateway.constant.RedisConstant;
import com.sq.apigateway.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {

        /**
         * /order/create（只许买家访问）
         * /order/finish（只许卖家访问）
         * /product/list
         */

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        if("/order/order/create".equals(request.getRequestURI()))
        {
            Cookie cookie = CookieUtil.get(request,"openid");


            if(cookie == null || StringUtils.isEmpty(cookie.getValue()))
            {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }


        if("/order/order/finish".equals(request.getRequestURI()))
        {
            Cookie cookie = CookieUtil.get(request,"token");
            if(cookie == null ||
                    StringUtils.isEmpty(cookie.getValue()) ||
                    StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String
                            .format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()))))
            {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        return null;
    }
}
