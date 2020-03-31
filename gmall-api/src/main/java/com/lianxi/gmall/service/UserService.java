package com.lianxi.gmall.service;


import com.lianxi.gmall.bean.UmsMember;
import com.lianxi.gmall.bean.UmsMemberReceiveAddress;
import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
