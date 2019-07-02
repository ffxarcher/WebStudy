package com.sq.sever.repository;

import com.sq.sever.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
   //根据openid查找用户信息
    UserInfo findByOpenid (String openid);

}
