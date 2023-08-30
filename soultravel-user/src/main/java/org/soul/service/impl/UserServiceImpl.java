package org.soul.service.impl;

import org.soul.model.User;
import org.soul.mapper.UserMapper;
import org.soul.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘贤壮
 * @since 2023-08-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectUser();
    }
}
