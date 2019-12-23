package life.hk.community.mapper;

import life.hk.community.model.Publish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gaoyishu
 * @date 2019/12/23 16:33
 **/

@Mapper
public interface PublishMapper {

    @Insert("insert into publish (title,description,gmt_create,gmt_modified,creator,tag) " +
            "values (#(title),#(description),#(gmtCreate),#(gmtModified),#(creator),#(tag)) " )
    public void create(Publish publish);


}
