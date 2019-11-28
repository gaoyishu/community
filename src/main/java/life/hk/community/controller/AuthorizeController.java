package life.hk.community.controller;

import life.hk.community.dto.AccessTokenDTO;
import life.hk.community.dto.GithubUser;
import life.hk.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: gaoyishu
 * Date: 2019/11/28
 * Time: 23:25
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;


    // map to callback
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setClient_id("8783a9933b655279fe38");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret("46a8add93427fc5100468c81425d0b9dde11014b");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
