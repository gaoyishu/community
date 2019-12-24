package life.hk.community.controller;

import life.hk.community.mapper.PublishMapper;
import life.hk.community.mapper.UserMapper;
import life.hk.community.model.Publish;
import life.hk.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoyishu
 * @date 2019/12/23 14:40
 **/

@Controller
public class PublishController {

    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/publish")
    public String publish() {
        return "publish";


    }

    @PostMapping("publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value ="description",required = false) String description,
            @RequestParam(value ="tag",required = false) String tag,
            HttpServletRequest request,
            Model model) {

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if (title == null || title == ""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }

        if (description == null || description == ""){
            model.addAttribute("error","描述不能为空");
            return "publish";
        }

        if (tag == null || tag == ""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }


        User user = null;
        Cookie[] cookies = request.getCookies();
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
        if (user == null) {
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Publish publish = new Publish();
        publish.setTitle(title);
        publish.setDescription(description);
        publish.setTag(tag);
        publish.setCreator(user.getId());
        publish.setGmtCreate(System.currentTimeMillis());
        publish.setGmtModified(user.getGmtModified());
        publishMapper.create(publish);
        return "redirect:/";

    }
}
