package com.sq.sever.service.Impl;

import com.sq.sever.dataobject.UserInfo;
import com.sq.sever.repository.UserInfoRepository;
import com.sq.sever.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 根据openid查询
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
