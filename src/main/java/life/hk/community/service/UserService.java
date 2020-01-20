package life.hk.community.service;

import life.hk.community.model.UserSecurity;
import org.springframework.stereotype.Service;

/**
 * @author gaoyishu
 * @date 2020/1/15 16:33
 * 账户信息 service 和数据库交互层
 **/

@Service
public class UserService {
    private Database database = new Database();

    public UserSecurity getUserByUsername(String username){
        UserSecurity originUser = database.getDataBase().get(username);
        if (originUser == null){
            return null;
        }
        return new UserSecurity(originUser.getId(),
                originUser.getUsername(),
                originUser.getPassword(),
                originUser.getAuthorities());
    }

}
