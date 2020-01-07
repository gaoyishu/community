package life.hk.community.mapper;

import life.hk.community.model.Publish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gaoyishu
 * @date 2019/12/23 16:33
 **/

@Mapper
public interface PublishMapper {

    @Insert("insert into publish (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})" )
    void create(Publish publish);


    @Select("select *from publish limit #{offset},#{size}")
    List<Publish> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from publish;")
    Integer count();

    @Select("select *from publish while creator = #{userId} limit #{offset},#{size}")
    List<Publish> list(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);
}
