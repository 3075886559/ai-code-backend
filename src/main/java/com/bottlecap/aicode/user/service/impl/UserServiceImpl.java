package com.bottlecap.aicode.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.bottlecap.aicode.user.entity.User;
import com.bottlecap.aicode.user.mapper.UserMapper;
import com.bottlecap.aicode.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author 30758
 * @since 2026-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
