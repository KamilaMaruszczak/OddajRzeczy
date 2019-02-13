package pl.maruszczak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maruszczak.model.User;
import pl.maruszczak.repository.UserRepository;
import pl.maruszczak.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", produces = "text/html; charset=utf-8", method = RequestMethod.GET)
    public String home() {

        return "freeAccess/home";
    }

    @RequestMapping(value = "/login", produces = "text/html; charset=utf-8", method = RequestMethod.GET)
    public String login() {

        return "/freeAccess/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {


        if (userService.login(email, password)) {
            User user = userRepository.findUserByEmail(email);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("name", user.getName());
            return "redirect:/";

        } else {
            model.addAttribute("error", "Błędny adres email lub hasło");
            return "/login";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/register", produces = "text/html; charset=utf-8", method = RequestMethod.GET)
    public String register() {

        return "/freeAccess/register";
    }

    @RequestMapping(value = "/register", produces = "text/html; charset=utf-8", method = {RequestMethod.POST})
    public String add(@Valid User user, BindingResult result, @RequestParam String repeatPassword, HttpSession session) {


        if (result.hasErrors() || !user.getPassword().equals(repeatPassword)) {
            result.addError(new FieldError("user", "password", "hasła się nie zgadzają"));
            return "/user/add";
        }

        userService.save(user);

        return "redirect:/login";

    }
}
