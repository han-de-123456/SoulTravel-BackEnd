package org.soul.mapper;

import org.soul.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
public interface UserMapper extends BaseMapper<User> {

    User selectUser();
}
