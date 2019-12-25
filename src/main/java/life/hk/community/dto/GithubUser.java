package life.hk.community.dto;

import lombok.Data;

/**
 * User: gaoyishu
 * Date: 2019/11/29
 * Time: 00:34
 */

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
