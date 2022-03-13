package by.tms.controller;

import by.tms.entity.User;
import by.tms.entity.UserDTO;
import by.tms.servise.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserServise userServise;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/reg")
    public String registration(@ModelAttribute("user") User user, Model model){ return  "reg";  }

    @PostMapping("/reg")
    public String сonfirmationOfRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return  "reg";
        }
        if(userServise.saveUser(user)){
            System.out.println("User added");
            return "home";
        }else {
            model.addAttribute("errormessage","Something went wrong");
            return  "reg";
        }
    }

    @GetMapping("/login")
    public  String authotization(@ModelAttribute("userdto") @Valid UserDTO userDTO, Model model){
        return  "login";
    }

    @PostMapping("/login")
    public String сonfirmationOfAuthorization(@ModelAttribute("userdto") @Valid UserDTO userDTO, BindingResult bindingResult, HttpSession httpSession, Model model){
        if(bindingResult.hasErrors()){
            return  "login";
        }else {
            Optional<User> optional = userServise.getUserByUsername(userDTO.getUsername());
            if(optional.isPresent()){
                if(optional.get().getPass().equals(userDTO.getPass())){
                    httpSession.setAttribute("user",optional.get());
                    return "home";
                }
                else {
                    model.addAttribute("messagepass","Incorrect pass");
                    return  "login";
                }
            }else {
                model.addAttribute("messageusername","This user is not registered");
                return  "login";
            }
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession,Model model){
        httpSession.invalidate();
        return "home";
    }

}
