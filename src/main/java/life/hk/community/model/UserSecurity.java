package life.hk.community.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gaoyishu
 * @date 2020/1/20 16:24
 **/

@Component
@Data
public class UserSecurity implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String roles;
    private String wechatAccount;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        String[] authorities = roles.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role:authorities){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

}
