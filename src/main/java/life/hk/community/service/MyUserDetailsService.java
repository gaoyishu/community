package life.hk.community.service;

import life.hk.community.mapper.UserMapper;
import life.hk.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: gaoyishu
 * Date: 2020/1/27
 * Time: 17:43
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User userBean = userMapper.selectByUsername(username);
        if (userBean == null) {
            throw new UsernameNotFoundException("数据库没有此用户");
        }
        return userBean;
    }
}
