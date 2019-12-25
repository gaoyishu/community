package life.hk.community.controller;

import life.hk.community.dto.PublishDTO;
import life.hk.community.mapper.PublishMapper;
import life.hk.community.mapper.UserMapper;
import life.hk.community.model.User;
import life.hk.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: gaoyishu
 * Date: 2019/11/23
 * Time: 10:10
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PublishService publishService;

    @GetMapping("/")
    // 先检查登录状态
    public String index(HttpServletRequest request,
                        Model model){

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }

        List<PublishDTO> publishDTOList = publishService.list();
        model.addAttribute("publishes",publishDTOList);
        return "index";
    }
}
