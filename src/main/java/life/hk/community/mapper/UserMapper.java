package life.hk.community.mapper;

import life.hk.community.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * User: gaoyishu
 * Date: 2019/12/19
 * Time: 23:39
 */

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User selectByUsername(@Param("username") String username);


    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}

