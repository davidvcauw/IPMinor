package be.ucll.david.Tasks.Controller;

import be.ucll.david.Tasks.dto.CreateUserDTO;
import be.ucll.david.Tasks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new CreateUserDTO()); //empty user for form
        return "register.html";
    }

    @PostMapping("/register")
    public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register.html";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login.html";
    }
}
