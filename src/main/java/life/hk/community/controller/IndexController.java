package life.hk.community.controller;

import life.hk.community.dto.PaginationDTO;
import life.hk.community.mapper.UserMapper;
import life.hk.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

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
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "12") Integer size
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) auth.getAuthorities();
        model.addAttribute("authorities", authorityCollection.toString());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());

        PaginationDTO pagination = publishService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
