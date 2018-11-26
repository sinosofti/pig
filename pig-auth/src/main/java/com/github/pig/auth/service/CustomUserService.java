
package com.github.pig.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.pig.auth.feign.UserService;
import com.github.pig.auth.util.UserDetailsImpl;
import com.github.pig.common.vo.Role;
import com.github.pig.common.vo.UserView;

/**
 * @author lengleng
 * @date 2017/10/26
 * <p>
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
       UserView userVo = userService.findUserByUsername(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("用户名不存在或者密码错误");
        }
       return new UserDetailsImpl(userVo);
    }

}
