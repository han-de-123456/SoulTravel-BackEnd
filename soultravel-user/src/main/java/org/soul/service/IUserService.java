package org.soul.service;

import org.soul.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘贤壮
 * @since 2023-08-30
 */
public interface IUserService extends IService<User> {

    User getUser();
}
