package com.lianxi.gmall.user.service.impl;

import com.lianxi.gmall.user.entity.UmsMember;
import com.lianxi.gmall.user.mapper.UserMapper;
import com.lianxi.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getUserlist() {

        Example example = new Example(UmsMember.class);
        example.createCriteria().andEqualTo("username","test");
        List<UmsMember> umsMembers = userMapper.selectByExample(example);
        return umsMembers;
    }
}
