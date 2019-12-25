package life.hk.community.dto;

import lombok.Data;

/**
 * User: gaoyishu
 * Date: 2019/11/28
 * Time: 23:51
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
