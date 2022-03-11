package by.tms.controller;

import by.tms.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calc")
public class CalcController {


	@GetMapping
	public String calculator() {
		return "calculator";
	}

	@PostMapping
	public String calculatorPost(int num1, int num2, String operator, Model model) {
		Calculator calculator = new Calculator();
		model.addAttribute("calculatorMessage", calculator.operation(num1,num2,operator));
		return "calculator";
	}

}
