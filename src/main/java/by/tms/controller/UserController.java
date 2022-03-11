package by.tms.controller;

import by.tms.entity.User;
import by.tms.servise.UserServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    UserServise userServise = new UserServise();

    @GetMapping
    public String test() {
        return "home";
    }

    @GetMapping("/reg")
    public String registration(){
        return  "reg";
    }

    @PostMapping("/reg")
    public String сonfirmationOfRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            for(FieldError fieldError:bindingResult.getFieldErrors()){
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return  "reg";
        }
        if(userServise.saveUser(user)){
            return "home";
        }else {
            model.addAttribute("errormessage","Something went wrong");
            return  "reg";
        }

    }
    @GetMapping("/login")
    public  String authotization(){
        return  "login";
    }

    @PostMapping("/login")
    public String сonfirmationOfAuthorization(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, HttpSession httpSession,Model model){
        if(bindingResult.hasErrors()){
            for(FieldError fieldError:bindingResult.getFieldErrors()){
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return  "login";
        }else {
            Optional<User> optional = userServise.getUserByUsername(user.getUsername());
            if(optional.isPresent()){
                if(optional.get().getPass().equals(user.getPass())){
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


}
