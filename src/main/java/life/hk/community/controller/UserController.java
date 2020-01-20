package life.hk.community.controller;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @author gaoyishu
 * @date 2020/1/20 17:50
 **/

@Controller
public class UserController {
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username",principal.getName());
        return "user/user";
    }
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "admin/admin";
    }
}
