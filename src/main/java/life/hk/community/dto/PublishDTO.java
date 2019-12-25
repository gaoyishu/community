package life.hk.community.dto;

import life.hk.community.model.User;
import lombok.Data;

/**
 * @author gaoyishu
 * @date 2019/12/25 17:21
 **/

@Data
public class PublishDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
