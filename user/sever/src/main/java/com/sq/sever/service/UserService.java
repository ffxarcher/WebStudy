package com.sq.sever.service;


import com.sq.sever.dataobject.UserInfo;

public interface UserService  {

        UserInfo findByOpenid(String openid);
}
