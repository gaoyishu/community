package life.hk.community.model;

import lombok.Data;

/**
 * User: gaoyishu
 * Date: 2019/11/23
 * Time: 17:41
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
