package life.hk.community.controller;

import life.hk.community.dto.PaginationDTO;
import life.hk.community.mapper.UserMapper;
import life.hk.community.model.User;
import life.hk.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoyishu
 * @date 2020/1/7 16:33
 **/

@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PublishService publishService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          HttpServletRequest request,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "12") Integer size) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        if (user == null) {
            return "redirect:/";
        }
        if ("publishes".equals(action)) {
            model.addAttribute("section", "publishes");
            model.addAttribute("sectionName", "我的发布");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PaginationDTO paginationDTO = publishService.list(user.getId(), page, size);

        model.addAttribute("pagination", paginationDTO);
        return "profile";
    }
}
