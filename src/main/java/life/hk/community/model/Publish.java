package life.hk.community.model;

import lombok.Data;

/**
 * @author gaoyishu
 * @date 2019/12/23 16:39
 **/

@Data
public class Publish {
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
}
