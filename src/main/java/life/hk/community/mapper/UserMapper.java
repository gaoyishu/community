package life.hk.community.mapper;

import life.hk.community.model.User;
import org.apache.ibatis.annotations.Insert;
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
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);


    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}

