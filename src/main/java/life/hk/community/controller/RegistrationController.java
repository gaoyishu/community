package life.hk.community.controller;

import life.hk.community.dto.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * @author gaoyishu
 * @date 2020/1/10 18:00
 **/

@Controller
public class RegistrationController {
    @RequestMapping(value = "user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model){
        RegistrationDTO registrationDTO = new RegistrationDTO();
        model.addAttribute("registrationUser",registrationDTO);
        return "registration";
    }
}
